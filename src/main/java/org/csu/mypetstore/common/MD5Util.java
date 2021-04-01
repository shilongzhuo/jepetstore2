package org.csu.mypetstore.common;

import java.security.MessageDigest;
import org.apache.commons.codec.digest.DigestUtils;

//MD5加密工具类
public class MD5Util {

    public static String key = "YiLuoYi";

    public static String md5(String password) {

        String md5str = DigestUtils.md5Hex(password + key);
        return md5str;
    }

    public static boolean verify(String password,String md5)throws Exception{
        String md5str = md5(password);
        if (md5str.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }

}
