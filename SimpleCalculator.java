import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ScientificCalculator extends JFrame implements ActionListener, KeyListener {

    private JTextField display;
    private JTextArea historyArea;
    private JScrollPane historyPane;

    private final String[] numberButtonsLabels = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", ".", "="
    };

    private final String[] operatorButtonsLabels = {
            "+", "-", "*", "/", "C", "CE"
    };

    private final String[] scientificButtonsLabels = {
            "sin", "cos", "tan", "log", "√", "x²", "1/x", "π", "e"
    };

    private ArrayList<String> historyList = new ArrayList<>();

    private double firstOperand = 0;
    private char operator = ' ';
    private boolean isOperatorClicked = false;

    private DecimalFormat df = new DecimalFormat("#.######");

    public ScientificCalculator() {
        setTitle("Scientific Calculator with History");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        display = new JTextField();
        display.setBounds(20, 20, 440, 40);
        display.setFont(new Font("Arial", Font.BOLD, 18));
        display.setEditable(false);
        display.addKeyListener(this);
        add(display);

        // History TextArea
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        historyPane = new JScrollPane(historyArea);
        historyPane.setBounds(20, 450, 440, 100);
        add(historyPane);

        // Number Buttons
        int x = 20, y = 70;
        for (int i = 0; i < numberButtonsLabels.length; i++) {
            JButton btn = new JButton(numberButtonsLabels[i]);
            btn.setBounds(x, y, 60, 40);
            btn.addActionListener(this);
            add(btn);
            x += 70;
            if ((i + 1) % 3 == 0) {
                x = 20;
                y += 50;
            }
        }

        // Operator Buttons
        x = 230;
        y = 270;
        for (String op : operatorButtonsLabels) {
            JButton btn = new JButton(op);
            btn.setBounds(x, y, 60, 40);
            btn.addActionListener(this);
            add(btn);
            y += 50;
        }

        // Scientific Buttons
        x = 310;
        y = 70;
        for (String sci : scientificButtonsLabels) {
            JButton btn = new JButton(sci);
            btn.setBounds(x, y, 80, 40);
            btn.addActionListener(this);
            add(btn);
            y += 50;
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("0123456789.".contains(cmd)) {
            if (isOperatorClicked) {
                display.setText("");
                isOperatorClicked = false;
            }
            if (cmd.equals(".") && display.getText().contains(".")) {
                return; // prevent multiple decimals
            }
            display.setText(display.getText() + cmd);

        } else if ("+-*/".contains(cmd)) {
            if (!display.getText().isEmpty()) {
                firstOperand = Double.parseDouble(display.getText());
            }
            operator = cmd.charAt(0);
            isOperatorClicked = true;

        } else if (cmd.equals("=")) {
            if (operator == ' ' || display.getText().isEmpty()) return;

            double secondOperand = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case '+': result = firstOperand + secondOperand; break;
                case '-': result = firstOperand - secondOperand; break;
                case '*': result = firstOperand * secondOperand; break;
                case '/':
                    if (secondOperand == 0) {
                        display.setText("Error: Divide by 0");
                        operator = ' ';
                        return;
                    }
                    result = firstOperand / secondOperand;
                    break;
            }

            String expression = df.format(firstOperand) + " " + operator + " " + df.format(secondOperand) + " = " + df.format(result);
            updateHistory(expression);
            display.setText(df.format(result));
            operator = ' ';

        } else if (cmd.equals("C")) {
            display.setText("");
            operator = ' ';
            firstOperand = 0;

        } else if (cmd.equals("CE")) {
            display.setText("");

        } else {  // scientific functions
            if (display.getText().isEmpty()) return;
            double value = Double.parseDouble(display.getText());
            double result = 0;
            String expression = "";

            switch (cmd) {
                case "sin":
                    result = Math.sin(Math.toRadians(value));
                    expression = "sin(" + value + ") = " + df.format(result);
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(value));
                    expression = "cos(" + value + ") = " + df.format(result);
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(value));
                    expression = "tan(" + value + ") = " + df.format(result);
                    break;
                case "log":
                    if (value <= 0) {
                        display.setText("Error: log domain");
                        return;
                    }
                    result = Math.log10(value);
                    expression = "log(" + value + ") = " + df.format(result);
                    break;
                case "√":
                    if (value < 0) {
                        display.setText("Error: sqrt domain");
                        return;
                    }
                    result = Math.sqrt(value);
                    expression = "√(" + value + ") = " + df.format(result);
                    break;
                case "x²":
                    result = value * value;
                    expression = value + "² = " + df.format(result);
                    break;
                case "1/x":
                    if (value == 0) {
                        display.setText("Error: divide by zero");
                        return;
                    }
                    result = 1 / value;
                    expression = "1/" + value + " = " + df.format(result);
                    break;
                case "π":
                    result = Math.PI;
                    expression = "π = " + df.format(result);
                    break;
                case "e":
                    result = Math.E;
                    expression = "e = " + df.format(result);
                    break;
            }

            updateHistory(expression);
            display.setText(df.format(result));
            isOperatorClicked = true;
        }
    }

    private void updateHistory(String entry) {
        historyList.add(entry);
        if (historyList.size() > 10) { // keep only last 10 entries
            historyList.remove(0);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : historyList) {
            sb.append(s).append("\n");
        }
        historyArea.setText(sb.toString());
    }

    // Keyboard input handling
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        String allowed = "0123456789.+-*/=";
        if (allowed.indexOf(c) == -1 && c != KeyEvent.VK_BACK_SPACE) {
            e.consume(); // ignore invalid keys
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            // simulate equal button press
            actionPerformed(new ActionEvent(equalButtonSimulator, ActionEvent.ACTION_PERFORMED, "="));
        } else if (code == KeyEvent.VK_BACK_SPACE) {
            String text = display.getText();
            if (!text.isEmpty()) {
                display.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    // Dummy button to simulate '=' key press via keyboard
    private final JButton equalButtonSimulator = new JButton("=");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScientificCalculator::new);
    }
}
