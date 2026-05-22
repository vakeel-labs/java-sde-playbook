package algorithms.backtracking;

public class RatInMaze {

    static boolean solve(int[][] A, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M)
            return false;
        if (A[i][j] == 2)
            return false;
        if (A[i][j] == 1)
            return false;

        if (i == N-1 && j == M-1)
            return true;

        A[i][j] = 2;

        if (solve(A, i+1, j, N, M) ||
                solve(A, i-1, j, N, M) ||
                solve(A, i, j+1, N, M) ||
                solve(A, i, j-1, N, M))
            return true;

        A[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {

        int[][] A = {
                {0, 0, 1},
                {1, 0, 0},
                {1, 1, 0}
        };

        int N = A.length;       // rows
        int M = A[0].length;    // columns

        // always start from (0,0)
        if (solve(A, 0, 0, N, M))
            System.out.println("Path exists!");
        else
            System.out.println("No path found.");
    }
}


/*
Rat in a Maze 🐭
The Problem Setup
Imagine a grid (N×M) where a rat starts at the top-left (0,0) and wants to reach the bottom-right (N-1, M-1).
The grid has two types of cells:

0 → empty, rat can walk here
1 → blocked, rat cannot enter

Goal: Is there any path from start to end?

Building the Intuition 🧠
Think about how you would solve a maze with a pen on paper.

You pick a direction → walk until you hit a wall → go back → try a different direction

That "go back and try another way" is exactly Backtracking.
The rat has 4 choices at every cell:
↓ go down    (i+1, j)
↑ go up      (i-1, j)
→ go right   (i, j+1)
← go left    (i, j-1)
At each step you ask: "Can I go here?"

What Makes a Move Valid?Anticipated request for subsequent procedural requirementsAnticipated request for subsequent procedural requirementsWhat Makes a Move Valid? ✅
Before the rat steps into any cell (i, j), it checks 3 conditions:

Condition 1 — Stay Inside the Maze
i >= 0  &&  i < N  &&  j >= 0  &&  j < M
The rat should never go outside the grid boundaries.

Condition 2 — Don't Revisit
A[i][j] != 2
If the rat already visited a cell (marked as 2), don't go there again.

Why? Otherwise the rat would loop forever — going in circles endlessly.


Condition 3 — Not Blocked
A[i][j] != 1
Can't walk through walls.

All 3 Together → Only Then Move
if(outside)      → return false
if(visited)      → return false
if(blocked)      → return false
✅ else          → move here!

Quick Visual Example
0  0  1
1  0  0
1  1  0
Rat starts at (0,0), wants to reach (2,2)
(0,0) → right → (0,1)
             ↓ right blocked by 1
        down → (1,1)
             → right → (1,2)
                      ↓ down → (2,2) ✅ REACHED!
 */