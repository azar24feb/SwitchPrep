package src.striver.Array;

import java.util.Arrays;

public class ArraysEasy {

    public static void main(String[] args) {
        findSingleElement(new int[] {3,4,1,2,1,2,3});
    }

    //Given a non-empty array of integers arr, every element appears twice except for one.
    // Find that single one.
    /*
    My Sol - Arithemetic approach -
    sum of distint elements - x1 + x2 + x3 + x4 ----- 1
    sum of all elements = 2x1 + 2x2 + 2x3 + x4 ------ 2
    hence 2 (1) - 2 = x4
     */
    /*
    XOR operation a^b , look XOR in google, XOR of all the elements will give the unique element
    two same numbers XOR is 0, XOR of a num with 0 is the num itself
     */
    public static void findSingleElement(int[] arr){
        int reduce = Arrays.stream(arr)
                .reduce(0, (a, b) -> a ^ b);
        System.out.println(reduce);
    }

    //Count max cons ones
    public static void countOne1(int[] arr) {
        int count = 0, maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                count++;
            else if (arr[i] != 1) {
                maxCount = Integer.max(maxCount, count);
                count = 0;
            }
        }
        System.out.println(maxCount);
    }

    //Count Maximum Consecutive One’s in the array
    public static void countOne(int[] arr) {
        int count = 0, maxCount = 0, i = 0, j = 0;
        // start with  i = j = 1, first position of 1, then j++ till j is 0
        // then reset i = j = 0, till i = j = 1, then repeat above step
        while (j < arr.length) {
            if (i == j) {
                if (arr[i] == 1) {
                    count = 1;
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else if (arr[j] == 1) {
                count++;
                j++;
            } else if (arr[j] != 1) {
                i = j;
                maxCount = count;
            }
            System.out.println(count + " : " + maxCount);
        }
        System.out.println(maxCount);
    }

    //union of two sorted arrays
    public static void union(int[] left, int[] right) {
        int lenL = left.length, lenR = right.length, l = lenL + lenR;
        int[] result = new int[l];
        int i = 0, j = 0, k = 0;
        //iterate till one of the array is complete
        while (i < lenL && j < lenR) {
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        //if items left in left arr
        while(i  < lenL){
            result[k++] = left[i++];
        }
        //if items left in right arr
        while (j < lenR){
            result[k++] = right[j++];
        }
        print(result);

    }

    // Important -> 1,2,4,0,0,4,5,0,4,0,1,2 - move all 0 to end and maintain order
    public static void zeroesToEnd(int[] arr){
        int i = 0, j = 1,temp;
        while(j < arr.length){
            if (arr[i] == 0){
                if (arr[j] != 0){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                }
            }
            else{
                i++;
            }
            j++;
        }
        print(arr);
    }

    //reverse an array
    public static void reverse(int[] arr){
        int i = 0, j = arr.length-1;
        int temp = 0;
        while (i < j){
            temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;

        }
        System.out.println(Arrays.toString(arr));
    }

    //Left rotate array by one place
    public static void leftRotateByKPlace(int[] arr, int k) {
        int l = arr.length;
        int[] result = new int[l];
        for (int i=0; i<l; i++){
            if (i < k)
                result[i] = arr[l-k+i];
            /*
            1 2 3 4 5
            5 1 2 3 4
            2 3 4 5 1
             */
            else
                result[i] = arr[i-k];
        }
        System.out.println(Arrays.toString(result));
    }

    //Left rotate array by one place
    public static void leftRotateByNPlace(int[] arr, int n) {

        int count = 0;
        while (count < n) {
            int last = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;
            count++;
        }
        System.out.println(Arrays.toString(arr));

    }

    //##IMP## remove duplicates from a sorted array
    public static void rmvDup(int[] arr) {
        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(arr) + ": i " + i + ": j " + j);
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i + 1] < arr[i])
                return false;
        }
        return true;
    }

    public static void findSecondLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        System.out.println("Max : " + max);
    }

    public static void findLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > max) max = a;
        }
        System.out.println("Max : " + max);
    }

    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
