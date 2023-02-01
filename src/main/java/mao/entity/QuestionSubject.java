package mao.entity;

import java.util.List;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.entity
 * Class(类名): QuestionSubject
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 12:36
 * Version(版本): 1.0
 * Description(描述)：
 * 示例：
 * <p>
 * {"data":{"subject":[{"s_id":39,"s_title":"方剂学"}],"chapter":[{"c_id":759,"c_name":"总论","c_subject":39},{"c_id":777,"c_name":"驱虫剂","c_subject":39}],"isfav":0},"status":1,"errMsg":""}
 * <p>
 * 丢弃"subject":[{"s_id":39,"s_title":"方剂学"}]这段
 */

public class QuestionSubject
{
    /**
     * 主题，例：[{"s_id":39,"s_title":"方剂学"}]
     */
    private String subject;

    /**
     * 章节
     */
    private List<QuestionChapter> chapter;


    /**
     * 未知字段
     */
    private Integer isfav;

    /**
     * 问题主题
     */
    public QuestionSubject()
    {

    }

    /**
     * 问题主题
     *
     * @param subject 主题
     * @param chapter 章
     * @param isfav   isfav
     */
    public QuestionSubject(String subject, List<QuestionChapter> chapter, Integer isfav)
    {
        this.subject = subject;
        this.chapter = chapter;
        this.isfav = isfav;
    }

    /**
     * 得到主题
     *
     * @return {@link String}
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * 设置主题
     *
     * @param subject 主题
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    /**
     * 得到章
     *
     * @return {@link List}<{@link QuestionChapter}>
     */
    public List<QuestionChapter> getChapter()
    {
        return chapter;
    }

    /**
     * 设置章
     *
     * @param chapter 章
     */
    public void setChapter(List<QuestionChapter> chapter)
    {
        this.chapter = chapter;
    }

    /**
     * 得到isfav
     *
     * @return {@link Integer}
     */
    public Integer getIsfav()
    {
        return isfav;
    }

    /**
     * 设置isfav
     *
     * @param isfav isfav
     */
    public void setIsfav(Integer isfav)
    {
        this.isfav = isfav;
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

        QuestionSubject that = (QuestionSubject) o;

        if (getSubject() != null ? !getSubject().equals(that.getSubject()) : that.getSubject() != null)
        {
            return false;
        }
        if (getChapter() != null ? !getChapter().equals(that.getChapter()) : that.getChapter() != null)
        {
            return false;
        }
        return getIsfav() != null ? getIsfav().equals(that.getIsfav()) : that.getIsfav() == null;
    }

    /**
     * 散列码
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        int result = getSubject() != null ? getSubject().hashCode() : 0;
        result = 31 * result + (getChapter() != null ? getChapter().hashCode() : 0);
        result = 31 * result + (getIsfav() != null ? getIsfav().hashCode() : 0);
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
        stringbuilder.append("subject：").append(subject).append('\n');
        stringbuilder.append("chapter：").append(chapter).append('\n');
        stringbuilder.append("isfav：").append(isfav).append('\n');
        return stringbuilder.toString();
    }
}
