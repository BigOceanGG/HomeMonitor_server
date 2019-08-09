package com.ocean.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidateCharacterUtils {

    public static boolean validateSpecialCharacter(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
    public static void main(String []args){
        ValidateCharacterUtils ss = new ValidateCharacterUtils();
        System.out.println(ss.validateSpecialCharacter("'lsllslsall"));
    }
}

