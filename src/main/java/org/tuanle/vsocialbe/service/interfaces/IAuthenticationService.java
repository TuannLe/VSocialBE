package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.AuthenticationRequest;
import org.tuanle.vsocialbe.dto.request.IntrospectRequest;
import org.tuanle.vsocialbe.dto.response.AuthenticationResponse;
import org.tuanle.vsocialbe.dto.response.IntrospectResponse;

public interface IAuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
    IntrospectResponse introspect(IntrospectRequest request);
}
