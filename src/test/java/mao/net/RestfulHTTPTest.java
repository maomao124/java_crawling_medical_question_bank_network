package mao.net;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.net
 * Class(测试类名): RestfulHTTPTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 19:24
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class RestfulHTTPTest
{

    private static  RestfulHTTP restfulHTTP;

    @BeforeAll
    static void beforeAll()
    {
        restfulHTTP = new SimpleRestfulHTTPImpl();
        restfulHTTP.setThreadPool(Executors.newSingleThreadExecutor());
    }

    @Test
    void requestArray()
    {
        //restfulHTTP.requestArray()
    }

    @Test
    void GETArray()
    {
    }

    @Test
    void asyncRequestArray()
    {
    }

    @Test
    void asyncGETRequestArray()
    {
    }
}
