package com.xdclass.xdvideo.framework;


import com.xdclass.xdvideo.domain.Permission;
import com.xdclass.xdvideo.domain.Role;
import com.xdclass.xdvideo.domain.User;
import com.xdclass.xdvideo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author ct
 * @Title: AuthRealm
 * @ProjectName demo2
 * @Description: 认证授权
 * @date 2018/11/18 21:55
 */
@SuppressWarnings("ALL")
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if (!CollectionUtils.isEmpty(roleSet)) {
            for(Role role : roleSet) {
                roleNameList.add(role.getRname());
                Set<Permission> permissionSet = role.getPermission();
                if (!CollectionUtils.isEmpty(permissionSet)) {
                    for (Permission permission : permissionSet) {
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }

    /**
     * 认证登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       //转换传入的token
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) authenticationToken;
        //从账户标识中取出用户名
        String username=usernamePasswordToken.getUsername();
        //从数据库中取出对应用户
        User user=userService.findByUsername(username);
        //转换成SimpleAuthenticationInfo对象
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
