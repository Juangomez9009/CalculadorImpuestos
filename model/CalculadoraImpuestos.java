package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CalculadoraImpuestos {
    private static List<String> historial = new ArrayList<>();

    public static double calcularImpuesto(Vehiculo vehiculo) {
        double tasaBase = cargarTasaBase();
        if (vehiculo.getTipoUso().equalsIgnoreCase("Público")) {
            tasaBase *= 0.8;
        }
        if (vehiculo.getAnioFabricacion() < 2010) {
            tasaBase *= 1.2;
        }
        return vehiculo.getAvaluo() * tasaBase;
    }

    private static double cargarTasaBase() {
        Properties propiedades = new Properties();
        try (InputStream input = new FileInputStream("tarifas.properties")) {
            propiedades.load(input);
            return Double.parseDouble(propiedades.getProperty("tasaBase", "0.015"));
        } catch (IOException | NumberFormatException e) {
            return 0.015; // Valor por defecto si no se encuentra el archivo
        }
    }

    public static void guardarHistorial(String resultado) {
        historial.add(resultado);
    }

    public static List<String> obtenerHistorial() {
        return historial;
    }
}
