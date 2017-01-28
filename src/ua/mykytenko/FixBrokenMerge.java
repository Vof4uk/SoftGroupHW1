package ua.mykytenko;

import java.util.Arrays;
import java.util.LinkedList;

public class FixBrokenMerge {
    public static int[] merge(int[] arr0, int[] arr1) {
        if(arr0 == null || arr1 == null){
            if(arr0 == arr1){
                return null;
            }
            return arr0 == null ? arr1 : arr0;
        }
        int[] newArray = new int[arr1.length + arr0.length];
        int runner0 = 0;
        int runner1 = 0;

        while (runner0 < arr0.length && runner1 < arr1.length) {
            if (arr0[runner0] <= arr1[runner1]) {
                newArray[runner0 + runner1] = arr0[runner0++];
            } else {
                newArray[runner0 + runner1] = arr1[runner1++];
            }
        }

        if (runner0 == arr0.length) {
            System.arraycopy(arr1, runner1, newArray, runner1 + arr0.length, arr1.length - runner1);
        } else if (runner1 == arr1.length) {
            System.arraycopy(arr0, runner0, newArray, runner0 + arr1.length, arr0.length - runner0);
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 6, 8, 13};
        int[] arr0 = {2, 4, 5};
        System.out.println("arr0 - " + Arrays.toString(arr0));
        System.out.println("arr1 - " + Arrays.toString(arr1));

        System.out.println(Arrays.toString(FixBrokenMerge.merge(arr0, arr1)));
    }
}