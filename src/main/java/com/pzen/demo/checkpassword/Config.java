package com.pzen.demo.checkpassword;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author pzen
 */

public class Config {
    /**
     * 密码口令检测对应系统等级
     */
    public static String SYSTEM_GRADE;

    /**
     * 是否检测密码口令长度标识
     */
    public static String CHECK_PASSWORD_LENGTH;
    /**
     * 密码最小长度，默认为8
     */
    public static String MIN_LENGTH;
    /**
     * 密码最大长度，默认为20
     */
    public static String MAX_LENGTH;

    /**
     * 是否包含数字
     */
    public static String CHECK_CONTAIN_DIGIT;
    /**
     * 是否区分大小写
     */
    public static String CHECK_DISTINGGUISH_CASE;
    /**
     * 是否包含小写字母
     */
    public static String CHECK_LOWER_CASE;
    /**
     * 是否包含大写字母
     */
    public static String CHECK_UPPER_CASE;
    /**
     * 是否包含特殊符号
     */
    public static String CHECK_CONTAIN_SPECIAL_CHAR;
    /**
     * 特殊符号集合
     */
    public static String DEFAULT_SPECIAL_CHAR = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    public static String SPECIAL_CHAR;

    /**
     * 是否检测键盘按键横向连续
     */
    public static String CHECK_HORIZONTAL_KEY_SEQUENTIAL;
    /**
     * 键盘物理位置横向不允许最小的连续个数
     */
    public static String LIMIT_HORIZONTAL_NUM_KEY;
    /**
     * 是否检测键盘按键斜向连续
     */
    public static String CHECK_SLOPE_KEY_SEQUENTIAL;
    /**
     * 键盘物理位置斜向不允许最小的连续个数
     */
    public static String LIMIT_SLOPE_NUM_KEY;

    /**
     * 是否检测逻辑位置连续
     */
    public static String CHECK_LOGIC_SEQUENTIAL;
    /**
     * 密码口令中字符在逻辑位置上不允许最小的连续个数
     */
    public static String LIMIT_LOGIC_NUM_CHAR;

    /**
     * 是否检测连续字符相同
     */
    public static String CHECK_SEQUENTIAL_CHAR_SAME;
    /**
     * 密码口令中相同字符不允许最小的连续个数
     */
    public static String LIMIT_NUM_SAME_CHAR;

    /**
     * 键盘横向方向规则
     */
    public static String[] KEYBOARD_HORIZONTAL_ARR = {
            "01234567890",
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm",
    };
    /**
     * 键盘斜线方向规则
     */
    public static String[] KEYBOARD_SLOPE_ARR = {
            "1qaz",
            "2wsx",
            "3edc",
            "4rfv",
            "5tgb",
            "6yhn",
            "7ujm",
            "8ik,",
            "9ol.",
            "0p;/",
            "=[;.",
            "-pl,",
            "0okm",
            "9ijn",
            "8uhb",
            "7ygv",
            "6tfc",
            "5rdx",
            "4esz"
    };

