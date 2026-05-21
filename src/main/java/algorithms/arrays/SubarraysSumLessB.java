package algorithms.arrays;

public class SubarraysSumLessB {
    static int solve(int[] A, int B) {
        int n = A.length;
        int curSum = 0;
        int ans = 0;
        int backPointer = 0;

        for (int i = 0; i < n; i++) {
            curSum += A[i];

            while (curSum >= B && backPointer <= i) {
                curSum -= A[backPointer];
                backPointer++;
            }

            ans += (i - backPointer + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, 15};
        int B = 10;
        System.out.println("Answer: " + solve(A, B)); // Expected: 4
    }
}


/*
Problem 1 — Sliding Window Deep Dive
What are we solving?
Given array A and number B, count subarrays whose sum < B

The Core Idea — "Sliding Window"
Think of it like a rubber band stretched over the array.

Right end (i) always moves forward
Left end (backPointer) shrinks the window when sum gets too big


Example: A = {1, 11, 2, 3, 15}, B = 10
Initial State
A = [ 1,  11,  2,  3,  15 ]
      ↑
   backPointer = 0
   curSum = 0
   ans = 0

Step-by-Step Walkthrough

🔵 i = 0, A[i] = 1
curSum = 0 + 1 = 1
Window: [1]   (backPointer=0, i=0)

Is curSum >= B?  →  1 >= 10?  NO → don't shrink

How many valid subarrays END at index 0?
→ (i - backPointer + 1) = (0 - 0 + 1) = 1

That subarray is: {1}  ✅ sum=1 < 10

ans = 0 + 1 = 1

🔵 i = 1, A[i] = 11
curSum = 1 + 11 = 12
Window: [1, 11]   (backPointer=0, i=1)

Is curSum >= B?  →  12 >= 10?  YES → SHRINK!
  Remove A[0]=1 → curSum = 12 - 1 = 11, backPointer = 1

Is curSum >= B?  →  11 >= 10?  YES → SHRINK AGAIN!
  Remove A[1]=11 → curSum = 11 - 11 = 0, backPointer = 2

Window is now EMPTY (backPointer > i)

How many valid subarrays END at index 1?
→ (i - backPointer + 1) = (1 - 2 + 1) = 0

No valid subarrays end here ❌

ans = 1 + 0 = 1

🔵 i = 2, A[i] = 2
curSum = 0 + 2 = 2
Window: [2]   (backPointer=2, i=2)

Is curSum >= B?  →  2 >= 10?  NO → don't shrink

How many valid subarrays END at index 2?
→ (i - backPointer + 1) = (2 - 2 + 1) = 1

That subarray is: {2}  ✅ sum=2 < 10

ans = 1 + 1 = 2

🔵 i = 3, A[i] = 3
curSum = 2 + 3 = 5
Window: [2, 3]   (backPointer=2, i=3)

Is curSum >= B?  →  5 >= 10?  NO → don't shrink

How many valid subarrays END at index 3?
→ (i - backPointer + 1) = (3 - 2 + 1) = 2

Those subarrays are:
  {2, 3}  ✅ sum=5 < 10
  {3}     ✅ sum=3 < 10

ans = 2 + 2 = 4

🔵 i = 4, A[i] = 15
curSum = 5 + 15 = 20
Window: [2, 3, 15]   (backPointer=2, i=4)

Is curSum >= B?  →  20 >= 10?  YES → SHRINK!
  Remove A[2]=2 → curSum = 20 - 2 = 18, backPointer = 3

Is curSum >= B?  →  18 >= 10?  YES → SHRINK!
  Remove A[3]=3 → curSum = 18 - 3 = 15, backPointer = 4

Is curSum >= B?  →  15 >= 10?  YES → SHRINK!
  Remove A[4]=15 → curSum = 15 - 15 = 0, backPointer = 5

Window is EMPTY again.

How many valid subarrays END at index 4?
→ (i - backPointer + 1) = (4 - 5 + 1) = 0

No valid subarrays end here ❌

ans = 4 + 0 = 4

Final Answer = 4 ✅

Why does (i - backPointer + 1) count subarrays?
At i=3, window is indices [2, 3]
backPointer=2, i=3

Subarrays ENDING at index 3:
  Starting at index 2 → {2, 3}
  Starting at index 3 → {3}

Count = 3 - 2 + 1 = 2  ✓

💡 Key Insight: If the window [backPointer...i] has valid sum,
then ALL subarrays ending at i and starting anywhere
from backPointer to i are also valid!
(because removing elements from front only makes sum smaller)


Visual Summary of all valid subarrays found
A = [ 1,  11,  2,  3,  15 ]
      0    1   2   3    4

✅ {1}       → sum = 1  < 10
❌ {11}      → sum = 11 ≥ 10
❌ {1,11}    → sum = 12 ≥ 10
✅ {2}       → sum = 2  < 10
✅ {3}       → sum = 3  < 10
✅ {2,3}     → sum = 5  < 10
❌ {15}      → sum = 15 ≥ 10
❌ ... all others with 15 are too big

TOTAL = 4 ✅

Why not brute force? (O(n²) vs O(n))
Brute force: check every possible subarray → n*(n+1)/2 checks
For n=100,000 → 5 BILLION checks 😱

Sliding Window: each element is added once, removed once
→ maximum 2n operations
For n=100,000 → 200,000 operations 🚀
 */