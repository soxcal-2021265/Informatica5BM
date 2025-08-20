package modelo;

public class Zapato {
    private int codigoZapato;
    private String nombre;
    private String marca;
    private String talla;
    private String color;

    public Zapato() {
    }

    public Zapato(int codigoZapato, String nombre, String marca, String talla, String color) {
        this.codigoZapato = codigoZapato;
        this.nombre = nombre;
        this.marca = marca;
        this.talla = talla;
        this.color = color;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
