package com.bruno_braz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //printFizzBuzz();
        //int[] notes = {1, 2, 2, 1, 5, 5};
        //System.out.println(getRareNotes(notes));

        /*int[] doorsStrength =  {10,25,5};
        int[] zombiesInflux =  {1,2,1};

        System.out.println(holdTheDoor(50, doorsStrength, zombiesInflux));*/

        //System.out.println(areAnagrams("Kylo Ren", "KN Lore Y"));
    }

    static void printFizzBuzz(){
        for(int i = 1; i < 101; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0){
                System.out.println("Fizz");
            }
            else if(i % 5 == 0){
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }

    static int[] getRareNotes(int[] notes){
        ArrayList<Integer> rareNotes = new ArrayList<>();
        Map<Integer, Integer> qtd = new HashMap<Integer, Integer>();

        for (int note : notes) {
            if (!qtd.containsKey(note)) {
                qtd.put(note, 0);
            }
            qtd.put(note, qtd.get(note)+1);
        }

        for (int note : notes){
            if (qtd.get(note).intValue() < 2){
                rareNotes.add(note);
            }
        }

        int[] rares = new int[rareNotes.size()];
        for (int i = 0; i < rareNotes.size(); i++){
            rares[i] = rareNotes.get(i);
        }

        if (rares.length == 0){
            return null;
        }

        return rares;
    }

    static int holdTheDoor(int hodorStrength, int[] doorsStrength, int[] zombiesInflux){
        ArrayList<Integer> seconds = new ArrayList<>();

        for (int i = 0; i < doorsStrength.length; i ++){
            seconds.add((hodorStrength + doorsStrength[i]) / zombiesInflux[i]);
        }

        int door = 0;
        int second = seconds.get(0);
        for (int i = 1; i < seconds.size(); i++){
            if (seconds.get(i) > second){
                door = i;
                second = seconds.get(i);
            }
        }

        return door;
    }

    static boolean areAnagrams(String word1, String word2){
        word1 = word1.toLowerCase().trim().replace(" ", "");
        word2 = word2.toLowerCase().trim().replace(" ", "");

        if (word1.length() != word2.length()){
            return false;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++){
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }

        return true;
    }

}
