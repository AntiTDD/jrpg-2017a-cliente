package frames;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Pantalla;
import mensajeria.PaquetePersonaje;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import java.util.ArrayList;

public class MenuInventario extends JFrame {
	private JLabel [] labelItems = new JLabel[20];
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public MenuInventario(PaquetePersonaje personaje) {
		
		setBackground(Color.LIGHT_GRAY);
		setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		setType(Type.UTILITY);
		setTitle("Inventario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		
		JLabel item1 = new JLabel();
		item1.setBounds(49,51,46,42);
		contentPane.add(item1);
		labelItems[0] = item1;
	
		JLabel item2 = new JLabel();
		item2.setBounds(119,51,46,42);
		contentPane.add(item2);
		labelItems[1] = item2;
		

		JLabel item3 = new JLabel();
		item3.setBounds(189,51,46,42);
		contentPane.add(item3);
		labelItems[2] = item3;
		
		JLabel item4 = new JLabel();
		item4.setBounds(259,51,46,42);
		contentPane.add(item4);
		labelItems[3] = item4;
		
		JLabel item5= new JLabel();
		item5.setBounds(329,51,46,42);
		contentPane.add(item5);
		labelItems[4] = item5;
		
		JLabel item6 = new JLabel();
		item6.setBounds(49,123,46,42);
		contentPane.add(item6);
		labelItems[5] = item6;
		
		JLabel item7 = new JLabel();
		item7.setBounds(119,123,46,42);
		contentPane.add(item7);
		labelItems[6] = item7;
		
		JLabel item8 = new JLabel();
		item8.setBounds(189,123,46,42);
		contentPane.add(item8);
		labelItems[7] = item8;
		
		JLabel item9 = new JLabel();
		item9.setBounds(259,123,46,42);
		contentPane.add(item9);
		labelItems[8] = item9;
		
		JLabel item10 = new JLabel();
		item10.setBounds(329,123,46,42);
		contentPane.add(item10);
		labelItems[9] = item10;
		
		JLabel item11 = new JLabel();
		item11.setBounds(49,195,46,42);
		contentPane.add(item11);
		labelItems[10] = item11;
		
		JLabel item12 = new JLabel();
		item12.setBounds(119,195,46,42);
		contentPane.add(item12);
		labelItems[11] = item12;
		
		JLabel item13 = new JLabel();
		item13.setBounds(189,195,46,42);
		contentPane.add(item13);
		labelItems[12] = item13;
		
		JLabel item14 = new JLabel();
		item14.setBounds(259,195,46,42);
		contentPane.add(item14);
		labelItems[13] = item14;
		
		JLabel item15 = new JLabel();
		item15.setBounds(329,195,46,42);
		contentPane.add(item15);
		labelItems[14] = item15;
		
		JLabel item16 = new JLabel();
		item16.setBounds(49,267,46,42);
		contentPane.add(item16);
		labelItems[15] = item16;
		
		JLabel item17 = new JLabel();
		item17.setBounds(119,267,46,42);
		contentPane.add(item17);
		labelItems[16] = item17;
		
		JLabel item18 = new JLabel();
		item18.setBounds(189,267,46,42);
		contentPane.add(item18);
		labelItems[17] = item18;
		
		JLabel item19 = new JLabel();
		item19.setBounds(259,267,46,42);
		contentPane.add(item19);
		labelItems[18] = item19;
		
		JLabel item20 = new JLabel();
		item20.setBounds(329,267,46,42);
		contentPane.add(item20);
		labelItems[19] = item20;
		
		JLabel lblItemEquipados = new JLabel("Items Equipados");
		lblItemEquipados.setFont(new Font("Book Antiqua", Font.BOLD, 22));
		lblItemEquipados.setForeground(Color.BLACK);
		lblItemEquipados.setBackground(Color.GRAY);
		lblItemEquipados.setBounds(119, 11, 179, 29);
		contentPane.add(lblItemEquipados);
		
	}
	
	public void cargarInventario(PaquetePersonaje personaje) {
		ArrayList<Integer> idItems = new ArrayList<Integer>();
		idItems = personaje.listarItems();
		for(int k=0; k < idItems.size(); k++) {
			int nroItem = idItems.get(k);
			labelItems[k].setIcon(new ImageIcon(MenuInventario.class.getResource("/frames/"+nroItem+".png")));
		}
	}

}
