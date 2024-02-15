package src.striver.array;

import java.util.Arrays;

public class ArraysEasy {

    public static void main(String[] args) {
        zeroesToEnd(new int[] {1,2,4,0,0,4,5,0,4,0,1,2});
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
