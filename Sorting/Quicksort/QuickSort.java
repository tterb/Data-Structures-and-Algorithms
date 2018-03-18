// Brett Stevenson
// Email: BStevensonDev@gmail.com
// QuickSort
// Date Modified: 03/03/2016
// QuickSort.java (v2.4)
/*
    This program features a quicksort implementation, capable of using either Lomuto or Hoare's
     partitioning method, as dictated by the command-line arguments. Each of which utilizes a
     median-of-three variant for selecting a pivot element to avoid worst-case performance.
*/
// Status: working/tested



import java.util.ArrayList;
import java.util.Scanner;


public class QuickSort {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            int val = scan.nextInt();
            if(val >= 0)
                list.add(val);
        }

        if(args.length > 0 && args[0].contains("-h"))
            quickSortHoare(list, 0, list.size()-1);  // Hoare's
        else
            quickSort(list, 0, list.size()-1);  // Lomuto's(Default)

        for(int val : list) {    // prints the formatted output
            System.out.printf("%09d", val);
            System.out.println("");
        }
        sortCheck(list);
    }


    private static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    private static void quickSort(ArrayList<Integer> list,int lower, int upper) {
        // Default quicksort implementation using Lomuto's method
        if (list.size() == 0 || lower > upper) return;
        if(upper > lower) {
            if(upper-lower > 5) {// implements median-of-three variable when the given interval is larger than the selected constant
                medianOfThree(list, lower, upper, upper);
            }
            int pivot = partitionLomuto(list, lower, upper);
            quickSort(list,lower, pivot-1);
            quickSort(list,pivot + 1, upper);
        }
    }


    private static void quickSortHoare(ArrayList<Integer> list, int lower, int upper) {
        // Alternative quicksort implementation using Hoare's method
        if (list.size() == 0 || lower > upper) return;
        if (upper > lower) {
            if (upper - lower > 5)
                medianOfThree(list, lower, upper, lower);
            int pivot = partitionHoares(list, lower, upper);
            quickSortHoare(list, lower, pivot);
            quickSortHoare(list, pivot + 1, upper);
        }
    }


    private static void medianOfThree(ArrayList<Integer> list, int lower, int upper, int target) {
        // Returns a more accurate pivot choice to prevent worst-case performance
        int mid = (lower+upper)/2;
        if(list.get(lower) > list.get(mid))
            swap(list, lower, mid);
        if(list.get(lower) > list.get(upper))
            swap(list, lower, upper);
        if(list.get(mid) > list.get(upper))
            swap(list, mid, upper);        // swaps the median value to the middle position
        swap(list, mid, target);         // swaps the median value with the target
    }


    private static int partitionLomuto(ArrayList<Integer> list, int lower, int upper) {
        // partitions the given interval using Lomuto's method
        int pivot = list.get(upper);
        int i = lower - 1;
        for(int j = lower; j < upper; j++) {
            if (list.get(j) <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i+1, upper);
        return i+1;
    }


    private static int partitionHoares(ArrayList<Integer> list, int lower, int upper) {
        // partitions the given interval using Hoare's method
        int pivot = list.get(lower);
        int i = lower - 1;
        int j = upper + 1;
        while(true) {
            do {
                j--;
            } while(list.get(j) > pivot);
            do {
                i++;
            } while(list.get(i) < pivot);

            if (i < j)
                swap(list, i, j);
            else
                return j;
        }
    }


    private static void sortCheck(ArrayList<Integer> list) {
        for(int i = 0; i < list.size()-1; i++) {
            int j = i+1;
            if(list.get(i) > list.get(j)) {
                System.out.println("\tOops! Your array is not sorted :( ");
                System.out.print("arr[" + i +"]: " + list.get(i));
                System.out.println(" > arr[" + j + "]: " + list.get(j));
                System.exit(0);
            } else if(j == list.size()-1 && j >= i) {
                System.out.println("\tYour array is correctly sorted!\n");
                //System.exit(0);
            }
        }
    }

}
