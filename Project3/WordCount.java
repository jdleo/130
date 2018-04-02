/**
 * Name: John Leonardo, W Reed
 * Course: CSC 130
 * File: WordCount.java
 * Description: The main program that can be executed to count the words in a file, and print the counts in descending order.
 */

import java.io.IOException;
import java.math.*;

public class WordCount {
    
    
    /**
     * Method to count and print words in a given file
     * @param structure : "-b" for BST, "-a" for AVL, "-h" for hashTable
     * @param option : "-frequency" for showing frequencies, "-num_unique" for just showing the num of unique words in any given document
     */
    private static void countWords(String file, String structure, String option) {
        //initialize data structure
        DataCounter<String> counter = new BinarySearchTree<String>();
        
        //keep flag for if we're doing frequency
        //if this is false, it means we just print num_unique on one line
        boolean isFrequency = true;
        
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
                counter = new HashTable<String>();
            } else {
                //user chose: java WordCount -h -num_unique <filename>
                counter = new HashTable<String>();
                isFrequency = false;
            }
        }
        
        if isFrequency {
            //print words along with their frequency
            try {
                FileWordReader reader = new FileWordReader(file);
                String word = reader.nextWord();
                while (word != null) {
                    counter.incCount(word);
                    word = reader.nextWord();
                }
            } catch (IOException e) {
                System.err.println("Error processing " + file + e);
                System.exit(1);
            }
            
            DataCount<String>[] counts = counter.getCounts();
            counts = sortByDescendingCount(counts);
            for (DataCount<String> c : counts)
                System.out.println(c.count + " \t" + c.data);
        } else {
            //print number of unique words
            
        }
        
    }

    /**
     * Method to sort an array of type DataCount in descending order
     * @param counts : the DataCount array object to sort
     * @return the sorted array
     */
    private static <E extends Comparable<? super E>> void sortByDescendingCount(
            DataCount<E>[] counts) {
        
        return counts;
    }

    public static void main(String[] args) {
        
        //string for showing usage to user
        String help = "Usage: java WordCount [ -b | -a | -h ] [ -frequency | -num_unique ] <filename>";
        
        //we want there to be exactly 3 arguments
        if (args.length != 3) {
            System.err.println(help);
            System.exit(1);
        }
        
        //argument 1 must be [ -b | -a | -h ]
        //argument 2 must be [ -frequency | -num_unique ]
        if ((args[0].equals("-b") || args[0].equals("-a") || args[0].equals("-h")) && (args[1].equals("-frequency") || args[1].equals("-num_unique"))) {
            //pass in args to countWords, handle them there
            countWords(args[2], args[0], args[2]);
        } else {
            //invalid format, show help msg
            System.err.println(help);
            System.exit(1);
        }
    }
}
