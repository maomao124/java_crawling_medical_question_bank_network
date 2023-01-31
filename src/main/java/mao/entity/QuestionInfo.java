package mao.entity;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.entity
 * Class(类名): QuestionInfo
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 19:58
 * Version(版本): 1.0
 * Description(描述)：
 * 示例：
 * {"name":"药事组织","version":1,"cid":654,"sid":31,"subject":"药事管理"}
 */

public class QuestionInfo
{
    /**
     * 名字
     */
    private String name;

    /**
     * 版本
     */
    private Integer version;

    /**
     * cid
     */
    private Integer cid;

    /**
     * sid
     */
    private Integer sid;

    /**
     * 主题
     */
    private String subject;

    /**
     * 问题信息
     */
    public QuestionInfo()
    {

    }

    /**
     * 问题信息
     *
     * @param name    名字
     * @param version 版本
     * @param cid     cid
     * @param sid     sid
     * @param subject 主题
     */
    public QuestionInfo(String name, Integer version, Integer cid, Integer sid, String subject)
    {
        this.name = name;
        this.version = version;
        this.cid = cid;
        this.sid = sid;
        this.subject = subject;
    }

    /**
     * 得到名字
     *
     * @return {@link String}
     */
    public String getName()
    {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * 得到版本
     *
     * @return {@link Integer}
     */
    public Integer getVersion()
    {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(Integer version)
    {
        this.version = version;
    }

    /**
     * 得到cid
     *
     * @return {@link Integer}
     */
    public Integer getCid()
    {
        return cid;
    }

    /**
     * 设置cid
     *
     * @param cid cid
     */
    public void setCid(Integer cid)
    {
        this.cid = cid;
    }

    /**
     * 得到sid
     *
     * @return {@link Integer}
     */
    public Integer getSid()
    {
        return sid;
    }

    /**
     * 设置sid
     *
     * @param sid sid
     */
    public void setSid(Integer sid)
    {
        this.sid = sid;
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

        QuestionInfo that = (QuestionInfo) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
        {
            return false;
        }
        if (getVersion() != null ? !getVersion().equals(that.getVersion()) : that.getVersion() != null)
        {
            return false;
        }
        if (getCid() != null ? !getCid().equals(that.getCid()) : that.getCid() != null)
        {
            return false;
        }
        if (getSid() != null ? !getSid().equals(that.getSid()) : that.getSid() != null)
        {
            return false;
        }
        return getSubject() != null ? getSubject().equals(that.getSubject()) : that.getSubject() == null;
    }

    /**
     * 散列码
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        result = 31 * result + (getCid() != null ? getCid().hashCode() : 0);
        result = 31 * result + (getSid() != null ? getSid().hashCode() : 0);
        result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
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
        stringbuilder.append("name：").append(name).append('\n');
        stringbuilder.append("version：").append(version).append('\n');
        stringbuilder.append("cid：").append(cid).append('\n');
        stringbuilder.append("sid：").append(sid).append('\n');
        stringbuilder.append("subject：").append(subject).append('\n');
        return stringbuilder.toString();
    }
}
