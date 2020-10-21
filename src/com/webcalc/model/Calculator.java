package com.webcalc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calculator2")
public class Calculator {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "number1")
	private double number1;
	@Column(name = "operator")
	private String operator;
	@Column(name = "number2")
	private double number2;
	@Column(name = "result")
	private double result;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	public Calculator(double number1, String operator, double number2) {
		super();
		this.number1 = number1;
		this.operator = operator;
		this.number2 = number2;
	}
	@Override
    public String toString() {
        return "Calculator [id=" + id + ", " + number1 + operator + number2 + "=" + result + "]";
    }
}
