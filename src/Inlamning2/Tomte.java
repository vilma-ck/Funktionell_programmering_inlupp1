package Inlamning2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-01-08
 * Project: inlamning2
 * Copyright: MIT
 */
public class Tomte {

    private String name;
    private Tomte chief;
    private List<Tomte> employees = new ArrayList<>();

    public Tomte(String name) {
        this.name = name;

    }

    public Tomte getChief() {
        return chief;
    }

    public void setChief(Tomte chief) {
        this.chief = chief;
        if(!chief.getEmployees().contains(this)){
            chief.getEmployees().add(this);
        }
    }

    public List<Tomte> getEmployees(){
        return employees;
    }

    public void setList(List<Tomte> employees){
        this.employees = employees;
        for(Tomte e : employees){
            e.setChief(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if(employees.isEmpty()){
            return name;
        }
        return name + ", och dens underordnade " + employees.stream().map(Tomte::getName).collect(Collectors.joining(", "));
    }
}
