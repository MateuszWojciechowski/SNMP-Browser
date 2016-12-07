package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.SNMPConnectionConfiguration;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainBrowserWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/** SNMP NEEDED FIELDS FROM STARTUPWINDOW */
	private SNMPConnectionConfiguration conf;
	
	/** BROWSER OUTPUT TEXTFIELD */
	private JTextField OIDTextField;
	
	/**
	 * BROWSER INPUT - Table with Get/Get Next results - columns : 
	 * Name/OID, Value, Type, IP:Port
	 */
	private JTable browserTable;
	private DefaultTableModel tableModel;

	/** MONITORING OUTPUT TEXTFIELD */
	private JTextField OIDMonitoringTextField;

	/** MONITORING INPUT TEXTFIELD */
	private JTextField OIDResultMonitoringTextField;
	private JTextPane valueResultMonitoringTextPane;
	private JTextField typeResultMonitoringTextField;
	private JTextField IPPortResultMonitoringTextField;
	
	/** CONFIGURATION TEXTFIELDS */
	private JTextField machineIPTextField;
	private JTextField snmpPortTextField;
	private JTextField readCommunityTextField;
	private JTextField writeCommunityTextField;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainBrowserWindow frame = new MainBrowserWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainBrowserWindow(SNMPConnectionConfiguration conf) {
		this();
		this.conf = conf;
		machineIPTextField.setText(conf.getMachineAddress());
		snmpPortTextField.setText(String.valueOf(conf.getSnmpPort()));
		readCommunityTextField.setText(conf.getReadCommunity());
		writeCommunityTextField.setText(conf.getWriteCommunity());
	}
	/**
	 * Create the frame.
	 */
	public MainBrowserWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 435);

		
		/** PANELS */
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TitledBorder browserBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE),
				"BROWSER");
		browserBorder.setTitleColor(Color.ORANGE);
		browserBorder.setTitleJustification(TitledBorder.CENTER);

		JPanel browserPanel = new JPanel();
		browserPanel.setBackground(Color.DARK_GRAY);
		browserPanel.setBounds(10, 11, 553, 374);
		browserPanel.setBorder(browserBorder);
		contentPane.add(browserPanel);
		browserPanel.setLayout(null);

		TitledBorder monitoringBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE),
				"MONITORING");
		monitoringBorder.setTitleColor(Color.ORANGE);
		monitoringBorder.setTitleJustification(TitledBorder.CENTER);

		JPanel monitoringPanel = new JPanel();
		monitoringPanel.setBackground(Color.DARK_GRAY);
		monitoringPanel.setBounds(573, 11, 373, 315);
		monitoringPanel.setBorder(monitoringBorder);
		contentPane.add(monitoringPanel);
		monitoringPanel.setLayout(null);

		
		/** BUTTONS */
		JButton btnGetNext = new JButton("Get Next");
		btnGetNext.setBackground(Color.GRAY);
		btnGetNext.setBounds(303, 37, 89, 23);
		browserPanel.add(btnGetNext);

		JButton btnGet = new JButton("Get");
		btnGet.setBackground(Color.GRAY);
		btnGet.setBounds(412, 37, 89, 23);
		browserPanel.add(btnGet);

		JButton btnStartMonitoring = new JButton("Start");
		btnStartMonitoring.setBackground(Color.GRAY);
		btnStartMonitoring.setBounds(272, 38, 89, 23);
		monitoringPanel.add(btnStartMonitoring);

		JButton btnStopMonitoring = new JButton("Stop");
		btnStopMonitoring.setBackground(Color.GRAY);
		btnStopMonitoring.setBounds(272, 72, 89, 23);
		monitoringPanel.add(btnStopMonitoring);

		
		/** LABELS */
		JLabel lblOID = new JLabel("OID:");
		lblOID.setForeground(Color.ORANGE);
		lblOID.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOID.setBounds(10, 38, 31, 20);
		browserPanel.add(lblOID);

		JLabel lblOIDMonitoring = new JLabel("OID:");
		lblOIDMonitoring.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOIDMonitoring.setForeground(Color.ORANGE);
		lblOIDMonitoring.setBounds(10, 39, 31, 20);
		monitoringPanel.add(lblOIDMonitoring);

		JLabel lblNameOIDResult = new JLabel("Name/OID:");
		lblNameOIDResult.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNameOIDResult.setForeground(Color.ORANGE);
		lblNameOIDResult.setBounds(10, 106, 73, 20);
		monitoringPanel.add(lblNameOIDResult);

		JLabel lblValueResult = new JLabel("Value:");
		lblValueResult.setHorizontalAlignment(SwingConstants.TRAILING);
		lblValueResult.setForeground(Color.ORANGE);
		lblValueResult.setBounds(10, 137, 73, 20);
		monitoringPanel.add(lblValueResult);

		JLabel lblTypeResult = new JLabel("Type:");
		lblTypeResult.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTypeResult.setForeground(Color.ORANGE);
		lblTypeResult.setBounds(10, 241, 73, 20);
		monitoringPanel.add(lblTypeResult);

		JLabel lblPortResult = new JLabel("IP:Port:");
		lblPortResult.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPortResult.setForeground(Color.ORANGE);
		lblPortResult.setBounds(10, 272, 73, 20);
		monitoringPanel.add(lblPortResult);
		
		JLabel lvlConf1 = new JLabel("machine IP:");
		lvlConf1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lvlConf1.setHorizontalAlignment(SwingConstants.TRAILING);
		lvlConf1.setForeground(Color.ORANGE);
		lvlConf1.setBounds(573, 334, 62, 20);
		contentPane.add(lvlConf1);
		
		JLabel lblConf2 = new JLabel("SNMP Port:");
		lblConf2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblConf2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConf2.setForeground(Color.ORANGE);
		lblConf2.setBounds(573, 365, 62, 20);
		contentPane.add(lblConf2);
		
		JLabel lblConf3 = new JLabel("R Community:");
		lblConf3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblConf3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConf3.setForeground(Color.ORANGE);
		lblConf3.setBounds(764, 334, 73, 20);
		contentPane.add(lblConf3);
		
		JLabel lblConf4 = new JLabel("W Community:");
		lblConf4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblConf4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConf4.setForeground(Color.ORANGE);
		lblConf4.setBounds(764, 365, 73, 20);
		contentPane.add(lblConf4);

		
		/** BROWSER OUTPUT TEXTFIELD */
		OIDTextField = new JTextField();
		OIDTextField.setBackground(Color.LIGHT_GRAY);
		OIDTextField.setBounds(51, 38, 225, 20);
		browserPanel.add(OIDTextField);
		OIDTextField.setColumns(10);

		
		/** BROWSER TABLE */
		browserTable = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Name/OID", "Value", "Type", "IP:Port" });
		browserTable.setModel(tableModel);
		JScrollPane browserScrollPane = new JScrollPane(browserTable);
		browserScrollPane.setBounds(10, 72, 533, 291);
		browserPanel.add(browserScrollPane);

		
		/** MONITORING OUTPUT TEXTFIELD */
		OIDMonitoringTextField = new JTextField();
		OIDMonitoringTextField.setColumns(10);
		OIDMonitoringTextField.setBackground(Color.LIGHT_GRAY);
		OIDMonitoringTextField.setBounds(51, 39, 211, 20);
		monitoringPanel.add(OIDMonitoringTextField);

		
		/** MONITORING INPUT TEXTFIELD */
		OIDResultMonitoringTextField = new JTextField();
		OIDResultMonitoringTextField.setEditable(false);
		OIDResultMonitoringTextField.setColumns(10);
		OIDResultMonitoringTextField.setBackground(Color.LIGHT_GRAY);
		OIDResultMonitoringTextField.setBounds(93, 106, 270, 20);
		monitoringPanel.add(OIDResultMonitoringTextField);

		typeResultMonitoringTextField = new JTextField();
		typeResultMonitoringTextField.setEditable(false);
		typeResultMonitoringTextField.setColumns(10);
		typeResultMonitoringTextField.setBackground(Color.LIGHT_GRAY);
		typeResultMonitoringTextField.setBounds(93, 241, 270, 20);
		monitoringPanel.add(typeResultMonitoringTextField);

		IPPortResultMonitoringTextField = new JTextField();
		IPPortResultMonitoringTextField.setEditable(false);
		IPPortResultMonitoringTextField.setColumns(10);
		IPPortResultMonitoringTextField.setBackground(Color.LIGHT_GRAY);
		IPPortResultMonitoringTextField.setBounds(93, 272, 270, 20);
		monitoringPanel.add(IPPortResultMonitoringTextField);

		valueResultMonitoringTextPane = new JTextPane();
		valueResultMonitoringTextPane.setEditable(false);
		valueResultMonitoringTextPane.setBounds(93, 137, 270, 93);
		monitoringPanel.add(valueResultMonitoringTextPane);
		

		/** CONFIGURATION TEXTFIELDS */
		machineIPTextField = new JTextField();
		machineIPTextField.setForeground(Color.ORANGE);
		machineIPTextField.setEditable(false);
		machineIPTextField.setEnabled(false);
		machineIPTextField.setColumns(10);
		machineIPTextField.setBackground(Color.DARK_GRAY);
		machineIPTextField.setBounds(642, 337, 111, 20);
		contentPane.add(machineIPTextField);
		
		snmpPortTextField = new JTextField();
		snmpPortTextField.setForeground(Color.ORANGE);
		snmpPortTextField.setEditable(false);
		snmpPortTextField.setEnabled(false);
		snmpPortTextField.setColumns(10);
		snmpPortTextField.setBackground(Color.DARK_GRAY);
		snmpPortTextField.setBounds(642, 365, 111, 20);
		contentPane.add(snmpPortTextField);
		
		readCommunityTextField = new JTextField();
		readCommunityTextField.setForeground(Color.ORANGE);
		readCommunityTextField.setEditable(false);
		readCommunityTextField.setEnabled(false);
		readCommunityTextField.setColumns(10);
		readCommunityTextField.setBackground(Color.DARK_GRAY);
		readCommunityTextField.setBounds(850, 334, 96, 20);
		contentPane.add(readCommunityTextField);
		
		writeCommunityTextField = new JTextField();
		writeCommunityTextField.setForeground(Color.ORANGE);
		writeCommunityTextField.setEditable(false);
		writeCommunityTextField.setEnabled(false);
		writeCommunityTextField.setColumns(10);
		writeCommunityTextField.setBackground(Color.DARK_GRAY);
		writeCommunityTextField.setBounds(850, 365, 96, 20);
		contentPane.add(writeCommunityTextField);
		
		/** LISTENERS */
		btnGetNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getNext();
			}
		});

		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get();
			}
		});
		
		btnStartMonitoring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monitoringStart();
			}
		});

		btnStopMonitoring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monitoringStop();
			}
		});
	}
	
	private void addRowToBrowserTable(String name, String value, String type, String IpPort)
	{
		tableModel.addRow(new Object[]{name, value, type, IpPort});
	}

	private void get() {
		// TODO Auto-generated method stub
		addRowToBrowserTable("TEST1", "TEST2", "TEST3", "TEST4");
		// Tutaj napewno do wykrozystania zmienna conf w ktorej sa parametry polaczenia SNMP
	}

	private void getNext() {
		// TODO Auto-generated method stub
		
	}
	
	private void monitoringStart() {
		// TODO Auto-generated method stub
		
	}
	
	private void monitoringStop() {
		// TODO Auto-generated method stub
		
	}
}
