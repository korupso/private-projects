package ch.meccariello.gui.calculator;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

class CalcButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;

    public CalcButton() {
        this(null);
    }

    public CalcButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(new Color(50, 50, 50));
        } else if (getModel().isRollover()) {
            g.setColor(new Color(25, 25, 25));
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}
