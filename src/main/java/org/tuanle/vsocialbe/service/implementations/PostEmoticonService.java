package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.PostEmoticonRequest;
import org.tuanle.vsocialbe.entity.PostEmoticon;
import org.tuanle.vsocialbe.exception.AppException;
import org.tuanle.vsocialbe.exception.ErrorCode;
import org.tuanle.vsocialbe.mapper.PostMapper;
import org.tuanle.vsocialbe.repositoty.PostEmoticonRepo;
import org.tuanle.vsocialbe.service.interfaces.IPostEmoticonService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostEmoticonService implements IPostEmoticonService {
    PostEmoticonRepo postEmoticonRepo;
    PostMapper postMapper;

    @Override
    public String createPostEmoticon(PostEmoticonRequest request) {
        PostEmoticon postEmoticon = new PostEmoticon();
        PostEmoticon.PostEmotionId postEmotionId = new PostEmoticon.PostEmotionId(request.getPostId(), request.getAccountId());
        postEmoticon.setPostEmotionId(postEmotionId);
        postEmoticon.setEmoticon(request.getEmoticon());
        postEmoticon.setPost(postMapper.toPost(request));
        postEmoticonRepo.save(postEmoticon);
        return "Success";
    }

    @Override
    public String updatePostEmoticon(PostEmoticonRequest request) {
        PostEmoticon.PostEmotionId postEmotionId = new PostEmoticon.PostEmotionId(request.getPostId(), request.getAccountId());
        PostEmoticon postEmoticon = postEmoticonRepo.findById(postEmotionId).orElseThrow(() -> new AppException(ErrorCode.POST_IMAGE_NOT_EXISTED));
        postEmoticon.setEmoticon(request.getEmoticon());
        postEmoticonRepo.save(postEmoticon);
        return "Success";
    }

    @Override
    public String deletePostEmoticon(PostEmoticonRequest request) {
        PostEmoticon.PostEmotionId postEmotionId = new PostEmoticon.PostEmotionId(request.getPostId(), request.getAccountId());
        PostEmoticon postEmoticon = postEmoticonRepo.findById(postEmotionId).orElseThrow(() -> new AppException(ErrorCode.POST_IMAGE_NOT_EXISTED));
        postEmoticonRepo.delete(postEmoticon);
        return "Success";
    }
}
