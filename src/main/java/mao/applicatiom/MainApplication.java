package mao.applicatiom;

import mao.net.RestfulHTTP;
import mao.net.SimpleRestfulHTTPImpl;
import mao.service.QuestionService;
import mao.service.impl.QuestionServiceImpl;

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
