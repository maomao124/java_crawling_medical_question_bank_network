package mao.entity;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.entity
 * Class(类名): QuestionSubjectMetaData
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 14:52
 * Version(版本): 1.0
 * Description(描述)： 列表元数据
 * [{"s_id":39,"s_title":"方剂学"}]
 */

public class QuestionSubjectMetaData
{
    /**
     * sid
     */
    private Long s_id;

    /**
     * 标题 ,方剂学
     */
    private String s_title;

    /**
     * 问题对象元数据
     */
    public QuestionSubjectMetaData()
    {

    }

    /**
     * 问题对象元数据
     *
     * @param s_id    年代id
     * @param s_title 年代标题
     */
    public QuestionSubjectMetaData(Long s_id, String s_title)
    {
        this.s_id = s_id;
        this.s_title = s_title;
    }

    /**
     * 得到年代id
     *
     * @return {@link Long}
     */
    public Long getS_id()
    {
        return s_id;
    }

    /**
     * 设置年代id
     *
     * @param s_id 年代id
     */
    public void setS_id(Long s_id)
    {
        this.s_id = s_id;
    }

    /**
     * 得到年代标题
     *
     * @return {@link String}
     */
    public String getS_title()
    {
        return s_title;
    }

    /**
     * 设置年代标题
     *
     * @param s_title 年代标题
     */
    public void setS_title(String s_title)
    {
        this.s_title = s_title;
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

        QuestionSubjectMetaData that = (QuestionSubjectMetaData) o;

        if (getS_id() != null ? !getS_id().equals(that.getS_id()) : that.getS_id() != null)
        {
            return false;
        }
        return getS_title() != null ? getS_title().equals(that.getS_title()) : that.getS_title() == null;
    }

    /**
     * 散列码
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        int result = getS_id() != null ? getS_id().hashCode() : 0;
        result = 31 * result + (getS_title() != null ? getS_title().hashCode() : 0);
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
        stringbuilder.append("s_id：").append(s_id).append('\n');
        stringbuilder.append("s_title：").append(s_title).append('\n');
        return stringbuilder.toString();
    }
}
