package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.ClientBll;
import BLL.DestinationBll;
import BLL.HolidayBll;
import ProductModel.DestinationQuerry;
import entities.Agent;
import entities.Client;
import entities.Cruise;
import entities.Holiday;
import entities.Stay;
import entities.Tour;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class AgentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table_1;
	private JTextField textField_9;
	private JTable table_2;
	JRadioButton rdbtnTour = new JRadioButton("Tour");
	JRadioButton rdbtnStay = new JRadioButton("Stay");
	JRadioButton rdbtnCruise = new JRadioButton("Cruise");
	private JTextField textField_10;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AgentGUI() {
		setTitle("Agent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 763);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCnp = new JLabel("cnp:");
		lblCnp.setBounds(10, 11, 60, 14);
		contentPane.add(lblCnp);
		
		JLabel lblName = new JLabel("name:");
		lblName.setBounds(10, 36, 60, 14);
		contentPane.add(lblName);
		
		JLabel lblAdress = new JLabel("adress:");
		lblAdress.setBounds(10, 64, 60, 14);
		contentPane.add(lblAdress);
		
		JLabel lblIdn = new JLabel("idn:");
		lblIdn.setBounds(10, 89, 60, 14);
		contentPane.add(lblIdn);
		
		textField = new JTextField();
		textField.setBounds(80, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 33, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 61, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 86, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnViewClients = new JButton("View Clients");
		btnViewClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClientBll.findAll(table);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewClients.setBounds(10, 117, 117, 23);
		contentPane.add(btnViewClients);
		
		JButton btnCreateClient = new JButton("Create Client");
		btnCreateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client c = new Client();
				c.setCnp(textField.getText());
				c.setName(textField_1.getText());
				c.setAdress(textField_2.getText());
				c.setIdn(textField_3.getText());
				ClientBll.createClient(c);
			}
		});
		btnCreateClient.setBounds(10, 151, 117, 23);
		contentPane.add(btnCreateClient);
		
		JButton btnUpdateClient = new JButton("Update Client");
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client c = new Client();
				c.setCnp(textField.getText());
				c.setName(textField_1.getText());
				c.setAdress(textField_2.getText());
				c.setIdn(textField_3.getText());
				ClientBll.updateClient(c);
			}
		});
		btnUpdateClient.setBounds(10, 185, 117, 23);
		contentPane.add(btnUpdateClient);
		
		JButton btnDeleteClient = new JButton("Delete Client");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client c = new Client();
				c.setCnp(textField.getText());
				ClientBll.deleteClient(c);
			}
		});
		btnDeleteClient.setBounds(10, 219, 117, 23);
		contentPane.add(btnDeleteClient);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("CNP");
		model.addColumn("Name");
		model.addColumn("IDN");
		model.addColumn("Adress");
		
		table = new JTable(model);
		table.setBounds(191, 22, 511, 153);
		contentPane.add(table);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setBounds(10, 253, 86, 14);
		contentPane.add(lblDestination);
		
		JLabel lblHotelName = new JLabel("Hotel name:");
		lblHotelName.setBounds(10, 278, 86, 14);
		contentPane.add(lblHotelName);
		
		JLabel lblPayment = new JLabel("Payment:");
		lblPayment.setBounds(10, 303, 86, 14);
		contentPane.add(lblPayment);
		
		JLabel lblNoPersons = new JLabel("No persons:");
		lblNoPersons.setBounds(10, 328, 72, 14);
		contentPane.add(lblNoPersons);
		
		JLabel lblDealine = new JLabel("Dealine:");
		lblDealine.setBounds(10, 353, 60, 14);
		contentPane.add(lblDealine);
		
		textField_4 = new JTextField();
		textField_4.setBounds(80, 250, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(80, 278, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(80, 303, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(80, 328, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(80, 353, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnViewHolidays = new JButton("View Holidays");
		btnViewHolidays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HolidayBll.viewHoliday(table_1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewHolidays.setBounds(172, 196, 131, 23);
		contentPane.add(btnViewHolidays);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DestinationBll.findD(textField_4.getText()) && ClientBll.clName(textField_9.getText())) {
				try {
					if(rdbtnTour.isSelected())
					{
						Tour c = new Tour(textField_4.getText(), Integer.parseInt(textField_6.getText()),
								Integer.parseInt(textField_7.getText()), textField_8.getText(), textField_9.getText());
						Holiday h = new Holiday(c);
						h.setHotel(textField_5.getText());
						System.out.println(c.getHotel());
						HolidayBll.reserveTour(c);
					}
					if(rdbtnStay.isSelected())
					{
						Stay c = new Stay(textField_4.getText(), Integer.parseInt(textField_6.getText()),
								Integer.parseInt(textField_7.getText()), textField_8.getText(), textField_9.getText());
						Holiday h = new Holiday(c);
						h.setHotel(textField_5.getText());
						System.out.println(c.getHotel());
						HolidayBll.reserveStay(c);
					}
					if(rdbtnCruise.isSelected())
					{
						Cruise c = new Cruise(textField_4.getText(), Integer.parseInt(textField_6.getText()),
								Integer.parseInt(textField_7.getText()), textField_8.getText(), textField_9.getText());
						Holiday h = new Holiday(c);
						h.setHotel(textField_5.getText());
						System.out.println(c.getHotel());
						HolidayBll.reserveCruise(c);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else JOptionPane.showMessageDialog(null, "Client sau destinatie invalida");
			}
		});
		btnReserve.setBounds(313, 196, 117, 23);
		contentPane.add(btnReserve);
		
		JButton btnNewButton = new JButton("Delete Holiday");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tour t = new Tour();
				Stay s = new Stay();
				Cruise c = new Cruise();
				c.setDestination(textField_4.getText());
				c.setClient(textField_9.getText());
				t.setDestination(textField_4.getText());
				t.setClient(textField_9.getText());
				s.setDestination(textField_4.getText());
				s.setClient(textField_9.getText());
				HolidayBll.deleteTour(t);
				HolidayBll.deleteStay(s);
				HolidayBll.deleteCruise(c);
			}
		});
		btnNewButton.setBounds(440, 196, 117, 23);
		contentPane.add(btnNewButton);
		
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Destination");
		model1.addColumn("Hotel");
		model1.addColumn("Deadline");
		model1.addColumn("Persons");
		model1.addColumn("Payment");
		model1.addColumn("Client");
		model1.addColumn("Type");
		
		table_1 = new JTable(model1);
		table_1.setBounds(211, 230, 393, 170);
		contentPane.add(table_1);
		
		JLabel lblClient = new JLabel("Client:");
		lblClient.setBounds(10, 381, 60, 14);
		contentPane.add(lblClient);
		
		textField_9 = new JTextField();
		textField_9.setBounds(80, 378, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnViewDestinations = new JButton("View Destinations");
		btnViewDestinations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DestinationBll.viewDest(table_2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewDestinations.setBounds(10, 515, 131, 23);
		contentPane.add(btnViewDestinations);
		
		JButton btnSearchDestination = new JButton("Search Destination");
		btnSearchDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestinationBll.findDestination(table_2, textField_4.getText());
			}
		});
		btnSearchDestination.setBounds(7, 549, 134, 23);
		contentPane.add(btnSearchDestination);
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.addColumn("Destination");
		model2.addColumn("price");
		
		table_2 = new JTable(model2);
		table_2.setBounds(224, 432, 274, 174);
		contentPane.add(table_2);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tour c = new Tour();
				c.setDestination(textField_4.getText());
				c.setPayment(Integer.parseInt(textField_6.getText()));
				c.setClient(textField_9.getText());		
				try {
					//HolidayBll.pay(c,DestinationBll.destPrice(textField_4.getText()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPay.setBounds(10, 583, 131, 23);
		contentPane.add(btnPay);
		
		
		rdbtnTour.setBounds(10, 428, 109, 23);
		contentPane.add(rdbtnTour);
		
		
		rdbtnStay.setBounds(10, 457, 109, 23);
		contentPane.add(rdbtnStay);
		
		rdbtnCruise.setBounds(10, 485, 109, 23);
		contentPane.add(rdbtnCruise);
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setBounds(10, 630, 60, 14);
		contentPane.add(lblComment);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(80, 627, 189, 86);
		contentPane.add(textField_10);
		
		JButton btnAddComment = new JButton("Add Comment");
		btnAddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestinationBll.addComment(textField_10.getText());
			}
		});
		btnAddComment.setBounds(286, 640, 131, 23);
		contentPane.add(btnAddComment);
	}
}
