/*
 * Decompiled with CFR 0.152.
 */
package click_game;

import click_game.Game;
import click_game.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window
extends JFrame {
    private JPanel container = new JPanel();
    private JButton but1 = new JButton("Click!");
    private JButton but2 = new JButton("Autoclick");
    private JLabel title = new JLabel();
    private JLabel label = new JLabel();
    private JLabel acstate = new JLabel();
    private Player player;
    private boolean autoclick = false;
    private static final long serialVersionUID = 0L;

    public Window(String title, Player player) {
        this.player = player;
        this.setTitle(title);
        this.setSize(720, 480);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                Player p = Window.this.getPlayer();
                p.save();
                e.getWindow().dispose();
            }
        });
        this.setResizable(true);
        this.setUndecorated(false);
        BorderLayout lo = new BorderLayout();
        this.container.setLayout(lo);
        this.title.setText("Hello, " + this.player.getName() + " !");
        this.title.setFont(new Font("Calibri", 1, 20));
        this.title.setForeground(Color.red);
        this.title.setHorizontalAlignment(0);
        this.label.setText("You've clicked " + this.player.getCt() + " times");
        this.label.setFont(new Font("Calibri", 1, 16));
        this.label.setForeground(Color.black);
        this.label.setHorizontalAlignment(0);
        this.acstate.setText("Autoclick: off");
        this.acstate.setFont(new Font("Calibri", 1, 12));
        this.acstate.setForeground(Color.black);
        this.acstate.setHorizontalAlignment(4);
        this.container.setBackground(Color.white);
        this.container.add((Component)this.title, "North");
        this.container.add((Component)this.label, "Center");
        JPanel bottom = new JPanel();
        bottom.add(this.but1);
        bottom.add(this.but2);
        bottom.add(this.acstate);
        this.container.add((Component)bottom, "South");
        this.but1.addActionListener(new ClickListener());
        this.but2.addActionListener(new ACButtonListener());
        this.setContentPane(this.container);
        this.setVisible(true);
    }

    public void switchPlayer(Player p) {
        this.player.save();
        this.player = p;
        this.title.setText("Hello, " + this.player.getName() + " !");
        this.updateLabel();
    }

    public synchronized void performAutoclick(int delay) {
        while (this.autoclick) {
            this.player.click();
            this.updateLabel();
            try {
                Thread.sleep(delay);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateLabel() {
        this.label.setText("You've clicked " + this.player.getCt() + " times");
    }

    private void updateACLabel() {
        this.acstate.setText("Autoclick: " + (this.autoclick ? "on" : "off"));
    }

    public Player getPlayer() {
        return this.player;
    }

    class ACButtonListener
    implements ActionListener {
        ACButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Window.this.autoclick = !Window.this.autoclick;
            Window.this.updateACLabel();
            if (Window.this.autoclick) {
                Thread t = new Thread(new AutoClick());
                t.start();
            }
        }
    }

    class AutoClick
    implements Runnable {
        AutoClick() {
        }

        @Override
        public void run() {
            Window.this.performAutoclick(Game.getDelay());
        }
    }

    class ClickListener
    implements ActionListener {
        ClickListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Window.this.player.click();
            Window.this.updateLabel();
        }
    }
}

