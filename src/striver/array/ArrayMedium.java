package src.striver.array;

import java.util.*;

import static src.striver.array.ArraysEasy.*;

public class ArrayMedium {
    public static void main(String[] args) {
//        longestConSeq(new int[]{100,102,105,101,109,108,200,4,6,5,8,9,7,10});
        setMatrixZero(new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,0},{1,1,1,1}});
    }

    /**
     * Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
     */
    public static void rotateMatrix(int[][] matrix){

    }

    /**
     * Set Matrix Zero
     * Problem Statement: Given a matrix if an element in the matrix is 0 then you will
     * have to set its entire column and row to 0 and then return the matrix.
     */
    public static void setMatrixZero(int[][] matrix){
        Set<Integer> l1 = new HashSet<>(), l2 = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    l1.add(i);
                    l2.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (l1.contains(i) || l2.contains(j)){ //instead of using set, use int[] to save time, if (int[i] == 1 || int[j] == 1 )
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));

    }
    /**
     * You are given an array of ‘N’ integers.
     * You need to find the length of the longest sequence which contains the consecutive elements.
     * Input: [100, 200, 1, 3, 2, 4]
     *
     * Output: 4
     *
     * Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
     */
    public static void longestConSeq(int[] arr){
        int[] array = Arrays.stream(arr)
                .sorted().toArray();
        print(array);
        int c = 1, cMax = 0;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i+1] - array[i] == 1){
                c++;
//                System.out.println(c);
                if(c > cMax)
                    cMax = c;
            }
            else c = 1;
        }
        System.out.println(cMax);
    }

    /**
     * Given an array, print all the elements which are leaders.
     * A Leader is an element that is greater than all of the elements on its right side in the array.
     */
    public static void leader(int[] arr){
        // iterate from right, and store the max values
        int max = arr[arr.length - 1];
        List<Integer> res = new ArrayList<>();
        res.add(max);
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i] > max){
                res.add(arr[i]);
                max = arr[i];
            }
        }
        System.out.println(res);
    }

    /**
     * find next lexicographically greater permutation
     * Input format: Arr[] = {1,3,2}
     * Output: Arr[] = {2,1,3}
     * Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}.
     * So, the next permutation just after {1,3,2} is {2,1,3}.
     */


    /**
     * There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements.
     * Without altering the relative order of positive and negative elements, you must return an array
     * of alternately positive and negative values.
     */
    public static void alternateSign(int[] arr) {
        int p = 0, n = 1;
        int[] res = new int[arr.length];
        int temp;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) {
                res[p] = arr[i];
                p+=2;
            }
            else {
                res[n] = arr[i];
                n+=2;
            }
        }

        print(res);
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
