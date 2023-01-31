package mao.utils;

import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.utils
 * Class(类名): SslUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 20:11
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class SslUtils
{

    /**
     * 信任所有https证书
     *
     * @throws Exception 异常
     */
    private static void trustAllHttpsCertificates() throws Exception
    {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }


    static class miTM implements TrustManager, X509TrustManager
    {
        /**
         * 得到接受发行人
         *
         * @return {@link X509Certificate[]}
         */
        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        /**
         * 是服务器信任
         *
         * @param certs 确实事情
         * @return boolean
         */
        public boolean isServerTrusted(X509Certificate[] certs)
        {
            return true;
        }

        /**
         * 是客户信任
         *
         * @param certs 确实事情
         * @return boolean
         */
        public boolean isClientTrusted(X509Certificate[] certs)
        {
            return true;
        }

        /**
         * 检查服务器可信
         *
         * @param certs    确实事情
         * @param authType 身份验证类型
         * @throws CertificateException 证书异常
         */
        public void checkServerTrusted(X509Certificate[] certs, String authType)
                throws CertificateException
        {
            return;
        }

        /**
         * 检查客户信任
         *
         * @param certs    确实事情
         * @param authType 身份验证类型
         * @throws CertificateException 证书异常
         */
        public void checkClientTrusted(X509Certificate[] certs, String authType)
                throws CertificateException
        {
            return;
        }
    }

    /**
     * 忽略HTTPS请求的SSL证书，必须在openConnection之前调用
     *
     * @throws Exception 异常
     */
    public static void ignoreSsl() throws Exception
    {
        HostnameVerifier hv = new HostnameVerifier()
        {
            public boolean verify(String urlHostName, SSLSession session)
            {
                System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                return true;
            }
        };
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
}
