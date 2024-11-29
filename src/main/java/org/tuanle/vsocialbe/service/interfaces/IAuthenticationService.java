package org.tuanle.vsocialbe.service.interfaces;

import com.nimbusds.jose.JOSEException;
import org.tuanle.vsocialbe.dto.request.AuthenticationRequest;
import org.tuanle.vsocialbe.dto.request.IntrospectRequest;
import org.tuanle.vsocialbe.dto.request.LogoutRequest;
import org.tuanle.vsocialbe.dto.request.RefreshTokenRequest;
import org.tuanle.vsocialbe.dto.response.AuthenticationResponse;
import org.tuanle.vsocialbe.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface IAuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
    IntrospectResponse introspect(IntrospectRequest request) throws ParseException, JOSEException;
    void logout(LogoutRequest request) throws ParseException, JOSEException;
    AuthenticationResponse refreshToken(RefreshTokenRequest request) throws ParseException, JOSEException;
}
