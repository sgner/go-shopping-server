package com.goShopping.utils;

import com.goShopping.entity.Code;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class SessionUtils {
    public static void storage (HttpServletRequest httpServletRequest, Code code){
        HttpSession Session = httpServletRequest.getSession();
        Session.setAttribute("code",code);
    }
    public static Code get(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        return (Code) session.getAttribute("code");
    }
    public static void remove(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("code");
    }
}