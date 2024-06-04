package com.goShopping.controller;

import com.goShopping.dto.UserLoginDTO;
import com.goShopping.dto.UserRegisterDTO;
import com.goShopping.properties.JWTProperties;
import com.goShopping.result.Result;
import com.goShopping.service.UserService;
import com.goShopping.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController  {
      @Autowired
      UserService userService;
      @Autowired
      JWTProperties jwtProperties;
      @PostMapping("/login")
      public Result login(@RequestBody @Validated UserLoginDTO userLoginDTO) throws Exception {
          return userService.login(userLoginDTO);
      }
      @PostMapping("/register")
      public Result register(@RequestBody @Validated UserRegisterDTO userRegisterDTO) throws Exception {
            return userService.register(userRegisterDTO);
      }
      @GetMapping("/recover")
      public Result recover(HttpServletRequest request) throws Exception {
            String token = request.getHeader("Authorization");
            Claims claims = null;
            try{
                  claims = JWTUtils.parseJwt(jwtProperties.getSecretKey(), token);
            }catch (Exception e){
                  log.info("jwt令牌解析失败");
                  return Result.error("登录状态已失效，请重新登录");
            }

            return userService.recover(claims);
      }
      @GetMapping("/autoLogin")
      public Result autoLogin(HttpServletRequest request){
            String token = request.getHeader("Authorization");
            Claims claims = null;
            try{
                  claims = JWTUtils.parseJwt(jwtProperties.getSecretKey(), token);
            }catch (Exception e){
                  log.info("jwt令牌解析失败");
                  return Result.error("自动登录失败，请重新登录");
            }
            return userService.autoLogin(claims);
      }
      @GetMapping("/logout")
      public Result logout(HttpServletRequest request){
             String token = request.getHeader("Authorization");
             Claims claims = null;
            try{
                 claims  = JWTUtils.parseJwt(jwtProperties.getSecretKey(), token);
            }catch (Exception e){
                  log.info("jwt令牌解析失败");
                  return Result.error("登录状态已失效，请重新登录");
            }
            return userService.logout(token,claims);
      }
      @GetMapping("/search/{mode}/{pageNum}")
      public Result search(@RequestParam String message, @PathVariable Integer mode,@PathVariable Integer pageNum){
             return userService.search(message,mode,pageNum);
      }
}
