package mao.net;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Class(类名): SimpleRestfulHTTPImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 14:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */


//public interface RestfulHTTPHandlerListener<T>
//{
//    /**
//     * 正常处理
//     *
//     * @param responseData 响应数据
//     * @param responseCode 响应代码
//     */
//    void OKHandler(T responseData, int responseCode);
//
//    /**
//     * 异常处理
//     *
//     * @param e            IOException
//     * @param responseCode 响应代码
//     */
//    void ExceptionHandler(IOException e, int responseCode);
//}


public class SimpleRestfulHTTPImpl extends SimpleHTTPImpl implements RestfulHTTP
{

    /**
     * 转换成json
     *
     * @param object 对象
     * @return {@link String}
     */
    protected String toJson(Object object)
    {
        return JSON.toJSONString(object);
    }

    /**
     * 解析Json
     *
     * @param json  json
     * @param clazz clazz
     * @return {@link T}
     */
    protected <T> T parse(String json, Class<T> clazz)
    {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 解析Json数组
     *
     * @param json  json
     * @param clazz clazz
     * @return {@link List}<{@link T}>
     */
    protected <T> List<T> parseArray(String json, Class<T> clazz)
    {
        return JSON.parseArray(json, clazz);
    }


    @Override
    public <T> T request(Class<T> responseClazz, String urlString, String method, Map<String, String> requestHeader, Object requestBody)
    {
        if (requestBody == null)
        {
            String json = this.request(urlString, method, requestHeader, null);
            return this.parse(json, responseClazz);
        }
        else
        {
            if (requestHeader == null)
            {
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/json;charsetset=UTF-8");
                map.put("Accept", "application/json");
                String json = this.request(urlString, method, map, toJson(requestBody));
                return this.parse(json, responseClazz);
            }
            else
            {
                requestHeader.put("Content-Type", "application/json;charsetset=UTF-8");
                requestHeader.put("Accept", "application/json");
                String json = this.request(urlString, method, requestHeader, toJson(requestBody));
                return this.parse(json, responseClazz);
            }
        }
    }

    /**
     * GET请求
     *
     * @param responseClazz 响应体的类型字节码
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link T}
     */
    @Override
    public <T> T GET(Class<T> responseClazz, String urlString, Map<String, String> requestHeader, Object requestBody)
    {
        return request(responseClazz, urlString, "GET", requestHeader, requestBody);
    }

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
    @Override
    public <T> void asyncRequest(Class<T> responseClazz, String urlString, String method,
                                 Map<String, String> requestHeader, Object requestBody, RestfulHTTPHandlerListener<T> listener)
    {
        if (requestBody != null)
        {
            if (requestHeader == null)
            {
                requestHeader = new HashMap<>();
                requestHeader.put("Content-Type", "application/json;charsetset=UTF-8");
                requestHeader.put("Accept", "application/json");
            }
            else
            {
                requestHeader.put("Content-Type", "application/json;charsetset=UTF-8");
                requestHeader.put("Accept", "application/json");
            }
        }
        this.asyncRequest(urlString, method, requestHeader, requestBody == null ? null : toJson(requestBody), new HTTPHandlerListener()
        {
            @Override
            public void OKHandler(String responseString, int responseCode)
            {
                T t = parse(responseString, responseClazz);
                listener.OKHandler(t, responseCode);
            }

            @Override
            public void ExceptionHandler(IOException e, int responseCode)
            {
                listener.ExceptionHandler(e, responseCode);
            }
        });
    }

    /**
     * 异步GET请求
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    @Override
    public <T> void asyncGETRequest(Class<T> responseClazz, String urlString,
                                    Map<String, String> requestHeader, Object requestBody, RestfulHTTPHandlerListener<T> listener)
    {
        this.asyncRequest(responseClazz, urlString, "GET", requestHeader, requestBody, listener);
    }


    /**
     * 请求数组
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link List}<{@link T}>
     */
    @Override
    public <T> List<T> requestArray(Class<T> responseClazz, String urlString, String method, Map<String, String> requestHeader, Object requestBody)
    {
        if (requestBody == null)
        {
            String json = this.request(urlString, method, requestHeader, null);
            return this.parseArray(json, responseClazz);
        }
        else
        {
            if (requestHeader == null)
            {
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/json;charsetset=UTF-8");
                map.put("Accept", "application/json");
                String json = this.request(urlString, method, map, toJson(requestBody));
                return this.parseArray(json, responseClazz);
            }
            else
            {
                requestHeader.put("Content-Type", "application/json;charsetset=UTF-8");
                requestHeader.put("Accept", "application/json");
                String json = this.request(urlString, method, requestHeader, toJson(requestBody));
                return this.parseArray(json, responseClazz);
            }
        }
    }

    /**
     * GET请求数组
     *
     * @param responseClazz 响应体的类型字节码
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link T}
     */
    @Override
    public <T> List<T> GETArray(Class<T> responseClazz, String urlString, Map<String, String> requestHeader, Object requestBody)
    {
        return requestArray(responseClazz, urlString, "GET", requestHeader, requestBody);
    }


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
    @Override
    public <T> void asyncRequestArray(Class<T> responseClazz, String urlString, String method, Map<String, String> requestHeader,
                                      Object requestBody, RestfulHTTPArrayHandlerListener<T> listener)
    {
        if (requestBody != null)
        {
            if (requestHeader == null)
            {
                requestHeader = new HashMap<>();
                requestHeader.put("Content-Type", "application/json;charsetset=UTF-8");
                requestHeader.put("Accept", "application/json");
            }
            else
            {
                requestHeader.put("Content-Type", "application/json;charsetset=UTF-8");
                requestHeader.put("Accept", "application/json");
            }
        }
        this.asyncRequest(urlString, method, requestHeader, requestBody == null ? null : toJson(requestBody), new HTTPHandlerListener()
        {
            @Override
            public void OKHandler(String responseString, int responseCode)
            {
                List<T> list = parseArray(responseString, responseClazz);
                listener.OKHandler(list, responseCode);
            }

            @Override
            public void ExceptionHandler(IOException e, int responseCode)
            {
                listener.ExceptionHandler(e, responseCode);
            }
        });
    }

    /**
     * 异步GET请求数组
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    @Override
    public <T> void asyncGETRequestArray(Class<T> responseClazz, String urlString, Map<String, String> requestHeader,
                                         Object requestBody, RestfulHTTPArrayHandlerListener<T> listener)
    {
        this.asyncRequestArray(responseClazz, urlString, "GET", requestHeader, requestBody, listener);
    }

}
