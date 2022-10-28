package com.MahSinApi.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ServerAddress {
    public static  String MainServerAddress = null;
    public static  String UPLOAD_DIRECTORY = null;
    public static  String IMAGE_DIRECTORY= null;
    public static  String UPLOAD_DIRECTORY_FOR_PARAGRAPHS_PICTURE = null;
    public static  String IMAGE_DIRECTORY_FOR_PARAGRAPHS_PICTURE= null;
    public static  String UPLOAD_DIRECTORY_FOR_POST = null;
    public static  String IMAGE_DIRECTORY_FOR_POST= null;
    public ServerAddress (){
        try {
            FileInputStream input = new FileInputStream("C:\\config\\config.properties");
            Properties prop = new Properties();
            prop.load(input);
            MainServerAddress=prop.getProperty("MainServerAddress");
            UPLOAD_DIRECTORY =prop.getProperty("UPLOAD_DIRECTORY");
            IMAGE_DIRECTORY=MainServerAddress+"/resources/images/";
            UPLOAD_DIRECTORY_FOR_PARAGRAPHS_PICTURE=prop.getProperty("UPLOAD_DIRECTORY_FOR_PARAGRAPHS_PICTURE");
            IMAGE_DIRECTORY_FOR_PARAGRAPHS_PICTURE=MainServerAddress+"/resources/paragraph/";
            UPLOAD_DIRECTORY_FOR_POST=prop.getProperty("UPLOAD_DIRECTORY_FOR_POST");
            IMAGE_DIRECTORY_FOR_POST=MainServerAddress+"/resources/post/";
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, unable to find config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
