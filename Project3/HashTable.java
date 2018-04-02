/**
 * Name: John Leonardo, W Reed
 * Course: CSC 130
 * File: WordCount.java
 * Description: This file is a HashTable implementation of DataCounter.
 */
public class HashTable implements DataCounter<String> {
    
    //number of primes for small inputs and relatively large inputs
    //used for table sizes to avoid collisions on quad probing
    int[] primes = {11, 503, 1009, 2003, 3001, 5003,
                    10007, 20011, 30011, 50021, 100003};
    
    //our actual hashTable, start with lowest prime as tableSize
    DataCount[] table = new DataCount[primes[0]];

    /** {@inheritDoc} */
    public DataCount<String>[] getCounts() {
        //array of only non-null data counts
        DataCount[] counts = new DataCount[getSize()];
        
        //cursor to keep track of what index we're on
        int cur = 0
        
        //iterate over table
        for (DataCount x : table) {
            //only take non-null data, we want counts
            if (x.data != null) {
                counts[cur] = x;
                cur++;
            }
        }
        return counts;
    }

    /** {@inheritDoc} */
    public int getSize() {
        //variable to keep count for size
        int count = 0;
        
        //iterate through table
        for (DataCount x : table) {
            //if this DataCount data is null, it does not contribute to count
            if (x.data != null) {
                count++;
            }
        }
        
        return count;
    }

    /** {@inheritDoc} */
    public void incCount(String data) {
        // TODO Auto-generated method stub

    }
    
    /**
     * Helper method to digest String to decimal (to format strings for key)
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

}
