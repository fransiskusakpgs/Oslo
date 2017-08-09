package com.bliblifuture.controller;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.Counter;
import com.bliblifuture.model.User;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.request.UserRequest;
import com.bliblifuture.response.*;
import com.bliblifuture.service.AuthenticationService;
import com.bliblifuture.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "api/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse editUser(@RequestBody UserRequest request){
        try{
            boolean success;
            if (request.getRole().equals("ROLE_ADMIN")){
                success =userService.editAdmin(request);
            }
            else if(request.getRole().equals("ROLE_COUNTER")){
                success = userService.editCounter(request);
            } else{
                success = false;
            }
            return new BaseResponse(success,"");
        } catch (Exception e){
            return new BaseResponse(false,e.getMessage());
        }


    }


    @RequestMapping(value="/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<UserResponse> getAllUsers(@RequestParam String warehouse){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        List<User> users= userService.findAll(username,warehouse);

        List<UserResponse> data = new ArrayList<>();

        for (User user: users) {
            UserResponse ures = new UserResponse();
            BeanUtils.copyProperties(user, ures);

            List<String> warehouses = new ArrayList<>();
            if(user.getRole().equals("ROLE_ADMIN")){
                Admin admin = (Admin)user;
                for (Warehouse wh:admin.getWarehouse()) {
                    warehouses.add(wh.getName());
                }
                ures.setRole("Admin");
            }
            else if(user.getRole().equals("ROLE_COUNTER")){
                Counter counter = (Counter)user;
                warehouses.add(counter.getWarehouse().getName());
                ures.setRole("Counter");
            }
            ures.setWarehouse(warehouses);
            data.add(ures);
        }

        ListResponse<UserResponse> response = new ListResponse<UserResponse>(true,"",data);
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

//    @RequestMapping(value = "api/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public SingleUserResponse loginUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        UserResponse userData = userService.getUserData(username);
//        return new SingleUserResponse(true, "",userData);
//    }

    @RequestMapping(value = "/api/usersingle", method = RequestMethod.GET)
    @ResponseBody
    public SingleUserResponse getDetailOfUser(@RequestParam String username) {
        User dataUser = userService.findDetailOfUser(username);
        SingleUserResponse dataresponseUser1 = new SingleUserResponse(true, "", dataUser);
        return dataresponseUser1;
    }


}
