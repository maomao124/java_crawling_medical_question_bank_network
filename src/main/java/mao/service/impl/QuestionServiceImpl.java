package mao.service.impl;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import mao.constant.UrlConstant;
import mao.entity.*;
import mao.handler.Base64;
import mao.net.RestfulHTTP;
import mao.service.QuestionService;
import mao.utils.FileUtils;
import mao.utils.SslUtils;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            Toolkit.getDefaultToolkit().beep();
            //得到错误信息
            String errMsg = r.getErrMsg();
            //抛出异常
            throw new RuntimeException("服务器错误! 状态码：" + status + "  错误信息：" + errMsg);
        }
        //正常
        //读取数据
        QuestionTitle questionTitle = r.getData(QuestionTitle.class);
        if (questionTitle == null)
        {
            Toolkit.getDefaultToolkit().beep();
            //得到错误信息
            String errMsg = r.getErrMsg();
            //抛出异常
            throw new RuntimeException("读取不到数据! 状态码：" + status + "  错误信息：" + errMsg);
        }
        if (questionTitle.getInfo() == null)
        {
            Toolkit.getDefaultToolkit().beep();
            //抛出异常
            throw new RuntimeException("读取不到数据! 请检查是否输入了正确的cid和sid");
        }
        //返回
        return questionTitle;
    }

    @Override
    public List<Question> getQuestionList(String quiz)
    {
        //解码
        String json;
        try
        {
            json = Base64.decode(quiz);
        }
        catch (Exception e)
        {
            throw new RuntimeException("解码失败！，可能是后端服务器换加密方式了，或者读取不到数据。以下是异常信息：\n" + e.getMessage());
        }
        //json转对象
        return JSON.parseArray(json, Question.class);
    }

    @Override
    public String saveToTxtFile(QuestionTitle questionTitle, List<Question> questionList)
    {
        QuestionInfo questionInfo = questionTitle.getInfo();
        String subject = questionInfo.getSubject();
        String name = questionInfo.getName();
        String fileName = subject + "-" + name + ".txt";
        System.out.println("正在保存到txt文件，文件名称：" + fileName);

        StringBuilder stringBuilder = new StringBuilder(1000);
        stringBuilder.append(subject).append("-").append(name)
                .append("\n\n\n");

        for (int i = 0; i < questionList.size(); i++)
        {
            Question question = questionList.get(i);
            //判断题型
            if (question.getQtype() == 1)
            {
                //单选题
                stringBuilder.append("第").append(i + 1).append("题")
                        .append("\n")
                        .append("题目类型：单选题")
                        .append("\n")
                        .append("问题：")
                        .append(question.getTitle())
                        .append("\n");
                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append(question.getA()).append("\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append(question.getB()).append("\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append(question.getC()).append("\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append(question.getD()).append("\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append(question.getE()).append("\n");
                }

                //正确答案
                stringBuilder.append("正确答案：")
                        .append(question.getAnswer()).append("\n");
                //解析
                if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder.append("解析：").append(question.getNote()).append("\n");
                }
            }

            if (question.getQtype() == 2)
            {
                //单选题
                stringBuilder.append("第").append(i + 1).append("题")
                        .append("\n")
                        .append("题目类型：多选题")
                        .append("\n")
                        .append("问题：")
                        .append(question.getTitle())
                        .append("\n");
                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append(question.getA()).append("\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append(question.getB()).append("\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append(question.getC()).append("\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append(question.getD()).append("\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append(question.getE()).append("\n");
                }

                //正确答案
                stringBuilder.append("正确答案：")
                        .append(question.getAnswer()).append("\n");
                //解析
                if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder.append("解析：").append(question.getNote()).append("\n");
                }
            }

            if (question.getQtype() == 3 || question.getQtype() == 4)
            {
                //单选题
                stringBuilder.append("第").append(i + 1).append("题")
                        .append("\n")
                        .append("题目类型：记忆题")
                        .append("\n")
                        .append("问题：")
                        .append(question.getTitle())
                        .append("\n");
                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append(question.getA()).append("\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append(question.getB()).append("\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append(question.getC()).append("\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append(question.getD()).append("\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append(question.getE()).append("\n");
                }
                //正确答案
                //stringBuilder.append("正确答案：")
                // .append(question.getAnswer()).append("\n");
                //解析
                if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder.append("解析：").append(question.getNote().trim()).append("\n");
                }
            }
            stringBuilder.append("\n\n\n");
        }

        String data = stringBuilder.toString();

        System.out.println("正在写入到文件 " + fileName);
        boolean b = FileUtils.write("./" + fileName, data);
        System.out.println("写入是否成功：" + b);

        return data;
    }

    @Override
    public String saveToTxtFileNoAnswer(QuestionTitle questionTitle, List<Question> questionList)
    {
        QuestionInfo questionInfo = questionTitle.getInfo();
        String subject = questionInfo.getSubject();
        String name = questionInfo.getName();
        String fileName = subject + "-" + name + "-无答案版.txt";
        System.out.println("正在保存到txt文件，文件名称：" + fileName);

        StringBuilder stringBuilder = new StringBuilder(1000);
        stringBuilder.append(subject).append("-").append(name)
                .append("\n\n\n");

        for (int i = 0; i < questionList.size(); i++)
        {
            Question question = questionList.get(i);
            //判断题型
            if (question.getQtype() == 1)
            {
                //单选题
                stringBuilder.append("第").append(i + 1).append("题")
                        .append("\n")
                        .append("题目类型：单选题")
                        .append("\n")
                        .append("问题：")
                        .append(question.getTitle())
                        .append("\n");
                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append(question.getA()).append("\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append(question.getB()).append("\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append(question.getC()).append("\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append(question.getD()).append("\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append(question.getE()).append("\n");
                }

            }

            if (question.getQtype() == 2)
            {
                //单选题
                stringBuilder.append("第").append(i + 1).append("题")
                        .append("\n")
                        .append("题目类型：多选题")
                        .append("\n")
                        .append("问题：")
                        .append(question.getTitle())
                        .append("\n");
                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append(question.getA()).append("\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append(question.getB()).append("\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append(question.getC()).append("\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append(question.getD()).append("\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append(question.getE()).append("\n");
                }
            }

            if (question.getQtype() == 3 || question.getQtype() == 4)
            {
                //单选题
                stringBuilder.append("第").append(i + 1).append("题")
                        .append("\n")
                        .append("题目类型：记忆题")
                        .append("\n")
                        .append("问题：")
                        .append(question.getTitle())
                        .append("\n");
                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append(question.getA()).append("\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append(question.getB()).append("\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append(question.getC()).append("\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append(question.getD()).append("\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append(question.getE()).append("\n");
                }
                //正确答案
                //stringBuilder.append("正确答案：")
                // .append(question.getAnswer()).append("\n");
                //解析
                if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder.append("解析：").append(question.getNote().trim()).append("\n");
                }
            }
            stringBuilder.append("\n\n\n");
        }

        String data = stringBuilder.toString();

        System.out.println("正在写入到文件 " + fileName);
        boolean b = FileUtils.write("./" + fileName, data);
        System.out.println("写入是否成功：" + b);

        return data;
    }


    @Override
    public String saveToMarkDownFile(QuestionTitle questionTitle, List<Question> questionList)
    {

        //分类
        //单选题
        List<Question> type1questionList = new ArrayList<>();
        //多选题
        List<Question> type2questionList = new ArrayList<>();
        //记忆题
        List<Question> type3questionList = new ArrayList<>();
        for (Question question : questionList)
        {
            if (question.getQtype() == 1)
            {
                //单选题
                type1questionList.add(question);
            }
            else if (question.getQtype() == 2)
            {
                //多选题
                type2questionList.add(question);
            }
            else
            {
                //记忆题
                type3questionList.add(question);
            }
        }

        QuestionInfo questionInfo = questionTitle.getInfo();
        String subject = questionInfo.getSubject();
        String name = questionInfo.getName();
        String fileName = subject + "-" + name + ".md";
        System.out.println("正在保存到md文件，文件名称：" + fileName);

        StringBuilder stringBuilder = new StringBuilder(1000);
        stringBuilder
                .append("\n")
                .append("<h1 style=\"font-size:2.2em;color:skyblue;text-align:left\">目录</h1>")
                .append("\n\n")
                .append("[TOC]")
                .append("\n\n")
                .append("---")
                .append("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
                .append("# ")
                .append(questionInfo.getSubject())
                .append("\n\n")
                .append("## ")
                .append(questionInfo.getName())
                .append("\n\n");

        int i = 1;

        if (type1questionList.size() > 0)
        {
            stringBuilder.append("### 单选题")
                    .append("\n\n");

            for (Question question : type1questionList)
            {
                stringBuilder.append("#### ")
                        .append(i)
                        .append(". ")
                        .append(question.getTitle())
                        .append("\n\n");

                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getA())
                            .append("\n\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getB())
                            .append("\n\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getC())
                            .append("\n\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getD())
                            .append("\n\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append("* ").append(question.getE())
                            .append("\n\n");
                }

                //正确答案
                stringBuilder.append("**")
                        .append("正确答案：")
                        .append(question.getAnswer())
                        .append("**")
                        .append("\n\n");
                //解析
                if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder
                            .append("> ")
                            .append("解析：").append(question.getNote())
                            .append("\n\n");
                }
                stringBuilder.append("\n\n\n\n\n\n");
                i++;
            }

        }

        if (type2questionList.size() > 0)
        {
            stringBuilder.append("\n\n\n\n");


            stringBuilder.append("### 多选题")
                    .append("\n\n");

            for (Question question : type2questionList)
            {
                stringBuilder.append("#### ")
                        .append(i)
                        .append(". ")
                        .append(question.getTitle())
                        .append("\n\n");

                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getA())
                            .append("\n\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getB())
                            .append("\n\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getC())
                            .append("\n\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getD())
                            .append("\n\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append("* ").append(question.getE())
                            .append("\n\n");
                }

                //正确答案
                stringBuilder.append("**")
                        .append("正确答案：")
                        .append(question.getAnswer())
                        .append("**")
                        .append("\n\n");
                //解析
                if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder
                            .append("> ")
                            .append("解析：").append(question.getNote())
                            .append("\n\n");
                }
                stringBuilder.append("\n\n\n\n\n\n");
                i++;
            }
        }

        if (type3questionList.size() > 0)
        {
            stringBuilder.append("\n\n\n\n");


            stringBuilder.append("### 记忆题")
                    .append("\n\n");

            for (Question question : type3questionList)
            {
                stringBuilder.append("#### ")
                        .append(i)
                        .append(". ")
                        .append(question.getTitle())
                        .append("\n\n");

                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getA())
                            .append("\n\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getB())
                            .append("\n\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getC())
                            .append("\n\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getD())
                            .append("\n\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append("* ").append(question.getE())
                            .append("\n\n");
                }

                //正确答案
                /*stringBuilder.append("**")
                        .append("正确答案：")
                        .append(question.getAnswer())
                        .append("**")
                        .append("\n\n");*/
                //解析
                if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder
                            .append("> ")
                            .append("解析：").append(question.getNote())
                            .append("\n\n");
                }
                stringBuilder.append("\n\n\n\n\n\n");
                i++;
            }
        }


        stringBuilder.append("\n\n\n\n\n\n\n\n\n\n")
                .append("---")
                .append("\n\n");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        stringBuilder.append("构建日期：").append(date)
                .append("\n\n").append("cid: ")
                .append(questionInfo.getCid())
                .append("\n\n").append("sid: ")
                .append(questionInfo.getSid())
                .append("\n\n")
                .append("build  by  mao")
                .append("\n\n").append("构建用户：")
                .append(System.getProperty("user.name"))
                .append("\n\n")
                .append("---");


        String data = stringBuilder.toString();

        System.out.println("正在写入到文件 " + fileName);
        boolean b = FileUtils.write("./" + fileName, data);
        System.out.println("写入是否成功：" + b);

        return data;

    }

    @Override
    public String saveToMarkDownFileNoAnswer(QuestionTitle questionTitle, List<Question> questionList)
    {
        //分类
        //单选题
        List<Question> type1questionList = new ArrayList<>();
        //多选题
        List<Question> type2questionList = new ArrayList<>();
        //记忆题
        List<Question> type3questionList = new ArrayList<>();
        for (Question question : questionList)
        {
            if (question.getQtype() == 1)
            {
                //单选题
                type1questionList.add(question);
            }
            else if (question.getQtype() == 2)
            {
                //多选题
                type2questionList.add(question);
            }
            else
            {
                //记忆题
                type3questionList.add(question);
            }
        }

        QuestionInfo questionInfo = questionTitle.getInfo();
        String subject = questionInfo.getSubject();
        String name = questionInfo.getName();
        String fileName = subject + "-" + name + "-无答案版.md";
        System.out.println("正在保存到md文件，文件名称：" + fileName);

        StringBuilder stringBuilder = new StringBuilder(1000);
        stringBuilder
                .append("\n")
                .append("<h1 style=\"font-size:2.2em;color:skyblue;text-align:left\">目录</h1>")
                .append("\n\n")
                .append("[TOC]")
                .append("\n\n")
                .append("---")
                .append("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
                .append("# ")
                .append(questionInfo.getSubject())
                .append("\n\n")
                .append("## ")
                .append(questionInfo.getName())
                .append("\n\n");

        int i = 1;

        if (type1questionList.size() > 0)
        {
            stringBuilder.append("### 单选题")
                    .append("\n\n");

            for (Question question : type1questionList)
            {
                stringBuilder.append("#### ")
                        .append(i)
                        .append(". ")
                        .append(question.getTitle())
                        .append("\n\n");

                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getA())
                            .append("\n\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getB())
                            .append("\n\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getC())
                            .append("\n\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getD())
                            .append("\n\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append("* ").append(question.getE())
                            .append("\n\n");
                }

                //正确答案
                /*stringBuilder.append("**")
                        .append("正确答案：")
                        .append(question.getAnswer())
                        .append("**")
                        .append("\n\n");*/
                //解析
                /*if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder
                            .append("> ")
                            .append("解析：").append(question.getNote())
                            .append("\n\n");
                }*/

                stringBuilder.append("\n\n\n\n\n\n");
                i++;
            }

        }

        if (type2questionList.size() > 0)
        {
            stringBuilder.append("\n\n\n\n");


            stringBuilder.append("### 多选题")
                    .append("\n\n");

            for (Question question : type2questionList)
            {
                stringBuilder.append("#### ")
                        .append(i)
                        .append(". ")
                        .append(question.getTitle())
                        .append("\n\n");

                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getA())
                            .append("\n\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getB())
                            .append("\n\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getC())
                            .append("\n\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getD())
                            .append("\n\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append("* ").append(question.getE())
                            .append("\n\n");
                }

                //正确答案
                /*stringBuilder.append("**")
                        .append("正确答案：")
                        .append(question.getAnswer())
                        .append("**")
                        .append("\n\n");*/
                //解析
                /*if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder
                            .append("> ")
                            .append("解析：").append(question.getNote())
                            .append("\n\n");
                }*/
                stringBuilder.append("\n\n\n\n\n\n");
                i++;
            }
        }

        if (type3questionList.size() > 0)
        {
            stringBuilder.append("\n\n\n\n");


            stringBuilder.append("### 记忆题")
                    .append("\n\n");

            for (Question question : type3questionList)
            {
                stringBuilder.append("#### ")
                        .append(i)
                        .append(". ")
                        .append(question.getTitle())
                        .append("\n\n");

                //选项a
                if (question.getA() != null && !question.getA().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getA())
                            .append("\n\n");
                }
                //选项b
                if (question.getB() != null && !question.getB().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getB())
                            .append("\n\n");
                }
                //选项c
                if (question.getC() != null && !question.getC().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getC())
                            .append("\n\n");
                }
                //选项d
                if (question.getD() != null && !question.getD().equals(""))
                {
                    stringBuilder.append("* ")
                            .append(question.getD())
                            .append("\n\n");
                }
                //选项e
                if (question.getE() != null && !question.getE().equals(""))
                {
                    stringBuilder.append("* ").append(question.getE())
                            .append("\n\n");
                }

                //正确答案
                /*stringBuilder.append("**")
                        .append("正确答案：")
                        .append(question.getAnswer())
                        .append("**")
                        .append("\n\n");*/
                //解析
                if (question.getNote() != null && !question.getNote().equals(""))
                {
                    stringBuilder
                            .append("> ")
                            .append("解析：").append(question.getNote())
                            .append("\n\n");
                }
                stringBuilder.append("\n\n\n\n\n\n");
                i++;
            }
        }


        stringBuilder.append("\n\n\n\n\n\n\n\n\n\n")
                .append("---")
                .append("\n\n");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        stringBuilder.append("构建日期：").append(date)
                .append("\n\n").append("cid: ")
                .append(questionInfo.getCid())
                .append("\n\n").append("sid: ")
                .append(questionInfo.getSid())
                .append("\n\n")
                .append("build  by  mao")
                .append("\n\n").append("构建用户：")
                .append(System.getProperty("user.name"))
                .append("\n\n")
                .append("---");


        String data = stringBuilder.toString();

        System.out.println("正在写入到文件 " + fileName);
        boolean b = FileUtils.write("./" + fileName, data);
        System.out.println("写入是否成功：" + b);

        return data;

    }


    @Override
    public String getMainHtml()
    {
        // 新建一个模拟谷歌Chrome浏览器的浏览器客户端对象
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        // 当JS执行出错的时候是否抛出异常, 这里选择不需要
        //接受任何主机连接 无论是否有有效证书
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        // 当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        //设置连接超时时间
        webClient.getOptions().setTimeout(60000);
        webClient.setJavaScriptTimeout(5000);
        webClient.getOptions().setDoNotTrackEnabled(false);
        // 是否启用CSS
        webClient.getOptions().setCssEnabled(true);
        // 启用JS
        webClient.getOptions().setJavaScriptEnabled(true);
        // 很重要，设置支持AJAX
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());

        HtmlPage page;
        try
        {
            page = webClient.getPage(UrlConstant.baseAppUrl);
            Thread.sleep(3000);
            System.out.println(page.asXml());
            return page.asXml();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            webClient.close();
        }
        return null;
    }


    @Override
    public QuestionSubject getQuestionSubject(String sid)
    {
        //url
        String url = UrlConstant.questionApiSubjectUrl + "?id=" + sid;
        //访问
        R r = restfulHTTP.GET(R.class, url, null, null);
        //状态
        Integer status = r.getStatus();
        //判断状态
        if (status != 1)
        {
            Toolkit.getDefaultToolkit().beep();
            //得到错误信息
            String errMsg = r.getErrMsg();
            //抛出异常
            throw new RuntimeException("服务器错误! 状态码：" + status + "  错误信息：" + errMsg);
        }
        //正常
        //读取数据
        QuestionSubject questionSubject = r.getData(QuestionSubject.class);
        if (questionSubject == null)
        {
            Toolkit.getDefaultToolkit().beep();
            //得到错误信息
            String errMsg = r.getErrMsg();
            //抛出异常
            throw new RuntimeException("读取不到数据! 状态码：" + status + "  错误信息：" + errMsg);
        }
        if (questionSubject.getSubject() == null)
        {
            Toolkit.getDefaultToolkit().beep();
            //抛出异常
            throw new RuntimeException("读取不到数据! 请检查是否输入了正确的sid");
        }

        return questionSubject;
    }

    @Override
    public QuestionSubjectMetaData getQuestionSubjectMetaData(String subject)
    {
        return null;
    }
}
