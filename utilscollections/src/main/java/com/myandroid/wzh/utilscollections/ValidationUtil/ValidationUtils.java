package com.myandroid.wzh.utilscollections.ValidationUtil;


import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author W.Z.H
 * @time 2018/6/9 9:08
 * @description 正则表达式
 */

public class ValidationUtils {


    /**
     * 邮箱表达式
     */
    private final static Pattern email_pattern = Pattern
            .compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");


    /**
     * 手机号表达式
     */
    private final static Pattern phone_pattern = Pattern
            .compile("^(13|15|18)\\d{9}$");


    /**
     * 银行卡号表达式
     */
    private final static Pattern bankNo_pattern = Pattern
            .compile("^[0-9]{16,19}$");


    /**
     * 数字表达式
     */
    private final static Pattern number_pattern = Pattern
            .compile("^[0-9]*$");


    /**
     * 大写字母表达式
     */
    private final static Pattern upChar_pattern = Pattern
            .compile("^[A-Z]+$");

    /**
     * 小写字母表达式
     */
    private final static Pattern lowChar_pattern = Pattern
            .compile("^[a-z]+$");

    /**
     * 大小写字母表达式
     */
    private final static Pattern letter_pattern = Pattern
            .compile("^[A-Za-z]+$");

    /**
     * 中文汉字表达式
     */
    private final static Pattern chinese_pattern = Pattern
            .compile("^[\u4e00-\u9fa5],{0,}$");


    /**
     * IP地式址表达
     */
    private final static Pattern ipaddress_pattern = Pattern
            .compile("[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))");


    /**
     * URL地址表达式
     */
    private final static Pattern url_pattern = Pattern
            .compile("(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?");




    /**
     * 验证是否为空串 (包括空格、制表符、回车符、
     * 换行符组成的字符串 若输入字符串为null或空字符串,返回true)
     * @param str 验证字符
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str) || str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }


    /**
     * 是否不为空
     * @param s
     */
    public static boolean isNotEmpty(String s){
        return s != null && !"".equals(s.trim());
    }


    /**
     * 验证是数字
     * @param str 验证字符
     * @return boolean
     */
    public static boolean isNumber(String str) {
        return number_pattern.matcher(str).matches();
    }


    /**
     * 验证是大写字母
     * @param str 验证字符
     * @return boolean
     */
    public static boolean isUpChar(String str) {
        return upChar_pattern.matcher(str).matches();
    }


    /**
     * 验证是小写字母
     * @param str 验证字符
     * @return boolean
     */
    public static boolean isLowChar(String str) {
        return lowChar_pattern.matcher(str).matches();
    }


    /**
     * 验证是英文字母
     * @param str 验证字符
     * @return boolean
     */
    public static boolean isLetter(String str) {
        return letter_pattern.matcher(str).matches();
    }


    /**
     * 验证输入汉字
     * @param str 验证字符
     * @return boolean
     */
    public static boolean isChinese(String str) {
        return chinese_pattern.matcher(str).matches();
    }

    /**
     * 是否含有特殊符号
     *
     * @param str 待验证的字符串
     * @return 是否含有特殊符号
     */
    public static boolean hasSpecialCharacter(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }


    /**
     * 验证邮箱是否正确
     * @param email  邮箱地址
     * @return boolean
     */
    public static boolean isEmail(String email) {
        return email_pattern.matcher(email).matches();
    }



    /**
     * 验证手机号是否正确
     * @param phone 手机号码
     * @return boolean
     */
    public static boolean isPhone(String phone) {
        return phone_pattern.matcher(phone).matches();
    }


    /**
     * 验证URL地址是否正确
     * @param url 地址
     * @return boolean
     */
    public static boolean isURL(String url){
        return url_pattern.matcher(url).matches();
    }




