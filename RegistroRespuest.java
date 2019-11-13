package com.example.appleacademy_;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRespuesta extends StringRequest {
    private static  final String ruta ="https://aulap.000webhostapp.com/registro.php";
    private Map<String, String> parametros;
    public RegistroRespuesta (String  nombre, String usuario, String correo, String clave, Response.Listener<String>listener){
        super(Request.Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("nombre",nombre+"");
        parametros.put("usuario",usuario+"");
        parametros.put("correo",correo+"");
        parametros.put("clave",clave+"");

    }

    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }
}
