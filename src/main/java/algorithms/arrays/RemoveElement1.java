package algorithms.arrays;

public class RemoveElement1 {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {           // <= to handle the meeting point
            if (nums[left] == val) {
                nums[left] = nums[right]; // overwrite bad element with last
                right--;                  // shrink from the right
                // do NOT advance left — the swapped-in element needs checking
            } else {
                left++;                   // this element is good, move on
            }
        }

        return left; // left == number of valid elements
    }
}
