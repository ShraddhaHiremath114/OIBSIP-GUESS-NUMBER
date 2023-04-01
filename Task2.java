package GuessTheNumber;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class Task2 {

	private JFrame frame;
	private JTextField UserNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task2 window = new Task2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	int Randomno=0;
	String str2="";
	int Attempt=0;
	public Task2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Shrads\\OasisInternship\\bg.png"));
		lblNewLabel.setBounds(33, 0, 300, 171);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterTheNumber = new JLabel("Enter The Number Between 1 to 100");
		lblEnterTheNumber.setFont(new Font("Verdana", Font.BOLD, 11));
		lblEnterTheNumber.setForeground(new Color(165, 42, 42));
		lblEnterTheNumber.setBounds(0, 182, 242, 14);
		frame.getContentPane().add(lblEnterTheNumber);
		
		JLabel Result = new JLabel("Guess");
		Result.setFont(new Font("Verdana", Font.BOLD, 11));
		Result.setForeground(new Color(165, 42, 42));
		Result.setBounds(158, 236, 242, 14);
		frame.getContentPane().add(Result);
		
		JLabel RandomNo = new JLabel("");
		RandomNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Randomno = (int)(Math.random()*100+1);
				str2=Integer.toString(Randomno);
				RandomNo.setText(str2);
			}
		});
		RandomNo.setBounds(378, 60, 46, 14);
		frame.getContentPane().add(RandomNo);
		
		UserNo = new JTextField();
		UserNo.setBounds(247, 182, 86, 20);
		frame.getContentPane().add(UserNo);
		UserNo.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=UserNo.getText();
				int un=Integer.parseInt(user);
				Attempt++;
				if (un <= 0 || un > 100 ){
					Result.setText("Invalid Guess");
					}

					else if (un == Randomno){
					Result.setText("Your "+Attempt +" Guess is correct !!!");
					}
					else if (un > Randomno){
					Result.setText("Your Guess is Too High !!!");
					}

					else if (un < Randomno){
					Result.setText("Your Guess is Too Low !!!");
					}
					else{
					Result.setText("Your Guess is incorrect !!!");

					}
				
			}
		});
		btnNewButton.setBounds(335, 181, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
