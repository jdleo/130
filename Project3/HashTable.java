/**
 * Name: John Leonardo, W Reed
 * Course: CSC 130
 * File: WordCount.java
 * Description: This file is a HashTable implementation of DataCounter.
 */
public class HashTable implements DataCounter<String> {
    
    

    /** {@inheritDoc} */
    public DataCount<String>[] getCounts() {
        // TODO Auto-generated method stub
        return null;
    }

    /** {@inheritDoc} */
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
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
