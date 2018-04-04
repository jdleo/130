/**
 * Name: John Leonardo, W Reed
 * Course: CSC 130
 * File: Correlator.java
 * Description: The main program that can be executed to count the words in a file, and print the counts in descending order.
 */

public class Correlator {
    
    /**
     *  MAIN METHOD
     */
    public static void main(String[] args) {
        String help = "Usage: java Correlator [ -b | -a | -h ] [-performance] <filename1> <filename2>";
        if (args.length == 3) {
            //user is running with three arguments
            if (args[0].equals("-b") || args[0].equals("-a") || args[0].equals("-h")) {
                //valid usage (NOT TESTING PERFORMANCE)
            } else {
                System.err.println(help);
                System.exit(1);
            }
        } else if (args.length == 4) {
            //user is running with four arguments
            if ((args[0].equals("-b") || args[0].equals("-a") || args[0].equals("-h")) && args[1].equals("-performance")) {
                //valid usage (TESTING PERFORMANCE)
            } else {
                System.err.println(help);
                System.exit(1);
            }
        } else {
            //invalid usage altogether
            System.err.println(help);
            System.exit(1);
        }
    }
}
