import java.io.IOException;
import java.math.*;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class WordCount {

    private static void countWords(String file) {
        DataCounter<String> counter = new BinarySearchTree<String>();

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
        sortByDescendingCount(counts);
        for (DataCount<String> c : counts)
            System.out.println(c.count + " \t" + c.data);
    }

    /**
     * TODO Replace this comment with your own.
     * 
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be in alphabetical order (for Strings, that
     * is. In general, use the compareTo method for the DataCount.data field).
     * 
     * This code uses insertion sort. You should modify it to use a different
     * sorting algorithm. NOTE: the current code assumes the array starts in
     * alphabetical order! You'll need to make your code deal with unsorted
     * arrays.
     * 
     * The generic parameter syntax here is new, but it just defines E as a
     * generic parameter for this method, and constrains E to be Comparable. You
     * shouldn't have to change it.
     * 
     * @param counts array to be sorted.
     */
    private static <E extends Comparable<? super E>> void sortByDescendingCount(
            DataCount<E>[] counts) {
        for (int i = 1; i < counts.length; i++) {
            DataCount<E> x = counts[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (counts[j].count >= x.count) {
                    break;
                }
                counts[j + 1] = counts[j];
            }
            counts[j + 1] = x;
        }
    }
    
    /**
     * Helper method to digest String to decimal
     * @param s : string to digest to decimal
     * @return : the int value of the String
     */
    private static int stringToDecimal(String s) {
        String digits = "0123456789ABCDEF";
        
        //convert the string to a hex string
        s = String.format("%040x", new BigInteger(1, s.getBytes()));
        
        //uppercase the hex string
        s = s.toUpperCase();
        
        //convert hex string to decimal
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
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
            if (args[0].equals("-b")) {
                if (args[1].equals("-frequency")) {
                    //user chose: java WordCount -b -frequency <filename>
                } else {
                    //user chose: java WordCount -b -num_unique <filename>
                }
            } else if (args[0].equals("-a")) {
                if (args[1].equals("-frequency")) {
                    //user chose: java WordCount -a -frequency <filename>
                } else {
                    //user chose: java WordCount -a -num_unique <filename>
                }
            } else if (args[0].equals("-h")) {
                if (args[1].equals("-frequency")) {
                    //user chose: java WordCount -h -frequency <filename>
                } else {
                    //user chose: java WordCount -h -num_unique <filename>
                }
            }
        } else {
            System.err.println(help);
            System.exit(1);
        }
    }
}
