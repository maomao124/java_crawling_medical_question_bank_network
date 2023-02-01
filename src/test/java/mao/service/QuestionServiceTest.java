package mao.service;

import mao.applicatiom.MainApplication;
import mao.entity.Question;
import mao.entity.QuestionTitle;
import mao.handler.Base64;
import org.junit.jupiter.api.Test;

import java.util.List;

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


    @Test
    void getQuestionList()
    {
        QuestionTitle questionTitle = MainApplication.getQuestionService().getQuestionTitle("432", "18");
        String quiz = questionTitle.getQuiz();
        List<Question> questionList = MainApplication.getQuestionService().getQuestionList(quiz);
        for (Question question : questionList)
        {
            System.out.println(question);
            System.out.println();
        }
    }

    @Test
    void getQuestionList2()
    {
        QuestionTitle questionTitle = MainApplication.getQuestionService().getQuestionTitle("437", "18");
        String quiz = questionTitle.getQuiz();
        String json = Base64.decode(quiz);
        System.out.println(json);
        List<Question> questionList = MainApplication.getQuestionService().getQuestionList(quiz);
        for (Question question : questionList)
        {
            System.out.println(question);
            System.out.println();
        }

        System.out.println("总数：" + questionList.size());
    }

    @Test
    void getQuestionList3()
    {
        QuestionTitle questionTitle = MainApplication.getQuestionService().getQuestionTitle("2002", "132");
        String quiz = questionTitle.getQuiz();
        String json = Base64.decode(quiz);
        System.out.println(json);
        List<Question> questionList = MainApplication.getQuestionService().getQuestionList(quiz);
        for (Question question : questionList)
        {
            System.out.println(question);
            System.out.println();
        }

        System.out.println("总数：" + questionList.size());
    }

    @Test
    void getMainHtml()
    {
        MainApplication.getQuestionService().getMainHtml();
    }
}
