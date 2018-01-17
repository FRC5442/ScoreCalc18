package edu.utexas.se.swing.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testSwing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testSwing frame = new testSwing();
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
	public testSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelloWorld = new JLabel("Hello World!");
		lblHelloWorld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHelloWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloWorld.setBounds(117, 69, 159, 27);
		contentPane.add(lblHelloWorld);
		
		JButton btnTakeMeHome = new JButton("Take Me Home");
		btnTakeMeHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnTakeMeHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTakeMeHome.setBounds(117, 139, 159, 39);
		contentPane.add(btnTakeMeHome);
	}
}
