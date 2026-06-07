package algorithms.arrays;

public class RemoveElement3 {

    public static void main(String[] args) {

        int[] a = {0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 5};
        int i = removeElement(a);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
