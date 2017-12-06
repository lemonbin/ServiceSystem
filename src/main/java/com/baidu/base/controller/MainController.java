package com.baidu.base.controller;

import com.baidu.base.utils.VerifyCode;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by dllo on 2017/12/4.
 */
@Controller
public class MainController {


    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping({"/", "index"})
    public String home() {
        return "index";
    }

    //定位到登录界面
    @RequestMapping("/login")
    public String loginPage() {
//        if (SecurityUtils.getSubject().isAuthenticated()) {
//            return "index";
//        }
        return "login";
    }


    //登录表单验证
    @RequestMapping("/loginSubmit")
    public String loginSubmit(HttpServletRequest request) throws Exception {

        //如果在shiro spring文件中, 配置了表单认证过滤器
        //那么在这个方法中只需要处理异常信息即可

//        SecurityUtils.getSubject()

        String exClassName = (String) request.getAttribute("shiroLoginFailure");

        if (UnknownAccountException.class.getName().equals(exClassName)) {
            throw new UnknownAccountException("账号不存在");
        } else if (IncorrectCredentialsException.class.getName().equals(exClassName)) {
            throw new IncorrectCredentialsException("密码错误");
        } else {
            throw new Exception(exClassName);
        }
    }

    @RequestMapping("/checkCode")
    public String checkCode(String verifyCode, HttpServletRequest request){
        String code = (String) request.getSession().getAttribute("code");
        if (code.equalsIgnoreCase(verifyCode)){
            return "验证码错误";
        }else {
            return "验证码正确";
        }
    }

    @RequestMapping("/admin-role")
    public String admin_role() {
        return "user/user-role";
    }

    @RequestMapping("/admin-permission")
    public String admin_permission() {

        return "user/user-permission";
    }

    @RequestMapping("/admin-list")
    public String admin_list() {

        return "user/user-list";
    }

    /**
     * 获取验证码图片以及值
     *
     */
    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCode code = new VerifyCode();
        BufferedImage image = code.getImage();
        request.getSession().setAttribute("code", code.getText());
        VerifyCode.output(image, response.getOutputStream());
    }


}
