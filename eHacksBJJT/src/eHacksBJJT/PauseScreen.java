package eHacksBJJT;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PauseScreen extends JPanel implements Common{
	
	private JButton restart;
	private JButton menu;

	
	public PauseScreen() {
		initComponents();
		setBackground(Color.white);
	}
	
	public void initComponents() {
		
		restart = new JButton("restart"); 
		menu = new JButton("menu");
		restart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restartMouseClicked(evt);
            }
        });
		menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
		

		setBounds(75,150,150,300);
		setBorder(BorderFactory.createLineBorder(Color.white));
		setForeground(Color.white);
		
		
		add(restart, BorderLayout.PAGE_START);
		restart.setBounds(0,0,75,50);

		add(menu, BorderLayout.PAGE_START);
		menu.setBounds(0,50,75,50);
		
	}
	
    private void restartMouseClicked(java.awt.event.MouseEvent evt) { 
    	//Screen.restart();
    	
        // TODO add your handling code here:
    }    
    private void menuMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	System.exit(1);
    }     
    
 
}
