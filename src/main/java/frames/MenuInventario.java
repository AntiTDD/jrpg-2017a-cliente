package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuInventario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInventario frame = new MenuInventario();
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
	public MenuInventario() {
		setBackground(Color.LIGHT_GRAY);
		setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		setType(Type.UTILITY);
		setTitle("Inventario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelItem1 = new JPanel();
		panelItem1.setBounds(42, 51, 46, 42);
		contentPane.add(panelItem1);
		
		JPanel panelItem2 = new JPanel();
		panelItem2.setBounds(112, 51, 46, 42);
		contentPane.add(panelItem2);
		
		JPanel panelItem3 = new JPanel();
		panelItem3.setBounds(182, 51, 46, 42);
		contentPane.add(panelItem3);
		
		JPanel panelItem4 = new JPanel();
		panelItem4.setBounds(252, 51, 46, 42);
		contentPane.add(panelItem4);
		
		JPanel panelItem5 = new JPanel();
		panelItem5.setBounds(322, 51, 46, 42);
		contentPane.add(panelItem5);
		
		JPanel panelItem6 = new JPanel();
		panelItem6.setBounds(42, 123, 46, 42);
		contentPane.add(panelItem6);
		
		JPanel panelItem7 = new JPanel();
		panelItem7.setBounds(112, 123, 46, 42);
		contentPane.add(panelItem7);
		
		JPanel panelItem8 = new JPanel();
		panelItem8.setBounds(182, 123, 46, 42);
		contentPane.add(panelItem8);
		
		JPanel panelItem9 = new JPanel();
		panelItem9.setBounds(252, 123, 46, 42);
		contentPane.add(panelItem9);
		
		JPanel panelItem10 = new JPanel();
		panelItem10.setBounds(322, 123, 46, 42);
		contentPane.add(panelItem10);
		
		JPanel panelItem11 = new JPanel();
		panelItem11.setBounds(42, 195, 46, 42);
		contentPane.add(panelItem11);
		
		JPanel panelItem12 = new JPanel();
		panelItem12.setBounds(112, 195, 46, 42);
		contentPane.add(panelItem12);
		
		JPanel panelItem13 = new JPanel();
		panelItem13.setBounds(182, 195, 46, 42);
		contentPane.add(panelItem13);
		
		JPanel panelItem14 = new JPanel();
		panelItem14.setBounds(252, 195, 46, 42);
		contentPane.add(panelItem14);
		
		JPanel panelItem15 = new JPanel();
		panelItem15.setBounds(322, 195, 46, 42);
		contentPane.add(panelItem15);
		
		JPanel panelItem16 = new JPanel();
		panelItem16.setBounds(42, 267, 46, 42);
		contentPane.add(panelItem16);
		
		JPanel panelItem17 = new JPanel();
		panelItem17.setBounds(112, 267, 46, 42);
		contentPane.add(panelItem17);
		
		JPanel panelItem18 = new JPanel();
		panelItem18.setBounds(182, 267, 46, 42);
		contentPane.add(panelItem18);
		
		JPanel panelItem19 = new JPanel();
		panelItem19.setBounds(252, 267, 46, 42);
		contentPane.add(panelItem19);
		
		JPanel panelItem20 = new JPanel();
		panelItem20.setBounds(322, 267, 46, 42);
		contentPane.add(panelItem20);
		
		JLabel lblItemEquipados = new JLabel("Items Equipados");
		lblItemEquipados.setFont(new Font("Book Antiqua", Font.BOLD, 22));
		lblItemEquipados.setForeground(Color.BLACK);
		lblItemEquipados.setBackground(Color.GRAY);
		lblItemEquipados.setBounds(119, 11, 179, 29);
		contentPane.add(lblItemEquipados);
		
	}
}
