package mao.handler;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.handler
 * Class(类名): Base64
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 19:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Base64
{
    /**
     * Base64解码
     *
     * @param str str
     * @return {@link String}
     */
    public static String decode(String str)
    {
        String decoded = null;
        byte[] bytes = java.util.Base64.getDecoder().decode(str);
        decoded = new String(bytes, StandardCharsets.UTF_8);
        return decoded;
    }
}
