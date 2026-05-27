package algorithms.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 0, 0, 0 };
        int m = 3;

        int[] b = { 2, 5, 6 };
        int n = 3;

        merge(a, m, b, n);
        System.out.println(Arrays.toString(a)); // [1, 2, 2, 3, 5, 6]
    }

    public static void merge(int[] a, int m, int[] b, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p  = m + n - 1;

        // Compare from the right, place the larger value at position p
        while (p1 >= 0 && p2 >= 0) {
            if (b[p2] >= a[p1]) {
                a[p] = b[p2];
                p2--;
            } else {
                a[p] = a[p1];
                p1--;
            }
            p--;
        }

        // If b still has leftover elements, copy them in
        // (leftover a elements are already in the correct spot)
        while (p2 >= 0) {
            a[p] = b[p2];
            p2--;
            p--;
        }
    }
}