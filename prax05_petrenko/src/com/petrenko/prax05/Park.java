package com.petrenko.prax05;
import java.util.ArrayList;
import java.util.List;

public class Park {
    private final String name;
    private List<Attraction> attractions;

    Park(String name){
        this.name = name;
        attractions = new ArrayList<>();
    }

    public void displayParkInfo(){
        System.out.printf("Park \t %s has following Attractions: \n", name);
        for(Attraction attraction : attractions){
            attraction.displayAttractionInfo();
        }
    }

    public void addAttraction(String name, String workHours, float cost){
        attractions.add(new Attraction(name, workHours, cost));
    }

    private static class Attraction{
        private final String name;
        private final String workHours;
        private final float cost;

        Attraction(String name, String workHours, float cost){
            this.name = name;
            this.workHours = workHours;
            this.cost = cost;
        }

        void displayAttractionInfo(){
            System.out.printf("Attraction Name: %s \t Work Hours: %s \t Cost: %.2f \n", name, workHours, cost);
        }
    }
}
