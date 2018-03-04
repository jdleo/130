/**
 * project2.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */
import java.util.Random;

public class project2 {
    public static void main(String[] args) {
        //test random method for lower and upper bounds
        for(int i = 0; i < 10000; i++) {
            n = rand();
            if (n == 10 || n == 99) {
                System.out.println(n);
            }
        }
    }
}

/**
 * Method for getting a random number in the interval [10,99]
 * @return int : the random number the method generates
 */
public int rand() {
    long seed = System.currentTimeMillis();     //seed for random gen
    Random R = new Random(seed);        //initialize Random class

    return R.nextInt(99 - 10) + 10;     //return random integer w bounds
}
