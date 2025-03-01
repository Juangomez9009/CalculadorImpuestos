package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import controller.Controlador;
import model.CalculadoraImpuestos;

public class VistaImpuestos extends JFrame {
    private JTextField marcaField, modeloField, anioField, cilindrajeField, avaluoField;
    private JComboBox<String> tipoUsoBox;
    private JButton calcularBtn;
    private JLabel resultadoLabel;
    private JTextArea historialArea;

    public VistaImpuestos() {
        setTitle("Cálculo de Impuestos de Vehículos");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 5, 5));

        add(new JLabel("Marca:"));
        marcaField = new JTextField(); add(marcaField);
        add(new JLabel("Modelo:"));
        modeloField = new JTextField(); add(modeloField);
        add(new JLabel("Año de fabricación:"));
        anioField = new JTextField(); add(anioField);
        add(new JLabel("Cilindraje:"));
        cilindrajeField = new JTextField(); add(cilindrajeField);
        add(new JLabel("Avalúo Comercial:"));
        avaluoField = new JTextField(); add(avaluoField);
        add(new JLabel("Tipo de Uso:"));
        tipoUsoBox = new JComboBox<>(new String[]{"Particular", "Público"}); add(tipoUsoBox);

        calcularBtn = new JButton("Calcular Impuesto");
        add(calcularBtn);
        resultadoLabel = new JLabel("Resultado: ");
        add(resultadoLabel);

        historialArea = new JTextArea(5, 30);
        historialArea.setEditable(false);
        add(new JScrollPane(historialArea));

        calcularBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarEntrada()) {
                    new Controlador(VistaImpuestos.this).calcularImpuesto();
                }
            }
        });
    }

    private boolean validarEntrada() {
        try {
            Integer.parseInt(anioField.getText());
            Integer.parseInt(cilindrajeField.getText());
            Double.parseDouble(avaluoField.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public String getMarca() { return marcaField.getText(); }
    public String getModelo() { return modeloField.getText(); }
    public int getAnioFabricacion() { return Integer.parseInt(anioField.getText()); }
    public int getCilindraje() { return Integer.parseInt(cilindrajeField.getText()); }
    public double getAvaluo() { return Double.parseDouble(avaluoField.getText()); }
    public String getTipoUso() { return (String) tipoUsoBox.getSelectedItem(); }

    public void mostrarResultado(double impuesto) {
        NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        String resultado = "Impuesto: $" + format.format(impuesto);
        resultadoLabel.setText(resultado);
        CalculadoraImpuestos.guardarHistorial(resultado);
        actualizarHistorial();
    }

    public void actualizarHistorial() {
        historialArea.setText("");
        for (String entry : CalculadoraImpuestos.obtenerHistorial()) {
            historialArea.append(entry + "\n");
        }
    }
}
