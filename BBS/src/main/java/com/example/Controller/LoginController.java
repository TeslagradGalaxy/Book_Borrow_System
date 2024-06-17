package com.example.Controller;

import com.example.Pojo.Result;
import com.example.Pojo.User;
import com.example.Service.UserService;
import com.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping
    public Result login(@RequestBody User user){
        User u=userService.login(user);
        if(u==null){
            return Result.error();
        }
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",u.getId());
        claims.put("Username",u.getUsername());
        String jwt= JwtUtils.generateJwt(claims);
        return Result.success(jwt);
    }
}
