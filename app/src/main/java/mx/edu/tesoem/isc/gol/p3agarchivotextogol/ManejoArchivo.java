package mx.edu.tesoem.isc.gol.p3agarchivotextogol;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ManejoArchivo {
    private ArrayList<Datos> TextoCompleto = new ArrayList<Datos>();
    private final String nomArch = "DatosAJSM.txt";

    public boolean Record(Context context, ArrayList<Datos> dato){
        try{
            Gson gson = new Gson();
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(nomArch, Activity.MODE_PRIVATE));
            for(Datos e: dato){
                Datos data = new Datos(e.getNombre(), e.getTelefono(), e.getDireccion(), e.getCorreo());
                String cjson = gson.toJson(data);
                archivo.write(cjson + "\n");
            }
            archivo.flush();
            archivo.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean Reed(Context context){
        try{
            Gson gson = new Gson();
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(nomArch));
            BufferedReader br = new BufferedReader(archivo);
            String cadena = br.readLine();
            while(cadena != null){
                Datos objDa = gson.fromJson(cadena, Datos.class);
                Datos obj = new Datos();
                obj.setNombre(objDa.getNombre());
                obj.setTelefono(objDa.getTelefono());
                obj.setDireccion(objDa.getDireccion());
                obj.setCorreo(objDa.getCorreo());
                TextoCompleto.add(obj);
                cadena = br.readLine();
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Datos> getContent(){
        return TextoCompleto;
    }

    public void add(Datos dato, ArrayList<Datos> textComplet){
        this.TextoCompleto = textComplet;
        this.TextoCompleto.add(dato);
    }

    public boolean Elimina(Context context, String[] cadena, ArrayList<Datos> data){
        ArrayList<Datos> temp = new ArrayList<Datos>();
        for(Datos e: data){
            if(!(e.getNombre().equals(cadena[0]) && e.getTelefono().equals(cadena[1]))){
                Datos obj = new Datos(e.getNombre(), e.getTelefono(), e.getDireccion(), e.getCorreo());
                temp.add(obj);
            }
        }
        TextoCompleto = temp;
        return true;
    }

    public String[] fillGV(ArrayList<Datos> txtComplet){
        String[] data = new String[(txtComplet.size() * 4) + 4];
        int col = 4;

        data[0] = "Nombre";
        data[1] = "Telefono";
        data[2] = "Direccion";
        data[3] = "Correo";

        for(Datos e: txtComplet){
            data[col] = e.getNombre();
            data[col + 1] = e.getTelefono();
            data[col + 2] = e.getDireccion();
            data[col + 3] = e.getCorreo();
            col += 4;
        }
        return data;
    }

    public String[] retNameTel(ArrayList<Datos> txtComplet){
        String[] data = new String[txtComplet.size()];
        int i = 0;
        for(Datos e: txtComplet){
            data[i] = e.getNombre() + " | " + e.getTelefono();
            i++;
        }
        return data;
    }

}
