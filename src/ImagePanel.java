import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	 
	private static final long serialVersionUID = 1L;
	private Image img;
 
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}
 
	public ImagePanel(Image img) {
		this.img = img;
	}
 
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}
