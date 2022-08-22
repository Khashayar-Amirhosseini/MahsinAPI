package com.MahSinApi.common;


import com.MahSinApi.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.QueryTimeoutException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ExceptionWrapper {
    public static String getMessage(Exception e) {
        System.out.println("wrapper runs");
        if(e instanceof AccessDeniedException){
            return ("دسترسی مورد نیاز را ندارید");
        }
        return e.getMessage();

    }
}
