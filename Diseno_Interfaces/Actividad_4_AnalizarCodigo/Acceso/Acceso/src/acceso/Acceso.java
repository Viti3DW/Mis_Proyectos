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

		JLabel lblNewLabel = new JLabel("Acceso a la aplicación");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 20, 300, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(30, 70, 90, 15);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(130, 67, 200, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(30, 105, 90, 15);
		frame.getContentPane().add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(130, 102, 200, 21);
		frame.getContentPane().add(passwordField);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar usuario");
		chckbxNewCheckBox.setBounds(126, 130, 200, 23);
		frame.getContentPane().add(chckbxNewCheckBox);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(130, 170, 110, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
