package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mensajeria.PaquetePersonaje;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class MenuComercio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuComercio frame = new MenuComercio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MenuComercio(PaquetePersonaje paquetePersonaje) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(10, 11, 339, 162);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMisItems = new JLabel("Mis items");
		lblMisItems.setBounds(130, 6, 68, 20);
		lblMisItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblMisItems);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setBounds(10, 37, 46, 42);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(105, 105, 105));
		panel_3.setBounds(80, 37, 46, 42);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(105, 105, 105));
		panel_4.setBounds(147, 37, 46, 42);
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(105, 105, 105));
		panel_5.setBounds(216, 37, 46, 42);
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(105, 105, 105));
		panel_6.setBounds(283, 37, 46, 42);
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(105, 105, 105));
		panel_7.setBounds(10, 109, 46, 42);
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(105, 105, 105));
		panel_8.setBounds(80, 109, 46, 42);
		panel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(105, 105, 105));
		panel_9.setBounds(147, 109, 46, 42);
		panel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(105, 105, 105));
		panel_10.setBounds(216, 109, 46, 42);
		panel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(105, 105, 105));
		panel_11.setBounds(283, 109, 46, 42);
		panel.add(panel_11);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 169, 169));
		panel_1.setBounds(10, 180, 339, 174);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSusItems = new JLabel("Sus ITEMS");
		lblSusItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSusItems.setBounds(126, 11, 82, 20);
		panel_1.add(lblSusItems);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(105, 105, 105));
		panel_12.setBounds(10, 39, 46, 42);
		panel_1.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(105, 105, 105));
		panel_13.setBounds(80, 39, 46, 42);
		panel_1.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(105, 105, 105));
		panel_14.setBounds(152, 39, 46, 42);
		panel_1.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(105, 105, 105));
		panel_15.setBounds(221, 39, 46, 42);
		panel_1.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(105, 105, 105));
		panel_16.setBounds(283, 39, 46, 42);
		panel_1.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(105, 105, 105));
		panel_17.setBounds(10, 105, 46, 42);
		panel_1.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(105, 105, 105));
		panel_18.setBounds(80, 105, 46, 42);
		panel_1.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(105, 105, 105));
		panel_19.setBounds(152, 105, 46, 42);
		panel_1.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(105, 105, 105));
		panel_20.setBounds(221, 105, 46, 42);
		panel_1.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(105, 105, 105));
		panel_21.setBounds(283, 105, 46, 42);
		panel_1.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(169, 169, 169));
		panel_22.setBounds(10, 359, 339, 70);
		contentPane.add(panel_22);
		panel_22.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(258, 35, 75, 23);
		panel_22.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(258, 5, 71, 23);
		panel_22.add(btnAceptar);
		
		JLabel lblNewLabel = new JLabel("ataque");
		lblNewLabel.setBounds(21, 39, 52, 14);
		panel_22.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		
		JLabel lblMagia = new JLabel("magia");
		lblMagia.setBounds(83, 39, 52, 14);
		panel_22.add(lblMagia);
		lblMagia.setForeground(new Color(0, 0, 255));
		
		JLabel lblDefensa = new JLabel("defensa");
		lblDefensa.setBounds(83, 9, 52, 14);
		panel_22.add(lblDefensa);
		lblDefensa.setForeground(new Color(0, 0, 0));
		lblDefensa.setBackground(Color.WHITE);
		
		JLabel lblEnergia = new JLabel("energia");
		lblEnergia.setBounds(156, 9, 52, 14);
		panel_22.add(lblEnergia);
		lblEnergia.setForeground(new Color(255, 255, 0));
		lblEnergia.setBackground(Color.WHITE);
		
		JLabel lblSalud = new JLabel("salud");
		lblSalud.setBounds(21, 9, 52, 14);
		panel_22.add(lblSalud);
		lblSalud.setForeground(new Color(50, 205, 50));
		lblSalud.setBackground(Color.WHITE);
	}
}
