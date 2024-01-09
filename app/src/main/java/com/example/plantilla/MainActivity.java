package com.example.plantilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.plantilla.WebServices.Asynchtask;
import com.example.plantilla.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://uealecpeterson.net/turismo/lugar_turistico/json_getlistadoGrid",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<LugarTuristico> lstLugarTuristico = new ArrayList<LugarTuristico>();

        JSONObject lista = new JSONObject(result);
        JSONArray JSONlista = lista.getJSONArray("data");

        lstLugarTuristico = LugarTuristico.JsonObjectsBuild(JSONlista);
        AdaptadorLugaresTuristicos adaptadorLugaresTuristicos
                = new AdaptadorLugaresTuristicos(this, lstLugarTuristico);
        ListView lstOpciones = (ListView)findViewById(R.id.lstLugaresT);
        lstOpciones.setAdapter(adaptadorLugaresTuristicos);
    }
}