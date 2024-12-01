package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.PostResponse;
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
    public Post createPost(AddPostRequest request) {
        try {
            Post post = postMapper.toPost(request);
            post.setStatus(1);
            post.setCreatedAt(LocalDateTime.now());
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

            return savedPost;
        } catch (AppException | IOException e) {
            throw new AppException(ErrorCode.CREATE_POST_FAIL);
        }
    }

    @Override
    public PostResponse getPostById(String postId) {
        return null;
    }

    @Override
    public List<PostResponse> getAllPost() {
        return List.of();
    }

    @Override
    public PostResponse updatePost(String postId, AddPostRequest request) {
        return null;
    }

    @Override
    public PostResponse deletePost(String postId) {
        return null;
    }
}
