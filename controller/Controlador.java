package controller;

import model.Vehiculo;
import model.CalculadoraImpuestos;
import view.VistaImpuestos;
import javax.swing.JOptionPane;

public class Controlador {
    private VistaImpuestos vista;

    public Controlador(VistaImpuestos vista) {
        this.vista = vista;
    }

    public void calcularImpuesto() {
        try {
            Vehiculo vehiculo = new Vehiculo(
                vista.getMarca(),
                vista.getModelo(),
                vista.getAnioFabricacion(),
                vista.getCilindraje(),
                vista.getAvaluo(),
                vista.getTipoUso()
            );
            double impuesto = CalculadoraImpuestos.calcularImpuesto(vehiculo);
            vista.mostrarResultado(impuesto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
