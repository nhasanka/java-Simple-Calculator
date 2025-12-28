import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

class SimpleCalculator {
    public static void main(String[] args) {

        // create frame for calculator
        JFrame frame = new JFrame("Simple Calculator");

        // add input fields
        JTextField numberOneTextbox = new JTextField();
        JTextField numberTwoTextbox = new JTextField();

        // Styling input fields
        numberOneTextbox.setFont(new Font("Arial", Font.PLAIN, 18));
        numberTwoTextbox.setFont(new Font("Arial", Font.PLAIN, 18));

        // Set preferred size for input fields
        numberOneTextbox.setMaximumSize(new Dimension(200, 40));
        numberTwoTextbox.setMaximumSize(new Dimension(200, 40));

        // Center align input fields
        numberOneTextbox.setAlignmentX(Component.CENTER_ALIGNMENT);
        numberTwoTextbox.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Result label
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create add buttons
        JButton additionButton = new JButton("Addition (+)");
        additionButton.setFont(new Font("Arial", Font.BOLD, 13));
        additionButton.setBackground(new Color(66, 133, 244));
        additionButton.setForeground(Color.WHITE);
        additionButton.setFocusPainted(false);
        additionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Create subtraction button
        JButton subtractionButton = new JButton("Subtraction (−)");
        subtractionButton.setFont(new Font("Arial", Font.BOLD, 13));
        subtractionButton.setBackground(new Color(66, 133, 244));
        subtractionButton.setForeground(Color.WHITE);
        subtractionButton.setFocusPainted(false);
        subtractionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Create multiplication button
        JButton multiplicationButton = new JButton("Multiplication (×)");
        multiplicationButton.setFont(new Font("Arial", Font.BOLD, 13));
        multiplicationButton.setBackground(new Color(66, 133, 244));
        multiplicationButton.setForeground(Color.WHITE);
        multiplicationButton.setFocusPainted(false);
        multiplicationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Create division button
        JButton divisionButton = new JButton("Division (÷)");
        divisionButton.setFont(new Font("Arial", Font.BOLD, 13));
        divisionButton.setBackground(new Color(66, 133, 244));
        divisionButton.setForeground(Color.WHITE);
        divisionButton.setFocusPainted(false);
        divisionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Create clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 13));
        clearButton.setBackground(new Color(219, 68, 55)); // red for clear
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        inputPanel.add(numberOneTextbox);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(numberTwoTextbox);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(resultLabel);

        // Create button panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.add(additionButton);
        buttonPanel.add(subtractionButton);
        buttonPanel.add(multiplicationButton);
        buttonPanel.add(divisionButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(new JLabel(""));

        // Main panel to hold input and button panels
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(mainPanel);

        // Frame settings
        frame.setSize(350, 420);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // add button action listeners
        additionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    double num1 = Double.parseDouble(numberOneTextbox.getText());
                    double num2 = Double.parseDouble(numberTwoTextbox.getText());
                    double result = num1 + num2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });

        // subtraction button action listener
        subtractionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    double num1 = Double.parseDouble(numberOneTextbox.getText());
                    double num2 = Double.parseDouble(numberTwoTextbox.getText());
                    double result = num1 - num2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });

        // multiplication button action listener
        multiplicationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    double num1 = Double.parseDouble(numberOneTextbox.getText());
                    double num2 = Double.parseDouble(numberTwoTextbox.getText());
                    double result = num1 * num2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });

        // division button action listener
        divisionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    double num1 = Double.parseDouble(numberOneTextbox.getText());
                    double num2 = Double.parseDouble(numberTwoTextbox.getText());
                    if (num2 == 0) {
                        resultLabel.setText("Cannot divide by zero!");
                    } else {
                        double result = num1 / num2;
                        DecimalFormat df = new DecimalFormat("#.##");
                        resultLabel.setText("Result: " + df.format(result));
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });

        // clear button action listener
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                numberOneTextbox.setText("");
                numberTwoTextbox.setText("");
                resultLabel.setText("Result:");
            }
        });
    }
}
