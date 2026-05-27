package algorithms.backtracking;

public class UniquePermutations {

    static void permute(int[] F, int N, char[] ans, int ind) {

        if (ind == N) {                         // Base case
            System.out.println(new String(ans));
            return;
        }
        for (int i = 0; i <= 25; i++) {         // All Possibilities
            if (F[i] > 0) {                     // Valid Possibility

                F[i]--;                         // Do
                ans[ind] = (char)(i + 'a');
                permute(F, N, ans, ind + 1);    // Recursion
                F[i]++;                         // Undo
            }
        }
    }

    public static void main(String[] args) {

        char[] A = {'a', 'a', 'b'};
        int N = A.length;

        int[] F = new int[26];
        for (char c : A) {
            int ch = 'a';
            F[c - ch]++;
        }

        char[] ans = new char[N];

        permute(F, N, ans, 0);
    }
}

/*
Unique Permutations 🔤
The Problem Setup
Given a char array that may have duplicate elements, print all unique permutations.
Input:  [a, a, b]
Output: aab, aba, baa  → only 3 unique (not 6!)

Normal permutations would give 6, but since two as are identical, many repeat


The Problem with Previous Approach 🤔
If we use the same rst[] visited array approach:
Pick a(index 0) → ... → aab ✅
Pick a(index 1) → ... → aab ❌ DUPLICATE!
Pick b          → ... → baa ✅
Swapping between two identical characters gives the same result — wasted work!

The New Intuition 💡
Instead of tracking which index is used, track how many of each character is still available
Use a frequency array F[] of size 26 (one slot per alphabet letter)
[a, a, b]
F['a'-'a'] = 2   → two a's available
F['b'-'a'] = 1   → one b available
Now at each position, loop through 26 letters, not N indices

If F[i] > 0 → this letter is available → use it → F[i]-- → recurse → F[i]++

Since we iterate by character not by index, duplicates are naturally avoided!

Ready for the recursion tree to see why this works? 👇

The Recursion Tree 🌳Visualized recursive structure for permutation generationVisualized recursive structure for permutation generationThe Recursion Tree 🌳
For [a, a, b]
With frequency array:
F = [a:2, b:1]
                    ind=0
              /           \
           a(F[a]=1)     b(F[b]=0)
            ind=1          ind=1
           /     \           |
        a(F[a]=0) b(F[b]=0) a(F[a]=1)
         ind=2    ind=2       ind=2
           |        |           |
           b        a           a
          aab ✅   aba ✅      baa ✅

Why no duplicates? 🤔
With the old rst[] approach:
ind=0 → pick a(index 0) → ...
ind=0 → pick a(index 1) → ... ← SAME result, different index!
With F[] approach:
ind=0 → pick 'a' → only ONE branch for 'a', regardless of how many a's exist

We pick by character value, not by index
So two identical characters = one single branch ✅


The shift in thinking
Old approachNew approachLoop N indicesLoop 26 lettersrst[i] used?F[i] > 0 available?Skip used indexSkip zero-count letter
 */