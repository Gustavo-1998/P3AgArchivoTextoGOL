package mx.edu.tesoem.isc.gol.p3agarchivotextogol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class eliminar extends AppCompatActivity {

    private ArrayList<Datos> txtCompleto = new ArrayList<Datos>();
    List<String> listaContacto = new ArrayList<String>();
    Spinner objSpinner;
    ArrayAdapter<String> listContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        try{
            objSpinner = findViewById(R.id.spNombre);
            ManejoArchivo objFM = new ManejoArchivo();
            objFM.Reed(this);
            txtCompleto = objFM.getContent();
            String[] data = objFM.retNameTel(txtCompleto);
            Collections.addAll(listaContacto, data);
            listContactAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaContacto);
            objSpinner.setAdapter(listContactAdapter);
            objSpinner.getSelectedItem().toString();
        }catch (NullPointerException e){
            Toast.makeText(this, "No hay contactos guardados.", Toast.LENGTH_SHORT).show();
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
            finish();
        }
    }

    public void regresa(View view){
        Intent main = new Intent(this, menu.class);
        startActivity(main);
        finish();
    }

    public void elimina(View view){
        ManejoArchivo objFM = new ManejoArchivo();
        String cadena = objSpinner.getSelectedItem().toString();
        int tam = cadena.length();
        String[] arreglo = new String[]{
                cadena.substring(0, cadena.indexOf(" | ")),
                cadena.substring(cadena.indexOf(" | ") + 3, tam)
        };
        objFM.Reed(this);
        if(objFM.Elimina(this, arreglo, objFM.getContent())){
            txtCompleto = objFM.getContent();
            if(objFM.Record(this, txtCompleto)){
                Toast.makeText(this, "Se ha borrado correctamente.", Toast.LENGTH_SHORT).show();
                Intent main = new Intent(this, eliminar.class);
                startActivity(main);
                finish();
            }
        }
    }
}
