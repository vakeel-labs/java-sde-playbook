package algorithms.arrays;

import java.util.Arrays;

public class RemoveElement2 {

    public static void main(String[] args) {

        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeElement(a);
        System.out.println(Arrays.toString(a));
    }

    public static int removeElement(int[] a) {

        if (a.length == 0) return 0;

        int k = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[k - 1]) {
                a[k] = a[i];
                k++;
            }
        }
        return k;
    }
}


/*
26. Remove Duplicates from Sorted Array
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.


Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */