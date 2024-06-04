package com.goShopping.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {
    @NotEmpty
    @Pattern(regexp= "^.{5,16}$", message = "用户名必须为5-16位")
    private String username;
    @NotEmpty
    @Pattern(regexp= "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>])[\\w!@#$%^&*(),.?\":{}|<>]{8,16}$", message = "密码需要8位以上，至少有一个大写字母一个特殊字符")
    private String password;
    @NotNull
    private boolean isAuto;
    @NotNull
    private boolean isRemember;
    @NotNull
    private String temporaryId;
    @NotNull
    private String code;
}
