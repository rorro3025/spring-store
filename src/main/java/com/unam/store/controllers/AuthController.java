package com.unam.store.controllers;

import com.unam.store.dao.UserDao;
import com.unam.store.models.User;
import com.unam.store.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

   @RequestMapping(value= "api/login",method = RequestMethod.POST)
    public String userLogin(@RequestBody User u){
       User userReturned =userDao.getUserByCredentials(u);
       if(userReturned != null){
           return jwtUtil.create(String.valueOf(userReturned.getId()),userReturned.getEmail());
       }else{
           return "error";
       }
   }

}
