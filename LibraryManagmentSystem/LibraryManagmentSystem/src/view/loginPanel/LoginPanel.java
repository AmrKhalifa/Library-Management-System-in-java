package view.loginPanel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class LoginPanel extends JPanel {

	
	JLabel userNameLabel;
	JTextField userNameField;
	JLabel passwordLabel;
	JPasswordField passwordField;
	JButton adminButton;
	JButton regularUserButton;
	SubmitButtonListener listener ;
	
	 final Font labelsFont = new Font("JF Flat", Font.PLAIN, 16);
	 final Font buttonsFont_3 =new Font("ara Jozoor", Font.PLAIN, 20);
	
	public LoginPanel() {
		setVisible(true);

		Border outerBorder = BorderFactory.createEmptyBorder(250, 200, 275, 275);
		Border middleBorder = BorderFactory.createTitledBorder("");
		Border innerBorder=BorderFactory.createTitledBorder("تسجيل الدخول");
		
		setBorder(new CompoundBorder(outerBorder, new CompoundBorder(middleBorder, innerBorder)));
		//Font font= new Font("Arial", Font.PLAIN,16);
		setFont(labelsFont);
		userNameLabel = new JLabel("اسم المستخدم");
		userNameLabel.setFont(labelsFont);
		userNameField = new JTextField(20);
		passwordLabel = new JLabel("رمز المرور");
		passwordLabel.setFont(labelsFont);
		passwordField = new JPasswordField(20);
		passwordField.setEchoChar('*');
		adminButton= new JButton("دخول كمستخدم مدير");
		adminButton.setFont(buttonsFont_3);
		regularUserButton = new JButton("دخول كمستخدم عادي");
		regularUserButton.setFont(buttonsFont_3);
		
		setLayout();
		
		adminButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				System.out.println(userNameField.getText()+ "\n"+ passwordField.getText());
				listener.fireAdminEntered(new UserEnteredEvent(userNameField.getText(),passwordField.getText().toString()));
				userNameField.setText("");
				passwordField.setText("");
			}
		});
		
		regularUserButton.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.fireRegularUserEnterd(new UserEnteredEvent(userNameField.getText(),passwordField.getText().toString()));
				userNameField.setText("");
				passwordField.setText("");
			}
			
		});
	}
	
	public void setLayout() {
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.NONE;
		gc.insets= new Insets(0,0,0,5);
		//////////////////////////////first row///////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = .01;

		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.anchor= GridBagConstraints.EAST;
		add(userNameField, gc);
		gc.gridx = 1;
		gc.anchor= GridBagConstraints.WEST;
		add(userNameLabel, gc);
		
		/////////////////////////////////////// nextRow/////////////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .01;

		gc.gridx = 0;
		gc.anchor= GridBagConstraints.EAST;
	
		add(passwordField, gc);
		gc.gridx = 1;
		gc.anchor= GridBagConstraints.WEST;
		add(passwordLabel, gc);
		
		/////////////////////////////////////// nextRow/////////////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .01;

		gc.gridx = 0;
		gc.anchor= GridBagConstraints.EAST;
		
		add(regularUserButton,gc);
		gc.gridx =1;
		gc.anchor= GridBagConstraints.WEST;
		add(adminButton, gc);
		
	}

	public void setListener(SubmitButtonListener listener) {
		this.listener = listener;
	}

	
}
