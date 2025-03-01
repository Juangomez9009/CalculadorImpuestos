package model;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cilindraje;
    private double avaluo;
    private String tipoUso; // Particular o Público

    public Vehiculo(String marca, String modelo, int anioFabricacion, int cilindraje, double avaluo, String tipoUso) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.cilindraje = cilindraje;
        this.avaluo = avaluo;
        this.tipoUso = tipoUso;
    }

    public double getAvaluo() { return avaluo; }
    public int getAnioFabricacion() { return anioFabricacion; }
    public String getTipoUso() { return tipoUso; }
}
