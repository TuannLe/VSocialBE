package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.PostResponse;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.entity.Post;
import org.tuanle.vsocialbe.entity.PostImage;
import org.tuanle.vsocialbe.exception.AppException;
import org.tuanle.vsocialbe.exception.ErrorCode;
import org.tuanle.vsocialbe.mapper.PostMapper;
import org.tuanle.vsocialbe.repositoty.PostImageRepo;
import org.tuanle.vsocialbe.repositoty.PostRepo;
import org.tuanle.vsocialbe.service.interfaces.IPostService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostService implements IPostService {
    PostRepo postRepo;
    PostMapper postMapper;
    CloudinaryService cloudinaryService;
    PostImageRepo postImageRepo;

    @Override
    public PostResponse createPost(AddPostRequest request) {
        try {
            Post post = postMapper.toPost(request);
            post.setStatus(1);
            post.setCreatedAt(LocalDateTime.now());
            Account account = new Account();
            account.setAccountId(request.getAccountId());
            post.setCreatedBy(account);
            Post savedPost = postRepo.save(post);

            List<String> imageUrls = new ArrayList<>();
            for (MultipartFile file : request.getImages()) {
                imageUrls.add(cloudinaryService.uploadImage(file));
            }
            List<PostImage> postImages = imageUrls.stream()
                    .map(detail -> {
                        System.out.println(savedPost.getPostId());
                        PostImage.PostImageId postImageId = new PostImage.PostImageId(savedPost.getPostId(), detail);
                        PostImage postImage = new PostImage();
                        postImage.setPostImageId(postImageId);
                        postImage.setPost(savedPost);
                        return postImage;
                    }).collect(Collectors.toList());

            postImageRepo.saveAll(postImages);

            return postMapper.toPostResponse(savedPost);
        } catch (AppException | IOException e) {
            throw new AppException(ErrorCode.CREATE_POST_FAIL);
        }
    }

    @Override
    public PostResponse getPostById(String postId) {
        return postMapper.toPostResponse(postRepo.findById(postId).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED)));
    }

    @Override
    public List<PostResponse> getAllPost() {
        List<Post> posts = postRepo.findAll();
        return posts.stream()
                .map(postMapper::toPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostResponse> getPostByAccountId(String accountId) {
        List<Post> posts = postRepo.findPostsByAccountId(accountId);
        return posts.stream()
                .map(postMapper::toPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostResponse> getPostFriendByAccountId(String accountId) {
        List<Post> posts = postRepo.findFriendPostsByAccountId(accountId);
        return posts.stream()
                .map(postMapper::toPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse updatePost(String postId, AddPostRequest request) {
        return null;
    }

    @Override
    public String deletePost(String postId) {
        Post existedPost = postRepo.findById(postId).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));
        postRepo.delete(existedPost);
        return "Post deleted successfully";
    }
}
