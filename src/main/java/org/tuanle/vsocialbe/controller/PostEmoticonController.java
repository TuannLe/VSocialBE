package org.tuanle.vsocialbe.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.tuanle.vsocialbe.dto.request.PostEmoticonRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.service.interfaces.IPostEmoticonService;

@RestController
@RequestMapping("/api/v1/post-emoticon")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostEmoticonController {
    IPostEmoticonService postEmoticonService;

    @PostMapping
    public APIResponse<String> createPostEmoticon(@RequestBody PostEmoticonRequest request) {
        return APIResponse.<String>builder()
                .result(postEmoticonService.createPostEmoticon(request))
                .build();
    }

    @PutMapping
    public APIResponse<String> updatePostEmoticon(@RequestBody PostEmoticonRequest request) {
        return APIResponse.<String>builder()
                .result(postEmoticonService.updatePostEmoticon(request))
                .build();
    }

    @DeleteMapping
    public APIResponse<String> deletePostEmoticon(@RequestBody PostEmoticonRequest request) {
        return APIResponse.<String>builder()
                .result(postEmoticonService.deletePostEmoticon(request))
                .build();
    }
}
