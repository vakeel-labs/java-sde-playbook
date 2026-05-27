package algorithms.arrays;

public class MooreAlgo {

    public static void main(String[] args) {

        int[] a = {4, 1, 4, 2, 4, 3, 4};
        int element = a[0];
        int ans = 1;
        for (int i = 1; i < a.length; i++) {

            if (ans == 0) {
                element = a[i];
                ans++;
            } else if (a[i] == element) {
                ans++;
            } else {
                ans--;
            }
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == element) {
                count++;
            }
        }

        if (count > a.length / 2) {
            System.out.println("Hell Found the element " + element);
        } else {
            System.out.println("Sorry Could not found this");
        }

    }

}

/*
Moore's Voting Algorithm 🗳️
What Problem Does It Solve?
Find the element that appears more than N/2 times in an array.
[4, 1, 4, 2, 4, 3, 4]
 N = 7,  N/2 = 3

 4 appears 4 times → 4 > 3 ✅ → 4 is the answer

The Core Intuition 🧠
Imagine an election. If one candidate has more than half the votes, even if all other candidates gang up against them, they still win.
So the idea is:

Cancel every different element against the candidate
If a majority exists, it will survive all cancellations


The Two Variables
javaint element = a[0];   // current candidate
int ans = 1;          // candidate's "strength"
Think of ans as net votes for the candidate

Walking Through Your Array
[4, 1, 4, 2, 4, 3, 4]
ia[i]elementansReason0441initial11401≠4, cancel2441ans=0, new candidate!32402≠4, cancel4441ans=0, new candidate!53403≠4, cancel6441ans=0, new candidate!
4 survives ✅
 */