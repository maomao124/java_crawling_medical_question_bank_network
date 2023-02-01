package mao.entity;

import java.io.Serializable;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.entity
 * Class(类名): QuestionTitle
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 19:53
 * Version(版本): 1.0
 * Description(描述)： 实体类
 * 示例：
 * {"info":{"name":"药事组织","version":1,"cid":654,"sid":31,"subject":"药事管理"},"quiz":"W3......cXR5cGUiOjJ9XQ=="}
 */

public class QuestionTitle
{
    /**
     * 信息
     */
    private QuestionInfo info;

    /**
     * 问题内容
     */
    private String quiz;

    /**
     * 问题标题
     */
    public QuestionTitle()
    {

    }

    /**
     * 问题标题
     *
     * @param info 信息
     * @param quiz 测试
     */
    public QuestionTitle(QuestionInfo info, String quiz)
    {
        this.info = info;
        this.quiz = quiz;
    }

    /**
     * 得到信息
     *
     * @return {@link QuestionInfo}
     */
    public QuestionInfo getInfo()
    {
        return info;
    }

    /**
     * 设置信息
     *
     * @param info 信息
     */
    public void setInfo(QuestionInfo info)
    {
        this.info = info;
    }

    /**
     * 得到测试
     *
     * @return {@link String}
     */
    public String getQuiz()
    {
        return quiz;
    }

    /**
     * 设置测试
     *
     * @param quiz 测试
     */
    public void setQuiz(String quiz)
    {
        this.quiz = quiz;
    }

    /**
     * =
     *
     * @param o o
     * @return boolean
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        QuestionTitle that = (QuestionTitle) o;

        if (getInfo() != null ? !getInfo().equals(that.getInfo()) : that.getInfo() != null)
        {
            return false;
        }
        return getQuiz() != null ? getQuiz().equals(that.getQuiz()) : that.getQuiz() == null;
    }

    /**
     * 散列码
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        int result = getInfo() != null ? getInfo().hashCode() : 0;
        result = 31 * result + (getQuiz() != null ? getQuiz().hashCode() : 0);
        return result;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("info：").append(info).append('\n');
        stringbuilder.append("quiz：").append(quiz).append('\n');
        return stringbuilder.toString();
    }
}
