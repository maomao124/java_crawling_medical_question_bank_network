package mao;

import mao.applicatiom.MainApplication;
import mao.entity.*;
import mao.service.QuestionService;

import java.io.IOException;
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
                "添加参数\"-d\"可在控制台输出更详细的数据，例如：\"java -jar xxx.jar -d\"\n" +
                "本程序需要两个数据，分别是cid和sid，怎么拿到这两个数据，步骤如下:\n" +
                "1.用浏览器进入该网址 https://www.medtiku.com/app\n" +
                "2.点击到做题页面 https://www.medtiku.com/app#/q/25/560/1\n" +
                "3.观察浏览器地址栏\n" +
                "4.例如 https://www.medtiku.com/app#/q/25/560/1，cid为560，sid为25\n" +
                "      https://www.medtiku.com/app#/q/129/1976/1，cid为1976，sid为129\n" +
                "如果输入cid的值为-1，那么将会把该二级列表下的所有题目都下载\n" +
                "软件有md和txt两种格式，如果想要转成docx、pdf、html、img等格式，请使用Typora软件导出，md文件可以使用Typora查看\n");


        System.out.println();
        System.out.println();

        Scanner input = new Scanner(System.in);

        String cid;
        String sid;
        System.out.print("请输入cid：");
        cid = input.next();
        System.out.print("请输入sid：");
        sid = input.next();

        QuestionService questionService = MainApplication.getQuestionService();

        if (cid.equals("-1"))
        {
            System.out.println();
            System.out.println("即将下载该二级列表下的所有题目");
            System.out.println("正在请求列表");
            QuestionSubject questionSubject = questionService.getQuestionSubject(sid);
            System.out.println("请求列表完成，该二级列表下一共有" + questionSubject.getChapter().size() + "项");
            System.out.println("二级列表元数据：" + questionSubject.getSubject());
            List<QuestionChapter> questionChapterList = questionSubject.getChapter();
            System.out.println("章节列表：");
            System.out.println("------------------------------------------------");
            System.out.println("| " + "序号" + "  |   " + "cid" + "   |   " + "章节名称");
            System.out.println("------------------------------------------------");
            for (int i = 0; i < questionChapterList.size(); i++)
            {
                QuestionChapter questionChapter = questionChapterList.get(i);
                System.out.println("|  " + (i + 1) + "   |   " + questionChapter.getC_id() + "   |   " + questionChapter.getC_name());
            }
            System.out.println("------------------------------------------------");

            System.out.println();
            System.out.println("按回车键继续");
            input.nextLine();
            input.nextLine();

            long start = System.currentTimeMillis();

            System.out.println("开始下载");


            for (int i = 0; i < questionChapterList.size(); i++)
            {
                QuestionChapter questionChapter = questionChapterList.get(i);
                System.out.println("下载进度：" + (i + 1) + "/" + questionChapterList.size());

                download(args, input, questionChapter.getC_id().toString(), sid);
                System.out.println();
            }

            System.out.println();
            System.out.println();
            System.out.println("下载完成");
            System.out.println();
            System.out.println("正在生成索引文件");
            QuestionSubjectMetaData questionSubjectMetaData = questionService.getQuestionSubjectMetaData(questionSubject.getSubject());
            String s = questionService.createIndexMarkDownFile(questionSubjectMetaData, questionSubject);
            System.out.println();
            System.out.println("完成");

            long end = System.currentTimeMillis();
            System.out.println("总耗时：" + (end - start) + "毫秒");
        }
        else
        {
            download(args, input, cid, sid);
        }

        System.out.println();
        System.out.println("按回车键退出程序");
        input.nextLine();
        input.nextLine();
    }

    private static void download(String[] args, Scanner input, String cid, String sid)
    {
        long start = System.currentTimeMillis();

        System.out.println();

        System.out.println("当前cid为" + cid + ",sid为" + sid);
        System.out.println();

        QuestionService questionService = MainApplication.getQuestionService();

        System.out.println("发起请求");
        QuestionTitle questionTitle = questionService.getQuestionTitle(cid, sid);

        if (args.length > 0)
        {
            if (args[0] != null)
            {
                if (args[0].equals("-d"))
                {
                    //输入更详细的数据
                    System.out.println("响应数据：\n" + questionTitle);
                    System.out.println();
                    System.out.println();
                }
            }
        }

        System.out.println("正在解析");
        String quiz = questionTitle.getQuiz();
        List<Question> questionList = questionService.getQuestionList(quiz);
        System.out.println("解析完成，一共" + questionList.size() + "条数据");
        System.out.println();

        if (args.length > 0)
        {
            if (args[0] != null)
            {
                if (args[0].equals("-d"))
                {
                    //输入更详细的数据
                    System.out.println("解析数据：\n");
                    for (Question question : questionList)
                    {
                        System.out.println(question);
                        System.out.println();
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println();
                }
            }
        }

        String s = questionService.saveToTxtFile(questionTitle, questionList);
        //System.out.println(s);
        System.out.println();
        String s1 = questionService.saveToTxtFileNoAnswer(questionTitle, questionList);
        System.out.println();
        String s2 = questionService.saveToMarkDownFile(questionTitle, questionList);
        System.out.println();
        String s3 = questionService.saveToMarkDownFileNoAnswer(questionTitle, questionList);
        System.out.println();

        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("耗时：" + (end - start) + "毫秒");

        System.out.println();
    }
}
