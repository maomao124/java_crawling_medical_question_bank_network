package mao.service.impl;

import mao.constant.UrlConstant;
import mao.entity.QuestionTitle;
import mao.entity.R;
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


    @Override
    public QuestionTitle getQuestionTitle(String cid, String sid)
    {
        //构建url
        String url = UrlConstant.questionApiUrl + "?cid=" + cid + "&sid=" + sid;
        //发起请求
        R r = restfulHTTP.GET(R.class, url, null, null);
        //状态
        Integer status = r.getStatus();
        //判断状态
        if (status != 1)
        {
            //得到错误信息
            String errMsg = r.getErrMsg();
            //抛出异常
            throw new RuntimeException("服务器错误! 状态码：" + status + "  错误信息：" + errMsg);
        }
        //正常
        //读取数据
        QuestionTitle questionTitle = r.getData();
        if (questionTitle == null)
        {
            //得到错误信息
            String errMsg = r.getErrMsg();
            //抛出异常
            throw new RuntimeException("读取不到数据! 状态码：" + status + "  错误信息：" + errMsg);
        }
        //返回
        return questionTitle;
    }
}
