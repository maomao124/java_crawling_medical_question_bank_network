package mao.service.impl;

import mao.net.RestfulHTTP;
import mao.service.QuestionService;
import mao.utils.SslUtils;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.service.impl
 * Class(类名): QuestionServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 20:16
 * Version(版本): 1.0
 * Description(描述)： 服务实现类
 */

public class QuestionServiceImpl implements QuestionService
{

    private final RestfulHTTP restfulHTTP;

    /**
     * 构造方法
     *
     * @param restfulHTTP restful http
     */
    public QuestionServiceImpl(RestfulHTTP restfulHTTP)
    {
        this.restfulHTTP = restfulHTTP;
    }

    static
    {
        try
        {
            SslUtils.ignoreSsl();
            System.out.println("忽略HTTPS请求的SSL证书");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
