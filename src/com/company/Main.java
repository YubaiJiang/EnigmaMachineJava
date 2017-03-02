package com.company;

public class Main {

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

        String reflectorName1 = "Beta";
        String reflector1 = "LEYJVCNIXWPBQMDRTAKZGFUHOS";

        String reflectorName2 = "Gamma";
        String reflector2 = "FSOKANUERHMBTIYCWLQPZXVGJD";

        String reflectorName3 = "A";
        String reflector3 = "EJMZALYXVBWFCRQUONTSPIKHGD";

        String reflectorName4 = "B";
        String reflector4 = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

        String reflectorName5 = "C";
        String reflector5 = "FVPJIAOYEDRZXWGCTKUQSBNMHL";

        String reflectorName6 = "B Thin";
        String reflector6 = "ENKQAUYWJICOPBLMDXZVFTHRGS";

        String reflectorName7 = "C Thin";
        String reflector7 = "RDOBJNTKVEHMLFCWZAXGYIPSUQ";

        String reflectorName8 = "ETW";
        String reflector8 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


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

        System.out.println("Please enter left rotor, selecting from " + rotorNameList + ".");
        String rotorNameLeft = System.console().readLine().toUpperCase();

        //check input validity.
        boolean rotorValidityLeft = false;

        while(!rotorValidityLeft){

            for(int i = 0; i < 8; i++){
                if(rotorNameLeft == rotorNames[i]){
                    rotorValidityLeft = true;
                }
            }

            if(rotorValidityLeft){

                System.out.println("Rotor "+ rotorNameLeft);

            } else {

                System.out.println("Invalid input, please try again.");
                rotorNameLeft = System.console().readLine().toUpperCase();

            }

        }


    }
}
