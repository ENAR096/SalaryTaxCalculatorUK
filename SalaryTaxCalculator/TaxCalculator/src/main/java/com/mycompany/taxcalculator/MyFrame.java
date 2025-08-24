/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taxcalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author naren
 */

//MyFrame child class of JFrame
public class MyFrame extends JFrame implements ActionListener{
   
    
     JComboBox taxCodeList;
     JTextField salaryField, hourlyField, avgHField;
     JLabel salaryFieldLabel,taxCodeLabel, hourlyLabel, avgHperWeekLabel;
     JPanel hourlyPanelLabel;
     JRadioButton yesButton,noButton;
     JButton clearButton, calculateButton;
     ResultWindow resultPage;
     int option = 0;
     CalculateTax calculate ;
     
    
    //define constructor, when we create the instance of myFrame    
    public MyFrame(){
        
        
        salaryFieldLabel = new JLabel();
        salaryField = new JTextField("0.0");        
        hourlyField = new JTextField("0.0");
        hourlyField.setEditable(false);
        
        yesButton = new JRadioButton("yes");
        yesButton.addActionListener(this);
        noButton = new JRadioButton("no");
        noButton.addActionListener(this);
       
        ButtonGroup group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);
        noButton.setSelected(true);
        
        clearButton = new JButton("clear all");
        clearButton.addActionListener(this);
        calculateButton = new JButton("calculate");
        calculateButton.addActionListener(this);
        
        
        hourlyLabel = new JLabel("Do you want to calculate your hourly wage instead?");
        
        hourlyPanelLabel = new JPanel();
        avgHperWeekLabel = new JLabel("How many hours you work per week?");
        avgHField = new JTextField("0.0");
        avgHField.setEditable(false);
        
        hourlyPanelLabel.setBackground(new Color(80,170,10));
        hourlyPanelLabel.setLayout(new GridLayout(3,1));
        
        hourlyLabel.setHorizontalAlignment(JLabel.CENTER);
        yesButton.setHorizontalAlignment(JRadioButton.CENTER);
        noButton.setHorizontalAlignment(JRadioButton.CENTER);
        yesButton.setBackground(new Color(80,170,10));
        noButton.setBackground(new Color(80,170,10));
        
        
        hourlyPanelLabel.add(hourlyLabel);
        hourlyPanelLabel.add(yesButton);
        hourlyPanelLabel.add(noButton);
        
        
        
        taxCodeLabel = new JLabel();
        
        String[] taxCodes = {"Select one of the options","1257L", "BR","D0","D1","NT"};
        taxCodeList = new JComboBox(taxCodes);
        //add listener to the combo box
        taxCodeList.addActionListener(this);
        taxCodeList.setSelectedIndex(0);
        
        // create the main window        
        this.setTitle("Salary Tax Calculator");
      
        this.setSize(750, 300);
        this.setLayout(new GridLayout(5,2,10,15)); // rows, cols
       
        
        
        
        salaryField.setPreferredSize(new Dimension(250,20));
        hourlyField.setPreferredSize(new Dimension(250,20));
        
        
        
        salaryFieldLabel.setText("I want to see the breakdown for a salary of £ ");
        salaryFieldLabel.setHorizontalAlignment(JLabel.CENTER);
        avgHperWeekLabel.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(salaryFieldLabel);
        this.add(salaryField);
        
        this.add(hourlyPanelLabel);
        this.add(hourlyField);
        
        this.add(avgHperWeekLabel);
        this.add(avgHField);
        
        taxCodeLabel.setText("Choose you tax code");
        taxCodeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(taxCodeLabel);
        this.add(taxCodeList);
        
        this.add(clearButton);
        this.add(calculateButton);
        
       
        
        this.setVisible(true); //make it visible. PUT THIS AT THE END, SO ALL COMPONENTS INSIDE OF THE FRAME ARE VISIBLE
        this.setResizable(false);
        
        //add logo to title bar
        //ImageIcon image = new ImageIcon("logo.png");
        //this.setIconImage(image.getImage());
        
        
        //when user click on the icon X, it will close the window
        //otherwise it runs on background
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        this.getContentPane().setBackground(new Color(80,170,10)); //change color of background
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //action listener for button list
        if(e.getSource () == taxCodeList ){
                
        }
        
        //action listener for radio buttons
        if(e.getSource() == yesButton){
            System.out.println("calculate hourly - yes");
            option = 1;
            salaryField.setText("0.0");
            salaryField.setEditable(false);
            hourlyField.setEditable(true);
            avgHField.setEditable(true);
        }
        if(e.getSource() == noButton){
            System.out.println("calculate hourly - no");
            option = 0;
            hourlyField.setText("0.0");
            avgHField.setText("0.0");
            hourlyField.setEditable(false);
            avgHField.setEditable(false);
            salaryField.setEditable(true);
            
        }
        
        
        //action listener for buttons :CLEAR and CALCULATE
        if (e.getSource() == clearButton){
            System.out.println("clear button clicked");
            salaryField.setText("0.0");
            hourlyField.setText("0.0");
            avgHField.setText("0.0");
            taxCodeList.setSelectedIndex(0);
        }
        if(e.getSource() == calculateButton){
            System.out.println("calculate button clicked");
            String taxcode = String.valueOf(taxCodeList.getSelectedItem());
            
            
            
            if(option == 0){
                calculate = new CalculateTax(salaryField.getText(), taxcode,option);
                System.out.println(salaryField.getText() +" "+ taxCodeList.getSelectedItem() + " "+ option);
              
                if (taxcode.compareTo("1257L") == 0) {
                   
                }
                calculate.CalculateTax();
                calculate.printTaxAndNi();
                resultPage= new ResultWindow(calculate.getTax(),calculate.getNi(), calculate.getGrossIncome());
            }
            else{
                calculate = new CalculateTax(hourlyField.getText(),avgHField.getText(), taxcode, option);
                System.out.println(hourlyField.getText()+" "+ avgHField.getText()+" "+ taxCodeList.getSelectedItem() + " "+ option);
                calculate.CalculateTax();
                calculate.printTaxAndNi();
                resultPage= new ResultWindow(calculate.getTax(),calculate.getNi(), calculate.getGrossIncome());
            }
            
        }
        
    }
    
}
