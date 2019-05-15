package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author lc
 */
@SuppressWarnings("all")
public class PropertiyRead {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "E:\\workspace\\spring-boot-demo\\src\\main\\java\\com\\lc\\util\\config.properties";
		String data = getPropertyAbsolutely(path);
        System.out.println(data);

        String data2 = getPropertyRelative("/config.properties");
        System.out.println(data2);
    }

    /**
     * 相对路径获取
     * @param name
     * @return
     * @throws IOException
     */
    public static String getPropertyRelative(String name) throws IOException {
        String strKey = null;
        String strValue = null;
        Properties properties = new Properties();
        properties.load(PropertiyRead.class.getResourceAsStream(name));
        Enumeration enum1 = properties.propertyNames();
        while (enum1.hasMoreElements()) {
             strKey = (String) enum1.nextElement();
             strValue = properties.getProperty(strKey);
        }
        return strKey+"="+strValue;
    }

    /**
     * 绝对路径获取
     * @param path
     * @return
     * @throws IOException
     */
    public static String getPropertyAbsolutely(String path) throws IOException {
        String strKey = null;
        String strValue = null;
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        Enumeration enum1 = properties.propertyNames();
        while (enum1.hasMoreElements()) {
           strKey = (String) enum1.nextElement();
           strValue = properties.getProperty(strKey);
        }
        return strKey+"="+strValue;
    }

    public static String getProperty2(String path)throws IOException{
        String strKey = null;
        String strValue = null;
        Properties properties = new Properties();
        properties.load(PropertiyRead.class.getResourceAsStream(""));



        return "";
    }



//    String propertiesPath = "/com/lc/util/config.properties";  //properties文件路径
//    Properties properties = new Properties();
////		String data = properties.getProperty("webservice_url");
//		 properties.load(new FileInputStream("E:\\workspace\\spring-boot-demo\\src\\main\\java\\com\\lc\\util\\config.properties"));
//    //        properties.load(Test.class.getResourceAsStream(propertiesPath));
//    Enumeration enum1 = properties.propertyNames();
//        while (enum1.hasMoreElements()) {
//        String strKey = (String) enum1.nextElement();
//        String strValue = properties.getProperty(strKey);
//        System.out.println(strKey+"="+strValue);
//    }

    private PropertiyRead() { }

    private static class SingletonHelp {
        static PropertiyRead instance = new PropertiyRead();
          }

    public static PropertiyRead getInstance() {
        return SingletonHelp.instance;
    }

}
