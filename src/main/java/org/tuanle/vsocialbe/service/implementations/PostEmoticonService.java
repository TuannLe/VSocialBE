package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.PostEmoticonRequest;
import org.tuanle.vsocialbe.repositoty.PostEmoticonRepo;
import org.tuanle.vsocialbe.service.interfaces.IPostEmoticonService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostEmoticonService implements IPostEmoticonService {
    PostEmoticonRepo postEmoticonRepo;

    @Override
    public String createPostEmoticon(PostEmoticonRequest request) {
        return "";
    }

    @Override
    public String updatePostEmoticon(PostEmoticonRequest request) {
        return "";
    }

    @Override
    public String deletePostEmoticon(PostEmoticonRequest request) {
        return "";
    }
}
