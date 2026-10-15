package acceso;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Acceso {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso window = new Acceso();
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
	public Acceso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Acceso");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblAcceso= new JLabel("Acceso a la aplicación");
		lblAcceso.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAcceso.setBounds(30, 20, 300, 25);
		frame.getContentPane().add(lblAcceso);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(30, 70, 90, 15);
		frame.getContentPane().add(lblUsuario);

		textField = new JTextField();
		textField.setBounds(130, 67, 200, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setBounds(30, 105, 90, 15);
		frame.getContentPane().add(lblPass);

		passwordField = new JPasswordField();
		passwordField.setBounds(130, 102, 200, 21);
		frame.getContentPane().add(passwordField);

		JCheckBox cbRecordarUser = new JCheckBox("Recordar usuario");
		cbRecordarUser.setBounds(126, 130, 200, 23);
		frame.getContentPane().add(cbRecordarUser);

		JButton btnEntrar = new JButton("Acceder");
		btnEntrar.setBounds(130, 210, 130, 23);
		btnEntrar.setEnabled(false);
		frame.getContentPane().add(btnEntrar);
	}
}
