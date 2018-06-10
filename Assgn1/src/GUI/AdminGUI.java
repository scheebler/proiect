package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.AgentBll;
import BLL.DestinationBll;
import BLL.HolidayBll;
import BLL.HotelBll;
import entities.Agent;
import entities.Destination;
import entities.Hotel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.TableModel;

public class AdminGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminGUI() {
		setTitle("Admin\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 804);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setBounds(25, 26, 84, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(25, 63, 69, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(126, 23, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 60, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCreateAgent = new JButton("Create Agent");
		btnCreateAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Agent c = new Agent();
					c.setPassword(textField_1.getText());
					c.setUsername(textField.getText());
					AgentBll.createAgent(c);
					AgentBll.viewAgents(table);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnCreateAgent.setBounds(25, 106, 125, 23);
		contentPane.add(btnCreateAgent);
		
		JButton btnUpdateAgent = new JButton("Update Agent");
		btnUpdateAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agent c = new Agent();
				c.setPassword(textField_1.getText());
				c.setUsername(textField.getText());
				AgentBll.updateAgent(c);
				try {
					AgentBll.viewAgents(table);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdateAgent.setBounds(25, 149, 125, 23);
		contentPane.add(btnUpdateAgent);
		
		JButton btnDeleteAgent = new JButton("Delete Agent");
		btnDeleteAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agent c = new Agent();
				c.setUsername(textField.getText());
				AgentBll.deleteAgent(c);
			}
		});
		btnDeleteAgent.setBounds(25, 185, 125, 23);
		contentPane.add(btnDeleteAgent);
		
		JButton btnViewAgent = new JButton("View Agent");
		btnViewAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AgentBll.viewAgents(table);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewAgent.setBounds(25, 227, 125, 23);
		contentPane.add(btnViewAgent);
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.addColumn("destination");
		model2.addColumn("name");
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("username");
		model.addColumn("password");
		
		table = new JTable(model);
		table.setBounds(175, 91, 329, 190);
		contentPane.add(table);
		
		JButton btnViewPassed = new JButton("View destination");
		btnViewPassed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DestinationBll.viewDest(table_1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewPassed.setBounds(25, 300, 125, 23);
		contentPane.add(btnViewPassed);
		
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Destination");
		model1.addColumn("Price");
		
		table_1 = new JTable(model1);
		table_1.setBounds(175, 304, 329, 206);
		contentPane.add(table_1);
		
		JButton btnDeletePassed = new JButton("Delete Destination");
		btnDeletePassed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestinationBll.deleteDestination(textField_2.getText());
			}
		});
		btnDeletePassed.setBounds(20, 331, 130, 23);
		contentPane.add(btnDeletePassed);
		
		JLabel lblDestination = new JLabel("destination");
		lblDestination.setBounds(230, 26, 84, 14);
		contentPane.add(lblDestination);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(230, 60, 84, 14);
		contentPane.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(308, 23, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(308, 60, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lblHotelName = new JLabel("hotel name:");
		lblHotelName.setBounds(400, 26, 125, 14);
		contentPane.add(lblHotelName);
		
		JLabel lblHotelDestination = new JLabel("hotel destination");
		lblHotelDestination.setBounds(400, 63, 84, 14);
		contentPane.add(lblHotelDestination);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(501, 23, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(511, 60, 86, 20);
		contentPane.add(textField_5);
		
		JButton btnCreateDestination = new JButton("Create Destination");
		btnCreateDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Destination d = new Destination(textField_2.getText(), Integer.parseInt(textField_3.getText()));
				DestinationBll.createDestination(d);
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Invalid input!");
			}
		}
		});
		btnCreateDestination.setBounds(25, 365, 125, 23);
		contentPane.add(btnCreateDestination);
		
		JButton btnUpdateDestination = new JButton("Update destination");
		btnUpdateDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					Destination d = new Destination(textField_2.getText(), Integer.parseInt(textField_3.getText()));
					DestinationBll.createDestination(d);
				}catch(NumberFormatException ee)
				{
					JOptionPane.showMessageDialog(null, "Invalid input!");
				}
			}
		});
		btnUpdateDestination.setBounds(25, 399, 125, 23);
		contentPane.add(btnUpdateDestination);
		
		JButton btnCreateHotel = new JButton("Create hotel");
		btnCreateHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel h = new Hotel(textField_4.getText(), textField_5.getText());
				try {
					HotelBll.createHotel(h);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Invalid input!");
				}
			}
		});
		btnCreateHotel.setBounds(20, 538, 125, 23);
		contentPane.add(btnCreateHotel);
		
		JButton btnUpdateHotel = new JButton("Update hotel");
		btnUpdateHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Hotel h = new Hotel(textField_4.getText(), textField_5.getText());
				HotelBll.updateHotel(h);
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Invalid input!");				}
			}
		});
		btnUpdateHotel.setBounds(20, 572, 125, 23);
		contentPane.add(btnUpdateHotel);
		
		JButton btnDeleteHotel = new JButton("Delete hotel");
		btnDeleteHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel h = new Hotel(textField_4.getText(), textField_5.getText());
				HotelBll.deleteHotel(h);
			}
		});
		btnDeleteHotel.setBounds(20, 606, 125, 23);
		contentPane.add(btnDeleteHotel);
		
		JButton btnViewHotels = new JButton("View hotels");
		btnViewHotels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HotelBll.viewHotels(table_2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnViewHotels.setBounds(20, 642, 125, 23);
		contentPane.add(btnViewHotels);
		
		table_2 = new JTable(model2);
		table_2.setBounds(175, 532, 329, 206);
		contentPane.add(table_2);
	}
}