package blackhole;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener{
	
	Object[] obj;
	Object BH;
	
	private boolean typing = false;
	private String sConstant = "";
	private int constant = 0;
	private int errormessage;
	
	public Window() {
		setBackground(new Color(24, 24, 24));
		setFocusable(true);
		setDoubleBuffered(true);
		
		obj = new Object[1];
		BH = new Object(1000000000, 400, 400);
		
		//typing = true;
		start();
		
		KAdapter adapt = new KAdapter();
		addKeyListener(adapt);
		
		Timer timer = new Timer(20, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D G = (Graphics2D) g;
		
		if (typing) {
			G.setColor(Color.white);
			G.drawString("What would you like the Universal Gravitational Constant to be for this simulation (type \"regular\" for the normal constant)? " + sConstant + "|", 120, 250);
			if (errormessage == 1) {
				G.setColor(Color.red);
				G.drawString("Please enter a regular integer, or 'regular'.", 350, 270);
			}
		} else {
			for (int i = 0; i < 1; i++) {
				Star s = (Star) obj[i];
				G.setColor(s.color);
				G.drawLine((int) s.x, (int) s.y, (int) s.x, (int) s.y);
			}
			
			G.setColor(Color.black);
			G.drawLine(400, 400, 400, 400);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < 1; i++) {
			Star s = (Star) obj[i];
			s.update(BH);
		}
		
		repaint();
	}
	
	private void setConstant(String s) {
		if (sConstant.equals("regular")) {
			
		} else {
			int temp = 0;
			for (int i = 0; i < s.length(); i++){
			    char c = s.charAt(i);
			    
			    temp *= 10;
			    
			    if (c == '1') {
			    	temp += 1;
			    } else if (c == '2') {
			    	temp += 2;
			    } else if (c == '3') {
			    	temp += 3;
			    } else if (c == '4') {
			    	temp += 4;
			    } else if (c == '5') {
			    	temp += 5;
			    } else if (c == '6') {
			    	temp += 6;
			    } else if (c == '7') {
			    	temp += 7;
			    } else if (c == '8') {
			    	temp += 8;
			    } else if (c == '9') {
			    	temp += 9;
			    } else if (c == '0') {
			    	temp += 0;
			    } else {
			    	errormessage = 1;
			    }
			    constant = temp;
			}
		}
		if (errormessage == 0) {
			typing = false;
			start();
		}
	}
	
	private void start() {
		for (int i = 0; i < 1; i++) {
			obj[i] = new Star();
		}
	}
	
	private class KAdapter extends KeyAdapter {
		
		public void keyTyped(KeyEvent e) {
			if (typing) {
				char c = e.getKeyChar();
				if (c == '') {
					if (sConstant.length() > 0){
						sConstant = sConstant.substring(0, sConstant.length() - 1);
					}
				} else if (c == '\n') {
					setConstant(sConstant);
				} else {
					sConstant += c;
				}
			}
		}
	
	}

}
