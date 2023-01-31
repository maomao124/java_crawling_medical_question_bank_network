package mao.net;

import java.io.IOException;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Interface(接口名): RestfulHTTPHandlerListener
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 14:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface RestfulHTTPHandlerListener<T>
{
    /**
     * 正常处理
     *
     * @param responseData 响应数据
     * @param responseCode 响应代码
     */
    void OKHandler(T responseData, int responseCode);

    /**
     * 异常处理
     *
     * @param e            IOException
     * @param responseCode 响应代码
     */
    void ExceptionHandler(IOException e, int responseCode);
}
