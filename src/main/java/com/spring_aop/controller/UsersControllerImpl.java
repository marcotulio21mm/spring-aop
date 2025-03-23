package com.spring_aop.controller;

import com.spring_aop.aspects.logging.Logging;
import com.spring_aop.aspects.mdc.MdcClear;
import com.spring_aop.model.entity.User;
import com.spring_aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersControllerImpl {

    private final UserService userService;

    @MdcClear
    @Logging
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    public User getUser(int id) {
        return null;
    }
}
