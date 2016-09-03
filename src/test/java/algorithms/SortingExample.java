package algorithms;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Snoob on 9/3/2016.
 */
public class SortingExample {
    final static int ARRAY_SIZE = 10000;
    final static boolean printOutput = false;
    public static int[] unsortedArray = new int[ARRAY_SIZE];
    public static int[] sortedArray = new int[ARRAY_SIZE];
    @BeforeClass
    public static void setUp() throws Exception {
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < ARRAY_SIZE; i++) {
            sortedArray[i] = unsortedArray[i] = random.nextInt(ARRAY_SIZE*5);
        }
        Arrays.sort(sortedArray);
        if(printOutput) {
            System.out.println("Original Array: ");
            System.out.println(Arrays.toString(unsortedArray));
        }

    }
    @Test
    public void insertionTest(){
        int[] tmpArray = Arrays.copyOf(unsortedArray, ARRAY_SIZE);
        /*
        Insertion Sorting:
        i: the position working
        from [j:Array_Size] find min then swap
         */
        // Sort from [0:position]
        for (int position = 1; position < ARRAY_SIZE; position++) {
            int j = position;
            //Push it back until correct position
            while(j>0 && tmpArray[j-1]>tmpArray[j]){
                int temp = tmpArray[j];
                tmpArray[j] = tmpArray[j-1];
                tmpArray[j-1] = temp;
                --j;
            }
            if(printOutput) {
                System.out.println("[0:" + position + "] :");
                System.out.println(Arrays.toString(tmpArray));
            }
        }
        Assert.assertArrayEquals(tmpArray,sortedArray);
    }
    @Test
    public void selectionTest(){
        int[] tmpArray = Arrays.copyOf(unsortedArray, ARRAY_SIZE);
        /*
        Selection Sorting:
        from [j:Array_Size] find min then swap
         */
        for (int position = 0; position < ARRAY_SIZE-1; position++) {
            int iMin = position;
            //Find the minimum value from position-Array:size
            for (int  i = position+1; i < ARRAY_SIZE; i++) {
                if (tmpArray[i] < tmpArray[iMin]) {
                    iMin = i;
                }
            }
            //Then swap
            if(iMin != position) {
                int temp = tmpArray[position];
                tmpArray[position] = tmpArray[iMin];
                tmpArray[iMin] = temp;
            }
            if(printOutput) {
                System.out.println("Select at: " + position);
                System.out.println(Arrays.toString(tmpArray));
            }
        }
        System.out.println(Arrays.toString(tmpArray));
        Assert.assertArrayEquals(tmpArray,sortedArray);
    }
    /*
    Buble Sorting:
    From [0 - position] do swap until unable swap
    Every Iteration, position--;
     */
    @Test
    public void bubbleTest(){
        int[] tmpArray = Arrays.copyOf(unsortedArray, ARRAY_SIZE);
        int position = ARRAY_SIZE;
         while(true){
             boolean swapped = false;
             for (int i = 1; i < position; i++) {
                 if(tmpArray[i-1] > tmpArray[i]){
                     int temp = tmpArray[i];
                     tmpArray[i] = tmpArray[i-1];
                     tmpArray[i-1] = temp;
                     swapped = true;
                 }
             }
             --position;
             if(!swapped) break;
             if(printOutput) {
                 System.out.println("Iteration:");
                 System.out.println(Arrays.toString(tmpArray));
             }
         }
        Assert.assertArrayEquals(tmpArray,sortedArray);
    }
}
