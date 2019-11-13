package com.example.appleacademy_;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class registrarse extends AppCompatActivity {

    public static void setOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        final EditText nombreR     = (EditText)findViewById(R.id.txtNombre);
        final EditText usuarioR    = (EditText)findViewById(R.id.txtUsuario);
        final EditText correoR     = (EditText)findViewById(R.id.txtCorreo);
        final EditText claveR = (EditText)findViewById(R.id.txtClave);
        Button btnRegistroR = (Button) findViewById(R.id.btnRegistro);
        btnRegistroR.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view){
                final String nombre = nombreR.getText().toString();
                final String usuario = usuarioR.getText().toString();
                final String correo = correoR.getText().toString();
                final String clave = claveR.getText().toString();
                Response.Listener <String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject JsonRespuesta = new JSONObject(response);
                            boolean ok = JsonRespuesta.getBoolean("success");
                            if (ok == true){
                                Intent i = new Intent(registrarse.this,login.class);
                                registrarse.this.startActivity(i);
                                registrarse.this.finish();

                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(registrarse.this);
                                alerta.setMessage("Fallo en el registro").setNegativeButton("Reintentar", null).create().show();
                            }
                        }catch(JSONException e){
                            e.getMessage();

                        }
                        }
                    };
                RegistroRespuesta r = new RegistroRespuesta(nombre,usuario,correo,clave,respuesta);
                RequestQueue  cola = Volley.newRequestQueue(registrarse.this);
                cola.add(r);



            }
        });

    }
}
