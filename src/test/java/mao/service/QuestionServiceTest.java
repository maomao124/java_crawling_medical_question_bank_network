package mao.service;

import mao.applicatiom.MainApplication;
import mao.entity.QuestionTitle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.service
 * Class(测试类名): QuestionServiceTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 20:33
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class QuestionServiceTest
{

    @Test
    void getQuestionTitle()
    {
        QuestionTitle questionTitle = MainApplication.getQuestionService().getQuestionTitle("653", "31");
        System.out.println(questionTitle);
    }

    @Test
    void getQuestionTitle2()
    {
        QuestionTitle questionTitle = MainApplication.getQuestionService().getQuestionTitle("510", "22");
        System.out.println(questionTitle);
    }

    @Test
    void getQuestionTitle3()
    {
        QuestionTitle questionTitle = MainApplication.getQuestionService().getQuestionTitle("432", "18");
        System.out.println(questionTitle);
    }
}
