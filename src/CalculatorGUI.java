import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {

    private JTextField number1Field;
    private JTextField number2Field;
    private JTextField resultField;

    private CalculatorLogic calculator = new CalculatorLogic();

    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Number 1:"));
        number1Field = new JTextField();
        add(number1Field);

        add(new JLabel("Number 2:"));
        number2Field = new JTextField();
        add(number2Field);

        JButton addBtn = new JButton("Add");
        JButton subBtn = new JButton("Subtract");
        JButton mulBtn = new JButton("Multiply");
        JButton divBtn = new JButton("Divide");
        JButton clearBtn = new JButton("Clear");

        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        add(clearBtn);

        addBtn.addActionListener(e -> calculate("add"));
        subBtn.addActionListener(e -> calculate("sub"));
        mulBtn.addActionListener(e -> calculate("mul"));
        divBtn.addActionListener(e -> calculate("div"));
        clearBtn.addActionListener(e -> clearFields());

        setVisible(true);
    }

    private void calculate(String op) {
        try {
            double n1 = Double.parseDouble(number1Field.getText());
            double n2 = Double.parseDouble(number2Field.getText());
            double result = 0;

            switch (op) {
                case "add": result = calculator.add(n1, n2); break;
                case "sub": result = calculator.subtract(n1, n2); break;
                case "mul": result = calculator.multiply(n1, n2); break;
                case "div": result = calculator.divide(n1, n2); break;
            }

            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Math Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void clearFields() {
        number1Field.setText("");
        number2Field.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
