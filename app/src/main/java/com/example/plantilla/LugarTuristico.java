package com.example.plantilla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LugarTuristico {
    String Nombre;
    String Direccion;
    String Logo;
    String Telefono;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public LugarTuristico(JSONObject a) throws JSONException {
        Nombre =  a.getString("nombre_lugar").toString();
        Direccion =  a.getString("direccion").toString() ;
        Telefono =  a.getString("telefono").toString() ;
        Logo = "https://uealecpeterson.net/turismo/assets/imgs/logos_gifs/" + a.getString("logo").toString();



    }

    public static ArrayList<LugarTuristico> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<LugarTuristico> lstLugaresTuristicos = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            lstLugaresTuristicos.add(new LugarTuristico(datos.getJSONObject(i)));
        }
        return lstLugaresTuristicos;
    }

}
