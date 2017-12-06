package com.baidu.base.controller;

import com.baidu.base.service.MainService;
import com.baidu.base.utils.AjaxResult;
import com.baidu.base.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by dllo on 2017/12/4.
 */
@Controller
public class MainController {
    @Resource
    private MainService mainService;

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
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "index";
        }
        return "login";
    }


    //登录表单验证
    @ResponseBody
    @RequestMapping("/loginSubmit")
    public AjaxResult loginSubmit(HttpServletRequest request) {
        AjaxResult ajaxResult = new AjaxResult();
        //如果在shiro spring文件中, 配置了表单认证过滤器
        //那么在这个方法中只需要处理异常信息即可

//        SecurityUtils.getSubject()
        String exClassName = (String) request.getAttribute("shiroLoginFailure");
        if (UnknownAccountException.class.getName().equals(exClassName)) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("用户名不存在");
        } else if (IncorrectCredentialsException.class.getName().equals(exClassName)) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("密码错误");
        } else {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("未知错误");
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/checkCode")
    public AjaxResult checkCode(String verifyCode, HttpServletRequest request){
        AjaxResult ajaxResult = new AjaxResult();
        String code = (String) request.getSession().getAttribute("code");
        if (code.equalsIgnoreCase(verifyCode)){
            ajaxResult.setMessage("验证码正确");
        }else {
            ajaxResult.setMessage("验证码错误");
        }
        return ajaxResult;
    }

    @RequestMapping("/admin-role")
    public String admin_role() {
        return "admin/admin-role";
    }

    @RequestMapping("/admin-permission")
    public String admin_permission() {
        return "admin/admin-permission";
    }

    @RequestMapping("/admin-list")
    public String admin_list() {
        return "admin/admin-list";
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
