package algorithms.arrays;

public class RemoveElement3 {

    public static void main(String[] args) {

        int[] a = {0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 5};
        int i = removeElement(a);
        System.out.println(i);
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
