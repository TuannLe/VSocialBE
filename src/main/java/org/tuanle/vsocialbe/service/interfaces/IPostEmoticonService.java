package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.PostEmoticonRequest;

public interface IPostEmoticonService {
    String createPostEmoticon(PostEmoticonRequest request);
    String updatePostEmoticon(PostEmoticonRequest request);
    String deletePostEmoticon(PostEmoticonRequest request);
}
