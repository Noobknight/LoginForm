package com.tadev.login;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PC on 10/05/2016.
 */
public class Validation {

    public boolean isUser(String userName, final String PATTERN) {
        if(TextUtils.isEmpty(userName)){
            return false;
        }
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(userName);
        return matcher.matches();
    }


    public boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isPassword(String pwd,final String patternPwd){
        if(TextUtils.isEmpty(pwd)){
            return false;
        }
        Pattern pattern = Pattern.compile(patternPwd);
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }

}
