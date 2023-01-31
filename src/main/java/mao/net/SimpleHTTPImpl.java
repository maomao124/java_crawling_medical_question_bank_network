package mao.net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Class(类名): SimpleHTTPImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 12:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

//public interface HTTPHandlerListener
//{
//    /**
//     * 正常处理
//     *
//     * @param responseString 响应体
//     * @param responseCode   响应代码
//     */
//    void OKHandler(String responseString, int responseCode);
//
//    /**
//     * 异常处理
//     *
//     * @param e            IOException
//     * @param responseCode 响应代码
//     */
//    void ExceptionHandler(IOException e, int responseCode);
//}

public class SimpleHTTPImpl implements HTTP
{
    /**
     * 字符集
     */
    protected String charset = "UTF-8";

    /**
     * 连接超时时间
     */
    protected int connectTimeout = 5000;

    /**
     * 读取超时时间
     */
    protected int readTimeout = 5000;

    /**
     * 默认请求头
     */
    protected Map<String, String> defaultRequestHeader;

    /**
     * 线程池
     */
    protected ExecutorService threadPool;


    public SimpleHTTPImpl()
    {

    }

    /**
     * SimpleHTTPImpl
     *
     * @param charset              字符集
     * @param connectTimeout       连接超时
     * @param readTimeout          读取超时
     * @param defaultRequestHeader 默认请求头
     * @param threadPool           线程池
     */
    public SimpleHTTPImpl(String charset, int connectTimeout, int readTimeout,
                          Map<String, String> defaultRequestHeader, ExecutorService threadPool)
    {
        this.charset = charset;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.defaultRequestHeader = defaultRequestHeader;
        this.threadPool = threadPool;
    }

    /**
     * 得到字符集
     *
     * @return {@link String}
     */
    @Override
    public String getCharset()
    {
        return charset;
    }


    /**
     * 设置字符集
     *
     * @param charset 字符集
     * @return {@link HTTP}
     */
    @Override
    public HTTP setCharset(String charset)
    {
        this.charset = charset;
        return this;
    }

    /**
     * 获得连接超时
     *
     * @return int
     */
    @Override
    public int getConnectTimeout()
    {
        return connectTimeout;
    }


    /**
     * 设置连接超时
     *
     * @param connectTimeout 连接超时
     * @return {@link HTTP}
     */
    @Override
    public HTTP setConnectTimeout(int connectTimeout)
    {
        this.connectTimeout = connectTimeout;
        return this;
    }

    /**
     * 获得读超时
     *
     * @return int
     */
    @Override
    public int getReadTimeout()
    {
        return readTimeout;
    }


    /**
     * 设置读取超时
     *
     * @param readTimeout 读取超时
     * @return {@link HTTP}
     */
    @Override
    public HTTP setReadTimeout(int readTimeout)
    {
        this.readTimeout = readTimeout;
        return this;
    }

    /**
     * 获取默认请求头
     *
     * @return {@link Map}<{@link String}, {@link String}>
     */
    @Override
    public Map<String, String> getDefaultRequestHeader()
    {
        return defaultRequestHeader;
    }


    /**
     * 设置默认请求头
     *
     * @param defaultRequestHeader 默认请求头
     * @return {@link HTTP}
     */
    @Override
    public HTTP setDefaultRequestHeader(Map<String, String> defaultRequestHeader)
    {
        this.defaultRequestHeader = defaultRequestHeader;
        return this;
    }


    /**
     * 获取线程池
     *
     * @return {@link ExecutorService}
     */
    public ExecutorService getThreadPool()
    {
        return threadPool;
    }


    /**
     * 设置线程池
     *
     * @param threadPool 线程池
     * @return {@link HTTP}
     */
    public HTTP setThreadPool(ExecutorService threadPool)
    {
        this.threadPool = threadPool;
        return this;
    }

