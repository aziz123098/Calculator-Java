import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorWithInputs extends JFrame {
    
    private JTextField input1Field, input2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, squareRootButton, cubeButton, clearButton;
    private double result;
    private String operator;

    public CalculatorWithInputs() {
       
        setTitle("Simple Calculator with Two Inputs");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        topPanel.add(new JLabel("Input 1:"));
        input1Field = new JTextField();
        input1Field.setFont(new Font("Arial", Font.PLAIN, 30));
        topPanel.add(input1Field);
        
        topPanel.add(new JLabel("Input 2:"));
        input2Field = new JTextField();
        input2Field.setFont(new Font("Arial", Font.PLAIN, 30));
        topPanel.add(input2Field);
        
        topPanel.add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setFont(new Font("Arial", Font.PLAIN, 30));
        resultField.setEditable(false);
        topPanel.add(resultField);
        
        add(topPanel, BorderLayout.NORTH);

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10)); 

    
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        squareRootButton = new JButton("Square Root");
        cubeButton = new JButton("Cube");
        clearButton = new JButton("Clear");

        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        subtractButton.setFont(new Font("Arial", Font.PLAIN, 20));
        multiplyButton.setFont(new Font("Arial", Font.PLAIN, 20));
        divideButton.setFont(new Font("Arial", Font.PLAIN, 20));
        squareRootButton.setFont(new Font("Arial", Font.PLAIN, 20));
        cubeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        clearButton.setFont(new Font("Arial", Font.PLAIN, 20));

        addButton.setFocusPainted(false);
        subtractButton.setFocusPainted(false);
        multiplyButton.setFocusPainted(false);
        divideButton.setFocusPainted(false);
        squareRootButton.setFocusPainted(false);
        cubeButton.setFocusPainted(false);
        clearButton.setFocusPainted(false);

        
        addButton.addActionListener(new OperatorButtonListener());
        subtractButton.addActionListener(new OperatorButtonListener());
        multiplyButton.addActionListener(new OperatorButtonListener());
        divideButton.addActionListener(new OperatorButtonListener());
        squareRootButton.addActionListener(new FunctionButtonListener());
        cubeButton.addActionListener(new FunctionButtonListener());
        clearButton.addActionListener(new ClearButtonListener());

      
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        
        panel.add(squareRootButton);
        panel.add(cubeButton);
        panel.add(clearButton);

        add(panel, BorderLayout.CENTER);
    }

    
    private class OperatorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double input1 = Double.parseDouble(input1Field.getText());
                double input2 = Double.parseDouble(input2Field.getText());
                operator = e.getActionCommand();

                switch (operator) {
                    case "Add":
                        result = input1 + input2;
                        break;
                    case "Subtract":
                        result = input1 - input2;
                        break;
                    case "Multiply":
                        result = input1 * input2;
                        break;
                    case "Divide":
                        if (input2 != 0) {
                            result = input1 / input2;
                        } else {
                            resultField.setText("Error (Div by 0)");
                            return;
                        }
                        break;
                }
                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid Input");
            }
        }
    }


    private class FunctionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double input1 = Double.parseDouble(input1Field.getText());

                if (e.getSource() == squareRootButton) {
                    result = Math.sqrt(input1);
                } else if (e.getSource() == cubeButton) {
                    result = Math.pow(input1, 3);
                }
                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid Input");
            }
        }
    }

    
    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            input1Field.setText("");
            input2Field.setText("");
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorWithInputs().setVisible(true);
            }
        });
    }
}