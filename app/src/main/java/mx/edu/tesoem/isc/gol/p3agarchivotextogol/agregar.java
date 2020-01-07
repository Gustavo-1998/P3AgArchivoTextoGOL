package mx.edu.tesoem.isc.gol.p3agarchivotextogol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class agregar extends AppCompatActivity {
    private ArrayList<Datos> txtCompleto = new ArrayList<Datos>();
    EditText txtNombre, txtTelefono, txtDireccion, txtCorreo;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        txtNombre = findViewById(R.id.txtName);
        txtTelefono = findViewById(R.id.txtTel);
        txtDireccion = findViewById(R.id.txtAddress);
        txtCorreo = findViewById(R.id.txtEmail);
    }

    public void regresa(View view){
        Intent main = new Intent(this, menu.class);
        startActivity(main);
        finish();
    }

    public void Guardar(View v){
        if(txtNombre.getText().toString().length() > 0  && txtTelefono.getText().toString().length() > 0
                && txtDireccion.getText().toString().length() > 0  && txtCorreo.getText().toString().length() > 0){
            ManejoArchivo objFM = new ManejoArchivo();
            Datos objData = new Datos(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtDireccion.getText().toString(), txtCorreo.getText().toString());
            objFM.Reed(this);
            objFM.add(objData, objFM.getContent());
            txtCompleto = objFM.getContent();
            if(objFM.Record(this, txtCompleto)){
                Toast.makeText(this, "Guardado correctamente.", Toast.LENGTH_SHORT).show();
                Intent main = new Intent(this, menu.class);
                startActivity(main);
                finish();
            }else{
                Toast.makeText(this, "Error al grabar.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Llene todos los campos.", Toast.LENGTH_SHORT).show();
        }
    }
}
