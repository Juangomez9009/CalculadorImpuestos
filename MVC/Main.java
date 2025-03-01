package MVC;

import javax.swing.*;
import view.VistaImpuestos;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        VistaImpuestos vista = new VistaImpuestos();
        vista.setVisible(true);
    }
}
