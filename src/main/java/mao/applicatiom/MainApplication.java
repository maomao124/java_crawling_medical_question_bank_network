package mao.applicatiom;

import mao.constant.UrlConstant;
import mao.net.RestfulHTTP;
import mao.net.SimpleRestfulHTTPImpl;
import mao.service.QuestionService;
import mao.service.impl.QuestionServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.applicatiom
 * Class(类名): MainApplication
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 20:34
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MainApplication
{
    /**
     * restfulHTTP
     */
    private static final RestfulHTTP restfulHTTP;

    public static final QuestionService questionService;

    static
    {
        restfulHTTP = new SimpleRestfulHTTPImpl();
        restfulHTTP.setConnectTimeout(30000);
        restfulHTTP.setReadTimeout(30000);
        restfulHTTP.setThreadPool(Executors.newFixedThreadPool(2));
        questionService = new QuestionServiceImpl(restfulHTTP);

        Map<String, String> header = new HashMap<>();

        header.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
        header.put("Referer", UrlConstant.baseUrl + "app");
        header.put("sec-ch-ua", "\"Not_A Brand\";v=\"99\", \"Microsoft Edge\";v=\"109\", \"Chromium\";v=\"109\"");
        header.put("sec-ch-ua-platform", "Windows");
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.70");

        restfulHTTP.setDefaultRequestHeader(header);
    }


    /**
     * 得到RestfulHTTP
     *
     * @return {@link RestfulHTTP}
     */
    public static RestfulHTTP getRestfulHTTP()
    {
        return restfulHTTP;
    }

    /**
     * 得到服务
     *
     * @return {@link QuestionService}
     */
    public static QuestionService getQuestionService()
    {
        return questionService;
    }

}
