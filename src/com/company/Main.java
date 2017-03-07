package com.company;
import java.lang.reflect.Array;
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

        /**=====================================
         * Initialisation
         =====================================*/

        System.out.println("Initialising...");

        System.out.println("Loading keyboard...");

        for (int i = 0; i < 26; i++) {

            System.out.println("Allocate " + keyboard.charAt(i) + " key to position " + (i));

        }

        System.out.println("");

        System.out.println("Looking for rotors...");

        String[] rotorSet = {rotor1, rotor2, rotor3, rotor4, rotor5, rotor6, rotor7, rotor8,};
        String[] rotorNames = {rotorName1, rotorName2, rotorName3, rotorName4, rotorName5, rotorName6, rotorName7, rotorName8,};
        String[] rotorSteppingPositions = {rotorStep1, rotorStep2, rotorStep3, rotorStep4, rotorStep5, rotorStep6, rotorStep7, rotorStep8};
        String rotorNameList = java.util.Arrays.toString(rotorNames);
        System.out.println("Found rotors " + rotorNameList + ".");
        System.out.println("");

        for (int i = 0; i < 8; i++) {

            System.out.println("Rotor " + rotorNames[i] + ":" + "\t" + rotorSet[i] + "\t Stepping position " + rotorSteppingPositions[i]);

        }

        System.out.println("");

        System.out.println("Looking for reflectors...");

        String[] reflectorSet = {reflector1, reflector2, reflector3, reflector4, reflector5, reflector6, reflector7, reflector8,};
        String[] reflectorNames = {reflectorName1, reflectorName2, reflectorName3, reflectorName4, reflectorName5, reflectorName6, reflectorName7, reflectorName8,};
        String reflectorNameList = java.util.Arrays.toString(reflectorNames);
        System.out.println("Found reflectors " + reflectorNameList + ".");
        System.out.println("");

        for (int i = 0; i < 8; i++) {

            System.out.println(reflectorNames[i] + ":" + "\t" + reflectorSet[i]);

        }

        System.out.println("");

        /**=====================================
         * Setup
         =====================================*/

        /*
        Setup reflector
         */

        System.out.println("Please enter reflector, selecting from " + reflectorNameList + ".");
        int[] reflector = selectWheel(reflectorSet, reflectorNames, keyboard);

        /*
        Setup rotors
         */

        //Setup left rotor
        System.out.println("Please enter left rotor, selecting from " + rotorNameList + ".");

        int[] rotorLeft = selectWheel(rotorSet, rotorNames, keyboard);
        int[] steppingLeft = getSteppingPosition(rotorLeft, rotorSet, rotorSteppingPositions, keyboard);

        //Setup middle rotor
        System.out.println("Please enter middle rotor, selecting from " + rotorNameList + ".");

        int[] rotorMiddle = selectWheel(rotorSet, rotorNames, keyboard);
        int[] steppingMiddle = getSteppingPosition(rotorMiddle, rotorSet, rotorSteppingPositions, keyboard);

        //Setup right rotor
        System.out.println("Please enter right rotor, selecting from " + rotorNameList + ".");

        int[] rotorRight = selectWheel(rotorSet, rotorNames, keyboard);
        int[] steppingRight = getSteppingPosition(rotorRight, rotorSet, rotorSteppingPositions, keyboard);

        /*
        Setup letter ring
         */

        //Setup left letter ring
        System.out.println("Please enter left letter ring position, single alphabet only.");
        int ringLeft = getPosition(keyboard);

        //Setup left middle ring
        System.out.println("Please enter middle letter ring position, single alphabet only.");
        int ringMiddle = getPosition(keyboard);

        //Setup right letter ring
        System.out.println("Please enter right letter ring position, single alphabet only.");
        int ringRight = getPosition(keyboard);

        /*
        Setup rotor position
         */

        //Setup left letter ring
        System.out.println("Please enter left window position, single alphabet only.");
        int windowLeft = getPosition(keyboard);

        //Setup left middle ring
        System.out.println("Please enter middle window position, single alphabet only.");
        int windowMiddle = getPosition(keyboard);

        //Setup right letter ring
        System.out.println("Please enter right window position, single alphabet only.");
        int windowRight = getPosition(keyboard);

        /*
        Setup plug-board
         */

        System.out.println("Please enter plug-board setting, even number of alphabets only.");
        char[] plugboard = insertPlugs(keyboard);

        boolean loop = true;

        while(loop) {

            /**=====================================
             * Read message into char[]
             =====================================*/

            //request input
            System.out.println("Please enter your message, maximum 500 characters, alphabets only.");
            char[] messageInput = readMessage(keyboard);

            /**=====================================
             * run message through Enigma Machine
             =====================================*/

            //run through plugboard
            char[] messageInProgress = runPlugboard(messageInput, plugboard);

            //Casting into number array
            String messageBeforeRotorString = new String(messageInProgress);
            int[] messageNumberArray = getNumberArray(messageBeforeRotorString, keyboard);

            //run through rotors one number by one number

            int messageSize = Array.getLength(messageNumberArray);

            for (int i = 0; i < messageSize; i++) {

                //stepping

                /*
                Right rotor always step. Middle rotor steps whenever right rotor stepped at right stepping position and
                at middle rotor at stepping position itself. Left rotor steps whenever middle rotor steps at middle
                stepping position

                variables involved: int windowRight/Middle/Left, int[] steppingRight/Middle
                 */

                //check if double stepping available.

                int middleSteppingSize = Array.getLength(steppingMiddle);

                for (int j = 0; j < middleSteppingSize; j++) {

                    if (windowMiddle == steppingMiddle[j]) {

                        windowMiddle++;

                        if (windowMiddle > 25) {

                            windowMiddle = windowMiddle - 26;

                        }

                        //Stepping left as well

                        windowLeft++;

                        if (windowLeft > 25) {

                            windowLeft = windowLeft - 26;

                        }

                        System.out.println("Middle stepping to " + windowMiddle);
                        System.out.println("");
                        System.out.println("Left stepping to " + windowLeft);
                        System.out.println("");
                        break;

                    }

                }

                //check if right stepped on stepping position.

                int rightSteppingSize = Array.getLength(steppingRight);

                for (int j = 0; j < rightSteppingSize; j++) {

                    if (windowRight == steppingRight[j]) {

                        windowMiddle++;

                        if (windowMiddle > 25) {

                            windowMiddle = windowMiddle - 26;

                        }

                        System.out.println("Middle stepping to " + windowMiddle);
                        System.out.println("");
                        break;

                    }

                }

                //right rotor always steps

                windowRight++;

                if (windowRight > 25) {

                    windowRight = windowRight - 26;

                }

                System.out.println("Right stepping to " + windowRight);
                System.out.println("");

                //run number through right rotor
                messageNumberArray[i] = runRotor(messageNumberArray[i], rotorRight, ringRight, windowRight);

                //run number through middle rotor
                messageNumberArray[i] = runRotor(messageNumberArray[i], rotorMiddle, ringMiddle, windowMiddle);

                //run number through left rotor
                messageNumberArray[i] = runRotor(messageNumberArray[i], rotorLeft, ringLeft, windowLeft);

                //run number through reflector
                messageNumberArray[i] = runRotor(messageNumberArray[i], reflector, 0, 0);

                //run number through left rotor reversed
                messageNumberArray[i] = runRotorReversed(messageNumberArray[i], rotorLeft, ringLeft, windowLeft);

                //run number through middle rotor reversed
                messageNumberArray[i] = runRotorReversed(messageNumberArray[i], rotorMiddle, ringMiddle, windowMiddle);

                //run number through right rotor reversed
                messageNumberArray[i] = runRotorReversed(messageNumberArray[i], rotorRight, ringRight, windowRight);

            }


            //casting output message into char[]
            String messageAfterRotor = getAlphabeticalString(messageNumberArray, keyboard);
            char[] messageAfterRotorArray = messageAfterRotor.toCharArray();

            //run plugboard again
            char[] messageOutputArray = runPlugboard(messageAfterRotorArray, plugboard);

            //casting final message into String and print
            String messageOutput = new String(messageOutputArray);
            System.out.println("message output is: " + messageOutput + ".");
            System.out.println("");

        }

    }

    /**=====================================
     * subfunctions
     =====================================*/

    /**
     * Rotor setup: request user input, check input validity, then select rotor String.
     *
     * @param partSets: collection or rotors or reflectors
     * @param nameSets: colloection of names of rotors or reflectors
     * @return rotorSelected: String of selected rotor/reflector details
     */

    public static int[] selectWheel(String[] partSets, String[] nameSets, String alphabets){

        boolean validity = false;

        // Read user input
        Scanner scan = new Scanner(System.in);
        String testInput = scan.nextLine().toUpperCase();
        String rotorSelected = new String();

        System.out.println("");
        System.out.println("Your input: [" + testInput +"].");
        System.out.println("");

        // Test if the input is a valid name
        while(!validity) {

            int rotorSetArraySize = Array.getLength(nameSets);

            // Run through name array
            for (int i = 0; i < rotorSetArraySize; i++) {

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

                //Request re-enter if not a valid input.
                System.out.println("");
                System.out.println("Invalid input, please try again.");
                testInput = scan.nextLine().toUpperCase();
                System.out.println("");
                System.out.println("Your input: [" + testInput + "].");
                System.out.println("");

            }

        }

        // Convert the rotor String into an array of number position.
        int[] rotorSelectedArray = getNumberArray(rotorSelected, alphabets);

        // give feedback
        System.out.println("Loaded wheel position:" + java.util.Arrays.toString(rotorSelectedArray) + ".");
        System.out.println("");
        return rotorSelectedArray;

    }

    /**
     * Function: Load stepping position
     */

    public static int[] getSteppingPosition(int[] rotorSelectedPosition, String[] partSet, String[] steppingPositionSet, String alphabets){

        String steppingPositionLoaded = new String();
        int setSize = Array.getLength(steppingPositionSet);
        String rotorSelected = getAlphabeticalString(rotorSelectedPosition, alphabets);

        //Looking for position
        for(int i = 0; i < setSize; i++){

            if(rotorSelected.equals(partSet[i])){

                steppingPositionLoaded = steppingPositionSet[i];
                System.out.println("Stepping position is [" + steppingPositionLoaded + "]");
                break;

            }

        }

        //Cast the position String into Array of numbers
        int[] steppingPositionArray = getNumberArray(steppingPositionLoaded, alphabets);

        //give feedback
        System.out.println("Load stepping position: " +  java.util.Arrays.toString(steppingPositionArray) + ".");
        System.out.println("");

        return steppingPositionArray;

    }

    /**
     * Function: Setup ring/window position
     */

    public static int getPosition(String alphabets){

        Scanner scan = new Scanner(System.in);
        String inputPosition = scan.nextLine().toUpperCase(); //read input
        int inputSize = inputPosition.length();
        int alphabetsSize = alphabets.length();
        char inputPositionChar;

        boolean validitySize;
        boolean validityString = false;
        boolean validity = false;

        int position = 26;

        //check user input validity
        while(!validity) {

            //check if user entered input of correct size
            validitySize = false; //set to default, change to true later in test.
            while(!validitySize){

                //check if the size is even and no more than 20
                if(inputSize == 1){

                    System.out.println("");
                    System.out.println(inputSize + " position provided.");
                    validitySize = true;
                    System.out.println("");

                } else {

                    System.out.println("");
                    System.out.println("Input invalid, wrong number of positions. Please enter again.");
                    inputPosition = scan.nextLine().toUpperCase(); // reset input
                    inputSize = inputPosition.length(); // reset size

                }

            }

            //Casting input String to char

            inputPositionChar = inputPosition.charAt(0);

            //check if the input is an alphabet
            while (!validityString) {

                for (int i = 0; i < alphabetsSize; i++) {


                    if (inputPositionChar == (alphabets.charAt(i))) {


                        //cast into number position
                        position = i;

                        validityString = true;

                        break;

                    }

                }

                if (validityString) {

                    System.out.println(inputPositionChar + " is a valid position.");

                } else {

                    System.out.println(inputPositionChar + " is an invalid position. Enter again, please.");
                    validityString = false;
                    validitySize = false;
                    inputPosition = scan.nextLine().toUpperCase(); // reset input
                    inputSize = inputPosition.length(); // reset size

                    break;

                }

            }

            //check if the input is valid (all alphabets, even, <=20)
            if (validitySize && validityString) {

                validity = true;
                System.out.println("");
                System.out.println("Valid input, position set to " + position + ".");
                System.out.println("");

            }

        }

        return position;

    }

    /**
     * Function: Insert plugs
     * scan user input and check validity
     *
     * @param alphabets: all alphabets
     * @return insertedPlugs: String of user input
     */

    public static char[] insertPlugs(String alphabets){

        Scanner scan = new Scanner(System.in);
        String insertedPlugs = scan.nextLine().toUpperCase().replaceAll("\\s+",""); //read input
        int plugSize = insertedPlugs.length();
        int alphabetsSize = alphabets.length();

        boolean validitySize;
        boolean validityString = false;
        boolean[] validityCharacter = new boolean[20];

        boolean validity = false;

        //check user input validity
        while(!validity) {

            //check if user entered input of correct size
            validitySize = false; //set to default, change to true later in test.
            while(!validitySize){

                //check if the size is even and no more than 20
                if((plugSize % 2 == 0) && plugSize <= 20){

                    System.out.println("");
                    System.out.println(plugSize + " plugs provided.");
                    validitySize = true;
                    System.out.println("");

                } else {

                    System.out.println("");
                    System.out.println("Input invalid, wrong number of characters. Please enter again.");
                    insertedPlugs = scan.nextLine().toUpperCase(); // reset input
                    plugSize = insertedPlugs.length(); // reset size

                }

            }

            //check if the input are all alphabets
            while (!validityString) {

                //set all characters valid as default, test later

                for(int i = 0; i < 20; i++){

                    validityCharacter[i] = true;

                }

                //check if characters in input match to any alphabet.
                for (int i = 0; i < plugSize; i++) {

                    validityCharacter[i] = false; // default, change later.

                    for (int j = 0; j < alphabetsSize; j++) {


                        if (insertedPlugs.charAt(i) == (alphabets.charAt(j))) {

                            validityCharacter[i] = true;

                        }

                    }

                    if (validityCharacter[i]) {

                        System.out.println(insertedPlugs.charAt(i) + " is a valid character.");

                    } else {

                        System.out.println(insertedPlugs.charAt(i) + " is an invalid character.");

                    }

                }

                //assess matching results

                validityString = true; //set as default. If false, change to false later
                for (int i = 0; i < plugSize; i++) {

                    if (!validityCharacter[i]) {

                        validityString = false;
                        validitySize = false;
                        System.out.println("");
                        System.out.println("Input invalid, invalid characters. Please enter again.");
                        insertedPlugs = scan.nextLine().toUpperCase(); // reset input
                        plugSize = insertedPlugs.length(); // reset size

                        break;

                    }

                }

                if(!validityString){

                    break;

                }

            }

            //check if the input is valid (all alphabets, even, <=20)
            if (validitySize && validityString) {

                validity = true;
                System.out.println("");
                System.out.println("Letters " + insertedPlugs + " are plugged as pairs.");
                System.out.println("");

            }

        }

        //casting
        char[] plugboard = insertedPlugs.toCharArray();

        //feedback
        System.out.println("Plugboard settings: " + java.util.Arrays.toString(plugboard));
        System.out.println("");
        return plugboard;

    }

    /**
     * Function: Read message into char[]
     */

    public static char[] readMessage(String alphabets){

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase().replaceAll("\\s+",""); //read input
        int inputSize = input.length();
        int alphabetsSize = alphabets.length();

        boolean validitySize;
        boolean validityString = false;
        boolean[] validityCharacter = new boolean[500];

        boolean validity = false;

        //check user input validity
        while(!validity) {

            //check if user entered input of correct size
            validitySize = false; //set to default, change to true later in test.
            while(!validitySize){

                //check if the size is even and no more than 20
                if(inputSize > 0 && inputSize <= 500){

                    System.out.println("");
                    System.out.println("Input length is valid.");
                    validitySize = true;
                    System.out.println("");

                } else {

                    System.out.println("");
                    System.out.println("Input invalid, wrong number of characters. Please enter again.");
                    input = scan.nextLine().toUpperCase(); // reset input
                    inputSize = input.length(); // reset size

                }

            }

            //check if the input are all alphabets
            while (!validityString) {

                //set all characters valid as default, test later

                for(int i = 0; i < 500; i++){

                    validityCharacter[i] = true;

                }

                //check if characters in input match to any alphabet.
                for (int i = 0; i < inputSize; i++) {

                    validityCharacter[i] = false; // default, change later.

                    for (int j = 0; j < alphabetsSize; j++) {


                        if (input.charAt(i) == (alphabets.charAt(j))) {

                            validityCharacter[i] = true;

                        }

                    }

                    if (validityCharacter[i]) {

                        System.out.println(input.charAt(i) + " is a valid character.");

                    } else {

                        System.out.println(input.charAt(i) + " is an invalid character.");

                    }

                }

                //assess matching results

                validityString = true; //set as default. If false, change to false later
                for (int i = 0; i < inputSize; i++) {

                    if (!validityCharacter[i]) {

                        validityString = false;
                        validitySize = false;
                        System.out.println("");
                        System.out.println("Input invalid, invalid characters. Please enter again.");
                        input = scan.nextLine().toUpperCase(); // reset input
                        inputSize = input.length(); // reset size

                        break;

                    }

                }

                if(!validityString){

                    break;

                }

            }

            //check if the input is valid (all alphabets, >0, <=500)
            if (validitySize && validityString) {

                validity = true;
                System.out.println("");
                System.out.println("Input: " + input +".");
                System.out.println("");

            }

        }

        //casting
        char[] inputMessageArray = input.toCharArray();

        //feedback
        System.out.println("Typing: " + java.util.Arrays.toString(inputMessageArray));
        System.out.println("");
        return inputMessageArray;

    }

    /**
     * Function: ran char[] through plugboard
     */

    public static char[] runPlugboard(char[] inputArray, char[] plugboard){

        int inputSize = Array.getLength(inputArray);
        int plugSize = Array.getLength(plugboard);

        System.out.println("Running message through plugboard...");

        for(int i = 0; i < inputSize; i++){

            for(int j = 0; j < plugSize; j++){

                if((inputArray[i] == plugboard[j]) && (j % 2 == 0)){

                    System.out.println("Plug " + plugboard[j] + " triggered, switch to " + plugboard[j + 1]);
                    inputArray[i] = plugboard[j + 1];
                    break;

                }

                if((inputArray[i] == plugboard[j]) && (j % 2 == 1)){

                    System.out.println("Plug " + plugboard[j] + " triggered, switch to " + plugboard[j - 1]);
                    inputArray[i] = plugboard[j - 1];
                    break;

                }

            }

        }

        //feedback

        System.out.println("");
        System.out.println("Message output from plugboard is " + java.util.Arrays.toString(inputArray));
        System.out.println("");
        return inputArray;

    }


    /**
     * Function: Turn alphabetical string into number array
     */

    public static int[] getNumberArray(String inputString, String alphabets){

        int inputSize = inputString.length();
        int alphabetsSize = alphabets.length();
        int[] outputArray = new int[inputSize];

        for(int i = 0; i < inputSize; i++){

            for(int j = 0; j < alphabetsSize; j++){

                if(inputString.charAt(i) == alphabets.charAt(j)){

                    outputArray[i] = j;
                    break;

                }

            }

        }

        return outputArray;

    }

    /**
     * Function: Turn number array into alphabetical string
     */

    public static String getAlphabeticalString(int[] inputArray, String alphabets){

        int inputSize = Array.getLength(inputArray);
        int alphabetsSize = alphabets.length();
        char[] letterArray = new char[inputSize];
        int[] alphabetsNumberArray = new int[alphabetsSize];

        for(int i = 0; i < alphabetsSize; i++){

            alphabetsNumberArray[i] = i;

        }

        for(int i = 0; i < inputSize; i++){

            for(int j = 0; j < alphabetsSize; j++){

                if(inputArray[i] == alphabetsNumberArray[j]){

                    letterArray[i] = alphabets.charAt(j);
                    break;

                }

            }

        }

        String letterString = new String(letterArray);
        return letterString;

    }

    /**
     * Function: run through rotor
     */

    public static int runRotor(int input, int[] rotor, int ring, int window){

        //feedback
        System.out.println("Rotor details: " + java.util.Arrays.toString(rotor) + ".");
        System.out.println("ring position: " + ring + "; window position: " + window + ".");
        System.out.print("Input position: " + input + "; ");

        //set output location
        int out = input - ring + window;

        //make sure output location is between 0-25
        while(out > 25){

            out = out - 26;

        }

        while(out < 0) {

            out = out + 26;

        }

        int output = rotor[out] + ring - window;

        while(output > 25){

            output = output - 26;

        }

        while(output < 0){

            output = output + 26;

        }

        //feedback
        System.out.println("output position: " + output + ".");
        System.out.println("");
        return output;

    }

    /**
     * Function: run through rotor reversed
     */

    public static int runRotorReversed(int input, int[] rotor, int ring, int window){

        //feedback
        System.out.println("Rotor details: " + java.util.Arrays.toString(rotor) + ".");
        System.out.println("ring position: " + ring + "; window position: " + window + ".");
        System.out.print("Input position: " + input + ";");

        //seek input position
        int rotorSize = Array.getLength(rotor);
        int out = 26;

        input = input + window - ring;

        while(input > 25){

            input = input - 26;

        }

        while(input < 0){

            input = input + 26;

        }

        for(int i = 0; i < rotorSize; i++){

            if(input == rotor[i]){

                out = i - window + ring;

                break;

            }

        }

        //make sure out is between 0-25

        while(out > 25){

            out = out - 26;

        }

        while(out < 0){

            out = out + 26;

        }

        //update input
        input = out;

        //feedback
        System.out.println(" output position: " + input + ".");
        System.out.println("");
        return input;

    }

}
