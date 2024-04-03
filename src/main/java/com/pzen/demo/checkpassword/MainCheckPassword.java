package com.pzen.demo.checkpassword;

/**
 * 密码规则验证测试
 * @author pzen
 */

public class MainCheckPassword {

    public static void main(String[] args) {
        System.out.println("this is a test code");

        boolean flag = false;
        String[] testPass = {
                null,
                "",
                "admin",
                "password",
                "123456",
                "12345678",
                "abcdefgh",
                "123abc456",
                "1231adf@",
                "12341adf@",
                "fdahuier243335ddfa#$*&",
                "aBcd1859d4!@",
                "zaq13edfgt#",
                "Bgt5sj4#",
                "Rcny*2023030321"
        };
        for (int i = 0; i < testPass.length; i++) {
            System.out.printf("testpass[%d] = %s\n", i,testPass[i]);
            flag = CheckPassword.EvalPWD(testPass[i]);
            if (flag) {
                System.out.println("通过规则。\n");
            } else {
                System.out.println("通过失败！\n");
            }
        }
    }

}
