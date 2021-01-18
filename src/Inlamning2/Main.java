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

    public Main(){
        database = new DataStructure();
    }

    public void lookupProgram(){
        database.loopData();

        Tomte lookupTomte = getUserInput();

        //upward recursion
        List<Tomte> allChiefs = getAllChiefs(lookupTomte);
        // print upward hierarchy
        for (Tomte t: allChiefs){
            System.out.println(t.getName());
        }


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
