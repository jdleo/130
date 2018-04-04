/**
 * Name: John Leonardo, W Reed
 * Course: CSC 130
 * File: Correlator.java
 * Description: The main program that can be executed to count the words in a file, and print the counts in descending order.
 */

import java.io.IOException;
import java.util.*;


public class Correlator {
    
    /**
     * Method that performs that stores, and finds correlations between words in two documents
     * @param file1 : the first file
     * @param file2 : the second file
     * @param structure: the data structure to use
     * @param isTesting : if this function is in test-mode. if so, it will show performance in ms
     */
    private static void correlate(String file1, String file2, String structure, boolean isTesting) {
        
        long startInserts = System.currentTimeMillis();
        //create data structure from file 1
        DataCounter<String> counter1 = createDataStructure(file1, structure);
        
        //create data structure from file 2
        DataCounter<String> counter2 = createDataStructure(file2, structure);
        long endInserts = System.currentTimeMillis();
        
        
        long startCorrelate = System.currentTimeMillis();
        //get correlation score between both documents
        score(counter1, counter2);
        long endCorrelate = System.currentTimeMillis();
        
        //if we're in testing mode, show runtimes to user
        if (isTesting) {
            
        }
        
    }
    
    /**
     * Method to give a correlation score between two data structures
     * @param d1 : the first data structure (the one we traverse)
     * @param d2 : the second data structure
     */
    private static void score(DataCounter<String> ds1, DataCounter<String> ds2) {
        
        //get the DataCount objects for both data structures
        DataCount<String>[] counts1 = ds1.getCounts();
        DataCount<String>[] counts2 = ds2.getCounts();
        
        //get the sizes (unique word count) of each DS
        int size1 = ds1.getSize();
        int size2 = ds2.getSize();
        
        //running total for total euclidian distance
        double totalDistance = 0.0;
        
        //traverse the first data structure
        for (DataCount<String> i : counts1) {
            //traverse second data structure to see if we can find it
            for (DataCount<String> j : counts2) {
                if (i.data.equals(j.data)) {
                    //found the word in the second DataStructure
                    
                    //first, take normalized frequencies
                    double frequency1 = (i.count / (double)size1);
                    double frequency2 = (j.count / (double)size2);
                    
                    //then add euclidian distance to the running total
                    double difference = frequency1 - frequency2;
                    totalDistance += Math.pow(difference,2);
                    
                    break;  //break inner loop
                }
            }
        }
        
        System.out.println("CORRELATION SCORE: " + totalDistance);
    }
    
    /**
     * Method to create data structure from given file
     * @param file : the file to create the DS from
     * @param structure : "-b" for BST, "-a" for AVL, "-h" for hashTable
     * @return the data structure with the data filled in
     */
    private static DataCounter<String> createDataStructure(String file, String structure) {
        //initialize empty data structure
        DataCounter<String> counter = new BinarySearchTree<String>();
        
        if (structure.equals("-a")) {
            //user chose AVL data structure
            counter = new AVLTree<String>();
        } else if (structure.equals("-h")) {
            //user chose Hash Table data structure
            counter = new HashTable();
        }
        
        //try to insert every word into our data structure
        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            //something went wrong
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }
        
        //return our data structure with all the word counts filled in
        return counter;
    }
    
    /**
     *  MAIN METHOD
     */
    public static void main(String[] args) {
        String help = "Usage: java Correlator [ -b | -a | -h ] [-performance] <filename1> <filename2>";
        if (args.length == 3) {
            //user is running with three arguments
            if (args[0].equals("-b") || args[0].equals("-a") || args[0].equals("-h")) {
                //valid usage (NOT TESTING PERFORMANCE)
                correlate(args[1], args[2], args[0], false);
            } else {
                System.err.println(help);
                System.exit(1);
            }
        } else if (args.length == 4) {
            //user is running with four arguments
            if ((args[0].equals("-b") || args[0].equals("-a") || args[0].equals("-h")) && args[1].equals("-performance")) {
                //valid usage (TESTING PERFORMANCE)
                correlate(args[2], args[3], args[0], true);
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
