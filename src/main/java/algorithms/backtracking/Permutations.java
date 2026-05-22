package algorithms.backtracking;

public class Permutations {

    public static void main(String[] args) {

        char[] A = {'a', 'b', 'c', 'd'};
        int N = A.length;

        boolean[] visited = new boolean[N];  // all false initially
        char[] ans = new char[N];        // empty answer array

        // always start from index 0
        permutation(A, visited, ans, 0);
    }

    private static void permutation(char[] a, boolean[] rst, char[] ans, int end) {

        int N = a.length;

        // Base case: all positions filled → print
        if (end == N) {
            System.out.println(new String(ans));
            return;
        }

        // Try all characters
        for (int i = 0; i < N; i++) {
            if (!rst[i]) {              // valid: not yet used

                rst[i] = true;          // DO: mark as used
                ans[end] = a[i];        // place character

                permutation(a, rst, ans, end + 1);  // recurse

                rst[i] = false;         // UNDO: backtrack
            }
        }

    }
}


/*
Permutations of a Character Array 🔤
The Problem Setup
Given a char array with distinct elements, print all possible permutations without modifying the input array.
Input:  [a, b, c]
Output: abc, acb, bac, bca, cab, cba  → 6 permutations

For n elements → n! permutations
3 elements → 3! = 6 ✅


Building the Intuition 🧠
Think of it like filling seats:
3 seats:  [_]  [_]  [_]

Seat 1 → 3 choices  (a or b or c)
Seat 2 → 2 choices  (remaining)
Seat 3 → 1 choice   (last one left)

3 × 2 × 1 = 6

But how do you know which characters are still available to place?
That's the key question — and the notes solve it using a visited array rst[]

rst[i] = true  → character at index i is already used
rst[i] = false → character at index i is free to pick


 The Recursion Tree 🌳Architected recursion tree visualization with traversal trackingArchitected recursion tree visualization with traversal trackingThe Recursion Tree 🌳
We build the answer array ans[] position by position
ind = which position of ans[] we are currently filling

For [a, b, c]
                    ind=0
              /      |      \
           a         b         c
         ind=1     ind=1     ind=1
         /   \     /   \     /   \
        b     c   a     c   a     b
       ind=2 ind=2 ...
        |     |
        c     b
       abc   acb  ...
At each level:

Loop through all characters in input
Skip if rst[i] = true (already used)
Pick it → mark rst[i] = true → go deeper → unmark (backtrack)


The visited array in action
Picking 'a' first:
rst = [T, F, F]   → b and c still free

  Picking 'b' next:
  rst = [T, T, F]  → only c free

    Picking 'c':
    rst = [T, T, T]  → ans = [a,b,c] ✅ print!

  Unmark 'b' → rst = [T, F, F]
  Picking 'c' next:
  rst = [T, F, T]  → only b free

    Picking 'b':
    rst = [T, T, T]  → ans = [a,c,b] ✅ print!

The same mark → recurse → unmark pattern as Rat in a Maze — just applied differently!
 */