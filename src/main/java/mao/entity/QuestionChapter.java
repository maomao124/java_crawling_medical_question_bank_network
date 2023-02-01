package mao.entity;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.entity
 * Class(类名): QuestionChapter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 12:39
 * Version(版本): 1.0
 * Description(描述)： {"c_id":759,"c_name":"总论","c_subject":39}
 */


public class QuestionChapter
{
    /**
     * cid
     */
    private Long c_id;

    /**
     * 名字
     */
    private String c_name;

    /**
     * 主题
     */
    private Long c_subject;

    /**
     * 章问题
     */
    public QuestionChapter()
    {

    }

    /**
     * 得到cid
     *
     * @return {@link Long}
     */
    public Long getC_id()
    {
        return c_id;
    }

    /**
     * 设置cid
     *
     * @param c_id c id
     */
    public void setC_id(Long c_id)
    {
        this.c_id = c_id;
    }

    /**
     * 得到c名字
     *
     * @return {@link String}
     */
    public String getC_name()
    {
        return c_name;
    }

    /**
     * 设置c名字
     *
     * @param c_name c名字
     */
    public void setC_name(String c_name)
    {
        this.c_name = c_name;
    }

    /**
     * 得到c主题
     *
     * @return {@link Long}
     */
    public Long getC_subject()
    {
        return c_subject;
    }

    /**
     * 设置c主题
     *
     * @param c_subject c主题
     */
    public void setC_subject(Long c_subject)
    {
        this.c_subject = c_subject;
    }

    /**
     * 章问题
     *
     * @param c_id      c id
     * @param c_name    c名字
     * @param c_subject c主题
     */
    public QuestionChapter(Long c_id, String c_name, Long c_subject)
    {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_subject = c_subject;
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

        QuestionChapter that = (QuestionChapter) o;

        if (getC_id() != null ? !getC_id().equals(that.getC_id()) : that.getC_id() != null)
        {
            return false;
        }
        if (getC_name() != null ? !getC_name().equals(that.getC_name()) : that.getC_name() != null)
        {
            return false;
        }
        return getC_subject() != null ? getC_subject().equals(that.getC_subject()) : that.getC_subject() == null;
    }

    /**
     * 散列码
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        int result = getC_id() != null ? getC_id().hashCode() : 0;
        result = 31 * result + (getC_name() != null ? getC_name().hashCode() : 0);
        result = 31 * result + (getC_subject() != null ? getC_subject().hashCode() : 0);
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
        stringbuilder.append("c_id：").append(c_id).append('\n');
        stringbuilder.append("c_name：").append(c_name).append('\n');
        stringbuilder.append("c_subject：").append(c_subject).append('\n');
        return stringbuilder.toString();
    }
}
