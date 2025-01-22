import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    Panel panel;
    public Frame(){
        setSize(1500,750);
        setTitle("Raycaster");

        panel = new Panel(1500,750);

        add(panel);

        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public static void main(String[] args){
        Frame f = new Frame();
    }

}
