import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class APCompSci {

	private JFrame frmApComputerScience;
	private JTextField DNAline;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APCompSci window = new APCompSci();
					window.frmApComputerScience.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public APCompSci() {
		initialize();
	}
	
	public String translate(String letter) {
		if(letter.equals("T") || letter.equals("t"))
			return "A";
		else if(letter.equals("A") || letter.equals("a"))
			return "U";
		else if(letter.equals("G") || letter.equals("g")) 
			return "C";
		else if(letter.equals("C") || letter.equals("c"))
			return "G";
		else if(letter.equals(" ")) 
			return "";
		else 
			return " error";
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApComputerScience = new JFrame();
		frmApComputerScience.setTitle("DNA to mRNA translator");
		frmApComputerScience.setBounds(100, 100, 450, 300);
		frmApComputerScience.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DNAline = new JTextField();
		DNAline.setBackground(new Color(204, 255, 255));
		frmApComputerScience.getContentPane().add(DNAline, BorderLayout.CENTER);
		DNAline.setColumns(10);
		
		JLabel lblEnterDnaLine = new JLabel("Enter DNA Line ");
		lblEnterDnaLine.setBackground(Color.WHITE);
		frmApComputerScience.getContentPane().add(lblEnterDnaLine, BorderLayout.NORTH);
		
		final JLabel result = new JLabel("Translated mRNA line: ");
		result.setBackground(Color.GREEN);
		frmApComputerScience.getContentPane().add(result, BorderLayout.SOUTH);
		
		JButton button = new JButton("Translate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String DNA = DNAline.getText();
				String result1 = "";
				for(int i = 0; i < DNA.length(); i++) {
					String trans = "" + DNA.charAt(i);
					result1 = result1 + translate(trans);
				}
				result.setText("Translated mRNA line: " + result1);
			}
		});
		frmApComputerScience.getContentPane().add(button, BorderLayout.EAST);
	}

}
