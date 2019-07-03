package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MSfata Programming Help
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
   @Id
   @Column(name = "CUST_ID")
   @GeneratedValue
   private Long id;

   @Column(name = "NAME")
   private String name;
   
  
   @Column(name="Salary")
   private Double salary;
   

   public Double getSalary() {
	return salary;
}


public void setSalary(Double salary) {
	this.salary = salary;
}


public Long getId() {
      return id;
   }


public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
