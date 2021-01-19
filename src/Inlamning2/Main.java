package Inlamning2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-01-14
 * Project: inlamning2
 * Copyright: MIT
 */
public class Main {
    private DataStructure database;
    Scanner scanner = new Scanner(System.in);

    public Main(){
        database = new DataStructure();
    }

    public void lookupProgram(){
        //database.loopData();

        while(true){

            Tomte lookupTomte = tomteLookup();

            //upward recursion
            List<Tomte> allChiefs = getAllChiefs(lookupTomte);
            System.out.print("Över " + lookupTomte.getName() + " jobbar: ");
            System.out.println(getResultString(allChiefs));

            // down-ward recursion
            List<Tomte> allEmployees = getALlEmployees(lookupTomte);
            System.out.print("Under " + lookupTomte.getName() + " jobbar: ");
            System.out.println(getResultString(allEmployees));

            System.out.println("Vill du slå upp en till tomte? (ja/nej)");
            String userChoice = scanner.next();
            if(userChoice.equalsIgnoreCase("nej")){
                break;
            }
        }
    }

    public String getResultString(List<Tomte> resultList){
        return resultList.stream().map(Tomte::getName).collect(Collectors.joining(", "));
    }


    // recursion for going down in the hierarchy

    public List<Tomte> getALlEmployees(Tomte tomte){
        List<Tomte> allEmployeesAcc = new ArrayList<>();
        getOneLayerEmployees(tomte, allEmployeesAcc);
        return allEmployeesAcc;
    }

    public List<Tomte> getOneLayerEmployees(Tomte tomte, List<Tomte> allEmployeesAcc){
        if(!tomte.getEmployees().isEmpty()){
            allEmployeesAcc.addAll(tomte.getEmployees());
            for (Tomte employee : tomte.getEmployees()) {
                getOneLayerEmployees(employee, allEmployeesAcc);
            }
            tomte.getEmployees();
        }
        return allEmployeesAcc;
    }


    // recursion for going up in the hierarchy

    public List<Tomte> getAllChiefs(Tomte tomte){
        List<Tomte> allChiefsAcc = new ArrayList<>();
        getOneLayerChief(tomte, allChiefsAcc);
        return allChiefsAcc;
    }

    public List<Tomte> getOneLayerChief(Tomte tomte, List<Tomte> allChiefsAcc){
        if(tomte.getChief() != null){
            allChiefsAcc.add(tomte.getChief());
            getOneLayerChief(tomte.getChief(), allChiefsAcc);
        }
        return allChiefsAcc;
    }


    public Tomte tomteLookup(){
        String tomteName = getUserInput("Namn att slå upp: ");
        Tomte result = database.lookupTomteByName(tomteName);
        while(result == null){
            tomteName = getUserInput("Skriv in namnet igen: ");
            result = database.lookupTomteByName(tomteName);
        }
        return result;
    }

    public String getUserInput(String prompt){
        System.out.println(prompt);
        return scanner.next();
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.lookupProgram();
    }


}
