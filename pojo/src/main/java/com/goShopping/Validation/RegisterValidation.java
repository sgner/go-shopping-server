package com.goShopping.Validation;

import com.goShopping.annotation.UserValidation;
import com.goShopping.dto.UserRegisterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RegisterValidation implements ConstraintValidator<UserValidation, UserRegisterDTO> {
    @Override
    public boolean isValid(UserRegisterDTO obj, ConstraintValidatorContext context) {
        return obj.getPassword().equals(obj.getRePassword());
    }
}