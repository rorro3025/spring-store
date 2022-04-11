package com.unam.store.controllers;

import com.unam.store.dao.UserDao;
import com.unam.store.models.User;
import com.unam.store.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/users" ,method = RequestMethod.GET)
    public List<User> getUsers(@RequestHeader(value = "Authorization") String token) {
        String idUser = jwtUtil.getKey(token);
        if(idUser==null)return new ArrayList<>();
        return userDao.getUsers();
    }

    @RequestMapping(value= "api/users",method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
       Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
       String hash = argon2.hash(1,1024,1,user.getPassword());
       user.setPassword(hash);
       userDao.registerUser(user);
    }
    @RequestMapping(value = "api/users/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable long id){
        User u = new User();
        u.setId(id);
        u.setName("Sandra BB");
        u.setPassword("12314");
        u.setEmail("sandBB@mail.com");
        return u;
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id){
       userDao.deleteUser(id);
    }
}
