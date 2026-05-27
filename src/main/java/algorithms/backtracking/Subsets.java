package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static List<ArrayList<Integer>> list = new ArrayList<>();
    static void subsets(int[] A, ArrayList<Integer> current, int ind) {
        int N = A.length;

        System.out.println(current);
        list.add(current);// print at every call

        for (int i = ind; i < N; i++) {
            current.add(A[i]);              // Do: add element
            subsets(A, current, i + 1);    // Recursion
            current.remove(current.size() - 1); // Undo: remove last
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        ArrayList<Integer> current = new ArrayList<>();
        subsets(A, current, 0);
        System.out.println(list.size());
    }
}