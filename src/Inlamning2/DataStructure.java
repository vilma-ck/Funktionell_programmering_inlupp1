package Inlamning2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-01-08
 * Project: inlamning2
 * Copyright: MIT
 */
public class DataStructure {

    private List<Tomte> database = new ArrayList<>();

    public DataStructure(){
        createCharacters();
    }

    public void loopData(){
        for (Tomte t : database){
            System.out.println(t);
        }
    }

    public Tomte lookupTomteByName(String name){
        for(Tomte tomte : database){
            if(tomte.getName().equalsIgnoreCase(name)){
                return tomte;
            }
        }
        return null;
    }

    private void createCharacters(){
        Tomte t1 = new Tomte("Tomten");
        Tomte t2 = new Tomte("Glader");
        Tomte t3 = new Tomte("Butter");
        Tomte t4 = new Tomte("Tröger");
        Tomte t5 = new Tomte("Trötter");
        Tomte t6 = new Tomte("Blyger");
        Tomte t7 = new Tomte("Rådjuret");
        Tomte t8 = new Tomte("Nyckelpigan");
        Tomte t9 = new Tomte("Haren");
        Tomte t10 = new Tomte("Räven");
        Tomte t11 = new Tomte("Skumtomten");
        Tomte t12 = new Tomte("Dammråttan");
        Tomte t13 = new Tomte("Gråsuggan");
        Tomte t14 = new Tomte("Myran");
        Tomte t15 = new Tomte("Bladlusen");

        database.add(t1); database.add(t2); database.add(t3); database.add(t4); database.add(t5);
        database.add(t6); database.add(t7); database.add(t8); database.add(t9); database.add(t10);
        database.add(t11); database.add(t12); database.add(t13); database.add(t14); database.add(t15);

        t2.setChief(t1);
        t3.setChief(t1);
        t4.setChief(t2);
        t5.setChief(t2);
        t6.setChief(t2);
        t7.setChief(t3);
        t8.setChief(t3);
        t9.setChief(t3);
        t10.setChief(t3);
        t11.setChief(t5);
        t12.setChief(t11);
        t13.setChief(t10);
        t14.setChief(t10);
        t15.setChief(t14);

    }

    public static void main(String[] args) {
        DataStructure ds = new DataStructure();
        ds.loopData();


    }
}
