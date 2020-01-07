package mx.edu.tesoem.isc.gol.p3agarchivotextogol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class listar extends AppCompatActivity {
    private ArrayList<Datos> txtCompleto = new ArrayList<Datos>();
    GridView gvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        gvLista = findViewById(R.id.gvLista);
        viewContent();
    }

    public void regresa(View view) {
        Intent main = new Intent(this, menu.class);
        startActivity(main);
        finish();
    }

    public void viewContent() {
        ManejoArchivo objFM = new ManejoArchivo();
        objFM.Reed(this);
        txtCompleto = objFM.getContent();
        String[] data = objFM.fillGV(txtCompleto);
        if (!(data.length == 4)) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
            gvLista.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No hay contactos guardados.", Toast.LENGTH_SHORT).show();
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
            finish();
        }
    }
}
