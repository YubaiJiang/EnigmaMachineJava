package com.company;
import java.util.Scanner;

public class Main {

    /**=====================================
     * Main function
     =====================================*/

    public static void main(String[] args) {
        // write your code here

        /**=====================================
         * Global variables
         =====================================*/
        String keyboard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        /**
         * Rotors https://en.wikipedia.org/wiki/Enigma_rotor_details
         */

        String rotorName1 = "I";
        String rotor1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        String rotorStep1 = "Q";

        String rotorName2 = "II";
        String rotor2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        String rotorStep2 = "E";

        String rotorName3 = "III";
        String rotor3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        String rotorStep3 = "V";

        String rotorName4 = "IV";
        String rotor4 = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
        String rotorStep4 = "J";

        String rotorName5 = "V";
        String rotor5 = "VZBRGITYUPSDNHLXAWMJQOFECK";
        String rotorStep5 = "Z";

        String rotorName6 = "VI";
        String rotor6 = "JPGVOUMFYQBENHZRDKASXLICTW";
        String rotorStep6 = "MZ";

        String rotorName7 = "VII";
        String rotor7 = "NZJHGRCXMYSWBOUFAIVLPEKQDT";
        String rotorStep7 = "MZ";

        String rotorName8 = "VIII";
        String rotor8 = "FKQHTLXOCBJSPDZRAMEWNIUYGV";
        String rotorStep8 = "MZ";


        /**
         * Reflectors
         */

        String reflectorName1 = "BETA";
        String reflector1 = "LEYJVCNIXWPBQMDRTAKZGFUHOS";

        String reflectorName2 = "GAMMA";
        String reflector2 = "FSOKANUERHMBTIYCWLQPZXVGJD";

        String reflectorName3 = "A";
        String reflector3 = "EJMZALYXVBWFCRQUONTSPIKHGD";

        String reflectorName4 = "B";
        String reflector4 = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

        String reflectorName5 = "C";
        String reflector5 = "FVPJIAOYEDRZXWGCTKUQSBNMHL";

        String reflectorName6 = "B THIN";
        String reflector6 = "ENKQAUYWJICOPBLMDXZVFTHRGS";

        String reflectorName7 = "C THIN";
        String reflector7 = "RDOBJNTKVEHMLFCWZAXGYIPSUQ";

        String reflectorName8 = "ETW";
        String reflector8 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        /**
         * Parts
         */


        /**
         * Others
         */







        /**=====================================
         * Start program
         =====================================*/

        System.out.println("Initialising...");

        System.out.println("Loading keyboard...");
        char[] keys = new char[26];
        for (int i = 0; i < 26; i++) {
            keys[i] = keyboard.charAt(i);
            System.out.println("Allocate " + keys[i] + " key to position " + (i));
        }

        System.out.println("Looking for rotors...");
        String[] rotorSet = {rotor1, rotor2, rotor3, rotor4, rotor5, rotor6, rotor7, rotor8,};
        String[] rotorNames = {rotorName1, rotorName2, rotorName3, rotorName4, rotorName5, rotorName6, rotorName7, rotorName8,};
        String[] rotorSteppingPositions = {rotorStep1, rotorStep2, rotorStep3, rotorStep4, rotorStep5, rotorStep6, rotorStep7, rotorStep8};
        String rotorNameList = java.util.Arrays.toString(rotorNames);
        System.out.println("Found rotors " + rotorNameList + ".");
        for (int i = 0; i < 8; i++) {
            System.out.println("Rotor " + rotorNames[i] + ":" + "\t" + rotorSet[i] + "\t Stepping position " + rotorSteppingPositions[i]);
        }

        System.out.println("Looking for reflectors...");
        String[] reflectorSet = {reflector1, reflector2, reflector3, reflector4, reflector5, reflector6, reflector7, reflector8,};
        String[] reflectorNames = {reflectorName1, reflectorName2, reflectorName3, reflectorName4, reflectorName5, reflectorName6, reflectorName7, reflectorName8,};
        String reflectorNameList = java.util.Arrays.toString(reflectorNames);
        System.out.println("Found reflectors " + reflectorNameList + ".");
        for (int i = 0; i < 8; i++) {
            System.out.println(reflectorNames[i] + ":" + "\t" + reflectorSet[i]);
        }

        /**=====================================
         * Setup
         =====================================*/

        /*
        Setup rotors
         */


        //Setup left rotor
        System.out.println("Please enter left rotor, selecting from " + rotorNameList + ".");

        String rotorLeft = selectRotor(rotorSet, rotorNames);
        String rotorLeftSteppingPosition = loadRotorSteppingPosition(rotorLeft, rotorSet, rotorSteppingPositions);

        //Setup middle rotor
        System.out.println("Please enter middle rotor, selecting from " + rotorNameList + ".");

        String rotorMiddle = selectRotor(rotorSet, rotorNames);
        String rotorMiddleSteppingPosition = loadRotorSteppingPosition(rotorMiddle, rotorSet, rotorSteppingPositions);

        //Setup right rotor
        System.out.println("Please enter right rotor, selecting from " + rotorNameList + ".");

        String rotorRight = selectRotor(rotorSet, rotorNames);
        String rotorRightSteppingPosition = loadRotorSteppingPosition(rotorRight, rotorSet, rotorSteppingPositions);


        /*
        Setup reflector
         */

        System.out.println("Please enter reflector, selecting from " + reflectorNameList + ".");
        String reflector = selectRotor(reflectorSet, reflectorNames);


    }

    /**=====================================
     * subfunctions
     =====================================*/

    /**
     * Rotor setup: request user input, check input validity, then select rotor String.
     *
     *
     * @param partSets collection or rotors or reflectors
     * @param nameSets colloection of names of rotors or reflectors
     */

    public static String selectRotor(String[] partSets, String[] nameSets){

        boolean validity = false;

        Scanner scan = new Scanner(System.in);
        String testInput = scan.nextLine().toUpperCase();
        String rotorSelected = new String();

        System.out.println("Your input: [" + testInput +"].");

        while(!validity) {

            for (int i = 0; i < 8; i++) {

                System.out.println("Check rotor " + nameSets[i] + ".");

                if (testInput.equals(nameSets[i])) {

                    validity = true;
                    rotorSelected = partSets[i];
                    System.out.println("Found a match.");

                    break;

                } else {
                    System.out.println("Not a match.");
                }
            }

            if (validity) {

                System.out.println("[" + testInput + "] [" + rotorSelected + "] selected");
                break;

            } else {

                System.out.println("Invalid input, please try again.");
                testInput = scan.nextLine().toUpperCase();
                System.out.println("Your input: [" + testInput + "].");

            }
        }

        return rotorSelected;
    }

    /**
     * Function: Load stepping position
     *
     * @param rotorSelected: detail(String) of the rotor selected by user
     * @param partSet: collection of parts
     * @param steppingPositionSet: collection of steppingPosition of all rotors
     */

    public static String loadRotorSteppingPosition(String rotorSelected, String[] partSet, String[] steppingPositionSet){

        String steppingPositionLoaded = new String();

        //Looking for position
        for(int i = 0; i < 8; i++){

            if(rotorSelected.equals(partSet[i])){

                steppingPositionLoaded = steppingPositionSet[i];
                System.out.println("Stepping position is [" + steppingPositionLoaded + "]");
                break;

            }

        }

        return steppingPositionLoaded;

    }
}
