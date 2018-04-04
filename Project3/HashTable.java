/**
 * Name: John Leonardo, W Reed
 * Course: CSC 130
 * File: WordCount.java
 * Description: This file is a HashTable implementation of DataCounter.
 */

import java.lang.Math;      //for pow
import java.math.*;     //for BigInteger

public class HashTable implements DataCounter<String> {
    
    //variable to keep track of the size of this hash table
    //(positions filled only, not table size)
    private int size = 0;
    
    //number of primes for small inputs and relatively large inputs
    //used for table sizes to avoid collisions on quad probing
    private int[] primes = {
    50003, 100003, 200003, 300007, 500009, 1000003
    };
    
    //our actual hashTable, start with lowest prime as tableSize
    private DataCount<String>[] table = new DataCount[primes[0]];

    /** {@inheritDoc} */
    public DataCount<String>[] getCounts() {
        //array of only non-null data counts
        DataCount<String>[] counts = new DataCount[getSize()];
        
        //cursor to keep track of what index we're on
        int cur = 0;
        
        //iterate over table
        for (DataCount<String> x : table) {
            //only take non-null data, we want counts
            if (x != null) {
                counts[cur] = x;
                cur++;
            }
        }
        return counts;
    }

    /** {@inheritDoc} */
    public int getSize() {
        return size;
    }

    /** {@inheritDoc} */
    public void incCount(String data) {
        
        if (getSize() == table.length / 2) {
            //this means table is half filled, we need to resize
            resize();
            insert(data);
        } else {
            //safe to insert data
            insert(data);
        }
    }
    
    /**
     * Helper method to resize table when needed
     */
    public void resize() {
        int newSize = 0;
        for(int size : primes) {
            if (getSize() >= size / 2) {
                //go to next prime
                newSize++;
            }
        }
        //get ref to old table
        DataCount<String>[] oldTable = table;
        
        //resize table to newSize
        table = new DataCount[primes[newSize]];
        
        //copy over all data to new table
        for(DataCount<String> item: oldTable) {
            if (item != null) {
                //insert
                int newIndex = insert(item.data);
                //also copy the count over
                table[newIndex].count = item.count;
            }
        }
    }
    
    /**
     * Helper method to insert data, and increase data count when needed
     * @param data : string to hash and insert in table
     * @return the index we ended up inserting at
     */
    private int insert(String data) {
        //counter to keep track of collisions so far
        int collisions = 0;
        
        //flag to decide if we collided on last insert attempt
        boolean didCollide = true;
        
        //variable to check which index we ended up inserting to
        int index = -1;
        
        //hash our key by converting to int representation and taking mod
        int key = stringToDecimal(data);
        int hash = key % table.length;
        
        //keep trying to insert, using quadratic probing
        //since collisions=0 , it starts h(k) + 0 (normal quad probing)
        while (didCollide) {
            //for every collision add collisions^2 to h(k)
            int desiredIndex = (hash + (int)Math.pow(collisions,2)) % table.length;
            //this means this table position is filled, could be OK tho
            if (table[desiredIndex] != null) {
                if (table[desiredIndex].data.equals(data)) {
                    //position is filled, but its same word. just inc count
                    table[desiredIndex].count++;
                    didCollide = false;
                } else {
                    //COLLISION : position is filled, but different word.
                    collisions++;
                    didCollide = true;
                }
            } else {
                //completely empty position, just insert into desired index
                DataCount<String> item = new DataCount(data, 1);
                table[desiredIndex] = item;
                didCollide = false;
                size++;     //increment data size
                index = desiredIndex;
            }
        }
        
        return index;
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
