package Inlamning2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-01-14
 * Project: inlamning2
 * Copyright: MIT
 */
public class Main {
    private DataStructure database;
    List<Tomte> employeeList = new ArrayList<>();
    List<Tomte> allChiefs = new ArrayList<>();

    public Main(){
        database = new DataStructure();
    }

    public void lookupProgram(){
        database.loopData();

        Tomte lookupTomte = getUserInput();

        //upward recursion
        getAllChiefs(lookupTomte);
        // print upward hierarchy
        for (Tomte t: allChiefs){
            System.out.println(t.getName());
        }


        lookupTomte = getUserInput();

        // down-ward recursion
        List<Tomte> downList = getALlEmployees(lookupTomte);
        for(Tomte t: downList){
            System.out.println(t);
        }



    }


    // recursion for going down in the hierarchy
/*

    public List<Tomte> getALlEmployeesOld(Tomte tomte){

        employeeList.addAll(tomte.getEmployees());
        System.out.println(employeeList.size() + " på första platsen " + employeeList.get(0));
        for (int i = 0; i < employeeList.size(); i++) {
            employeeList.addAll(getOneLayerEmployees(employeeList.get(i), i));
        }
        //employeeList.addAll(getOneLayerEmployees(employeeList.get(0), 0));
        return employeeList;

    }

 */
// sida 753
    public List<Tomte> getALlEmployees(Tomte tomte){
        List<Tomte> employedLayers = new ArrayList<>();
        if(! tomte.getEmployees().isEmpty()){
            List<Tomte> tempMidList = new ArrayList<>();
            tempMidList.addAll(tomte.getEmployees());
            for (int i = 0; i < tempMidList.size(); i++) {
                employedLayers.add(tempMidList.get(i));
                getALlEmployees(tempMidList.get(i));
            }
            tomte.getEmployees();
        } return employedLayers;
    }

    public void getOneLayerEmployees(Tomte tome){

    }
/*
    public List<Tomte> getOneLayerEmployeesOld(Tomte tomte, int index){
        if(tomte.getEmployees().isEmpty() && index == employeeList.size()-1){
            System.out.println(tomte.getName() + " " + "tomt");
            return tomte.getEmployees();
        } else {
            employeeList.addAll(tomte.getEmployees());
            getOneLayerEmployees(employeeList.get(index++), index++);
            return employeeList;

        }
    }

 */




    // recursion for going up in the hierarchy

    public List<Tomte> getAllChiefs(Tomte tomte){
        getOneLayerChief(tomte);
        return allChiefs;
    }

    public void getOneLayerChief(Tomte tomte){
        if(tomte.getChief() != null){
            allChiefs.add(tomte.getChief());
            getOneLayerChief(tomte.getChief());
        }
    }


    public Tomte getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Namn att slå upp: ");
        String tomteName = scanner.next();
        return database.lookupTomteByName(tomteName);
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.lookupProgram();
    }



}
