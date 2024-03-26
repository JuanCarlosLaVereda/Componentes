package es.ieslavereda.componentes;

public class Usuario {
    private String nombre;
    private String apellidos;

    public Usuario(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString(){
        return nombre + " " + apellidos;
    }
}
