package com.iot.sale.Base.util;

import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/11/26
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class StringUtil {

    private static String[] chineseNum = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    /**
     * 将单个的数字转换成字符
     *
     * @param i
     * @return
     */
    public static String int2String(Integer i) {
        if (i != null) {
            return chineseNum[i % 10];
        } else {
            return "";
        }
    }

    /**
     * 判断字符串是否为空，为Null、空串返回true；否则返回false；
     *
     * @param str
     * @return boolean
     */
    public static final boolean isNull(String str) {
        if (str != null && str.trim().length() >= 1) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 判断字符串是否为空，不为null，且也不为空字符串，则返回true，否则返回false。
     *
     * @param str
     * @return boolean
     */
    public static final boolean isNotNull(String str) {
        return !isNull(str);
    }

    /**
     * 对字符串进行MD5编码
     *
     * @param str 原字符串
     * @return MD5串(小写)
     */
    public static final String getMD5(String str) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        byte[] source = str.getBytes();

        MessageDigest mdTemp = null;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        mdTemp.update(source);
        byte[] md = mdTemp.digest();
        int j = md.length;

        char resultData[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            resultData[k++] = hexDigits[byte0 >>> 4 & 0xf];
            resultData[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(resultData);
    }

    /**
     * 用于将url地址转换成Unicode编码格式,默认是按照UTF-8格式进行编码的
     *
     * @param url www.baidu.com
     * @return 如：www.baidu.com/中国/china 则编码为：www.baidu.com/%E4%B8%AD%E5%9B%BD/china
     * @see：<br/> 字符编码笔记：ASCII，Unicode和UTF-8 http://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html <br/>
     * 关于URL编码	http://www.ruanyifeng.com/blog/2010/02/url_encoding.html <br/>
     * 字体编辑用中日韩字Unicode编码表 http://www.chi2ko.com/tool/CJK.htm
     * Unicode字符列表	http://zh.wikipedia.org/wiki/Unicode%E5%AD%97%E7%AC%A6%E5%88%97%E8%A1%A8
     */
    public static String encodeURL(String url) {
        try {
            /**
             * 将unicode编码中128后所有字符全部进行编码，排除掉128之前的是因为不编码 / : ? & 等字符。
             * 参考：
             */
            Matcher matcher = Pattern.compile("[\\u0080-\\uffff]").matcher(url);//
            while (matcher.find()) {
                String tmp = matcher.group();
                url = url.replaceAll(tmp, java.net.URLEncoder.encode(tmp, "UTF-8"));
            }
            url = url.replaceAll(" ", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 按照特定字符来分割字符串，返回分割后的集合
     *
     * @param str 将要被转换到字符串
     * @param p   分割所遵循的字符格式
     * @return
     * @注意：如果str中两个,之间包含了空字符串，该空字符串将被忽略。
     */
    public static List<String> stringToList(String str, String p) {
        if (isNull(str)) {
            return new ArrayList<String>();
        }
        String[] split = str.split(p);
        List<String> list = new ArrayList<String>();
        for (String s : split) {
            if (isNotNull(s.trim())) {
                list.add(s.trim());
            }
        }
        return list;
    }

    /**
     * 将一个包含string的集合转化为一个以","分割的字符串。
     *
     * @param coll
     * @return
     * @注意：如果list中包含了空字符串，该空字符串将被忽略。
     */
    public static String arrayToString(Collection<String> coll) {
        if (coll == null || coll.size() < 1) {
            return "";
        }
        StringBuffer sbf = new StringBuffer(256);
        for (String str : coll) {
            if (isNotNull(str)) {
                sbf = sbf.append(str.trim() + ",");
            }
        }
        String str = sbf.substring(0, sbf.length() - 1);
        return str;
    }

    /**
     * 字符是否都为英文字母
     *
     * @param str
     * @return
     */
    public static boolean isEnglishWord(String str) {
        if (isNull(str)) {
            return false;
        }
        char[] array = str.toCharArray();
        for (char c : array) {
            if (c < 65 || (c > 90 && c < 97) || c > 122) {
                return false;
            }
        }
        return true;
    }

    /**
     * 截取长字符串，比如将字符串“山东工商在传销企业录入数据[金惠花392310241982040739]与测试比对信息做对比时发出报警,该人员为测试比对”
     * 截取为“山东工商在传销企业录入数据……”
     *
     * @param num 截取的长度
     * @param str
     * @return
     */
    public static String stringSub(int num, String s) {
        int length = s.length();
        if (length <= num) {
            return s;
        } else {
            return s.substring(0, num) + "......";
        }
    }

    /**
     * 截取长字符串
     * <p>
     * stringSub("abcdef",5,"...") --> "abcde..."
     * stringSub("abcdef",10,"...") --> "abcdef"
     * stringSub("abcdef",5,null) --> "abcde"
     * stringSub("abcdef",5,"，你好") --> "abcde，你好"
     *
     * @param str       被截取的原始字符
     * @param subLength 截取的 长度
     * @param appendStr 被截取的字符后追加的字符。
     * @return
     */
    public static String subString(String str, int subLength, String appendStr) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return str;
        }
        if (str.length() < subLength) {
            return str;
        }

        String substring = str.substring(0, subLength);
        if (appendStr == null) {
            return substring;
        }
        return substring + appendStr;
    }

    /**
     * 截取长字符串
     * <p>
     * stringSub("abcde12345abcde",5,4,"...") --> "1234..."
     * stringSub("abcde12",5,4,"...") --> "12"
     * stringSub("abc",5,4,null) --> ""
     *
     * @param str        被截取的原始字符
     * @param startIndex 开始截取的位置，角标从0开始。如：startIndex = 5，则从第五位开始（包含第5位）。
     * @param subLength  截取的 长度
     * @param appendStr  被截取的字符后追加的字符。
     * @return
     */
    public static String subString(String str, int startIndex, int subLength, String appendStr) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return str;
        }
        if (str.length() < startIndex) {
            return "";
        }
        if (str.length() < (startIndex + subLength + 1)) {
            return str.substring(startIndex);
        }

        String substring = str.substring(startIndex, startIndex + subLength);
        if (appendStr == null) {
            return substring;
        }
        return substring + appendStr;
    }

    /**
     * 判断字符是否被GMS系统支持，只支持0-9，a-z,A-Z，中文，及连字符-_— 。
     * 主要用于判断前台传输过来的字符是否包含特殊字符等
     * 中日韩文在unicode中编码范围为 4E00 - 9FA5，19968 - 40869
     * 0-9	48-57
     * a-z	97-122
     * A-Z 65-90
     *
     * @param str
     * @return
     */
    public static boolean verify(String str) {
        boolean able = Boolean.TRUE;

        for (int i = 0; i < str.length(); i++) {
            int charAt = str.charAt(i);
            if (charAt >= 48 && charAt <= 57) {// 0-9
                able = Boolean.TRUE;
            } else if (charAt >= 65 && charAt <= 90) {// A-Z
                able = Boolean.TRUE;
            } else if (charAt >= 97 && charAt <= 122) {// a-z
                able = Boolean.TRUE;
            } else if (charAt >= 19968 && charAt <= 40869) {// 中日韩字符范围
                able = Boolean.TRUE;
            } else if (charAt == 45 || charAt == 95 || charAt == 8212) {// -_—
                // 英文及中文连字符
                able = Boolean.TRUE;
            } else {
                able = Boolean.FALSE;
                break;
            }
        }

        return able;
    }

    /**
     * 过滤表情
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        if (StringUtils.isNotBlank(source)) {
            return source.replaceAll("[\ud83c\udc00-\ud83e\udfff]|[\u2600-\u27ff]", "");
        } else {
            return source;
        }
    }

    /**
     * 打印字符串的unicode吗
     *
     * @param str
     * @return
     */
    public static String toUnicode(String str) {
        //存放返回值
        String restr = "";
        for (char a : str.toCharArray()) {
            //十六进制显示
            String ch = Integer.toHexString((int) a);
            //用0补齐四位
            for (int i = ch.length(); i < 4; i++) {
                ch = "0" + ch;
            }
            //全部转换成大写    不转换也无所谓
            ch = ch.toUpperCase();
            restr += "\\u" + ch;
        }
        return restr;
    }


    public static String toCamelStyle(String name) {
        StringBuilder newName = new StringBuilder();
        int len = name.length();

        for (int i = 0; i < len; ++i) {
            char c = name.charAt(i);
            if (i == 0) {
                newName.append(Character.toLowerCase(c));
            } else {
                newName.append(c);
            }
        }

        return newName.toString();
    }


    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values != null && values.length != 0) {
            String[] arr$ = values;
            int len$ = values.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                String value = arr$[i$];
                result &= !isEmpty(value);
            }
        } else {
            result = false;
        }

        return result;
    }


    public static boolean isEmpty(String value) {
        int strLen;
        if (value != null && (strLen = value.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(value.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNumeric(Object obj) {
        if (obj == null) {
            return false;
        } else {
            char[] chars = obj.toString().toCharArray();
            int length = chars.length;
            if (length < 1) {
                return false;
            } else {
                int i = 0;
                if (length > 1 && chars[0] == 45) {
                    i = 1;
                }

                while (i < length) {
                    if (!Character.isDigit(chars[i])) {
                        return false;
                    }

                    ++i;
                }

                return true;
            }
        }
    }


    public static String unicodeToChinese(String unicode) {
        StringBuilder out = new StringBuilder();
        if (!isEmpty(unicode)) {
            for (int i = 0; i < unicode.length(); ++i) {
                out.append(unicode.charAt(i));
            }
        }

        return out.toString();
    }


    public static String escapeXml(String value) {
        StringBuilder writer = new StringBuilder();
        char[] chars = value.trim().toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            switch (c) {
                case '\"':
                    writer.append("&quot;");
                    continue;
                case '&':
                    writer.append("&amp;");
                    continue;
                case '\'':
                    writer.append("&apos;");
                    continue;
                case '<':
                    writer.append("&lt;");
                    continue;
                case '>':
                    writer.append("&gt;");
                    continue;
            }

            if (c == 9 || c == 10 || c == 13 || c >= 32 && c <= '\ud7ff' || c >= '\ue000' && c <= '�' || c >= 65536 && c <= 1114111) {
                writer.append(c);
            }
        }

        return writer.toString();
    }

    public static Set<String> getClassProperties(Class<?> clazz, boolean isGet) {
        HashSet propNames = new HashSet();

        try {
            BeanInfo e = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] props = e.getPropertyDescriptors();
            PropertyDescriptor[] arr$ = props;
            int len$ = props.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                PropertyDescriptor prop = arr$[i$];
                String name = prop.getName();
                Method method;
                if (isGet) {
                    method = prop.getReadMethod();
                } else {
                    method = prop.getWriteMethod();
                }

                if (!"class".equals(name) && method != null) {
                    propNames.add(name);
                }
            }

            return propNames;
        } catch (Exception var11) {
            throw new RuntimeException(var11);
        }
    }
}