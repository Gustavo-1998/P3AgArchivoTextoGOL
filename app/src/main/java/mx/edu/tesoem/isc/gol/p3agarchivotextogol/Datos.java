package mx.edu.tesoem.isc.gol.p3agarchivotextogol;

public class Datos {
    private String Nombre, Telefono, Direccion, Correo;

    public Datos() {
    }

    public Datos(String nombre, String telefono, String direccion, String correo) {
        Nombre = nombre;
        Telefono = telefono;
        Direccion = direccion;
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
