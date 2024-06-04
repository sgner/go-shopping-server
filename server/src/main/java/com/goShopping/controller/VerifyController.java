package com.goShopping.controller;

import com.goShopping.entity.Code;
import com.goShopping.result.Result;
import com.goShopping.service.VerifyService;
import com.goShopping.vo.VerifyVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/verify")
@Slf4j
public class VerifyController {
    @Autowired
    VerifyService verifyService;
    @GetMapping()
    @ResponseBody
    public Result getVerify(@RequestParam("temporaryId") String temporaryId){
        log.info("请求创建验证码");
        Code code = verifyService.getCode();
        log.info("验证码：{}",code.getCode());
        if(temporaryId.isEmpty()){
            temporaryId = String.valueOf(UUID.randomUUID());
            log.info("生成临时id：{}",temporaryId);
        }else{
            log.info("临时id(已生成)：{}",temporaryId);
        }

        verifyService.storageCodeInRedis(code,temporaryId);
        String imgCode = code.getCode();
        byte[] imageBytes = new byte[0];
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write((RenderedImage) code.getImage(), "png", baos);
            baos.flush();
            imageBytes = baos.toByteArray();
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
        VerifyVO verifyVO = VerifyVO.builder().image(imageBytes).code(imgCode).temporaryId(temporaryId).build();
        return Result.success(verifyVO);
    }

}
