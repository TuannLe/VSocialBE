package org.tuanle.vsocialbe.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.tuanle.vsocialbe.dto.request.FriendRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.service.interfaces.IFriendService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/friend")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FriendController {
    IFriendService friendService;

    @PostMapping("/add")
    public APIResponse<String> addFriend(@RequestBody FriendRequest request) {
        return APIResponse.<String>builder()
                .result(friendService.addFriend(request))
                .build();
    }

    @PostMapping("/block")
    public APIResponse<String> blockFriend(@RequestBody FriendRequest request) {
        return APIResponse.<String>builder()
                .result(friendService.blockFriend(request))
                .build();
    }

    @PutMapping()
    public APIResponse<String> acceptFriend(@RequestBody FriendRequest request) {
        return APIResponse.<String>builder()
                .result(friendService.acceptFriend(request))
                .build();
    }

    @DeleteMapping()
    public APIResponse<String> unFriend(@RequestBody FriendRequest request) {
        return APIResponse.<String>builder()
                .result(friendService.unFriend(request))
                .build();
    }

    @GetMapping()
    public APIResponse<List<String>> getFriends() {
        return APIResponse.<List<String>>builder()
                .result(friendService.getFriendsRequest())
                .build();
    }

}
