package com.baidu.base.controller;

import com.baidu.base.domain.IPAddress;
import com.baidu.base.utils.GeetestConfig;
import com.baidu.base.utils.GeetestLib;
import com.baidu.base.service.MainService;
import com.baidu.base.utils.AjaxResult;
import com.baidu.user.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

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

    @RequestMapping("/admin-role-add")
    public String roleAdd() {
        return "admin/admin-role-add";
    }


    /**
     * 定位到登录界面
     */
    @RequestMapping("/login")
    public String loginPage() {

        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "index";
        }
        return "login";
    }

    @RequestMapping("/retrieve-password")
    public String retrieve_password() {
        return "retrieve-password";
    }


    /**
     * 登录表单验证
     */
    @ResponseBody
    @RequestMapping("/loginSubmit")
    public AjaxResult loginSubmit(HttpServletRequest request) throws IOException {
        AjaxResult ajaxResult = new AjaxResult();

        String exClassName = (String) request.getAttribute("shiroLoginFailure");

        if (UnknownAccountException.class.getName().equals(exClassName)) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("用户名不存在");
        } else if (IncorrectCredentialsException.class.getName().equals(exClassName)) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("密码错误");
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
     * 忘记密码修改
     *
     * @param user User对象
     * @throws MessagingException
     */
    @ResponseBody
    @RequestMapping("/retrieve-pwd")
    public AjaxResult retrieve_pwd(User user, HttpServletRequest request) throws MessagingException {
        AjaxResult ajaxResult = new AjaxResult();
        // 1. 得到session
        Properties pros = new Properties();
        // 设置服务器的主机名
        pros.setProperty("mail.host", "smtp.163.com");
        // 设置需要验证
        pros.setProperty("mail.smtp.auth", "true");

        // Authenticator 是一个接口 javax.mail 用于验证用户名和密码
        Authenticator auth = new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("xinrugao@163.com", "why1993521");
            }
        };
        Session session = Session.getInstance(pros, auth);
        // 2. 创建 MimeMessage, 代表一个邮件对象
        MimeMessage msg = new MimeMessage(session);
        // 设置发件人
        msg.setFrom(new InternetAddress("xinrugao@163.com"));
        // 设置收件人
        msg.setRecipients(Message.RecipientType.TO, user.getEmail());
        String url = "<a href='http://localhost:8080/retrievePWD?username="
                + user.getUsername() + "&password=" + user.getPassword() + "'>点击重置密码</a> 或者复制链接访问: " +
                "http://localhost:8080/retrievePWD?username=" + user.getUsername() + "&password=" + user.getPassword() + "";
        // 设置主题
        msg.setSubject("修改密码");
        // 设置内容
        msg.setContent(url, "text/html;charset=utf-8");
        // 3.发邮件
        try {
            Transport.send(msg);
        } catch (Exception e) {
            ajaxResult.setMessage("邮箱发送失败, 请稍后再试");
        }
        ajaxResult.setMessage("邮箱发送成功请前去确认");
        return ajaxResult;
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @RequestMapping("/retrievePWD")
    public String retrievePWD(User user) {
        mainService.updatePassword(user);
        return "_blank";
    }

    /**
     * 校验用户名
     *
     * @param username 用户名
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkAdmin")
    public AjaxResult checkAdmin(String username) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = mainService.findByUsername(username);
        if (user != null)
            ajaxResult.setMessage("用户名校验成功");
        else
            ajaxResult.setMessage("用户名不存在");
        return ajaxResult;
    }

    /**
     * 校验邮箱
     *
     * @param user1
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkEmail")
    public AjaxResult checkEmail(User user1) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = mainService.findByUsername(user1.getUsername());
        if (user != null) {
            boolean boo = user.getEmail().equals(user1.getEmail());
            if (boo)
                ajaxResult.setMessage("邮箱校验成功");
            else
                ajaxResult.setMessage("邮箱不存在");
        } else {
            ajaxResult.setMessage("用户名不存在");
        }
        return ajaxResult;
    }

    /**
     * 获取动态验证
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getVerifyCode")
    public void register2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                GeetestConfig.isnewfailback());
        String resStr = "{}";

        //自定义userid
        String userid = "test";

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("user_id", userid); //网站用户id
        param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP

        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(param);

        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("userid", userid);

        resStr = gtSdk.getResponseStr();

        PrintWriter out = response.getWriter();
        out.println(resStr);
    }

    @ResponseBody
    @RequestMapping("/showIP")
    public List<IPAddress> showIP() {
        return mainService.findIP();
    }

}
