/*
 * Decompiled with CFR 0.152.
 */
package click_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Panel
extends JPanel
implements ActionListener {
    private static final long serialVersionUID = 0L;
    private int x = 0;
    private int y = 0;
    private Color color = Color.orange;

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(this.color);
        g.fillOval(this.x, this.y, 100, 100);
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.color = new Color((int)(Math.random() * 1.6777216E7));
        this.repaint();
    }
}

