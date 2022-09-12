package com.ideas2it.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "role")
public class Role {

    @Id 
    @GeneratedValue
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Employee> employees = new HashSet<Employee>();

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

    public Set<Employee> getEmployee(){
        return employees;
    }
   
    public void setEmployee(Set<Employee> employees){
        this.employees = employees;
    }
}