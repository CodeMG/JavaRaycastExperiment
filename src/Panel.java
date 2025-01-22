import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel{

    private BufferedImage image;
    public Panel(int width,int height){
        setSize(width,height);
        Raycaster caster = new Raycaster();
        long timeBefore = System.currentTimeMillis();
        image = caster.renderImage();
        long timeAfter = System.currentTimeMillis();
        System.out.println(timeAfter-timeBefore);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(),getHeight(),null);

    }

}
