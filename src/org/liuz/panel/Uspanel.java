package org.liuz.panel;

import javax.swing.*;
import java.awt.*;

public class Uspanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g ;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(240,220,220));
        g2d.fillRoundRect(0,-5,getWidth(),getHeight(),10,10);

    }

}
