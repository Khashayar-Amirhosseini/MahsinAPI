package com.MahSinApi.common;
import java.io.IOException;
import java.util.logging.*;

public class MahsinLogger {
    private static final Logger logger = Logger.getLogger(MahsinLogger.class.getName());
    public static void log(String loggerLevel,String messege) throws IOException {
        Handler fileHandler = null;
        Formatter simpleFormatter = null;

        try {
            fileHandler = new FileHandler("D:/Projects/MahsinApi/javacodegeeks.formatter.log",50*50,1,true);
            simpleFormatter = new SimpleFormatter();
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(simpleFormatter);
            switch (loggerLevel) {
                case "severe":
                    logger.severe(messege);

                    break;
                case "warning":
                    logger.warning(messege);
                    break;
                case "config":
                    logger.config(messege);
                    break;
                default:
                    logger.info(messege);
            }
            fileHandler.setLevel(Level.ALL);
            logger.setLevel(Level.ALL);
        }
        catch (Exception e){
            logger.log(Level.SEVERE,"Error occur in FileHandler",e);
        }
    }
}
