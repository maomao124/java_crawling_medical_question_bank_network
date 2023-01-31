package mao.utils;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：java爬取医学题库网
 * Package(包名): mao.utils
 * Class(类名): FileUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 22:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class FileUtils
{
    /**
     * 向文件写数据
     *
     * @param data     数据
     * @param filePath 文件路径
     * @return boolean
     */
    public static boolean write(String filePath, String data)
    {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        try
        {
            File file = new File(filePath);
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            //保存
            outputStreamWriter.write(data);
            //刷新
            outputStreamWriter.flush();
            return true;
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件保存失败！！！");
            e.printStackTrace();
            return false;
        }
        finally
        {
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
            try
            {
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
