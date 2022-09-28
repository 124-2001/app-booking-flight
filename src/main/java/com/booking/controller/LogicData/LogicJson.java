package com.booking.controller.LogicData;

import com.booking.model.Flight;
import com.google.gson.Gson;

public class LogicJson {
    public String ConvertObjectToStringJson(Object object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }
    public Object ConvertStringJsonToObject(String json, Flight object){
        Gson gson = new Gson();
        object = gson.fromJson(json,Flight.class);
        return object;
    }
}
