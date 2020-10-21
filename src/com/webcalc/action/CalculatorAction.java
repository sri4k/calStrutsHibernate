package com.webcalc.action;

import com.webcalc.model.Calculator;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webcalc.service.CalculatorService;

public class CalculatorAction  {

	private double number1, number2, result;
	private String operator;
	
    public double getNumber1() {
		return number1;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String executeCalculator() {
    	System.out.println("executeCalculator");
    	Calculator calculator;
    	if(operator != null) {
    		try {
    			calculator = new Calculator(number1,operator,number2);
        		saveCalculation(calculator);
        		return "success";
    		} catch(Exception e) {
    			return "error";
    		}
    	}
    	return "input";
    }
	
	public String executeResult() {
    	System.out.println("executeResult");
    	Calculator calculator;
    	if(operator != null) {
    		try {
    			calculator = new Calculator(number1,operator,number2);
        		saveCalculation(calculator);
        		return "success";
    		} catch(Exception e) {
    			return "error";
    		}
    	}
    	return "input";
    }

    public static double getResult(Calculator calculator) throws ArithmeticException {
		double result;
		switch(calculator.getOperator())
	    {
	        case "+":
	            result = calculator.getNumber1() + calculator.getNumber2();
	            break;
	
	        case "-":
	            result = calculator.getNumber1() - calculator.getNumber2();
	            break;
	
	        case "*":
	            result = calculator.getNumber1() * calculator.getNumber2();
	            break;
	
	        case "/":
	            result = calculator.getNumber1() / calculator.getNumber2();
	            break;
	
	        default:
	            System.err.print("Error! operator is not correct");
	            return -1;
	    }
		System.out.println(result);
		return result;
    }
    
    public static int saveCalculation(Calculator calculator) {
    	Session session = new Configuration().configure("hibernate.cfg.xml").
    						buildSessionFactory().openSession();
    	Transaction t = session.beginTransaction();
    	
    	double result = getResult(calculator);
    	calculator.setResult(result);
    	int i = (Integer)session.save(calculator);
    	
    	t.commit();
    	session.close();
    	return i;
    }
    
    public List<Calculator> getAllCalculation() throws Exception{
        
        Session session = new Configuration().configure("hibernate.cfg.xml").
					buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        
        try{    
			List<Calculator> calculatedList = session.createSQLQuery("SELECT * FROM calculator2").list();
	        if(calculatedList.size() > 0)
	        {
	            return calculatedList;
	        }
        } 
        catch(Exception e) {
            throw e;
        }
        finally {
        	session.close();
        }
        
        return null;  
    }
}
