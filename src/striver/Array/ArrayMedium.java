package src.striver.Array;

import java.util.*;

import static src.striver.Array.ArraysEasy.*;

public class ArrayMedium {
    public static void main(String[] args) {
        countSubarrWithSumK(new int[]{1},0);
//        spiralMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}});
    }

    /**
     * Sort 0,1,2
     * The steps will be the following:
     *
     * First, we will run a loop that will continue until mid <= high.
     * There can be three different values of mid pointer i.e. arr[mid]
     * If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subarray from index 0 to (low-1) only contains 0.
     * If arr[mid] == 1, we will just increment the mid pointer and then the index (mid-1) will point to 1 as it should according to the rules.
     * If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subarray from index high+1 to (n-1) only contains 2.
     * In this step, we will do nothing to the mid-pointer as even after swapping, the subarray from mid to high(after decrementing high)
     *          might be unsorted. So, we will check the value of mid again in the next iteration.
     */

    /**
     *Count Subarray sum Equals K
     * Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
     */
    public static int countSubarrWithSumK(int[] arr, int k) {
        //Watch the video explanation, very good apprach using prefix sum
        // we need to find no of prefix sum where sum = x - k, x is sum till ith index
        int n = arr.length; // size of the given array.
        Map<Integer,Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        System.out.println(cnt);
        return cnt;
    }

    /**
     * Spiral Traversal of Matrix
     * Input: Matrix[][] = { { 1, 2, 3, 4 },
     * { 5, 6, 7, 8 },
     * { 9, 10, 11, 12 },
     * { 13, 14, 15, 16 } }
     * <p>
     * Output: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
     */
    public static void spiralMatrix(int[][] matrix) {
        int noOfElements = matrix.length * matrix[0].length;
        List<Integer> list = new ArrayList<>();
        //We need to loop in 4 directions, forward, down, back and up in a cyclical order, initialize the boundaries
        int colMax = matrix[0].length - 1, colMin = 0, rowMax = matrix.length - 1, rowMin = 0;
        //Iterate the rows and colums in between the boundaries
        int rowCount = 0, colCount = 0, count = 0;
        String direction = "forward";
        /*Everytime you move in a direction, increase the lower limit of that direction
        eg, moving forward from colMin to colMax, increase the colMin
        moving down from rowMin to rowMax, increase the rowMin
        moving back from colMax to colMin, decrease the colMax
        moving up from rowMax to rowMin, decrease the rowMax
        Exception, in the first iteration moving forward,
        don't increase the colMin, because you need to move back from colMax to colMin for the last row*/
        while (count < noOfElements) {
            switch (direction) {
                case "forward":
                    list.add(matrix[rowMin][colCount]);
                    if (colCount == colMax) {
                        if (count > matrix[0].length - 1) { // check if it is the first iteration
                            colMin++;
                        }
                        direction = "down";
                        rowCount++;
                    } else colCount++;
                    break;
                case "down":
                    list.add(matrix[rowCount][colMax]);
                    if (rowCount == rowMax) {
                        rowMin++;
                        direction = "back";
                        colCount--;
                    } else rowCount++;
                    break;
                case "back":
                    list.add(matrix[rowMax][colCount]);
                    if (colCount == colMin) {
                        colMax--;
                        direction = "up";
                        rowCount--;
                    } else colCount--;
                    break;
                case "up":
                    list.add(matrix[rowCount][colMin]);
                    if (rowCount == rowMin) {
                        rowMax--;
                        direction = "forward";
                        colCount++;
                    } else rowCount--;
                    break;
            }
            count++;
        }
        System.out.println(list);
    }

    /**
     * Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
     */
    public static void rotateMatrix(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * Set Matrix Zero
     * Problem Statement: Given a matrix if an element in the matrix is 0 then you will
     * have to set its entire column and row to 0 and then return the matrix.
     */
    public static void setMatrixZero(int[][] matrix) {
        Set<Integer> l1 = new HashSet<>(), l2 = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    l1.add(i);
                    l2.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (l1.contains(i) || l2.contains(j)) { //instead of using set, use int[] to save time, if (int[i] == 1 || int[j] == 1 )
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
     * <p>
     * Output: 4
     * <p>
     * Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
     */
    public static void longestConSeq(int[] arr) {
        int[] array = Arrays.stream(arr)
                .sorted().toArray();
        print(array);
        int c = 1, cMax = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] == 1) {
                c++;
//                System.out.println(c);
                if (c > cMax)
                    cMax = c;
            } else c = 1;
        }
        System.out.println(cMax);
    }

    /**
     * Given an array, print all the elements which are leaders.
     * A Leader is an element that is greater than all the elements on its right side in the array.
     */
    public static void leader(int[] arr) {
        // iterate from right, and store the max values
        int max = arr[arr.length - 1];
        List<Integer> res = new ArrayList<>();
        res.add(max);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
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
            if (arr[i] >= 0) {
                res[p] = arr[i];
                p += 2;
            } else {
                res[n] = arr[i];
                n += 2;
            }
        }

        print(res);
    }

    /**
     * Stock Buy And Sell - maximum profit
     */
    public static void maxStockProfit(int[] prices) {
        int max = 0, profit = 0, min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
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
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max)
                max = sum;
            if (sum <= 0)
                sum = 0;
        }
        System.out.println(max);
    }

    /**
     * Given an array of N integers, write a program to return an element that
     * occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
     * <p>
     * Moore’s Voting Algorithm
     */
    public static void majorityElement(int[] arr) {
        int el = arr[0], count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
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
    public static void twoSum(int[] arr, int k) {
        /**
         * 2 methods - use hashing, and check if the pair is present in the map
         * or sort the array, and check with two pointers from start and end
         */
    }
}
