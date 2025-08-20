package modelo;

public class Cliente {
    private int codigoCliente;
    private int codigoZapato;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int codigoCliente, int codigoZapato, String nombre, String telefono, String correo, String direccion) {
        this.codigoCliente = codigoCliente;
        this.codigoZapato = codigoZapato;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoZapato() {
        return codigoZapato;
    }

    public void setCodigoZapato(int codigoZapato) {
        this.codigoZapato = codigoZapato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
