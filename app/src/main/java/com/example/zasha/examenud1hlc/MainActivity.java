package com.example.zasha.examenud1hlc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int CODIGO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INTENT EXPLICITO para abrir ACTIVIDADES
        Button boton1 = (Button) findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                nombre();
            }
        });


        //INTENT IMPLICITO para abrir MAPS
        Button boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                map();
            }
        });

        //INTENT IMPLICITO para abrir YOUTUBE
        Button boton3 = (Button) findViewById(R.id.button3);
        boton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                youTube();
            }
        });

    }//final onCreate

    public void map() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + "ies al-andalus almeria"));
        startActivity(intent);
    }

    public void youTube() {
        String cadena ="ies alandalus almeria";
        Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + cadena));
        startActivity(youtubeIntent);
    }

    public void nombre(){
        EditText etNombre = (EditText)findViewById(R.id. editText);//Llamo al campo de texto
        String nombre = etNombre.getText().toString();//Capturo el texto introducido en una variable

        Intent intent = new Intent(this, Activity2.class);//Actividad de destino
        Bundle bundle = new Bundle();//Paquete de datos a enviar

        bundle.putString("NOMBRE", nombre);
        intent.putExtras(bundle);//Recojo todos los datos en el paquete bundle

        startActivityForResult(intent, CODIGO);// Ejecuto el activity (intent) Verifica
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 0){
            TextView textResultado = (TextView)findViewById(R.id.textView);
            textResultado.setText(data.getExtras().getString("code"));
        }
    }


}//final clase
