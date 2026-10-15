/**
* Clase Activdad1.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Actividad1 {

	private JFrame frmActividad;
	private JTextField textIntroduceNumero;
	private JTextField textResultado;
	private JTextField textIntroduceDecimalHexa;
	private JTextField textResultadoHexa;
	private JPanel panelCartas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actividad1 window = new Actividad1();
					window.frmActividad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Actividad1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmActividad = new JFrame();
		frmActividad.setTitle("Actividad_1");
		frmActividad.setBounds(100, 100, 450, 300);
		frmActividad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmActividad.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel(); /* La creación del panel principal debe estar declarado arriba del todo */
		frmActividad.getContentPane().add(panelMenu, BorderLayout.NORTH);
		panelMenu.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnMenuBinario = new JButton("Binario");
		btnMenuBinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelCartas.getLayout(); /* para mostrar el panel binario */
				cl.show(panelCartas, "panelBinario");
			}
		});
		panelMenu.add(btnMenuBinario);
		
		JButton btnMenuHexadecimal = new JButton("Hexadecimal");
		btnMenuHexadecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelCartas.getLayout(); /* para mostrar el panel hexadecimal */
				cl.show(panelCartas, "panelHexadecimal");
			}
		});
		panelMenu.add(btnMenuHexadecimal);
		
		panelCartas = new JPanel();
		frmActividad.getContentPane().add(panelCartas, BorderLayout.CENTER);
		panelCartas.setLayout(new CardLayout(0, 0));
		
		JPanel panelBinario = new JPanel();
		panelCartas.add(panelBinario, "panelBinario");
		panelBinario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDecimal = new JLabel("Numero Decimal");
		panelBinario.add(lblDecimal);
		
		textIntroduceNumero = new JTextField();
		panelBinario.add(textIntroduceNumero);
		textIntroduceNumero.setColumns(10);
		
		JButton btnConversor = new JButton("Convertir a Decimal");
		panelBinario.add(btnConversor);
		
		JLabel lblResultado = new JLabel("Resultado");
		panelBinario.add(lblResultado);
		
		textResultado = new JTextField();
		textResultado.setEditable(false);
		textResultado.setToolTipText("");
		panelBinario.add(textResultado);
		textResultado.setColumns(10);
		
		JPanel panelHexadecimal = new JPanel();
		panelCartas.add(panelHexadecimal, "panelHexadecimal");
		
		JLabel lblDecimalHex = new JLabel("Numero Decimal");
		panelHexadecimal.add(lblDecimalHex);
		
		textIntroduceDecimalHexa = new JTextField();
		textIntroduceDecimalHexa.setColumns(10);
		panelHexadecimal.add(textIntroduceDecimalHexa);
		
		JButton btnConversorHexa = new JButton("Convertir a Hexadecimal");
		panelHexadecimal.add(btnConversorHexa);
		
		JLabel lblResultadoHexa = new JLabel("Resultado");
		panelHexadecimal.add(lblResultadoHexa);
		
		textResultadoHexa = new JTextField();
		textResultadoHexa.setToolTipText("");
		textResultadoHexa.setEditable(false);
		textResultadoHexa.setColumns(10);
		panelHexadecimal.add(textResultadoHexa);
	}

}
