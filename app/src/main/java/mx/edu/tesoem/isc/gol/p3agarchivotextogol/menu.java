package mx.edu.tesoem.isc.gol.p3agarchivotextogol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void agrega(View view){
        Intent agrega= new Intent(this, agregar.class);
        startActivity(agrega);
        finish();
    }

    public void lista(View view){
        Intent lista = new Intent(this, listar.class);
        startActivity(lista);
        finish();
    }

    public void elimina(View view){
        Intent elimina = new Intent(this, eliminar.class);
        startActivity(elimina);
        finish();
    }
}
