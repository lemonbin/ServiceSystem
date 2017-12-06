package com.baidu.base.controller;

import com.baidu.base.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
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
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "index";
        }
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
    public String checkCode(String verifyCode, HttpServletRequest request) {
        String code = (String) request.getSession().getAttribute("code");
        if (code.equalsIgnoreCase(verifyCode)) {
            return "验证码错误";
        } else {
            return "验证码正确";
        }
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

    @RequestMapping("/admin-role-add")
    public String admin_role_add() {
        return "admin/admin-role-add";
    }

    /**
     * 获取验证码图片以及值
     */
    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCode code = new VerifyCode();
        BufferedImage image = code.getImage();
        request.getSession().setAttribute("code", code.getText());
        VerifyCode.output(image, response.getOutputStream());
    }


    @RequestMapping("/article-list")
    public String article_listPage() {
        return "article/article-list";
    }

    @RequestMapping("/picture-list")
    public String picture_listPage() {
        return "picture/picture-list";
    }

    @RequestMapping("/product-brand")
    public String product_brandPage() {
        return "product/product-brand";
    }

    @RequestMapping("/product-category")
    public String product_categoryPage() {
        return "product/product-category";
    }

    @RequestMapping("/product-category-add")
    public String product_category_addPage() {
        return "product/product-category-add";
    }

    @RequestMapping("/product-list")
    public String product_listPage() {
        return "product/product-list";
    }

    @RequestMapping("/feedback-list")
    public String feedback_listPage() {
        return "feedback-list";
    }

    @RequestMapping("/member-list")
    public String member_listPage() {
        return "member/member-list";
    }

    @RequestMapping("/member-add")
    public String member_addPage() {
        return "member/member-add";
    }

    @RequestMapping("/member-del")
    public String member_delPage() {
        return "member/member-del";
    }


    @RequestMapping("/member-show")
    public String member_showPage() {
        return "member/member-show";
    }

    @RequestMapping("/member-record-browse")
    public String member_record_browsePage() {
        return "member/member-record-browse";
    }

    @RequestMapping("/member-record-download")
    public String member_record_downloadPage() {
        return "member/member-record-download";
    }

    @RequestMapping("/member-record-share")
    public String member_record_sharePage() {
        return "member/member-record-share";
    }

    @RequestMapping("/charts-1")
    public String charts_1Page() {
        return "charts/charts-1";
    }

    @RequestMapping("/charts-2")
    public String charts_2Page() {
        return "charts/charts-2";
    }

    @RequestMapping("/charts-3")
    public String charts_3Page() {
        return "charts/charts-3";
    }

    @RequestMapping("/charts-4")
    public String charts_4Page() {
        return "charts/charts-4";
    }

    @RequestMapping("/charts-5")
    public String charts_5Page() {
        return "charts/charts-5";
    }

    @RequestMapping("/charts-6")
    public String charts_6Page() {
        return "charts/charts-6";
    }

    @RequestMapping("/charts-7")
    public String charts_7Page() {
        return "charts/charts-7";
    }

    @RequestMapping("/system-base")
    public String system_basePage() {
        return "system/system-base";
    }

    @RequestMapping("/system-category")
    public String system_categoryPage() {
        return "system/system-category";
    }

    @RequestMapping("/system-data")
    public String system_dataPage() {
        return "system/system-data";
    }

    @RequestMapping("/system-shielding")
    public String system_shieldingPage() {
        return "system/system-shielding";
    }

    @RequestMapping("/system-log")
    public String system_logPage() {
        return "system/system-log";
    }
}
