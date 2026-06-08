/*
 * Decompiled with CFR 0.152.
 */
package click_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class Button
extends JButton
implements MouseListener {
    private static final long serialVersionUID = 0L;
    private String text;
    private Color color = Color.white;

    public Button(String text) {
        super(text);
        this.text = text;
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(this.color);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        g.drawString(this.text, this.getWidth() / 2 - this.text.length(), this.getHeight() / 2);
    }

    private void resetColor() {
        this.color = Color.white;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        this.color = Color.lightGray;
    }

    @Override
    public void mouseExited(MouseEvent event) {
        this.resetColor();
    }

    @Override
    public void mousePressed(MouseEvent event) {
        this.color = Color.darkGray;
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        this.resetColor();
    }
}

