package edu.whu.controller;

import edu.whu.entity.User;
import edu.whu.entity.UserDto;
import edu.whu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("")
    @PreAuthorize("hasAuthority('user/query')")
    public List<User> findAllUser(){
        return userService.list();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user/update')")
    public void addUser(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('user/update')")
    public void deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
    }

    @GetMapping("{userName}")
    @PreAuthorize("hasAuthority('user/query') or #userName == authentication.name")
    public UserDto getUser(@PathVariable String userName){
        return userService.getUser(userName);
    }


    @PutMapping("")
    @PreAuthorize("hasAuthority('user/update') or #user.id == authentication.name")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
}
