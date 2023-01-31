package mao.net;


import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Interface(接口名): RestfulHTTP
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 12:44
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface RestfulHTTP extends HTTP
{
    /**
     * 请求
     *
     * @param responseClazz 响应体的类型字节码
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link T}
     */
    <T> T request(Class<T> responseClazz, String urlString, String method,
                  Map<String, String> requestHeader, Object requestBody);

    /**
     * GET请求
     *
     * @param responseClazz 响应体的类型字节码
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link T}
     */
    <T> T GET(Class<T> responseClazz, String urlString,
              Map<String, String> requestHeader, Object requestBody);


    /**
     * 异步请求
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    <T> void asyncRequest(Class<T> responseClazz, String urlString, String method,
                          Map<String, String> requestHeader, Object requestBody, RestfulHTTPHandlerListener<T> listener);


    /**
     * 异步GET请求
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    <T> void asyncGETRequest(Class<T> responseClazz, String urlString,
                             Map<String, String> requestHeader, Object requestBody, RestfulHTTPHandlerListener<T> listener);


    /**
     * 请求数组
     *
     * @param responseClazz 响应体的类型字节码
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link List}<{@link T}>
     */
    <T> List<T> requestArray(Class<T> responseClazz, String urlString, String method,
                             Map<String, String> requestHeader, Object requestBody);


    /**
     * GET请求数组
     *
     * @param responseClazz 响应体的类型字节码
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link T}
     */
    <T> List<T> GETArray(Class<T> responseClazz, String urlString,
              Map<String, String> requestHeader, Object requestBody);


    /**
     * 异步请求数组
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    <T> void asyncRequestArray(Class<T> responseClazz, String urlString, String method,
                          Map<String, String> requestHeader, Object requestBody, RestfulHTTPArrayHandlerListener<T> listener);


    /**
     * 异步GET请求数组
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    <T> void asyncGETRequestArray(Class<T> responseClazz, String urlString,
                             Map<String, String> requestHeader, Object requestBody, RestfulHTTPArrayHandlerListener<T> listener);
}
