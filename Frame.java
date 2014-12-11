package blackhole;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Frame() {
		add(new Window());
		
		BufferedImage BufImage = null;
		try {
			BufImage = ImageIO.read(getClass().getResource("/blackhole/BlackHoleLogo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (BufImage != null) {
    	    ImageIcon ii = new ImageIcon(BufImage);
    	    Image image = ii.getImage();
    	    setIconImage(image);
    	}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(960, 640);
		setLocationRelativeTo(null);
		setTitle("Black Hole Simulator (Alpha)");
		setVisible(true);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Frame();
	}
	
}
