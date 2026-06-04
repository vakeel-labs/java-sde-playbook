package algorithms.arrays;

public class RemoveElement3 {

    public static void main(String[] args) {

        int[] a = {0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 5};
        int i = removeElement(a);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0; // Writer pointer — how many valid elements written

        for (int i = 0; i < nums.length; i++) {  // Reader pointer
            // Write if: fewer than 2 written OR current != what was written 2 steps ago
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k] = nums[i];  // Writer writes
                k++;                 // Writer moves forward
            }
            // else: skip (Reader moves forward, Writer stays)
        }

        return k; // Length of valid portion
    }
}
