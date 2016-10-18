package com.sviluppo.pierangelo.fragmentretrofitgson.Service;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.sviluppo.pierangelo.fragmentretrofitgson.Model.Cluniacensi;

import java.lang.reflect.Type;

/**
 * Created by pierangelo on 17/10/16.
 */
public class CluniacensiDeserializer {
    //@Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement element = json.getAsJsonObject().get("fields");
        return new Gson().fromJson(element, Cluniacensi.class);
    }
}
