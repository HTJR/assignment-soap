package com.ericsson.webservices.soapexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ericsson.user.GetUserRequest;
import com.ericsson.user.GetUserResponse;

@Endpoint
public class UserEndPoint {
    
    private static final String NAMESPACE="http://www.ericsson.com/user";
    
    @Autowired
    private UserService service;
    
    @PayloadRoot(namespace = NAMESPACE,localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserDetails(@RequestPayload GetUserRequest user) {
        return service.getUserDetails(user);
    }
}