    /**
     * 验证是否是正整数
     * @param str 验证字符
     * @return boolean
     */
    public static boolean isInteger(String str){
        try{
            Integer.valueOf(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }


    /**
     * 验证是否是小数
     * @param paramString 验证字符
     * @return boolean
     */
    public static boolean isPoint(String paramString){
        if(paramString.indexOf(".") > 0){
            if(paramString.substring(paramString.indexOf(".")).length() > 3){
                return false;
            }
        }
        return true;
    }


    /**
     * 验证是否银行卡号
     * @param bankNo 银行卡号
     * @return
     */
    public static boolean isBankNo(String bankNo){
        //替换空格
        bankNo = bankNo.replaceAll(" ", "");
        //银行卡号可为12位数字
        if(12 == bankNo.length()){
            return true;
        }
        //银行卡号可为16-19位数字
        return bankNo_pattern.matcher(bankNo).matches();
    }

    /**
     * 判断是否有特殊字符
     * @param str 验证字符
     * @return boolean
     */
    public static boolean isPeculiarStr(String str){
        boolean flag = false;
        String regEx = "[^0-9a-zA-Z\u4e00-\u9fa5]+";
        if(str.length() != (str.replaceAll(regEx, "").length())) {
            flag = true;
        }
        return  flag;
    }

    /**
     * 获取字符串中文字符的长度（每个中文算2个字符）.
     *
     * @param str
     *            指定的字符串
     * @return 中文字符的长度
     */
    public static int chineseLength(String str) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); i++) {
                /* 获取一个字符 */
                String temp = str.substring(i, i + 1);
                /* 判断是否为中文字符 */
                if (temp.matches(chinese)) {
                    valueLength += 2;
                }
            }
        }
        return valueLength;
    }

    /**
     * 描述：获取字符串的长度.
     *
     * @param str
     *            指定的字符串
     * @return 字符串的长度（中文字符计2个）
     */
    public static int strLength(String str) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
            for (int i = 0; i < str.length(); i++) {
                // 获取一个字符
                String temp = str.substring(i, i + 1);
                // 判断是否为中文字符
                if (temp.matches(chinese)) {
                    // 中文字符长度为2
                    valueLength += 2;
                } else {
                    // 其他字符长度为1
                    valueLength += 1;
                }
            }
        }
        return valueLength;
    }

    /**
     * 描述：是否只是字母和数字.
     *
     * @param str
     *            指定的字符串
     * @return 是否只是字母和数字:是为true，否则false
     */
    public static Boolean isNumberLetter(String str) {
        Boolean isNoLetter = false;
        String expr = "^[A-Za-z0-9]+$";
        if (str.matches(expr)) {
            isNoLetter = true;
        }
        return isNoLetter;
    }

    /**
     * 描述：是否包含中文.
     *
     * @param str
     *            指定的字符串
     * @return 是否包含中文:是为true，否则false
     */
    public static Boolean isContainChinese(String str) {
        Boolean isChinese = false;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
            for (int i = 0; i < str.length(); i++) {
                // 获取一个字符
                String temp = str.substring(i, i + 1);
                // 判断是否为中文字符
                if (temp.matches(chinese)) {
                    isChinese = true;
                } else {

                }
            }
        }
        return isChinese;
    }


    /**
     * 描述：截取字符串到指定字节长度.
     *
     * @param str
     *            the str
     * @param length
     *            指定字节长度
     * @return 截取后的字符串
     */
    public static String cutString(String str, int length) {
        return cutString(str, length, "");
    }

    /**
     * 描述：截取字符串到指定字节长度.
     *
     * @param str
     *            文本
     * @param length
     *            字节长度
     * @param dot
     *            省略符号
     * @return 截取后的字符串
     */
    public static String cutString(String str, int length, String dot) {
        int strBLen = strlen(str, "GBK");
        if (strBLen <= length) {
            return str;
        }
        int temp = 0;
        StringBuffer sb = new StringBuffer(length);
        char[] ch = str.toCharArray();
        for (char c : ch) {
            sb.append(c);
            if (c > 256) {
                temp += 2;
            } else {
                temp += 1;
            }
            if (temp >= length) {
                if (dot != null) {
                    sb.append(dot);
                }
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 描述：截取字符串从第一个指定字符.
     *
     * @param str1
     *            原文本
     * @param str2
     *            指定字符
     * @param offset
     *            偏移的索引
     * @return 截取后的字符串
     */
    public static String cutStringFromChar(String str1, String str2, int offset) {
        if (isEmpty(str1)) {
            return "";
        }
        int start = str1.indexOf(str2);
        if (start != -1) {
            if (str1.length() > start + offset) {
                return str1.substring(start + offset);
            }
        }
        return "";
    }

    /**
     * 描述：获取字节长度.
     *
     * @param str
     *            文本
     * @param charset
     *            字符集（GBK）
     * @return the int
     */
    public static int strlen(String str, String charset) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int length = 0;
        try {
            length = str.getBytes(charset).length;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    /**
     * 获取大小的描述.
     *
     * @param size
     *            字节个数
     * @return 大小的描述
     */
    public static String getSizeDesc(long size) {
        String suffix = "B";
        if (size >= 1024) {
            suffix = "K";
            size = size >> 10;
            if (size >= 1024) {
                suffix = "M";
                // size /= 1024;
                size = size >> 10;
                if (size >= 1024) {
                    suffix = "G";
                    size = size >> 10;
                    // size /= 1024;
                }
            }
        }
        return size + suffix;
    }

    /**
     * 手机号码，中间4位星号替换
     *
     * @param phone 手机号
     * @return 星号替换的手机号
     */
    public static String phoneNoHide(String phone) {
        // 括号表示组，被替换的部分$n表示第n组的内容
        // 正则表达式中，替换字符串，括号的意思是分组，在replace()方法中，
        // 参数二中可以使用$n(n为数字)来依次引用模式串中用括号定义的字串。
        // "(\d{3})\d{4}(\d{4})", "$1****$2"的这个意思就是用括号，
        // 分为(前3个数字)中间4个数字(最后4个数字)替换为(第一组数值，保持不变$1)(中间为*)(第二组数值，保持不变$2)
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 银行卡号，保留最后4位，其他星号替换
     *
     * @param cardId 卡号
     * @return 星号替换的银行卡号
     */
    public static String cardIdHide(String cardId) {
        return cardId.replaceAll("\\d{15}(\\d{3})", "**** **** **** **** $1");
    }

}
