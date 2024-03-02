package co.edu.uniquindio.poo;

public class Mascota {

    // Atributos
    private String nombre;
    private String especie;
    private String genero;
    private String raza;
    private byte edad;
    private String color;
    private double peso;



    // Constructor
    public Mascota(String nombre, String especie, String raza, String genero, byte edad,  String color,  double peso) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.edad = edad;
        this.color = color;
        this.peso = peso;

        assert edad > 0 : "La edad debe ser mayor a cero";
    }

    // Getters y Setters



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

        public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

        public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

        public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

}
