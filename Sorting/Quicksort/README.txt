COMMAND-LINE PARAMETER:
    By default, if no parameter is given, the program will use Lomuto's
    partitioning method. Although, If the program is run with the
    command-line parameter, "-h", the program will proceed
    using Hoare's partitioning method.


Algorithm Analysis:

    The primary differences between Lomuto and Hoare's partitioning methods are that while Lomuto's method partitions around the last element of the presented array and scans from left to right, performing individual swaps. Hoare's method partitions around the first element of the array and scans from both ends until meeting at the center, only swapping misplaced pairs.
    On average, when presented with an array of random unsorted integers, the two methods will behave similarly, as both are capable of partitioning an array of length (n) using (n-1) comparisons and providing comparable O(n lgn) performance, although Hoare's method will require less swaps since it only swaps misplaced pairs. Similarly, both methods also benefit from the implementation of a median-of-three variant, as it protects both methods from selecting a pivot that would cause worst-case behavior, particularly in a pre-sorted array.

Pre-sorted Set:
    Additionally, when presented with a pre-sorted array, Lomuto's method will nonetheless perform multiple unnecessary swaps, where Hoare's method will not perform any unnecessary swaps as it will recognize that there are no misplaced pairs. (Unless the median-of-three variant has already misplaced a set of values)

Repeating Set:
    When presented with an array with repeating/equal elements, both partitioning methods perform unnecessary swaps, although Hoare's method will out perform Lomuto's as it will only perform one unnecessary swap for each pair of repeated elements. As a result, when presented with an array containing only a single repeated integer, both methods will be observed at their worst case. Though Hoare's method will perform better than Lomuto's, due to the fact that while Hoare's method will swap every pair the two sides will always meet in the middle, preserving it's O(n lgn) performance. Whereas Lomuto's method will swap every single element in the list because "arr[j] <= pivot" will always be true, causing it's performance to decrease to O(n^2).

    Conclusively, while Lomuto's partitioning method is easier to implement and in many cases performs similarly to Hoare's, there are some cases in which the performance of Lomuto's method to degrades to O(n^2), whereas Hoare's method guarentees that a maximum of (n/2) swaps will occur.





    Comparisons --> Both methods can be implemented using (n−1) comparisons to partition an array of length (n).
    This is essentially optimal, since we need to compare every element to the pivot for deciding where to put it.

    # of Swaps --> random
    Hoare --> guarentees that a maximum of n/2 swaps will occur

    Lomuto --> scans from left to right
    Hoare -- > scans from both ends to center

    Lomuto --> partitions around last element of subarray
    Hoare --> partitions around first element of subarray

    Hoare --> The upper and lower indices move towards each other until they cross, which if correctly implemented,should always be the pivot. the process of which, divides the array into two upper and lower pieces. At which time, pairs of misplaced values from each side are swapped to their correct sides.

    Although, when presented an already sorted array, Lomuto's method will still perform it's initial swaps, whereas Hoare's method will not perform any unnecessary swaps as it will recognize there are no misplaced pairs.

    When presented with an array containing only zeros, we will observe both methods at their worst case, though Hoare's method will have increased performance over Lomuto's, due to the fact that while Hoare's method will swap every pair the two sides will always meet at the middle, preserving it's O(n logn)performance.
    Whereas Lomuto's method will swap every single element in the list, causing it's performance to decrease to O(n^2).

    Conclusively, while Lomuto's method is both easier implement and comparable in performance to Hoare's, as previously
    expressed, in some specific cases Hoare's method will provide an increased performance.