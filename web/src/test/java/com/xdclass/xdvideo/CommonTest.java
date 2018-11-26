package com.xdclass.xdvideo;

import com.xdclass.xdvideo.domain.User;
import com.xdclass.xdvideo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class CommonTest {
    @Test
    public void testGeneJwt(){
        User user=new User();
        user.setId(999);
        user.setHeadImg("www.xdclass.net");
        user.setName("xdclass");
        String token= JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }
    /**
     * 解密
     */

    @Test
    public  void  testCheck(){

        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjk5OSwibmFtZSI6InhkY2xhc3MiLCJpbWciOiJ3d3cueGRjbGFzcy5uZXQiLCJpYXQiOjE1NDMxMTE1NzMsImV4cCI6MTU0NTAzOTgzNH0.YXyjfhopZwHL3rHd9e-2n6HPCIFH11v1Atqc5UQLzUw";
        Claims claims=JwtUtils.checkJwt(token);
        if(claims!=null){
        String name=(String) claims.get("name");
        int id=(Integer) claims.get("id");
            String img=(String) claims.get("img");

            System.out.println(name);
            System.out.println(id);
            System.out.println(img);
        }else {
            //别人伪造，或者过期
            System.out.println("非法token");
        }

    }
}