    static {
        Properties prop = new Properties();

        try {
            URL url = Config.class.getClassLoader().getResource("password.properties");

            //读取属性文件enc.properties
            InputStream in = null;
            if (url != null) {
                in = new BufferedInputStream(new FileInputStream(URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8)));
            }
            prop.load(in);
            Iterator<String> it = prop.stringPropertyNames().iterator();
            while (it.hasNext()) {
                String key = it.next();

                if (key.equals("systemGrade")) {
                    SYSTEM_GRADE = prop.getProperty(key);
                }

                if (key.equals("checkPasswordLength")) {
                    CHECK_PASSWORD_LENGTH = prop.getProperty(key);
                }
                if (key.equals("limitPassMinLength")) {
                    MIN_LENGTH = prop.getProperty(key);
                }
                if (key.equals("limitPassMaxLength")) {
                    MAX_LENGTH = prop.getProperty(key);
                }

                if (key.equals("checkContainDigit")) {
                    CHECK_CONTAIN_DIGIT = prop.getProperty(key);
                }
                if (key.equals("checkContainUpperLowerCase")) {
                    CHECK_DISTINGGUISH_CASE = prop.getProperty(key);
                }
                if (key.equals("checkContainLowerCase")) {
                    CHECK_LOWER_CASE = prop.getProperty(key);
                }
                if (key.equals("checkContainUpperCase")) {
                    CHECK_UPPER_CASE = prop.getProperty(key);
                }
                if (key.equals("checkContainSpecialChar")) {
                    CHECK_CONTAIN_SPECIAL_CHAR = prop.getProperty(key);
                }
                if (key.equals("specialCharSet")) {
                    SPECIAL_CHAR = prop.getProperty(key);
                }

                if (key.equals("checkHorizontalKeySequential")) {
                    CHECK_HORIZONTAL_KEY_SEQUENTIAL = prop.getProperty(key);
                }
                if (key.equals("horizontalKeyLimitNum")) {
                    LIMIT_HORIZONTAL_NUM_KEY = prop.getProperty(key);
                }
                if (key.equals("checkSlopeKeySequential")) {
                    CHECK_SLOPE_KEY_SEQUENTIAL = prop.getProperty(key);
                }
                if (key.equals("slopeKeyLimitNum")) {
                    LIMIT_SLOPE_NUM_KEY = prop.getProperty(key);
                }

                if (key.equals("checkLogicSequential")) {
                    CHECK_LOGIC_SEQUENTIAL = prop.getProperty(key);
                }
                if (key.equals("logicLimitNum")) {
                    LIMIT_LOGIC_NUM_CHAR = prop.getProperty(key);
                }

                if (key.equals("checkSequentialCharSame")) {
                    CHECK_SEQUENTIAL_CHAR_SAME = prop.getProperty(key);
                }
                if (key.equals("sequentialCharNum")) {
                    LIMIT_NUM_SAME_CHAR = prop.getProperty(key);
                }

            }
            in.close();

            if ("2".equals(SYSTEM_GRADE) || "3".equals(SYSTEM_GRADE)) {

                if ("".equals(CHECK_PASSWORD_LENGTH)) {
                    CHECK_PASSWORD_LENGTH = "enable";
                    MIN_LENGTH = "8";
                    MAX_LENGTH = "20";
                }
                if ("".equals(CHECK_CONTAIN_DIGIT)) {
                    CHECK_CONTAIN_DIGIT = "enable";
                }
                if ("".equals(CHECK_DISTINGGUISH_CASE)) {
                    CHECK_DISTINGGUISH_CASE = "disable";
                }
                if ("".equals(CHECK_LOWER_CASE)) {
                    CHECK_LOWER_CASE = "enable";
                }
                if ("".equals(CHECK_UPPER_CASE)) {
                    CHECK_UPPER_CASE = "enable";
                }
                if ("".equals(CHECK_CONTAIN_SPECIAL_CHAR)) {
                    if ("2".equals(SYSTEM_GRADE)) {
                        CHECK_CONTAIN_SPECIAL_CHAR = "disable";
                    } else {
                        CHECK_CONTAIN_SPECIAL_CHAR = "enable";
                        if ("".equals(SPECIAL_CHAR)) {
                            SPECIAL_CHAR = DEFAULT_SPECIAL_CHAR;
                        }
                    }
                }

                if ("".equals(CHECK_HORIZONTAL_KEY_SEQUENTIAL)) {
                    CHECK_HORIZONTAL_KEY_SEQUENTIAL = "enable";
                    if ("2".equals(SYSTEM_GRADE)) {
                        LIMIT_HORIZONTAL_NUM_KEY = "4";
                    } else {
                        LIMIT_HORIZONTAL_NUM_KEY = "3";
                    }
                }

                if ("".equals(CHECK_SLOPE_KEY_SEQUENTIAL)) {
                    CHECK_SLOPE_KEY_SEQUENTIAL = "enable";
                    if ("2".equals(SYSTEM_GRADE)) {
                        LIMIT_SLOPE_NUM_KEY = "4";
                    } else {
                        LIMIT_SLOPE_NUM_KEY = "3";
                    }
                }

                if ("".equals(CHECK_LOGIC_SEQUENTIAL)) {
                    CHECK_LOGIC_SEQUENTIAL = "enable";
                    if ("2".equals(SYSTEM_GRADE)) {
                        LIMIT_LOGIC_NUM_CHAR = "4";
                    } else {
                        LIMIT_LOGIC_NUM_CHAR = "3";
                    }

                }
                if ("".equals(CHECK_SEQUENTIAL_CHAR_SAME)) {
                    CHECK_SEQUENTIAL_CHAR_SAME = "enable";
                    if ("2".equals(SYSTEM_GRADE)) {
                        LIMIT_NUM_SAME_CHAR = "4";
                    } else {
                        LIMIT_NUM_SAME_CHAR = "3";
                    }
                }
            } else {
                SYSTEM_GRADE = "3";
                CHECK_PASSWORD_LENGTH = "enable";
                MIN_LENGTH = "8";
                MAX_LENGTH = "20";
                CHECK_CONTAIN_DIGIT = "enable";
                CHECK_LOWER_CASE = "enable";
                CHECK_UPPER_CASE = "enable";
                CHECK_CONTAIN_SPECIAL_CHAR = "enable";
                CHECK_HORIZONTAL_KEY_SEQUENTIAL = "enable";
                LIMIT_HORIZONTAL_NUM_KEY = "3";
                CHECK_SLOPE_KEY_SEQUENTIAL = "enable";
                LIMIT_SLOPE_NUM_KEY = "3";
                CHECK_LOGIC_SEQUENTIAL = "enable";
                LIMIT_LOGIC_NUM_CHAR = "3";
                CHECK_SEQUENTIAL_CHAR_SAME = "enable";
                LIMIT_NUM_SAME_CHAR = "3";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
