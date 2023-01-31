package mao;

import mao.applicatiom.MainApplication;
import mao.entity.Question;
import mao.entity.QuestionTitle;
import mao.service.QuestionService;

import java.util.List;
import java.util.Scanner;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao
 * Class(类名): Run
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Run
{
    public static void main(String[] args)
    {
        System.out.println("！！！本程序仅供学习使用，禁止用于任何商业目的！！！");
        System.out.println();
        System.out.println("数据来源：https://www.medtiku.com/app");
        System.out.println();
        System.out.println("使用说明：\n" +
                "本程序需要两个数据，分别是cid和sid，怎么拿到这两个数据，步骤如下:\n" +
                "1.用浏览器进入该网址 https://www.medtiku.com/app\n" +
                "2.点击到做题页面 https://www.medtiku.com/app#/q/25/560/1\n" +
                "3.观察浏览器地址栏\n" +
                "4.例如 https://www.medtiku.com/app#/q/25/560/1，cid为560，sid为25\n" +
                "      https://www.medtiku.com/app#/q/129/1976/1，cid为1976，sid为129\n");


        System.out.println();
        System.out.println();

        Scanner input = new Scanner(System.in);

        String cid;
        String sid;
        System.out.print("请输入cid：");
        cid = input.next();
        System.out.print("请输入sid：");
        sid = input.next();

        System.out.println();

        System.out.println("当前cid为" + cid + ",sid为" + sid);
        System.out.println();

        QuestionService questionService = MainApplication.getQuestionService();

        System.out.println("发起请求");
        QuestionTitle questionTitle = questionService.getQuestionTitle(cid, sid);
        System.out.println("正在解析");
        String quiz = questionTitle.getQuiz();
        List<Question> questionList = questionService.getQuestionList(quiz);
        System.out.println("解析完成，一共" + questionList.size() + "条数据");

        String s = questionService.saveToTxtFile(questionTitle, questionList);
        System.out.println(s);
    }
}
