package com.codebind;

import javax.swing.*;

public class register extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton clearButton;
    private JButton saveButton;
    private JButton editButton;
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel title1;
    private JPanel title2;
    private JPanel listArea;
    private JTextPane employeeRegistrationFormTextPane;
    private JLabel Name;
    private JLabel ID;
    private JLabel address;
    private JLabel telephone;
    private JLabel salary;
    private JCheckBox EPFETFCheckBox;
    private JList list1;

    register(){
        super("Employee Registration App");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

    }

    public static void main(String[] args) {
        register screen= new register();
        screen.setVisible(true);
    }
}
