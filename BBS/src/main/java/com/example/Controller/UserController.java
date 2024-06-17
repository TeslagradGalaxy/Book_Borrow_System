package com.example.Controller;

import com.example.Pojo.Result;
import com.example.Pojo.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/insertUser")
    public Result insertUser(@RequestBody User user){
        userService.insertUser(user);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return Result.success();
    }
    @GetMapping("/show/{id}")
    public Result showBorrowedBookHistory(@PathVariable Integer id){
        return Result.success(userService.showBorrowedBookHistory(id));
    }
    @GetMapping("/show1/{id}")
    public Result showBorrowedBookById(@PathVariable Integer id){
        return Result.success(userService.showBorrowedBookById(id));
    }

}
