/**
 * Name: John Leonardo
 * Date: 12 February 2018
 * Class: CSC 130
 * File: ArrayStack.java
 */

public class ArrayStack implements DStack {
    
    //initializing the size of the array to be 10
    private int currentSize = 10;
    
    //initialize the array with size of currentSize (10)
    private double[] data = new double[currentSize];
    
    //variable to keep track of the index we're pointed at in the array
    private int cur = 0;
    
    public boolean isEmpty() {
        return (cur == 0); //if cur 0, it's empty
    }
    
    public void push(double d) {
        //increment cur, since we are pushing data to the next index
        cur++;
        
        if (cur <= currentSize) {
            //we can push the data since it does not exceed currentSize
            data[cur - 1] = d;
        } else {
            //we will make new array with doubled size and copy over data
            currentSize *= 2;
            double[] tmp = new double[currentSize];
            
            //copy over data to tmp
            int tmp_cur = 0;
            for (double i : data) {
                tmp[tmp_cur] = i;
                tmp_cur++;
            }
            
            data = tmp;
            
            //then, finally append the data, since our array can fit it now
            data[cur - 1] = d;
        }
        
    }
    
    public double pop() {
        
        //grab the object at the head of the array stack
        double head = data[cur];
        
        //move the cursor down in the stack
        cur--;
        
        return head;
        
    }
    
    public double peek() {
        return data[data.length - 1]; //return the end of the arrayStack
    }
    
}
