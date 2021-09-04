/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.to.swing.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Koles
 */
public class MainWindow {
    private JFrame window = new JFrame("Game to swing component");
    private JPanel desck = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JLabel text = new JLabel("Enter some text: ");
    private JTextField textField = new JTextField(20);
    private JButton someButton = new JButton("Some Button");
    private JTextArea ta = new JTextArea(10,20);
    private JScrollPane scroll = new JScrollPane(ta);
    private JCheckBox check = new JCheckBox("Check");
    
    protected void create(){
        textField.setToolTipText("Some Text");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(BorderLayout.NORTH, desck);
        desck.setBackground(Color.blue);
        //desck.setLayout();
        desck.add(text);
        desck.add(textField);
        window.add(BorderLayout.SOUTH, someButton);
        textField.selectAll();
        textField.addActionListener(new MyComboListener());
        window.getContentPane().add(BorderLayout.CENTER, centerPanel);
        centerPanel.setBackground(Color.CYAN);
        ta.setLineWrap(true); //Включаем перенос текста
        scroll.setVerticalScrollBarPolicy
                                (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        scroll.setHorizontalScrollBarPolicy
                               (ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        centerPanel.add(scroll);
        check.addItemListener(new MyComboListener());
        centerPanel.add(check);
        
        someButton.addActionListener(new MyComboListener());
        
        System.out.print(textField.getText());
        
        window.setSize(600,600);
        window.setVisible(true);
    }
    
    
    private class MyComboListener implements ActionListener, ItemListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            textField.selectAll();
            System.out.println(textField.getText());
            ta.append(textField.getText() + " \n");
            textField.setText(" ");
        
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.print(e.getStateChange());
            System.out.println(check.isSelected());
            if(check.isSelected()){
                ta.append("Check is selected!");
                System.out.println("Check is selected!");
            }
            else{
                ta.append("Check is not selected!");
                System.out.println("Check is not selected!");
            }
        }
        
    }
}
