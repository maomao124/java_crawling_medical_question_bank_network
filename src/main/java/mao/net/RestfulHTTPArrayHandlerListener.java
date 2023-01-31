package mao.net;

import java.io.IOException;
import java.util.List;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.net
 * Interface(接口名): RestfulHTTPArrayHandlerListener
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 19:13
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface RestfulHTTPArrayHandlerListener<T>
{
    /**
     * 正常处理
     *
     * @param responseData 响应数据
     * @param responseCode 响应代码
     */
    void OKHandler(List<T> responseData, int responseCode);

    /**
     * 异常处理
     *
     * @param e            IOException
     * @param responseCode 响应代码
     */
    void ExceptionHandler(IOException e, int responseCode);
}
