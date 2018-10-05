package com.example.alumno.clase5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 04/10/2018.
 */

public class ParserJSONPersona {

    public static List<Personas> getPersonas(String jsonString)
    {
        List<Personas>listaPersonas = new ArrayList<Personas>();

        try {
            JSONArray listaJson = new JSONArray(jsonString);
            for (int i = 0; i < listaJson.length(); i++)
            {
                Personas p = new Personas();
                JSONObject object = listaJson.getJSONObject(i);
                p.setFirstName(object.getString("first_name"));
                p.setLastName(object.getString("last_name"));
                p.setPhone(object.getString("phone"));
                listaPersonas.add(p);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return listaPersonas;

    }
}
