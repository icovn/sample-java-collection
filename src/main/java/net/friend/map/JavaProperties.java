package net.friend.map;

import java.io.InputStream;
import java.util.Properties;

public class JavaProperties {
    public static void main(String[] args)throws Exception{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("java-properties.properties");

        Properties prop =new Properties();
        prop.load(inputStream);

        System.out.println(prop.getProperty("user"));
        System.out.println(prop.getProperty("password"));
    }
}
