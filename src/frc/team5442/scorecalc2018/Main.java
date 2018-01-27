package frc.team5442.scorecalc2018;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameEventFile = new JLabel("Game Event File:");
		lblGameEventFile.setBounds(36, 35, 104, 16);
		contentPane.add(lblGameEventFile);
		
		JTextArea txtMatchEventsFilepath = new JTextArea();
		txtMatchEventsFilepath.setBounds(138, 32, 415, 22);
		contentPane.add(txtMatchEventsFilepath);
		
		JTextArea txtMatchEvents = new JTextArea();
		txtMatchEvents.setBounds(36, 72, 648, 257);
		contentPane.add(txtMatchEvents);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath = "C:\\Users\\tunruh\\Desktop\\match01.csv";
				try {
	                FileReader reader;
					reader = new FileReader( filePath );
	                BufferedReader br = new BufferedReader(reader);
	                txtMatchEventsFilepath.setText(filePath);
	                txtMatchEvents.read(br, null);
	                br.close();
	                txtMatchEventsFilepath.requestFocus();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBrowse.setBounds(568, 31, 97, 25);
		contentPane.add(btnBrowse);
		
		JButton btnRunMatch = new JButton("Run Match");
		btnRunMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRunMatch.setBounds(36, 338, 97, 25);
		contentPane.add(btnRunMatch);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(145, 342, 520, 16);
		contentPane.add(lblResults);
				
	}
}
