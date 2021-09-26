/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.Timer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort(Config config) {
        this(new BaseHelper<>(DESCRIPTION, config));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    public InsertionSort() {
        this(BaseHelper.getHelper(InsertionSort.class));
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();
        if ((to-from)<=1){
            return;
        }
        for (int i = from+1; i <= to-1; i++){
            for (int j = i; j >= from+1; j--){
                if(helper.swapStableConditional(xs,j)){
                    ;
                }
                else{
                    break;
                }
//                System.out.println("j"+j);
//                boolean flag = helper.swapStableConditional(xs,j);
//                if (flag == false){
//                    break;
//                }
            }
        }
//        System.out.println("after"+ Arrays.toString(xs));
        return;

        // TO BE IMPLEMENTED
    }

    public static final String DESCRIPTION = "Insertion sort";

    public static <T extends Comparable<T>> void sort(T[] ts) {
        new InsertionSort<T>().mutatingSort(ts);
    }
    public static void main(String[] args){
//        Comparable[] sortedarr = {1,2,3,4,5,6,7,8,9};
//        Comparable[] randomarr = {2,5,6,4,8,1,3,9,7};
//        Comparable[] reversedarr = {9,8,7,6,5,4,3,2,1};
//        Comparable[] partarr = {4,5,6,7,1,2,3,8,9};

//        Timer timer = new Timer();
//        int reapeatnum = 10000;
//        InsertionSort insertionSort = new InsertionSort();
//        double totaltime = reapeatnum*timer.repeat(reapeatnum,() ->{
//            insertionSort.sort(sortedarr,0,9);
//            return null;
//        }
//        );
//        System.out.println("time for sorted arary size of 900 is "+totaltime);
//        Timer timer1 = new Timer();
//        totaltime = reapeatnum*timer1.repeat(reapeatnum,() ->{
//                    insertionSort.sort(randomarr,0,9);
//                    return null;
//                }
//        );
//        System.out.println("time for random arary size of 900 is "+totaltime);
//        timer = new Timer();
//        totaltime = reapeatnum*timer.repeat(reapeatnum,() ->{
//                    insertionSort.sort(reversedarr,0,9);
//                    return null;
//                }
//        );
//        System.out.println("time for reversed arary size of 900 is "+totaltime);
        int arrsize = 64000;
        Comparable[] sortedarr = new Comparable[arrsize];
        for (int i = 0; i < arrsize; i++){
            sortedarr[i] = i;
        }

        Comparable[] reversedarr = new Comparable[arrsize];
        for (int i = 0; i < arrsize; i++){
            reversedarr[i] = arrsize-i;
        }

        Comparable[] randomarr = new Comparable[arrsize];
        Random rd = new Random();
        for (int i = 0; i < arrsize; i++){
            randomarr[i] = rd.nextInt();
        }

        Comparable[] partarr = new Comparable[arrsize];
        for (int i = 0; i < arrsize/2; i++){
            partarr[i] = i;
        }
        for (int i = arrsize/2; i < arrsize; i++){
            partarr[i] = rd.nextInt();
        }


        InsertionSort insertionSort = new InsertionSort();


        long startTime = System.nanoTime();
        insertionSort.sort(sortedarr,0,arrsize);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("time for sorted array = "+totalTime/1000000+" milliseconds with n = "+arrsize);


        startTime = System.nanoTime();
        insertionSort.sort(reversedarr,0,arrsize);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("time for reversed array = "+totalTime/1000000+" milliseconds with n = "+arrsize);


        startTime = System.nanoTime();
        insertionSort.sort(randomarr,0,arrsize);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("time for random array = "+totalTime/1000000+" milliseconds with n = "+arrsize);


        startTime = System.nanoTime();
        insertionSort.sort(partarr,0,arrsize);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("time for partially random array = "+totalTime/1000000+" milliseconds with n = "+arrsize);





    }
}
