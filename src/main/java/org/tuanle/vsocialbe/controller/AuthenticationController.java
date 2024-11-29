package org.tuanle.vsocialbe.controller;

import com.nimbusds.jose.JOSEException;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tuanle.vsocialbe.dto.request.AuthenticationRequest;
import org.tuanle.vsocialbe.dto.request.IntrospectRequest;
import org.tuanle.vsocialbe.dto.request.LogoutRequest;
import org.tuanle.vsocialbe.dto.request.RefreshTokenRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.dto.response.AuthenticationResponse;
import org.tuanle.vsocialbe.dto.response.IntrospectResponse;
import org.tuanle.vsocialbe.service.interfaces.IAuthenticationService;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    IAuthenticationService authService;

    @PostMapping("/login")
    APIResponse<AuthenticationResponse> authenticated(@RequestBody AuthenticationRequest request) {
        var result = authService.authenticate(request);
        return APIResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    APIResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authService.introspect(request);
        return APIResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/refresh")
    APIResponse<AuthenticationResponse> authenticated(@RequestBody RefreshTokenRequest request) throws ParseException, JOSEException {
        var result = authService.refreshToken(request);
        return APIResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    APIResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authService.logout(request);
        return APIResponse.<Void>builder()
                .build();
    }
}
