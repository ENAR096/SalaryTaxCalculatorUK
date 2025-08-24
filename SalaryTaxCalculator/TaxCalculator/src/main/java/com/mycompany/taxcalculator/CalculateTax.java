/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taxcalculator;

/**
 *
 * @author naren
 */
public class CalculateTax {
    
    private double salary, hourlyWage, hoursPerWeek;
    private String taxCode;
    private int option;
    private double[] result = new double [2];
    private double grossIncome;
    
    
    public CalculateTax(String salary, String taxCode, int option){
        this.salary = Double.parseDouble(salary);
        this.taxCode = taxCode;
        this.option = option;
    }
    
    public CalculateTax(String hourlyWage, String hoursPerWeek, String taxCode, int option){
        this.hourlyWage = Double.parseDouble(hourlyWage);
        this.hoursPerWeek = Double.parseDouble(hoursPerWeek);
        this.taxCode = taxCode;
        this.option = option;
    }
    
    public double getSalary(){
        return this.salary;
    }
    public String getTaxCode(){
        return this.taxCode;
    }
    public double getHourWage (){
        return this.hourlyWage;
    }
    public double getHours(){
        return this.hoursPerWeek;
    }
    public double getTax(){
        return result[0];
    }
    public double getNi(){
        return result[1];
    }
    public double getGrossIncome(){
        return grossIncome;
    }
    
    
    public void setSalary(String salary){
        this.salary = Double.parseDouble(salary);
    }
    public void setTaxCode(String taxCode){
        this.taxCode= taxCode;
    }
    public void setHourWage (String hourlyWage){
        this.hourlyWage= Double.parseDouble(hourlyWage);
    }
    public void setHours(String hoursPerWeek){
        this.hoursPerWeek =Double.parseDouble( hoursPerWeek);
    }
    
    public void printTaxAndNi(){
        System.out.println("Tax: "+ result[0]+ " Ni: "+result[1] + " Total deduction: "+ (result[0]+result[1]));
    }
    
    public double[] CalculateTax(){
        //System.out.println("XXXXX");
        double personalAllowance = 12570.0;
        double taxableIncome = salary - personalAllowance;
        double hourWageYear = hourlyWage * hoursPerWeek * 52;
        double taxableIncomeHour = hourWageYear - personalAllowance;
        double tax= 0, ni  = 0;
        
        if(taxCode.compareTo("1257L")==0){
            //breakdown of salary if option is 0
            if(option == 0){
                if(taxableIncome  <  0.0){
                    //System.out.println("you do not pay tax");
                    tax = 0;
                    
                }else if(taxableIncome <= 37700.0){
                    //System.out.println("you pay "+(taxableIncome*0.20)+ " in taxes per year");
                   tax =taxableIncome*0.20;
                   
                }else if(taxableIncome <= 112570.0){
                    //System.out.println("you pay "+((37700.0 * 0.20) + ((taxableIncome - 37700.0) * 0.40))+ " in taxes per year");
                    tax= ((37700.0 * 0.20) + ((taxableIncome - 37700.0) * 0.40));
                }else{
                  //  System.out.println("you pay "+((37700.0 * 0.20) + ((112570.0- 37700.0) * 0.40) + ((taxableIncome - 112570.0) * 0.45))+ " in taxes per year");
                  tax = ((37700.0 * 0.20) + ((112570.0- 37700.0) * 0.40) + ((taxableIncome - 112570.0) * 0.45));
                }

             }
            //calculate hourly wage if option is not 0
            else{
                if(taxableIncomeHour  <  0){
                    //System.out.println("you do not pay tax");
                    tax= 0;
                }else if(taxableIncomeHour <= 37700){
                    //System.out.println("you pay "+(taxableIncomeHour*0.20)+ " in taxes per year");
                    tax =  (taxableIncomeHour*0.20);
                }else if(taxableIncomeHour <= 112570){
                    //System.out.println("you pay "+((37700 * 0.20) + ((taxableIncomeHour - 37700) * 0.40))+ " in taxes per year");
                    tax = ((37700 * 0.20) + ((taxableIncomeHour - 37700) * 0.40));
                }else{
                    //System.out.println("you pay "+((37700 * 0.20) + ((112570 - 37700) * 0.40) + ((taxableIncomeHour - 112570) * 0.45))+ " in taxes per year");
                    tax = ((37700 * 0.20) + ((112570 - 37700) * 0.40) + ((taxableIncomeHour - 112570) * 0.45));
                }
                }
         }else if(taxCode.compareTo("BR")==0){
             if(option == 0){
                 //System.out.println("you pay "+(taxableIncome*0.20)+ " in taxes per year");
                 tax = (salary*0.20);
             }else{
                 //System.out.println("you pay "+(taxableIncomeHour*0.20)+ " in taxes per year");
                 tax = (hourWageYear*0.20);
             }
             
         }else if(taxCode.compareTo("D0")==0){
             if(option == 0){
                 //System.out.println("you pay "+(taxableIncome*0.40)+ " in taxes per year");
                 tax = (taxableIncome*0.40);
             }else{
                 //System.out.println("you pay "+(taxableIncomeHour*0.40)+ " in taxes per year");
                 tax = (taxableIncomeHour*0.40);
             }
             
         }else if(taxCode.compareTo("D1")==0){
             if(option == 0){
                 //System.out.println("you pay "+(taxableIncome*0.45)+ " in taxes per year");
                 tax = (taxableIncome*0.45);
             }else{
                 //System.out.println("you pay "+(taxableIncomeHour*0.45)+ " in taxes per year");
                 tax= (taxableIncomeHour*0.45);
             }
             
         }else if(taxCode.compareTo("NT")==0){
             if(option == 0){
                 //System.out.println("No income tax is deducted");
                 tax = 0;
             }else{
                 //System.out.println("No income tax is deducted");
                 tax = 0;
             }
             
         }else{
             System.out.println("something went wrong");
             tax = -1;
         }
        
         if(option == 0){
             this.grossIncome = salary;
             if(salary >12570){
                 if(salary <=50270){
                     ni = taxableIncome*0.08;
                 }else{
                     ni = ((50270 - 12570)*0.08) +(salary - 50270)*0.02;
                 }
             }  
             
             }else{
             this.grossIncome = hourWageYear;
                if(hourWageYear >12570){
                 if(hourWageYear <=50270){
                     ni = taxableIncomeHour*0.08;
                 }else{
                     ni = ((50270 - 12570)*0.08) +(hourWageYear - 50270)*0.02;
                 }
             }  
             
                 
             }
        
        
        result[0] = tax;
        result[1]=ni;
        return result;
        
        
    }
    
}
