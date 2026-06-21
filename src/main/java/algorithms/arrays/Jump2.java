package algorithms.arrays;

public class Jump2 {
    public int jump(int[] nums) {

        int jumps = 0;
        int L = 0, R = 0;

        while (R < nums.length - 1) {
            int farthest = 0;
            for (int i=L; i<=R; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            L = R + 1;
            R = farthest;
            jumps++;
        }
        return jumps;
    }
}