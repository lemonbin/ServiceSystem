package com.baidu.base.shiro;

import com.baidu.base.domain.IPAddress;
import com.baidu.base.mapper.MainMapper;

import com.baidu.user.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.apache.shiro.web.subject.WebSubject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 2017/12/4.
 */
@Service
public class MyRealm extends AuthorizingRealm {

    @Resource
    private MainMapper mainMapper;


    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权方式

        //1.认证的结果: 取出User实体类/用户名
        String username = (String) principalCollection.getPrimaryPrincipal();

        System.out.println(username);

        //2.从数据库中获取该用户的所有角色和权限

        //============>模拟数据<===================

        List<String> roleList = new ArrayList<>();
        roleList.add("CEO");
        roleList.add("HR");

        List<String> perList = new ArrayList<>();
        perList.add("user:create");
        perList.add("user:query");


        //============>模拟结束<===================

        //3.将获取的角色和权限统一起来
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        info.addStringPermissions(perList);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        ServletRequest request = ((WebSubject) SecurityUtils.getSubject()).getServletRequest();
        //获得用户此次输入的用户名
        String username = (String) token.getPrincipal();
        //此处应该拿username去数据库查询, 是否存在该用户
        User user = mainMapper.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户名不存在");
        }
        String password = new String((char[]) token.getCredentials());

        User user1 = new User(username, password);

        User user2 = mainMapper.findSingle(user1);
        if (user2 == null) {
            throw new IncorrectCredentialsException("密码错误");
        } else {
            request.getServletContext().setAttribute("user", user2);
            List<IPAddress> ipAddresses = mainMapper.findIP();
            IPAddress ipAddress1 = ipAddresses.get(ipAddresses.size() - 1);
            String ip = request.getRemoteAddr();
            IPAddress ipAddress = new IPAddress();
            ipAddress.setId(user2.getId());
            ipAddress.setLoginTime(new Timestamp(new Date().getTime()));
            ipAddress.setIp(ip);
            ipAddress.setCount(ipAddress1.getCount() + 1);
            mainMapper.save(ipAddress);
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
