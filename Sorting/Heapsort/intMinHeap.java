// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Integer Minimum Heap & Priority Queue
// Date Modified: 02/24/2016
// intMinHeap.java (v1.4)
//
/* This class contains an implementation of a zero-based, minimum heap that stores
   integers and implements a minimum priority queue. This class also features a
   heapsort implementation, which creates a deep copy of the heap prior to sorting
   and also copies the array after being sorted, to restore the previous
   heap-structured array while also returning the sorted array.
*/
// Status: working/testing


import java.io.Serializable;


class intMinHeap implements Serializable {

    private int [] arr;
    private int capacity; // max capacity of heap
    private int size;    // current size of heap

    public intMinHeap(){   // default constructor
        capacity = 100;
        size = 0;
        arr = new int[capacity];
    }

    public intMinHeap(int [] inputArr){   // overloaded constructor
        capacity = inputArr.length*2;  // sets capacity to twice the size of input array
        arr = new int[capacity];
        size = inputArr.length;
        System.arraycopy(inputArr, 0, arr, 0, size);
        buildHeap();
    }

    private int parent(int index) { return (index-1)/2;}  // returns the index of the parent of the given index
    private int left(int index) { return (index*2)+ 1;}   // returns the index of left child of the given index
    private int right(int index) { return (index*2)+ 2;}  // returns the index of left child of the given index

    public boolean isEmpty(){ return (size == 0); }
    public boolean isFull(){ return (size >= capacity); }


    private void buildHeap() {  // converts an array into a heap structure
        if(isEmpty()) return;
        for(int index = size/2; index >= 0; index--) {
            heapify(index);
        }
    }


    private void heapify(int index) {
        // fixes "violations" of heap property caused by deleting/inserting elements.
        while (right(index) < size) {
            int min = minimumOfThree(index, left(index), right(index));
            if (min == index || min <= 0)
                return;
            swap(index, min);
            heapify(min);
        }
    }


    public void heapInsert(int key) {  // inserts a new integer into the heap
        if (isFull()) { return; }
        arr[size] = key+1;
        decreaseKey(size, key);  // correctly places new integer within the heap.
        size++;
    }


    public void decreaseKey(int index, int key) {
        // decreases value of element at index to the given key, if the key is < than current value.
        if(index > 0 && index < size+1) {
            if (arr[index] > key) {
                arr[index] = key;
                while(index > 0 && arr[parent(index)] > arr[index]) {
                    swap(index, parent(index));
                    index = parent(index);
                }
            }
        }
    }


    private void swap(int parent, int child) {
        int temp = arr[child];
        arr[child] = arr[parent];
        arr[parent] = temp;
    }


    public int minimumOfThree(int index, int left, int right) {
        // returns the smallest value between the given index and it's immediate children.
        if(isEmpty() || right > size)
            return 0;        // returns 0 when heap is empty or index does not have both children.
        if(arr[left] < arr[index] && arr[left] < arr[right])
            return left;
        else if (arr[right] < arr[index] && arr[right] < arr[left])
            return right;
        else
            return index;
    }


    public int minimum() {  // returns the smallest integer(root) of the heap
        if(isEmpty()) return 0; // returns 0 on empty heap
        return arr[0];
    }


    public int extractMin() { // returns and removes the root of the heap
        if(isEmpty())
            return 0; // returns (0) on empty heap
        int result = arr[0];
        swap(0, size-1);
        size--;
        heapify(0);
        return result;
    }


    public int[] heapsort() {
        // makes a deep copy of heap and then implements heapsort and returns the sorted array
        // while still maintaining the previously unsorted heap.
        int[] arrCopy = deepCopy(arr); // make copy of arr[] to maintain heap
        for(int i = size-1; i > 1; i--) {
            swap(0, i);
            size--;
            heapify(0);
        }
        size = arrCopy.length;  // resets size variable to length of unsorted heap
        int[] sorted = deepCopy(arr);  // make a copy of the newly sorted arr[]
        arr = deepCopy(arrCopy);  // return arr[] to original pre-sorted state
        return sorted;
    }



    private int[] deepCopy(int[] array) {  // returns a deep copy of the given array
        int[] copiedArr = new int[size];
        System.arraycopy(array, 0, copiedArr, 0, size);
        return copiedArr;
    }


    public String toString() {  // formats the printing of the heap-structured array
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if(!isEmpty()) {
            for(int i = 0; i < size; i++) {
                sb.append(arr[i]);
                sb.append(", ");
            }
            sb.delete(sb.toString().length() - 2, sb.toString().length());
        }
        sb.append("} - size: ");
        sb.append(size);
        return sb.toString();
    }

    public void visualize() {
        System.out.println("\t\t\t   " + arr[0]);
        System.out.print("\t\t" + arr[1]);
        System.out.println("\t\t\t\t" + arr[2]);
        System.out.print("\t" + arr[3] + "\t    " + arr[4]);
        System.out.println("\t\t " + arr[5] + "\t\t " + arr[6]);
        System.out.print("  " + arr[7] + "   " + arr[8] + "  ");
        if(size > 9)
            System.out.print(arr[9] + "   ");
        if(size > 10)
            System.out.print(arr[10] + "    ");
        if(size > 11)
            System.out.print(arr[11] + "   ");
        if(size > 12)
            System.out.print(arr[12] + "    ");
        if(size > 13)
            System.out.print(arr[13] + "   ");
        if(size > 14)
            System.out.print(arr[14] + "   ");
        System.out.println("");
    }
}
