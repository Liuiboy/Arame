package org.liuz;


import org.liuz.button.RedButtonUI;
import org.liuz.button.YellowButtonUI;
import org.liuz.button.greenButtonUI;
import org.liuz.panel.TitlePanel;
import org.liuz.panel.Uspanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Arame extends JFrame {
    private boolean monitor = true;
    private int mx, my, jfx, jfy;
    private int agox = 0, agoy = 0, agow = 0, agoh = 0;
    /**
     * 窗体标题块panel
     *
     */
    private TitlePanel headline;
    /**
     * 窗体主体panel
     */
    private JPanel Usp;

    {
        headline = new TitlePanel();
        Usp = new Uspanel();

        this.setLayout(null);
        this.setSize(400, 300);
        //初始化标题块大小
        headline.setBounds(0, 0, this.getWidth(), 30);
        aFrameInit();
        Usp.setBounds(0, 30, this.getWidth(), getHeight() - 25);
        this.add(headline);
        add(Usp);

        setBackground(new Color(0, 0, 0, 0));
    }
    public Arame() {
        ////this.setUndecorated(true);
    }
    /**
     * 初始化窗体标题块panel
     */
    private void aFrameInit(){
        headline.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (monitor) {
                    setLocation(jfx + (e.getXOnScreen() - mx), jfy + (e.getYOnScreen() - my));
                }
            }
        });
        headline.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (monitor) {
                    mx = e.getXOnScreen();
                    my = e.getYOnScreen();
                    jfx = getX();
                    jfy = getY();
                }

            }
        });
        JButton button = new JButton();
        button.setUI(new RedButtonUI());
        button.setBorderPainted(false);
        button.setBounds(10, 7, 18, 18);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        headline.add(button);
        JButton button1 = new JButton();
        button1.setUI(new YellowButtonUI());
        button1.setBorderPainted(false);
        button1.setBounds(37, 7, 18, 18);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(ICONIFIED);
            }
        });
        headline.add(button1);
        JButton button2 = new JButton();
        button2.setUI(new greenButtonUI());
        button2.setBorderPainted(false);
        button2.setBounds(64, 7, 18, 18);
        headline.add(button2);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Toolkit.getDefaultToolkit().getScreenSize().width != getWidth() && Toolkit.getDefaultToolkit().getScreenSize().height != getWidth()) {
                    agox = getX();
                    agoy = getY();
                    agoh = getHeight();
                    agow = getWidth();
                    setSize(Toolkit.getDefaultToolkit().getScreenSize().width,  Toolkit.getDefaultToolkit().getScreenSize().height);
                    setLocation(0, 0);
                    monitor = false;

                } else {
                    setSize(agow, agoh);
                    setLocation(agox, agoy);
                    monitor = true;
                }


            }
        });
    }
    @Override
    public void setBackground(Color bgColor) {

        synchronized (getTreeLock()) {
            this.setUndecorated(true);
            super.setBackground(bgColor);
        }
    }

    public void setSize(int width, int height) {

        super.setSize(width, height);
        headline.setBounds(0, 0, this.getWidth(), 30);
        Usp.setBounds(0, 30, this.getWidth(), getHeight() - 25);
    }

    public Component join(Component component) {
        return Usp.add(component);
    }

    public Component join(String mane, Component component) {
        return Usp.add(mane, component);
    }

    @Override
    public void setTitle(String title) {
        headline.setTitle(title);
    }
}
