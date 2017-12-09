package com.example.aulab.registro_alumnos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    RelativeLayout miLayouyt;
    EditText nombres,correos;
    Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miLayouyt=findViewById(R.id.milayout);
        nombres=findViewById(R.id.editText);
        correos=findViewById(R.id.editText2);
        enviar=findViewById(R.id.button);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String URL="http://www.programadoresperuanos.com/test_app/pruebaa/index.php";
                AsyncHttpClient clientedar = new AsyncHttpClient();

                RequestParams datos=new RequestParams();
                datos.put("datonombres",nombres.getText().toString());
                datos.put("datocorreo",correos.getText().toString());

                clientedar.post(getApplicationContext(), URL, datos, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        //notificaciones de tipo tostada qye salen de abajo hgacia rriba que desdataprece solo
                        if(statusCode==200){
                            //Toast.makeText(getApplicationContext(),"Exito al Guardar los Datos",Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(),String.valueOf(responseBody),Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), String.valueOf(statusCode)+" "+String.valueOf(responseBody),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                        //Toast.makeText(getApplicationContext(),"Error al Guardar los Datos",Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),String.valueOf(statusCode)+" "+ String.valueOf(error),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }


}
