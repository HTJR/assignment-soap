package com.ericsson.webservices.soapexample;

import org.springframework.stereotype.Service;

import com.ericsson.user.GetUserRequest;
import com.ericsson.user.GetUserResponse;

@Service
public class UserService {

    public GetUserResponse getUserDetails(GetUserRequest user) {

        if(user.getUserName().equalsIgnoreCase("Deepak")) {
            GetUserResponse getUserResponse= new GetUserResponse();
            getUserResponse.setUserName("Deepak");
            getUserResponse.setUserAge(25);
            getUserResponse.setUserAddress("Delhi");

            return getUserResponse;
        }

        else if(user.getUserName().equalsIgnoreCase("Rajeev")) {
            GetUserResponse getUserResponse= new GetUserResponse();
            getUserResponse.setUserName("Rajeev");
            getUserResponse.setUserAge(34);
            getUserResponse.setUserAddress("Agra");

            return getUserResponse;
        }
        return null;

    }
 
}