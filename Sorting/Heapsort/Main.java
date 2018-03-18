// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Integer Minimum Heap & Priority Queue
// Date Modified: 02/24/2016
// Main.java (v1.4)
//
/* This class contains the main method of the program and is responsible for both providing the
   input for the intMinHeap.java class, as well as calling various methods and printing their
   result.
*/
// Status: working/tested



public class Main {


    private static int[] testCase2 = { 5, 1, 2, 4, 9, 8, -1, 6, 10, 7, 0, -8, 3, -7, -2, -9};
    private static int[] emptyCase = { };
    private static int[] fullCase = {7031, 4004, 2150, 1476, 2597, 1364, 5827, 550, 6162, 1649, 7647, 1860, 1718, 3446, 6537, 7903, 8590, 2415, 4388, 3911, 6398, 7643, 2297, 5732, 5613, 1472, 7924, 8820, 7167, 1683, 5725, 890, 4139, 205, 1523, 2982, 839, 3285, 845, 8440, 5954, 7572, 4691, 2582, 4797, 7298, 5621, 4839, 3321, 6774, 7427, 5587, 6350, 6906, 7650, 3849, 2052, 6656, 7551, 7353, 6340, 8622, 3607, 5914, 4664, 353, 1276, 7115, 8054, 2422, 5772, 6696, 8910, 817, 1674, 7091, 8905, 2128, 2166, 1014, 3516, 3472, 2030, 3720, 2522, 2377, 8272, 1332, 8930, 8871, 5119, 3700, 4515, 3632, 5777, 333, 1463, 1121, 4346, 3915, 7479, 2218, 3468, 2836, 6103, 422, 7829, 2957, 1794, 946, 7390, 6702, 6209, 433, 3338, 3839, 4614, 1418, 7583, 2970, 7566, 2268, 1986, 1460, 5471, 6861, 4621, 4421, 7651, 1873, 655, 7991, 6901, 6636, 6778, 2383, 5795, 709, 656, 7509, 5013, 705, 8115, 4949, 2793, 8912, 2930, 5738, 4079, 7248, 1207, 1076, 4339, 4202, 6564, 6509, 6933, 3287, 7943, 6168, 6880, 5478, 4393, 5146, 1714, 1133, 3313, 304, 5172, 6351, 329, 8817, 4767, 703};

    public static void main(String[] args){
        int[] testCase = { 5, 3, 7, 1, 2, 4, 9, 8, 6, 10 };
        System.out.println("Brett Stevenson (bstevens)");
        //System.out.println("Original: {5, 3, 7, 1, 2, 4, 9, 8, 6, 10}");

        intMinHeap heap = new intMinHeap(testCase);

        // print heap & heap size
        System.out.print("Heap: ");
        System.out.println(heap);
        // call extractMin && print
        System.out.print("extractMin(): ");
        System.out.println(heap.extractMin());
        // call extractMin && print
        System.out.print("extractMin(): ");
        System.out.println(heap.extractMin());
        // print heap & heap size
        System.out.print("Heap: ");
        System.out.println(heap);
        // insert(1)
        System.out.println("Inserting:(1)");
        heap.heapInsert(1);
        // print heap & heap size
        System.out.print("Heap: ");
        System.out.println(heap);
        // call heapsort() & print the sorted array
        System.out.print("Sorted: {");
        int[] sorted = heap.heapsort();
        for(int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i]);   // print the returned array
            if(i != sorted.length-1)
                System.out.print(", ");
        }
        System.out.println("} - size: " + sorted.length);

        // print original unsorted heap & heap size
        System.out.print("Heap: ");
        System.out.println(heap);
        heap.visualize();
    }
}


