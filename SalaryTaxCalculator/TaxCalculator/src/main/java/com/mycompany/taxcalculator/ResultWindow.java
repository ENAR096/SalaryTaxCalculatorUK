/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taxcalculator;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author naren
 */
public class ResultWindow extends JFrame{
    private double[] printResult = new double [2];
    private double salary;
    private String taxCode;
    
    
    
    ResultWindow(double tax, double ni, double salary){
        this.printResult[0] = tax;
        this.printResult[1]=ni;
        this.salary = salary;
      
        
        this.setTitle("Result Page");
        this.setSize(850, 500);
        this.setLayout(new GridLayout(5,5));
  
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        Border border = BorderFactory.createLineBorder(Color.black);
        
        this.add(new JPanel());
        this.add(new JLabel("Yearly",JLabel.CENTER));
        this.add(new JLabel("Monthly",JLabel.CENTER));
        this.add(new JLabel("Weekly",JLabel.CENTER));
        this.add(new JLabel("Daily - (5 working days)",JLabel.CENTER));
        this.add(new JLabel("Gross Income",JLabel.CENTER));
        this.add(new JLabel(Double.toString(this.salary),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.salary/12*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.salary/52*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.salary/260*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel("Tax",JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.printResult[0]*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.printResult[0]/12*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.printResult[0]/52*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.printResult[0]/260*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel("Ni",JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.printResult[1]*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.printResult[1]/12*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.printResult[1]/52*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel(Double.toString(Math.round(this.printResult[1]/260*100.0)/100.0),JLabel.CENTER));
        this.add(new JLabel("2025 Take Home",JLabel.CENTER));
        this.add(new JLabel(Double.toString((Math.round((this.salary - this.printResult[0] - this.printResult[1])*100.0)/100.0)),JLabel.CENTER));
        this.add(new JLabel(Double.toString((Math.round((this.salary - this.printResult[0] - this.printResult[1])/12*100.0)/100.0)),JLabel.CENTER));
        this.add(new JLabel(Double.toString((Math.round((this.salary - this.printResult[0] - this.printResult[1])/52*100.0)/100.0)),JLabel.CENTER));
        this.add(new JLabel(Double.toString((Math.round((this.salary - this.printResult[0] - this.printResult[1])/260*100.0)/100.0)),JLabel.CENTER));
        
        
        
        this.setVisible(true);
        
        
    }

}
