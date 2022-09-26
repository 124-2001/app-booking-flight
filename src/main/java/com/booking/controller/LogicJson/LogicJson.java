package com.booking.controller.LogicJson;

import com.google.gson.Gson;

public class LogicJson {
    public String ConvertObjectToStringJson(Object object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }
    public Object ConvertStringJsonToObject(String json,Object object){
        Gson gson = new Gson();
        object = gson.fromJson(json,Object.class);
        return object;
    }
}
