import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JFrame {

    private final JPanel panel;
    private final BufferedImage buffer;

    public Canvas() {
        setTitle("CirculoBasico");
        setSize(600, 600);
        panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(600, 600);
        setLocationRelativeTo(null);
        buffer = new BufferedImage(panel.getWidth(),panel.getHeight(),BufferedImage.TYPE_INT_ARGB);
        add(panel);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        circuloBasico(300, 300, 250, Color.red);
        getGraphics().drawImage(buffer,0,0,panel);
    }

    public void circuloBasico(int xc, int yc, int r, Color a){
        int x1 = xc - r;
        int x2 = xc + r;
        for(int x = x1; x <= x2; x++){
            double temp = Math.sqrt(Math.pow(r,2)-Math.pow((x-xc),2));
            double ya = yc + temp;
            double yb = yc - temp;
            buffer.setRGB(x, (int) ya, a.getRGB());
            buffer.setRGB(x, (int) yb, a.getRGB());
        }
        int y1 = yc-r;
        int y2 = yc+r;
        for(int y = y1; y <= y2; y++){
            double temp = Math.sqrt(Math.pow(r,2)-Math.pow((y-yc),2));
            double xa = xc + temp;
            double xb = xc - temp;
            buffer.setRGB((int) xa, y, a.getRGB());
            buffer.setRGB((int) xb, y, a.getRGB());
        }
    }
}
