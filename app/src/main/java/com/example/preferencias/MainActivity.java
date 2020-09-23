package com.example.preferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etDato;
    Button btnGuardar, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        final SharedPreferences sharprefs = getSharedPreferences("ArchivoSP", context.MODE_PRIVATE);


        etDato = (EditText)findViewById(R.id.etDato);
        btnMostrar = (Button)findViewById(R.id.btnMostrar);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);
                String valor = sharpref.getString("MiDato","No hay dato");
                Toast.makeText(getApplicationContext(), "Dato guardado : "+valor,Toast.LENGTH_LONG).show();

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharpref.edit();
                editor.putString("MiDato", etDato.getText().toString());
                editor.commit();

            }
        });


    }
}
