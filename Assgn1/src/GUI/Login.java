package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.AgentBll;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static AdminGUI frame1 = new AdminGUI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setBounds(80, 87, 75, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(80, 124, 75, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(165, 84, 108, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 121, 108, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("admin")&& textField_1.getText().equals("mypass"))
				{
					try {
						frame1.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else
				{
					try {
						if(AgentBll.checkAgent(textField.getText(), textField_1.getText()))
						{
							try {
								AgentGUI frame = new AgentGUI();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						else JOptionPane.showMessageDialog(null, "Cont invalid!");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnLogin.setBounds(165, 167, 108, 23);
		contentPane.add(btnLogin);
	}
	public static void close()
	{
		frame1.dispatchEvent(new WindowEvent(frame1, WindowEvent.WINDOW_CLOSING));
	}
}
