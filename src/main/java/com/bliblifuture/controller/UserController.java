package com.bliblifuture.controller;

import com.bliblifuture.model.User;
import com.bliblifuture.request.UserRequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.service.AuthenticationService;
import com.bliblifuture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "api/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse editUser(@RequestBody UserRequest request){
        try{
            if (request.getRole().equals("ROLE_ADMIN")){
                userService.editAdmin(request);
            }
            else if(request.getRole().equals("ROLE_COUNTER")){
                userService.editCounter(request);
            }
            return new BaseResponse(true,"");
        } catch (Exception e){
            return new BaseResponse(false,e.getMessage());
        }


    }

    @RequestMapping(value="/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<User> getAllUsers(@RequestParam String warehouse){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        List<User> data= userService.findAll(username,warehouse);
        ListResponse<User> response = new ListResponse<>(true,"",data);
        return response;
    }


    @RequestMapping(value = "api/users", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse registerUser(@RequestBody UserRequest request) {
        try {
            if (request.getRole().equals("ROLE_ADMIN")) {
                userService.registerAdmin(request);
            } else if (request.getRole().equals("ROLE_COUNTER")) {
                userService.registerCounter(request);
            }
            return  new BaseResponse(true,"");
        } catch (Exception e) {
            return  new BaseResponse(false,e.getMessage());
        }
    }
}
