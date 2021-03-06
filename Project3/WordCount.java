/**
 * Name: John Leonardo, W Reed
 * Course: CSC 130
 * File: WordCount.java
 * Description: The main program that can be executed to count the words in a file, and print the counts in descending order.
 */

import java.io.IOException;
import java.util.*;


public class WordCount {
    
    
    /**
     * Method to count and print words in a given file
     * @param structure : "-b" for BST, "-a" for AVL, "-h" for hashTable
     * @param option : "-frequency" for showing frequencies, "-num_unique" for just showing the num of unique words in any given document
     * @param isTesting : if this function is in test-mode. if so, it will only show performance and no result output.
     */
    private static void countWords(String file, String structure, String option, boolean isTesting) {
        //initialize data structure
        DataCounter<String> counter = new BinarySearchTree<String>();
        
        //keep flag for if we're doing frequency
        //if this is false, it means we just print num_unique on one line
        boolean isFrequency = true;
        
        //variables for start and end times (for testing)
        long start = 0;
        long end = 0;
        
        if (structure.equals("-b")) {
            if (option.equals("-frequency")) {
                //user chose: java WordCount -b -frequency <filename>
                //do nothing: options are already BST and isFrequency
            } else {
                //user chose: java WordCount -b -num_unique <filename>
                isFrequency = false;
            }
        } else if (structure.equals("-a")) {
            if (option.equals("-frequency")) {
                //user chose: java WordCount -a -frequency <filename>
                counter = new AVLTree<String>();
            } else {
                //user chose: java WordCount -a -num_unique <filename>
                counter = new AVLTree<String>();
                isFrequency = false;
            }
        } else if (structure.equals("-h")) {
            if (option.equals("-frequency")) {
                //user chose: java WordCount -h -frequency <filename>
                counter = new HashTable();
            } else {
                //user chose: java WordCount -h -num_unique <filename>
                counter = new HashTable();
                isFrequency = false;
            }
        }
        
        //try to insert every word into our data structure
        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            
            // *** START TIMING IN MILLISECONDS ***
            start = System.currentTimeMillis();
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
            // *** END TIMING ***
            end = System.currentTimeMillis();
            
        } catch (IOException e) {
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }
        
        //only show word-related output if we're not in testing mode
        if (!isTesting) {
            if (isFrequency) {
                DataCount<String>[] counts = counter.getCounts();
                //sort descending
                counts = sortByDescendingCount(counts);
                
                for (DataCount<String> c : counts)
                    System.out.println(c.count + " \t" + c.data);
            } else {
                //just print num unique
                System.out.println("Number of unique words: " + counter.getSize());
            }
        } else {
            //show performance to the user
            //along with the data structure they tested
            String ds = "Binary Search Tree";
            if (structure.equals("-a")) {
                ds = "AVL Tree";
            } else if (structure.equals("-h")) {
                ds = "Hash Table";
            }
            
            //show msg to user
            String msg = String.format("Data Structure: %s\nRuntime for all inserts: %d ms", ds, end-start);
            System.out.println(msg);
        }
        
        
    }
    
    /**
     * Helper method to sort descending word count, and ascending alphabet
     * @param counts : array to sort
     * @return the sorted array
     */
    private static <E extends Comparable<? super E>> DataCount<E>[] sortByDescendingCount(DataCount<E>[] counts) {
        for (int i = 1; i < counts.length; i++) {
            DataCount<E> x = counts[i];
            System.out.println(i);
            System.out.println(counts[i].data);
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (counts[j].count >= x.count) {
                    break;
                }
                counts[j + 1] = counts[j];
            }
            counts[j + 1] = x;
        }
        
        return counts;
    }

    /**
     *  MAIN METHOD
     */
    public static void main(String[] args) {
        
        //string for showing usage to user
        String help = "Usage: java WordCount [ -b | -a | -h ] [ -frequency | -num_unique | -performance ] <filename>";
        
        //we want there to be exactly 3 arguments
        if (args.length != 3) {
            System.err.println(help);
            System.exit(1);
        }
        
        //argument 1 must be [ -b | -a | -h ]
        //argument 2 must be [ -frequency | -num_unique ]
        if ((args[0].equals("-b") || args[0].equals("-a") || args[0].equals("-h")) && (args[1].equals("-frequency") || args[1].equals("-num_unique"))) {
            //pass in args to countWords, handle them there
            countWords(args[2], args[0], args[1], false);
        } else if ((args[0].equals("-b") || args[0].equals("-a") || args[0].equals("-h")) && args[1].equals("-performance")) {
            //testing performance alone
            countWords(args[2], args[0], args[1], true);
        } else {
            //invalid format, show help msg
            System.err.println(help);
            System.exit(1);
        }
    }
}
