package com.xdclass.xdvideo.framework;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author ct
 * @Title: CredentialMatch
 * @ProjectName demo2
 * @Description: 校验传入密码和数据库密码匹配
 * @date 2018/11/18 23:26
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {

    /**
     * 密码校验规则的重写
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //转换token为UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //拿出token里的密码
        String password = new String(usernamePasswordToken.getPassword());
        //拿出数据密码
        String dbpassword =(String) info.getCredentials();
        //自定义规则，看他们是否相等就可以了
        return this.equals(password,dbpassword);
    }

}