    /**
     * 请求
     *
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link String}
     */
    @Override
    public String request(String urlString, String method, Map<String, String> requestHeader, String requestBody)
    {
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        OutputStreamWriter outputStreamWriter = null;
        try
        {
            URL url = new URL(urlString);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            //设置请求方法
            httpURLConnection.setRequestMethod(method);
            //设置超时时间
            httpURLConnection.setConnectTimeout(this.getConnectTimeout());
            httpURLConnection.setReadTimeout(this.getReadTimeout());
            //填充参数的请求头,优先级更高
            if (requestHeader != null && requestHeader.size() != 0)
            {
                HttpURLConnection finalHttpURLConnection1 = httpURLConnection;
                requestHeader.forEach(new BiConsumer<String, String>()
                {
                    @Override
                    public void accept(String s, String s2)
                    {
                        //System.out.println("s=" + s + ",s2=" + s2);
                        finalHttpURLConnection1.addRequestProperty(s, s2);
                    }
                });
            }
            //填充默认的请求头
            if (defaultRequestHeader != null && defaultRequestHeader.size() != 0)
            {
                HttpURLConnection finalHttpURLConnection = httpURLConnection;
                defaultRequestHeader.forEach(new BiConsumer<String, String>()
                {
                    @Override
                    public void accept(String s, String s2)
                    {
                        //System.out.println("s=" + s + ",s2=" + s2);
                        finalHttpURLConnection.addRequestProperty(s, s2);
                    }
                });
            }
            //填充请求体
            if (requestBody != null && requestBody.length() != 0)
            {
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStreamWriter = new OutputStreamWriter(outputStream);
                outputStreamWriter.write(requestBody);
                outputStreamWriter.flush();
            }
            //连接
            httpURLConnection.connect();
            //获得输入流
            inputStream = httpURLConnection.getInputStream();
            //转换流
            inputStreamReader = new InputStreamReader(inputStream, getCharset());
            //缓冲流
            bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            //写入数据
            while ((str = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(str).append("\n");
            }
            return stringBuilder.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if (inputStreamReader != null)
                {
                    inputStreamReader.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if (inputStream != null)
                {
                    inputStream.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if (outputStreamWriter != null)
                {
                    outputStreamWriter.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            if (httpURLConnection != null)
            {
                httpURLConnection.disconnect();
            }
        }
    }

    /**
     * 请求
     *
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @return {@link String}
     */
    @Override
    public String request(String urlString, String method, Map<String, String> requestHeader)
    {
        return request(urlString, method, requestHeader, null);
    }

    /**
     * 请求
     *
     * @param urlString   url字符串
     * @param method      方法
     * @param requestBody 请求体
     * @return {@link String}
     */
    @Override
    public String request(String urlString, String method, String requestBody)
    {
        return request(urlString, method, null, requestBody);
    }

    /**
     * 请求
     *
     * @param urlString url字符串
     * @param method    方法
     * @return {@link String}
     */
    @Override
    public String request(String urlString, String method)
    {
        return request(urlString, method, null, null);
    }

    /**
     * GET请求
     *
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link String}
     */
    @Override
    public String GET(String urlString, Map<String, String> requestHeader, String requestBody)
    {
        return request(urlString, "GET", requestHeader, requestBody);
    }

    /**
     * GET请求
     *
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @return {@link String}
     */
    @Override
    public String GET(String urlString, Map<String, String> requestHeader)
    {
        return request(urlString, "GET", requestHeader, null);
    }

    /**
     * GET请求
     *
     * @param urlString   url字符串
     * @param requestBody 请求体
     * @return {@link String}
     */
    @Override
    public String GET(String urlString, String requestBody)
    {
        return request(urlString, "GET", null, requestBody);
    }

    /**
     * GET请求
     *
     * @param urlString url字符串
     * @return {@link String}
     */
    @Override
    public String GET(String urlString)
    {
        return request(urlString, "GET", null, null);
    }

    /**
     * 异步请求
     *
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    @Override
    public void asyncRequest(String urlString, String method, Map<String, String> requestHeader, String requestBody, HTTPHandlerListener listener)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                BufferedReader bufferedReader = null;
                InputStreamReader inputStreamReader = null;
                InputStream inputStream = null;
                HttpURLConnection httpURLConnection = null;
                OutputStreamWriter outputStreamWriter = null;
                try
                {
                    URL url = new URL(urlString);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    //设置请求方法
                    httpURLConnection.setRequestMethod(method);
                    //设置超时时间
                    httpURLConnection.setConnectTimeout(getConnectTimeout());
                    httpURLConnection.setReadTimeout(getReadTimeout());
                    //填充参数的请求头，优先级更高
                    if (requestHeader != null && requestHeader.size() != 0)
                    {
                        HttpURLConnection finalHttpURLConnection1 = httpURLConnection;
                        requestHeader.forEach(new BiConsumer<String, String>()
                        {
                            @Override
                            public void accept(String s, String s2)
                            {
                                //System.out.println("s=" + s + ",s2=" + s2);
                                finalHttpURLConnection1.addRequestProperty(s, s2);
                            }
                        });
                    }
                    //填充默认的请求头
                    if (defaultRequestHeader != null && defaultRequestHeader.size() != 0)
                    {
                        HttpURLConnection finalHttpURLConnection = httpURLConnection;
                        defaultRequestHeader.forEach(new BiConsumer<String, String>()
                        {
                            @Override
                            public void accept(String s, String s2)
                            {
                                //System.out.println("s=" + s + ",s2=" + s2);
                                finalHttpURLConnection.addRequestProperty(s, s2);
                            }
                        });
                    }
                    //填充请求体
                    if (requestBody != null && requestBody.length() != 0)
                    {
                        httpURLConnection.setDoOutput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStreamWriter = new OutputStreamWriter(outputStream);
                        outputStreamWriter.write(requestBody);
                        outputStreamWriter.flush();
                    }
                    //连接
                    httpURLConnection.connect();
                    //获得输入流
                    inputStream = httpURLConnection.getInputStream();
                    //转换流
                    inputStreamReader = new InputStreamReader(inputStream, getCharset());
                    //缓冲流
                    bufferedReader = new BufferedReader(inputStreamReader);
                    String str;
                    StringBuilder stringBuilder = new StringBuilder();
                    //写入数据
                    while ((str = bufferedReader.readLine()) != null)
                    {
                        stringBuilder.append(str).append("\n");
                    }
                    listener.OKHandler(stringBuilder.toString(), httpURLConnection.getResponseCode());
                }
                catch (IOException e)
                {
                    int code = 0;
                    try
                    {
                        if (httpURLConnection != null)
                        {
                            code = httpURLConnection.getResponseCode();
                        }
                    }
                    catch (Exception ignored)
                    {

                    }
                    listener.ExceptionHandler(e, code);
                }
                finally
                {
                    try
                    {
                        if (bufferedReader != null)
                        {
                            bufferedReader.close();
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    try
                    {
                        if (inputStreamReader != null)
                        {
                            inputStreamReader.close();
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    try
                    {
                        if (inputStream != null)
                        {
                            inputStream.close();
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    try
                    {
                        if (outputStreamWriter != null)
                        {
                            outputStreamWriter.close();
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    if (httpURLConnection != null)
                    {
                        httpURLConnection.disconnect();
                    }
                }
            }
        };
        if (this.threadPool == null)
        {
            new Thread(runnable).start();
            return;
        }
        //使用线程池
        threadPool.submit(runnable);
    }

    /**
     * 异步请求
     *
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param listener      侦听器
     */
    @Override
    public void asyncRequest(String urlString, String method, Map<String, String> requestHeader, HTTPHandlerListener listener)
    {
        asyncRequest(urlString, method, requestHeader, null, listener);
    }

    /**
     * 异步请求
     *
     * @param urlString   url字符串
     * @param method      方法
     * @param requestBody 请求体
     * @param listener    侦听器
     */
    @Override
    public void asyncRequest(String urlString, String method, String requestBody, HTTPHandlerListener listener)
    {
        asyncRequest(urlString, method, null, requestBody, listener);

    }

    /**
     * 异步请求
     *
     * @param urlString url字符串
     * @param method    方法
     * @param listener  侦听器
     */
    @Override
    public void asyncRequest(String urlString, String method, HTTPHandlerListener listener)
    {
        asyncRequest(urlString, method, null, null, listener);
    }

    /**
     * 异步GET请求
     *
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    @Override
    public void asyncGETRequest(String urlString, Map<String, String> requestHeader, String requestBody, HTTPHandlerListener listener)
    {
        asyncRequest(urlString, "GET", requestHeader, requestBody, listener);

    }

    /**
     * 异步GET请求
     *
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param listener      侦听器
     */
    @Override
    public void asyncGETRequest(String urlString, Map<String, String> requestHeader, HTTPHandlerListener listener)
    {
        asyncRequest(urlString, "GET", requestHeader, null, listener);
    }

    /**
     * 异步GET请求
     *
     * @param urlString   url字符串
     * @param requestBody 请求体
     * @param listener    侦听器
     */
    @Override
    public void asyncGETRequest(String urlString, String requestBody, HTTPHandlerListener listener)
    {
        asyncRequest(urlString, "GET", null, requestBody, listener);

    }

    /**
     * 异步GET请求
     *
     * @param urlString url字符串
     * @param listener  侦听器
     */
    @Override
    public void asyncGETRequest(String urlString, HTTPHandlerListener listener)
    {
        asyncRequest(urlString, "GET", null, null, listener);

    }
}
