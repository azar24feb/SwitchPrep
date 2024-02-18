package src.striver.array;

public class ArrayMedium {
    public static void main(String[] args) {
        maxStockProfit(new int[]{7,9,3,6});
    }

    /**
     * There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements.
     * Without altering the relative order of positive and negative elements, you must return an array
     * of alternately positive and negative values.
     */
    public static void alternateSign(int[] arr){
        for (int i = 0; i < arr.length; i++){

        }
    }

    /**
     * Stock Buy And Sell - maximum profit
     */
    public static void maxStockProfit(int[] prices){
        int max = 0, profit = 0, min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <  min) min = prices[i];
            profit = prices[i] - min;
            if (profit > max) max = profit;
        }
        System.out.println(max);
    }

    /**
     * Kadane’s Algorithm : Maximum Subarray Sum in an Array
     * Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
     * has the largest sum and returns its sum and prints the subarray.
     */
    public static void maxSubarray(int[] arr) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > max)
                max = sum;
            if(sum <= 0)
                sum = 0;
        }
        System.out.println(max);
    }

    /**
     * Given an array of N integers, write a program to return an element that
     * occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
     *
     *  Moore’s Voting Algorithm
     */
    public static void majorityElement(int[] arr){
        int el = arr[0], count = 0;
        for (int i = 0; i<arr.length; i++){
            if (count == 0){
                el = arr[i];
            }
            int i1 = arr[i] == el ? count++ : count--;
        }
        if (count > 0)
            System.out.println(el);
        else
            System.out.println(-1);
    }

    /**
     * Sort an array of 0,1 and 2
     * solution - use 3 pointers, low, mid and high, 0 to low-1 is 0, low to mid is unsorted, to mid-1 is 0, mid to hig
     */

    /**
     * 2 sum problem - Given an array of integers arr[] and an integer target.
     * Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.
     */
    public static void twoSum(int[] arr, int k){
        /**
         * 2 methods - use hashing, and check if the pair is present in the map
         * or sort the array, and check with two pointers from start and end
         */
    }
}
