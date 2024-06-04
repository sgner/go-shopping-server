package com.goShopping.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
     private Integer id;
     @NotEmpty
     @Pattern(regexp= "^\\.{5,16}$", message = "用户名必须为5-16位")
     private String username;
     @NotEmpty
     @Pattern(regexp= "^(?=.*[a-z])(?=.*[A-Z])(?=.*d)(?=.*!%*?&])[A-Za-zd@!%*?&]{8,}$", message = "密码需要8位以上，至少有一个大写字母一个特殊字符")
     private String password;
     @NotEmpty
     private boolean isAuto;
     @NotEmpty
     private boolean isRemember;
     private String phoneNumber;
     private String Email;
     private String address;
     private String avatar;
     private Integer status;
}
