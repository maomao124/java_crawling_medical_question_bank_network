package mao.net;



import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Interface(接口名): HTTP
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 12:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface HTTP
{
    /**
     * 得到字符集
     *
     * @return {@link String}
     */
    String getCharset();

    /**
     * 设置字符集
     *
     * @param charset 字符集
     * @return {@link HTTP}
     */
    HTTP setCharset(String charset);

    /**
     * 获得连接超时
     *
     * @return int
     */
    int getConnectTimeout();

    /**
     * 设置连接超时
     *
     * @param connectTimeout 连接超时
     * @return {@link HTTP}
     */
    HTTP setConnectTimeout(int connectTimeout);

    /**
     * 获得读超时
     *
     * @return int
     */
    int getReadTimeout();

    /**
     * 设置读取超时
     *
     * @param readTimeout 读取超时
     * @return {@link HTTP}
     */
    HTTP setReadTimeout(int readTimeout);

    /**
     * 获取默认请求头
     *
     * @return {@link Map}<{@link String}, {@link String}>
     */
    Map<String, String> getDefaultRequestHeader();

    /**
     * 设置默认请求头
     *
     * @param defaultRequestHeader 默认请求头
     * @return {@link HTTP}
     */
    HTTP setDefaultRequestHeader(Map<String, String> defaultRequestHeader);

    /**
     * 获取线程池
     *
     * @return {@link ExecutorService}
     */
    ExecutorService getThreadPool();

    /**
     * 设置线程池
     *
     * @param threadPool 线程池
     * @return {@link HTTP}
     */
    HTTP setThreadPool(ExecutorService threadPool);

    /**
     * 请求
     *
     * @param urlString     url字符串
     * @param method        方法，GET,POST,PUT,DELETE...
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link String}
     */
    String request(String urlString, String method, Map<String, String> requestHeader, String requestBody);

    /**
     * 请求
     *
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @return {@link String}
     */
    String request(String urlString, String method, Map<String, String> requestHeader);

    /**
     * 请求
     *
     * @param urlString   url字符串
     * @param method      方法
     * @param requestBody 请求体
     * @return {@link String}
     */
    String request(String urlString, String method, String requestBody);

    /**
     * 请求
     *
     * @param urlString url字符串
     * @param method    方法
     * @return {@link String}
     */
    String request(String urlString, String method);

    /**
     * GET请求
     *
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link String}
     */
    String GET(String urlString, Map<String, String> requestHeader, String requestBody);

    /**
     * GET请求
     *
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @return {@link String}
     */
    String GET(String urlString, Map<String, String> requestHeader);

    /**
     * GET请求
     *
     * @param urlString   url字符串
     * @param requestBody 请求体
     * @return {@link String}
     */
    String GET(String urlString, String requestBody);

    /**
     * GET请求
     *
     * @param urlString url字符串
     * @return {@link String}
     */
    String GET(String urlString);


    /**
     * 异步请求
     *
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    void asyncRequest(String urlString, String method, Map<String, String> requestHeader,
                      String requestBody, HTTPHandlerListener listener);

    /**
     * 异步请求
     *
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param listener      侦听器
     */
    void asyncRequest(String urlString, String method, Map<String, String> requestHeader, HTTPHandlerListener listener);

    /**
     * 异步请求
     *
     * @param urlString   url字符串
     * @param method      方法
     * @param requestBody 请求体
     * @param listener    侦听器
     */
    void asyncRequest(String urlString, String method, String requestBody, HTTPHandlerListener listener);

    /**
     * 异步请求
     *
     * @param urlString url字符串
     * @param method    方法
     * @param listener  侦听器
     */
    void asyncRequest(String urlString, String method, HTTPHandlerListener listener);


    /**
     * 异步GET请求
     *
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    void asyncGETRequest(String urlString, Map<String, String> requestHeader,
                         String requestBody, HTTPHandlerListener listener);

    /**
     * 异步GET请求
     *
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param listener      侦听器
     */
    void asyncGETRequest(String urlString, Map<String, String> requestHeader, HTTPHandlerListener listener);

    /**
     * 异步GET请求
     *
     * @param urlString   url字符串
     * @param requestBody 请求体
     * @param listener    侦听器
     */
    void asyncGETRequest(String urlString, String requestBody, HTTPHandlerListener listener);

    /**
     * 异步GET请求
     *
     * @param urlString url字符串
     * @param listener  侦听器
     */
    void asyncGETRequest(String urlString, HTTPHandlerListener listener);
}
