package ua.mykytenko;

import java.util.Arrays;

public class ArrayUtils {
    public static void main(String[] args) {
        int[][] array = new int[5][8];
        for (int[] anArray : array) {
            fillArrayRndInteger(anArray, 1, 100);
            System.out.println(Arrays.toString(anArray));
        }
        int sum = 0;
        for (int[] a: array) {
            sum += arrayElementsSum(a);
        }
        System.out.println("sum is " + sum);

        int[] array2 = new int[20];
        fillArrayRndInteger(array2, 1, 100);
        System.out.println(Arrays.toString(array2));
        bubbleSort(array2, true);
        System.out.println(Arrays.toString(array2));
        bubbleSort(array2, false);
        System.out.println(Arrays.toString(array2));
        insertionSort(array2, true);
        System.out.println(Arrays.toString(array2));
        insertionSort(array2, false);
        System.out.println(Arrays.toString(array2));
        pickAndDragSort(array2, true);
        System.out.println(Arrays.toString(array2));
        pickAndDragSort(array2, false);
        System.out.println(Arrays.toString(array2));
    }
    public static void fillArrayRndInteger(int[] array, int minValue, int maxValue){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*(maxValue - minValue + 1) + minValue);
        }
    }

    public static int arrayElementsSum(int[] array){
        int sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        return sum;
    }
    
    public static void bubbleSort(int[] array, boolean ascending){
        for (int runCount = 0; runCount < array.length - 1; runCount++) {
            for (int position = 1; position < array.length - runCount; position++) {
                if((array[position] < array[position - 1]) == ascending)
                {
                    swapElements(array, position, position - 1);
                }
            }
        }
    }

    public static void insertionSort(int[] array, boolean ascending){
        for (int runnerPosition = 1; runnerPosition < array.length; runnerPosition++) {
            for (int compareElementIndex = 0; compareElementIndex < runnerPosition; compareElementIndex++) {
                if((array[runnerPosition] < array[compareElementIndex]) == ascending)
                {
                    int buffer = array[runnerPosition];
                    System.arraycopy(array, compareElementIndex, array, compareElementIndex + 1, runnerPosition - compareElementIndex);
                    array[compareElementIndex] = buffer;
                    break;
                }
            }
        }
    }

    public static void pickAndDragSort(int[] array, boolean ascending){
        for (int runCount = 1; runCount < array.length; runCount++) {
            int chosenElement = array[0];
            int chosenElementIndex = 0;
            for (int runnerPosition = 0; runnerPosition < array.length - runCount; runnerPosition++) {
                if((array[runnerPosition] > chosenElement) == ascending){
                    chosenElement = array[runnerPosition];
                    chosenElementIndex = runnerPosition;
                }
                swapElements(array, chosenElementIndex, array.length - runCount);
            }
        }
    }

    public static void swapElements(int[] array, int index1, int index2){
        int buffer = array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;
    }
}
