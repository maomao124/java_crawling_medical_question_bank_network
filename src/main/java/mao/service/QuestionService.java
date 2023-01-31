package mao.service;

import mao.entity.Question;
import mao.entity.QuestionTitle;
import mao.entity.R;

import java.util.List;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.service
 * Interface(接口名): QuestionService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 20:16
 * Version(版本): 1.0
 * Description(描述)： 服务
 */

public interface QuestionService
{
    /**
     * 得到题目的信息
     *
     * @param cid cid
     * @param sid sid
     * @return {@link QuestionTitle}
     */
    QuestionTitle getQuestionTitle(String cid, String sid);

    /**
     * 得到题目列表
     *
     * @param quiz QuestionTitle的quiz字段，是一串base64码
     * @return {@link List}<{@link Question}>
     */
    List<Question> getQuestionList(String quiz);

    /**
     * 保存到txt文件
     *
     * @param questionTitle questionTitle
     * @param questionList  List<Question>
     * @return {@link String} txt文件里的内容
     */
    String saveToTxtFile(QuestionTitle questionTitle, List<Question> questionList);
}
