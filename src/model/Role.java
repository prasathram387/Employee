package com.ideas2it.management.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

    @Id 
    @GeneratedValue
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @ManyToMany(mappedBy = "roles")
    private List<Employee> employees = new ArrayList<Employee>();

    public Role() {

    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
   
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }    

    public String getName() {
	return name;
    }


    public void setName(String name){
        this.name = name;
    }    

    public List<Employee> getEmployee(){
        return employees;
    }
   
    public void setEmployee(List<Employee> employees){
        this.employees = employees;
    }
}