package com.qf.util;

import java.util.HashMap;

public class UrlUtil {

    //this method is used to get the request attribute in the url
    //give 'key=123&?abc=321'  return {'key'='123', 'abc'='123'}
    public static HashMap<String, String> queryStringParse(String query){
        String[] params = query.split("&\\?");
        HashMap<String, String> paramMap = new HashMap<>();
        for (String param : params) {
            String[] keyValue = param.split("=");
            //replace % with ''
            paramMap.put(keyValue[0], keyValue[1].replaceAll("%", " "));
        }

        return paramMap;
    }
}
