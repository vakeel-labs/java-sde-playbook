package algorithms.greedy;

import java.util.Arrays;

public class MinimumCandi {

    public static void main(String[] args) {

//        int[] a = {1, 5, 2, 1};
        int[] a = {1, 6, 3, 1, 10, 12, 20, 5, 2};
        int[] c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = 1;
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                c[i] = c[i - 1] + 1;
            }
        }

        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                c[i] = Math.max(c[i + 1] + 1, c[i]);
            }
        }

        System.out.println(Arrays.toString(c));


    }
}

/*
The Candy Problem — Intuition Building
What's the Problem?
N children standing in a line, each with a mark (score). Teacher gives candies with two rules:

Every child gets at least 1 candy
If a child has higher marks than their neighbour, they must get more candies than that neighbour

Find the minimum total candies needed.

Why is this Hard? The Conflict.
A child has TWO neighbours — left and right. You have to satisfy BOTH sides simultaneously.
A = [1, 5, 2, 1]
         ↑
    child 2 (marks=5)
    must beat child 1 (left)
    AND must beat child 3 (right)
If you only look left → you might violate the right side. If you only look right → you might violate the left side.

The Three Rules from Your Notes
Rule 1: ∀i, c[i] >= 1 — everyone gets at least 1 candy. Start by giving everyone 1.
Rule 2: if A[i] > A[i-1] then c[i] = c[i-1] + 1 — if you score more than your LEFT neighbour, take one more candy than them. Scan left to right.
Rule 3: if A[i] > A[i+1] then c[i] = max(c[i+1] + 1, c[i]) — if you score more than your RIGHT neighbour, make sure you have more than them. Scan right to left. Use max because rule 2 may have already given you enough.

Why Two Passes? The Core Intuition
One pass is not enough because a child's candy count depends on BOTH sides.
Think of it like this — left to right pass fixes the left relationship. Right to left pass fixes the right relationship. max ensures we never break what the previous pass already correctly set.

Example 1 Walkthrough — A = [1, 5, 2, 1]
Start: c = [1, 1, 1, 1]
Left to right pass (fix left neighbour rule):
i=1: A[1]=5 > A[0]=1 → c[1] = c[0]+1 = 2    c = [1,2,1,1]
i=2: A[2]=2 > A[1]=5? NO                      c = [1,2,1,1]
i=3: A[3]=1 > A[2]=2? NO                      c = [1,2,1,1]
Right to left pass (fix right neighbour rule):
i=2: A[2]=2 > A[3]=1 → c[2] = max(c[3]+1, c[2]) = max(2,1) = 2    c = [1,2,2,1]
i=1: A[1]=5 > A[2]=2 → c[1] = max(c[2]+1, c[1]) = max(3,2) = 3    c = [1,3,2,1]
i=0: A[0]=1 > A[1]=5? NO                                            c = [1,3,2,1]
Answer = 1+3+2+1 = 7 ✅

Example 2 — A = [4,4,4,4,4]
All equal marks → no child scores MORE than neighbour → nobody triggers rule 2 or 3.
Everyone stays at 1 candy. Answer = 5 ✅
 */
