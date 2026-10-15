/**
* Clase FormularioAlta.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package formulario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class FormularioAlta {

	private JFrame frame;
	private JTextField txtNombre;
	private JPasswordField txtContrasena;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAlta window = new FormularioAlta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormularioAlta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Formulario de Alta");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		
		// Panel inferior para los botones (Guardar / Cancelar)
		JPanel panelBotones = new JPanel();
		frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(0, 255, 0));
		btnGuardar.setMnemonic('G');
		btnGuardar.setToolTipText("Guardar datos del formulario");
		panelBotones.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setToolTipText("Borrar los datos del formulario");
		btnCancelar.setMnemonic('C');
		panelBotones.add(btnCancelar);
		
		// Panel central para el formulario
		JPanel panelFormulario = new JPanel();
		panelFormulario.setBorder(new EmptyBorder(5, 15, 5, 15));
		// GridLayout de 2 columnas con separación horizontal y vertical de 10px
		panelFormulario.setLayout(new GridLayout(0, 2, 10, 10));
		frame.getContentPane().add(panelFormulario, BorderLayout.CENTER);
		
		/* Nombre y Apellidos */
		JLabel lblNombre = new JLabel("Nombre y Apellidos:");
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Introduce tu nombre y apellidos");
		txtNombre.setColumns(10);
		lblNombre.setLabelFor(txtNombre);
		panelFormulario.add(lblNombre);
		panelFormulario.add(txtNombre);
		
		/* DNI */
		JLabel lblDni = new JLabel("DNI:");
		JFormattedTextField txtDni = new JFormattedTextField();
		txtDni.setToolTipText("Formato: 12345678-A");
		lblDni.setLabelFor(txtDni);
		panelFormulario.add(lblDni);
		panelFormulario.add(txtDni);
		
		/* Contraseña */
		JLabel lblContrasena = new JLabel("Contraseña:");
		txtContrasena = new JPasswordField();
		txtContrasena.setToolTipText("Introduce tu contraseña");
		lblContrasena.setLabelFor(txtContrasena);
		panelFormulario.add(lblContrasena);
		panelFormulario.add(txtContrasena);
		
		/* Provincia */
		JLabel lblProvincia = new JLabel("Provincia:");
		JComboBox<String> cbProvincia = new JComboBox<String>();
		cbProvincia.setModel(new DefaultComboBoxModel<String>(new String[] {
			"A Coruña", "Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", 
			"Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", 
			"Comunidad de Madrid", "Comunidad Foral de Navarra", "Córdoba", "Cuenca", "Girona", 
			"Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Illes Balears", "Jaén", 
			"La Rioja", "Las Palmas", "León", "Lleida", "Lugo", "Málaga", "Ourense", "Palencia", 
			"Pontevedra", "Región de Murcia", "Salamanca", "Santa Cruz de Tenerife", "Segovia", 
			"Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", 
			"Vizcaya", "Zamora", "Zaragoza"
		}));
		cbProvincia.setSelectedIndex(5);
		cbProvincia.setToolTipText("Selecciona tu provincia de residencia");
		lblProvincia.setLabelFor(cbProvincia);
		panelFormulario.add(lblProvincia);
		panelFormulario.add(cbProvincia);
		
		/* Edad */
		JLabel lblEdad = new JLabel("Edad:");
		JSpinner spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(18, 16, 99, 1));
		spnEdad.setToolTipText("Indica tu edad (entre 16 y 99 años)");
		lblEdad.setLabelFor(spnEdad);
		panelFormulario.add(lblEdad);
		panelFormulario.add(spnEdad);
		
		/* Nivel de Estudios */
		JLabel lblEstudios = new JLabel("Nivel de Estudios:");
		JPanel panelEstudios = new JPanel();
		panelEstudios.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JRadioButton rbPrimaria = new JRadioButton("Primaria/ESO");
		lblEstudios.setLabelFor(rbPrimaria);
		rbPrimaria.setToolTipText("Educación básica");
		buttonGroup.add(rbPrimaria);
		panelEstudios.add(rbPrimaria);
		
		JRadioButton rbBachillerato = new JRadioButton("Bachillerato");
		rbBachillerato.setToolTipText("Estudios de bachillerato");
		buttonGroup.add(rbBachillerato);
		panelEstudios.add(rbBachillerato);
		
		JRadioButton rbCiclo = new JRadioButton("Ciclo Formativo");
		rbCiclo.setToolTipText("Formación profesional");
		buttonGroup.add(rbCiclo);
		panelEstudios.add(rbCiclo);
		
		JRadioButton rbUniversidad = new JRadioButton("Universidad / Grado");
		rbUniversidad.setToolTipText("Estudios universitarios");
		buttonGroup.add(rbUniversidad);
		panelEstudios.add(rbUniversidad);
		
		panelFormulario.add(lblEstudios);
		panelFormulario.add(panelEstudios);
		
		JLabel lblIdiomas = new JLabel("Idiomas");
		panelFormulario.add(lblIdiomas);
		
		JPanel panelIdiomas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelIdiomas.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelFormulario.add(panelIdiomas);
		
		JCheckBox chkEspanol = new JCheckBox("Espanol\r\n");
		lblIdiomas.setLabelFor(chkEspanol);
		panelIdiomas.add(chkEspanol);
		
		JCheckBox chkFrances = new JCheckBox("Frances");
		panelIdiomas.add(chkFrances);
		
		JCheckBox chkIngles = new JCheckBox("Ingles");
		panelIdiomas.add(chkIngles);
		
		JCheckBox chkChino = new JCheckBox("Chino");
		panelIdiomas.add(chkChino);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setToolTipText("Introduce tus observaciones adicionales");
		panelFormulario.add(lblObservaciones);
		
		JScrollPane scrollObservaciones = new JScrollPane();
		panelFormulario.add(scrollObservaciones);
		
		JTextArea textObservaciones = new JTextArea();
		lblObservaciones.setLabelFor(textObservaciones);
		textObservaciones.setWrapStyleWord(true);
		textObservaciones.setLineWrap(true);
		textObservaciones.setToolTipText("Introduce tus observaciones adicionales");
		scrollObservaciones.setViewportView(textObservaciones);
	}
}