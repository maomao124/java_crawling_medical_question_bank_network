package mao.entity;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.entity
 * Class(类名): Question
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 19:37
 * Version(版本): 1.0
 * Description(描述)： 题目实体类，和json数据一一对应
 * 示例：
 * {"id":1272,"pre":null,"title":"药物作用的基本表现是是机体器官组织：","a":"A.功能升高或兴奋","b":"B.功能降低或抑制","c":"C.兴奋和/或抑制",
 * "d":"D.产生新的功能","e":"E.A和D","answer":"C","note":"","qtype":1}
 */

public class Question
{
    /**
     * id
     */
    private Long id;

    /**
     * 未知字段，经常为null
     */
    private String pre;

    /**
     * 标题，就是问题内容，例：药物作用的基本表现是是机体器官组织
     */
    private String title;

    /**
     * 选项a
     */
    private String a;

    /**
     * 选项b
     */
    private String b;

    /**
     * 选项a
     */
    private String c;

    /**
     * 选项a
     */
    private String d;

    /**
     * 选项a
     */
    private String e;

    /**
     * 正确答案
     */
    private String answer;

    /**
     * 解析
     */
    private String note;

    /**
     * 问题类型，经常为1
     */
    private Long qtype;

    /**
     * 问题
     */
    public Question()
    {

    }

    /**
     * 问题
     *
     * @param id     id
     * @param pre    精准医疗
     * @param title  标题
     * @param a      一个
     * @param b      b
     * @param c      c
     * @param d      d
     * @param e      e
     * @param answer 回答
     * @param note   请注意
     * @param qtype  qtype
     */
    public Question(Long id, String pre, String title, String a, String b, String c, String d, String e, String answer, String note, Long qtype)
    {
        this.id = id;
        this.pre = pre;
        this.title = title;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.answer = answer;
        this.note = note;
        this.qtype = qtype;
    }

    /**
     * 得到id
     *
     * @return {@link Long}
     */
    public Long getId()
    {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * 得到精准医疗
     *
     * @return {@link String}
     */
    public String getPre()
    {
        return pre;
    }

    /**
     * 设置精准医疗
     *
     * @param pre 精准医疗
     */
    public void setPre(String pre)
    {
        this.pre = pre;
    }

    /**
     * 得到标题
     *
     * @return {@link String}
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * 木屐
     *
     * @return {@link String}
     */
    public String getA()
    {
        return a;
    }

    /**
     * 刺毛
     *
     * @param a 一个
     */
    public void setA(String a)
    {
        this.a = a;
    }

    /**
     * getb进行排队
     *
     * @return {@link String}
     */
    public String getB()
    {
        return b;
    }

    /**
     * setb
     *
     * @param b b
     */
    public void setB(String b)
    {
        this.b = b;
    }

    /**
     * getc
     *
     * @return {@link String}
     */
    public String getC()
    {
        return c;
    }

    /**
     * 国家经贸委
     *
     * @param c c
     */
    public void setC(String c)
    {
        this.c = c;
    }

    /**
     * getd
     *
     * @return {@link String}
     */
    public String getD()
    {
        return d;
    }

    /**
     * setd
     *
     * @param d d
     */
    public void setD(String d)
    {
        this.d = d;
    }

    /**
     * gete
     *
     * @return {@link String}
     */
    public String getE()
    {
        return e;
    }

    /**
     * 汤
     *
     * @param e e
     */
    public void setE(String e)
    {
        this.e = e;
    }

    /**
     * 得到回答
     *
     * @return {@link String}
     */
    public String getAnswer()
    {
        return answer;
    }

    /**
     * 设置回答
     *
     * @param answer 回答
     */
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    /**
     * 得到请注意
     *
     * @return {@link String}
     */
    public String getNote()
    {
        return note;
    }

    /**
     * 设置请注意
     *
     * @param note 请注意
     */
    public void setNote(String note)
    {
        this.note = note;
    }

    /**
     * 得到qtype
     *
     * @return {@link Long}
     */
    public Long getQtype()
    {
        return qtype;
    }

    /**
     * 设置qtype
     *
     * @param qtype qtype
     */
    public void setQtype(Long qtype)
    {
        this.qtype = qtype;
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

        Question question = (Question) o;

        if (getId() != null ? !getId().equals(question.getId()) : question.getId() != null)
        {
            return false;
        }
        if (getPre() != null ? !getPre().equals(question.getPre()) : question.getPre() != null)
        {
            return false;
        }
        if (getTitle() != null ? !getTitle().equals(question.getTitle()) : question.getTitle() != null)
        {
            return false;
        }
        if (getA() != null ? !getA().equals(question.getA()) : question.getA() != null)
        {
            return false;
        }
        if (getB() != null ? !getB().equals(question.getB()) : question.getB() != null)
        {
            return false;
        }
        if (getC() != null ? !getC().equals(question.getC()) : question.getC() != null)
        {
            return false;
        }
        if (getD() != null ? !getD().equals(question.getD()) : question.getD() != null)
        {
            return false;
        }
        if (getE() != null ? !getE().equals(question.getE()) : question.getE() != null)
        {
            return false;
        }
        if (getAnswer() != null ? !getAnswer().equals(question.getAnswer()) : question.getAnswer() != null)
        {
            return false;
        }
        if (getNote() != null ? !getNote().equals(question.getNote()) : question.getNote() != null)
        {
            return false;
        }
        return getQtype() != null ? getQtype().equals(question.getQtype()) : question.getQtype() == null;
    }

    /**
     * 散列码
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPre() != null ? getPre().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getA() != null ? getA().hashCode() : 0);
        result = 31 * result + (getB() != null ? getB().hashCode() : 0);
        result = 31 * result + (getC() != null ? getC().hashCode() : 0);
        result = 31 * result + (getD() != null ? getD().hashCode() : 0);
        result = 31 * result + (getE() != null ? getE().hashCode() : 0);
        result = 31 * result + (getAnswer() != null ? getAnswer().hashCode() : 0);
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
        result = 31 * result + (getQtype() != null ? getQtype().hashCode() : 0);
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
        stringbuilder.append("id：").append(id).append('\n');
        stringbuilder.append("pre：").append(pre).append('\n');
        stringbuilder.append("title：").append(title).append('\n');
        stringbuilder.append("a：").append(a).append('\n');
        stringbuilder.append("b：").append(b).append('\n');
        stringbuilder.append("c：").append(c).append('\n');
        stringbuilder.append("d：").append(d).append('\n');
        stringbuilder.append("e：").append(e).append('\n');
        stringbuilder.append("answer：").append(answer).append('\n');
        stringbuilder.append("note：").append(note).append('\n');
        stringbuilder.append("qtype：").append(qtype).append('\n');
        return stringbuilder.toString();
    }
}
