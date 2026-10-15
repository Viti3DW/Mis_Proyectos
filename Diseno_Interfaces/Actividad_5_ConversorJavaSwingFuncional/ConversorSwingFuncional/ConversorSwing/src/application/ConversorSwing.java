/**
* Clase ConversorSwing.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package application;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.ConversorNumerico;

public class ConversorSwing {

    private JFrame frmConversorSwing;
    private JTextField textIntroduceNumero;
    private JTextField textResultado;
    private JTextField textIntroduceDecimalHexa;
    private JTextField textResultadoHexa;
    private JPanel panelCartas;

    public ConversorSwing() {
        initialize();
    }

    // Método simple para hacer visible la ventana desde el Main
    public void hacerVisible() {
        frmConversorSwing.setVisible(true);
    }

    private void initialize() {
        frmConversorSwing = new JFrame();
        frmConversorSwing.setTitle("Conversor Swing");
        frmConversorSwing.setBounds(100, 100, 450, 300);
        frmConversorSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConversorSwing.getContentPane().setLayout(new BorderLayout(0, 0));

        // PANEL SUPERIOR (BOTONES DEL MENÚ)
        JPanel panelMenu = new JPanel();
        frmConversorSwing.getContentPane().add(panelMenu, BorderLayout.NORTH);
        panelMenu.setLayout(new GridLayout(0, 2, 0, 0));

        JButton btnMenuBinario = new JButton("Binario");
        btnMenuBinario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) panelCartas.getLayout();
                cl.show(panelCartas, "panelBinario");
            }
        });
        panelMenu.add(btnMenuBinario);

        JButton btnMenuHexadecimal = new JButton("Hexadecimal");
        btnMenuHexadecimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) panelCartas.getLayout();
                cl.show(panelCartas, "panelHexadecimal");
            }
        });
        panelMenu.add(btnMenuHexadecimal);

        // PANEL CENTRAL (CARTAS)
        panelCartas = new JPanel();
        frmConversorSwing.getContentPane().add(panelCartas, BorderLayout.CENTER);
        panelCartas.setLayout(new CardLayout(0, 0));

        // PANEL 1: BINARIO
        JPanel panelBinario = new JPanel();
        panelCartas.add(panelBinario, "panelBinario");
        panelBinario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblDecimal = new JLabel("Numero Decimal");
        panelBinario.add(lblDecimal);

        textIntroduceNumero = new JTextField();
        textIntroduceNumero.setColumns(10);
        // Si pulsas Intro dentro de la caja, ejecuta la conversión
        textIntroduceNumero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarConversionBinaria();
            }
        });
        panelBinario.add(textIntroduceNumero);

        JButton btnConversor = new JButton("Convertir a Binario");
        btnConversor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarConversionBinaria();
            }
        });
        panelBinario.add(btnConversor);

        JLabel lblResultado = new JLabel("Resultado");
        panelBinario.add(lblResultado);

        textResultado = new JTextField();
        textResultado.setEditable(false);
        textResultado.setColumns(10);
        panelBinario.add(textResultado);

        // PANEL 2: HEXADECIMAL
        JPanel panelHexadecimal = new JPanel();
        panelCartas.add(panelHexadecimal, "panelHexadecimal");

        JLabel lblDecimalHex = new JLabel("Numero Decimal");
        panelHexadecimal.add(lblDecimalHex);

        textIntroduceDecimalHexa = new JTextField();
        textIntroduceDecimalHexa.setColumns(10);
        // Si pulsas Intro dentro de la caja, ejecuta la conversión
        textIntroduceDecimalHexa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarConversionHexa();
            }
        });
        panelHexadecimal.add(textIntroduceDecimalHexa);

        JButton btnConversorHexa = new JButton("Convertir a Hexadecimal");
        btnConversorHexa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarConversionHexa();
            }
        });
        panelHexadecimal.add(btnConversorHexa);

        JLabel lblResultadoHexa = new JLabel("Resultado");
        panelHexadecimal.add(lblResultadoHexa);

        textResultadoHexa = new JTextField();
        textResultadoHexa.setEditable(false);
        textResultadoHexa.setColumns(10);
        panelHexadecimal.add(textResultadoHexa);
    }

    // Lógica para binario con control de errores
    private void realizarConversionBinaria() {
        try {
            int numero = Integer.parseInt(textIntroduceNumero.getText());
            String binario = ConversorNumerico.decimalABinario(numero);
            textResultado.setText(binario);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frmConversorSwing, 
                "Debes introducir un número entero válido", 
                "Error de entrada", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Lógica para hexadecimal con control de errores
    private void realizarConversionHexa() {
        try {
            int numero = Integer.parseInt(textIntroduceDecimalHexa.getText());
            String hexa = ConversorNumerico.decimalAHexadecimal(numero);
            textResultadoHexa.setText(hexa);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frmConversorSwing, 
                "Debes introducir un número entero válido", 
                "Error de entrada", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}