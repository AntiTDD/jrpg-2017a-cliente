package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mensajeria.PaquetePersonaje;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class MenuComercio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 JPanel contentPane;
	
	JPanel[]panelMio = new JPanel [10];
	JPanel[]panelEnemigo = new JPanel [10];
	JLabel[]misItems = new JLabel[10];
	JLabel[]itemsEnemigo = new JLabel[10];
	

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
		
		JLabel lblMisItems = new JLabel("Ofrezco");
		lblMisItems.setBounds(127, 6, 88, 20);
		lblMisItems.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		panel.add(lblMisItems);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setBounds(10, 37, 46, 42);
		panel.add(panel_2);
		panelMio[0] = panel_2;
		panel_2.setLayout(null);
		
		JLabel lblItem = new JLabel("");
		lblItem.setBounds(5, -3, 46, 42);
		panel_2.add(lblItem);
		misItems[0] = lblItem;
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(105, 105, 105));
		panel_3.setBounds(80, 37, 46, 42);
		panel.add(panel_3);
		panelMio[1] = panel_3;
		panel_3.setLayout(null);
		
		JLabel lblItem_1 = new JLabel("");
		lblItem_1.setBounds(5, -3, 46, 42);
		panel_3.add(lblItem_1);
		misItems[1] = lblItem_1;
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(105, 105, 105));
		panel_4.setBounds(147, 37, 46, 42);
		panel.add(panel_4);
		panelMio[2] = panel_4;
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, -3, 46, 42);
		panel_4.add(label);
		misItems[2] = label;
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(105, 105, 105));
		panel_5.setBounds(216, 37, 46, 42);
		panel.add(panel_5);
		panelMio[3] = panel_5;
		panel_5.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(5, 3, 46, 42);
		panel_5.add(label_1);
		misItems[3] = label_1;
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(105, 105, 105));
		panel_6.setBounds(283, 37, 46, 42);
		panel.add(panel_6);
		panelMio[4] = panel_6;
		panel_6.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(5, -3, 46, 42);
		panel_6.add(label_2);
		misItems[4] = label_2;
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(105, 105, 105));
		panel_7.setBounds(10, 109, 46, 42);
		panel.add(panel_7);
		panelMio[5] = panel_7;
		panel_7.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(5, -3, 46, 42);
		panel_7.add(label_3);
		misItems[5] = label_3;
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(105, 105, 105));
		panel_8.setBounds(80, 109, 46, 42);
		panel.add(panel_8);
		panelMio[6] = panel_8;
		panel_8.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(5, -3, 46, 42);
		panel_8.add(label_4);
		misItems[6] = label_4;
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(105, 105, 105));
		panel_9.setBounds(147, 109, 46, 42);
		panel.add(panel_9);
		panelMio[7] = panel_9;
		panel_9.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(5, -3, 46, 42);
		panel_9.add(label_5);
		misItems[7] = label_5;
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(105, 105, 105));
		panel_10.setBounds(216, 109, 46, 42);
		panel.add(panel_10);
		panelMio[8] = panel_10;
		panel_10.setLayout(null);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(5, -3, 46, 42);
		panel_10.add(label_6);
		misItems[8] = label_6;
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(105, 105, 105));
		panel_11.setBounds(283, 109, 46, 42);
		panel.add(panel_11);
		panelMio[9] = panel_11;
		panel_11.setLayout(null);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(5, -3, 46, 42);
		panel_11.add(label_7);
		misItems[9] = label_7;
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 169, 169));
		panel_1.setBounds(10, 180, 339, 174);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSusItems = new JLabel("Recibo");
		lblSusItems.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		lblSusItems.setBounds(138, 8, 75, 20);
		panel_1.add(lblSusItems);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(105, 105, 105));
		panel_12.setBounds(10, 39, 46, 42);
		panel_1.add(panel_12);
		panelEnemigo[0] = panel_12;
		panel_12.setLayout(null);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(5, -3, 46, 42);
		panel_12.add(label_8);
		itemsEnemigo[0] = label_8;
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(105, 105, 105));
		panel_13.setBounds(80, 39, 46, 42);
		panel_1.add(panel_13);
		panelEnemigo[1] = panel_13;
		panel_13.setLayout(null);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(5, -3, 46, 42);
		panel_13.add(label_9);
		itemsEnemigo[1] = label_9;
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(105, 105, 105));
		panel_14.setBounds(152, 39, 46, 42);
		panel_1.add(panel_14);
		panelEnemigo[2] = panel_14;
		panel_14.setLayout(null);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(5, -3, 46, 42);
		panel_14.add(label_10);
		itemsEnemigo[2] = label_10;
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(105, 105, 105));
		panel_15.setBounds(221, 39, 46, 42);
		panel_1.add(panel_15);
		panelEnemigo[3] = panel_15;
		panel_15.setLayout(null);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(5, -3, 46, 42);
		panel_15.add(label_11);
		itemsEnemigo[3] = label_11;
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(105, 105, 105));
		panel_16.setBounds(283, 39, 46, 42);
		panel_1.add(panel_16);
		panelEnemigo[4] = panel_16;
		panel_16.setLayout(null);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(5, -3, 46, 42);
		panel_16.add(label_12);
		itemsEnemigo[4] = label_12;
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(105, 105, 105));
		panel_17.setBounds(10, 105, 46, 42);
		panel_1.add(panel_17);
		panelEnemigo[5] = panel_17;
		panel_17.setLayout(null);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(5, -3, 46, 42);
		panel_17.add(label_13);
		itemsEnemigo[5] = label_13;
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(105, 105, 105));
		panel_18.setBounds(80, 105, 46, 42);
		panel_1.add(panel_18);
		panelEnemigo[6] = panel_18;
		panel_18.setLayout(null);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(5, -3, 46, 42);
		panel_18.add(label_14);
		itemsEnemigo[6] = label_14;
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(105, 105, 105));
		panel_19.setBounds(152, 105, 46, 42);
		panel_1.add(panel_19);
		panelEnemigo[7] = panel_19;
		panel_19.setLayout(null);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(5, -3, 46, 42);
		panel_19.add(label_15);
		itemsEnemigo[7] = label_15;
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(105, 105, 105));
		panel_20.setBounds(221, 105, 46, 42);
		panel_1.add(panel_20);
		panelEnemigo[8] = panel_20;
		panel_20.setLayout(null);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(5, -3, 46, 42);
		panel_20.add(label_16);
		itemsEnemigo[8] = label_16;
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(105, 105, 105));
		panel_21.setBounds(283, 105, 46, 42);
		panel_1.add(panel_21);
		panelEnemigo[9] = panel_21;
		panel_21.setLayout(null);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(5, -3, 46, 42);
		panel_21.add(label_17);
		itemsEnemigo[9] = label_17;
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(169, 169, 169));
		panel_22.setBounds(10, 359, 339, 70);
		contentPane.add(panel_22);
		panel_22.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Rechazó");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(238, 35, 91, 24);
		panel_22.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Acepto");
				//quitar los items que entregué
				//quitar los bonus de los items que entregue
				//agregar los nuevos
				//agregar los nuevos bonus
			}
		});
		btnAceptar.setBounds(238, 5, 91, 23);
		panel_22.add(btnAceptar);
		
		JLabel lblAtaque = new JLabel("ataque");
		lblAtaque.setBounds(21, 39, 52, 14);
		panel_22.add(lblAtaque);
		lblAtaque.setForeground(new Color(255, 0, 0));
		lblAtaque.hide();
		
		JLabel lblMagia = new JLabel("magia");
		lblMagia.setBounds(83, 39, 52, 14);
		panel_22.add(lblMagia);
		lblMagia.setForeground(new Color(0, 0, 255));
		lblMagia.hide();
		
		JLabel lblDefensa = new JLabel("defensa");
		lblDefensa.setBounds(83, 9, 52, 14);
		panel_22.add(lblDefensa);
		lblDefensa.setForeground(new Color(0, 0, 0));
		lblDefensa.setBackground(Color.WHITE);
		lblDefensa.hide();
		
		JLabel lblEnergia = new JLabel("energia");
		lblEnergia.setBounds(156, 9, 52, 14);
		panel_22.add(lblEnergia);
		lblEnergia.setForeground(new Color(255, 255, 0));
		lblEnergia.setBackground(Color.WHITE);
		lblEnergia.hide();
		
		JLabel lblSalud = new JLabel("salud");
		lblSalud.setBounds(21, 9, 52, 14);
		panel_22.add(lblSalud);
		lblSalud.setForeground(new Color(50, 205, 50));
		lblSalud.setBackground(Color.WHITE);
		lblSalud.hide();
	}
}

