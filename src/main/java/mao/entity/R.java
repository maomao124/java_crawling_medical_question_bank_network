package mao.entity;

import com.alibaba.fastjson.JSON;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.entity
 * Class(类名): R
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)： 无
 * 示例：
 * {"data":{"info":{"name":"药事组织","version":1,"cid":654,"sid":31,"subject":"药事管理"},"quiz":"W3......cXR5cGUiOjJ9XQ=="},"status":1,"errMsg":""}
 */

public class R
{
    /**
     * 数据
     */
    private String data;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 错误消息
     */
    private String errMsg;

    /**
     * r
     */
    public R()
    {
    }

    /**
     * r
     *
     * @param data   数据
     * @param status 状态
     * @param errMsg 犯错消息
     */
    public R(String data, Integer status, String errMsg)
    {
        this.data = data;
        this.status = status;
        this.errMsg = errMsg;
    }

    /**
     * 得到数据
     *
     * @return {@link String}
     */
    public <T> T getData(Class<T> clazz)
    {
        return JSON.parseObject(data, clazz);
    }

    /**
     * 得到数据
     *
     * @return {@link String}
     */
    public String getData()
    {
        return data;
    }

    /**
     * 设置数据
     *
     * @param data 数据
     */
    public void setData(String data)
    {
        this.data = data;
    }

    /**
     * 得到状态
     *
     * @return {@link Integer}
     */
    public Integer getStatus()
    {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    /**
     * 得到犯错消息
     *
     * @return {@link String}
     */
    public String getErrMsg()
    {
        return errMsg;
    }

    /**
     * 设置犯错消息
     *
     * @param errMsg 犯错消息
     */
    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }


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

        R r = (R) o;

        if (getData() != null ? !getData().equals(r.getData()) : r.getData() != null)
        {
            return false;
        }
        if (getStatus() != null ? !getStatus().equals(r.getStatus()) : r.getStatus() != null)
        {
            return false;
        }
        return getErrMsg() != null ? getErrMsg().equals(r.getErrMsg()) : r.getErrMsg() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getData() != null ? getData().hashCode() : 0;
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getErrMsg() != null ? getErrMsg().hashCode() : 0);
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("data：").append(data).append('\n');
        stringbuilder.append("status：").append(status).append('\n');
        stringbuilder.append("errMsg：").append(errMsg).append('\n');
        return stringbuilder.toString();
    }
}
