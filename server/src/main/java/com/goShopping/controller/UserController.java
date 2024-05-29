package com.goShopping.controller;

import com.goShopping.dto.UserLoginDTO;
import com.goShopping.dto.UserRegisterDTO;
import com.goShopping.result.Result;
import com.goShopping.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController  {
      @Autowired
      UserService userService;
      @PostMapping("/login")
      public Result login(@RequestBody @Validated UserLoginDTO userLoginDTO) throws Exception {
          return userService.login(userLoginDTO);
      }
      @PostMapping("/register")
      public Result register(@RequestBody @Validated UserRegisterDTO userRegisterDTO) throws Exception {
            return userService.register(userRegisterDTO);

      }
}
