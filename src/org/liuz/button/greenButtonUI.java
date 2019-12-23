package org.liuz.button;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class greenButtonUI extends BasicButtonUI {
    @Override
    protected void installDefaults(AbstractButton b){
        super.installDefaults(b);
        LookAndFeel.installProperty(b,"opaque",Boolean.FALSE);
    }
    @Override
    public void paint(Graphics g, JComponent c){
        g.setColor(new Color(98,197,84));
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, 18, 18);
        super.paint(g,c);
    }
    public void paintButtonPressed(Graphics g, AbstractButton b) {
        g.setColor(new Color(37,200,58));
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, 18, 18);
        g2d.setColor(new Color(3,100,3));
        g2d.drawLine(3,9,14,9);
        g2d.drawLine(8,4,8,15);
    }
}
