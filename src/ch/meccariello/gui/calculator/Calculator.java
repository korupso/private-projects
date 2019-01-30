package ch.meccariello.gui.calculator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Calculator {

	private JFrame frame;
	private ArrayList<CalcButton> buttons;
	private String calculation = new String();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\meccariello\\Downloads\\calc.png"));
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 311, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNumbers = new JLabel("");
		lblNumbers.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumbers.setBounds(20, 21, 254, 28);
		frame.getContentPane().add(lblNumbers);
		lblNumbers.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNumbers.setForeground(Color.WHITE);
		lblNumbers.setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(Color.WHITE, 2));
		panel.setBounds(10, 10, 275, 50);
		frame.getContentPane().add(panel);

		String[] labels = new String[] { "%", "√", "^", "⅟x", "C", "_", "⌫", "÷", "7", "8", "9", "×", "4", "5", "6",
				"-", "1", "2", "3", "+", "±", "0", ".", "=" };
		buttons = new ArrayList<CalcButton>();
		for (int i = 0; i < 24; i++)
			buttons.add(new CalcButton(labels[i]));

		for (int i = 0; i < 24; i++) {
			CalcButton button = buttons.get(i);
			Color defaultColor = Character.isDigit(button.getText().toCharArray()[0]) ? Color.BLACK
					: new Color(15, 15, 15);
			button.setForeground(new Color(200, 200, 200));
			button.setBackground(defaultColor);
			button.setBounds(10 + (i % 4) * 70, 70 + (i / 4) * 45, 65, 40);
			button.setFocusPainted(false);
			button.setFont(new Font("Tahoma 11", Font.BOLD, 15));
			button.setBorder(new LineBorder(Color.GRAY, 1));

			button.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					String t = button.getText();
					if ("=".equals(t)) {
						try {
							lblNumbers.setText(calc(calculation));
							calculation = calc(calculation);
						} catch (ScriptException ex) {
							ex.printStackTrace();
						}
					} else if ("C".equals(t)) {
						calculation = new String();
						lblNumbers.setText("");
					} else {
						calculation = calculation + ("+-×÷".contains(t) ? " " + t + " " : t);
						lblNumbers.setText(calculation);
					}
				};
			});
			frame.getContentPane().add(buttons.get(i));
		}
	}

	public static String calc(String input) throws ScriptException {
		LinkedList<Object> calc = new LinkedList<Object>();
		String calculation = "";

		for (String s : input.split(" "))
			calc.add(Character.isDigit(s.charAt(0)) ? new BigDecimal(s) : s);
		for (int i = 0; i < calc.size(); i++) {
			if ("×".equals(calc.get(i)))
				calc.set(i, "*");
			if ("÷".equals(calc.get(i)))
				calc.set(i, "/");
			calculation += calc.get(i);
		}

		BigDecimal result = new BigDecimal(new ScriptEngineManager().getEngineByName("JavaScript").eval(calculation).toString());
		if (result.toString().contains(".0")) {
			return result.toBigInteger().toString();
		}
		return result.toString();
	}
}
