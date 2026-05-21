package algorithms.greedy;

import java.util.*;

public class MaxJobs {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] e = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            pairList.add(new Pair(a[i], e[i]));
        }

        Collections.sort(pairList);
        int second = pairList.get(0).getSecond();
        int count = 1;

        for (Pair pair : pairList) {
            Integer fist1 = pair.getFist();
            Integer second1 = pair.getSecond();

            if (second <= fist1) {
                count++;
                second = second1;
            }


        }

        System.out.println(pairList);
        System.out.println(count);

    }
}


/*
Job Scheduling Problem — Intuition Building
What's the Problem?
N jobs, each with a start time and end time. Only one job can run at a time. Find the maximum number of jobs you can complete.

Why is this Hard? The Conflict.
You can't do all jobs — they overlap. So you must CHOOSE which jobs to take. The wrong choice early blocks many future jobs.
Job 7:  8am ————————————————— 3pm   (7 hours, blocks everything)
Job 1:  9am —— 11am                  (2 hours, frees you up early)
If you greedily pick the longest job → you're blocked for hours. If you pick the shortest-ending job → you're free sooner to take more jobs.

The Core Intuition — Why Sort by End Time?
Ask yourself: "Which job should I pick first?"
Not the shortest job. Not the earliest starting job. The job that ends the earliest.
Why? Because finishing early gives you the maximum remaining time to fit more jobs. Every time you finish a job, you want your next free slot to start as early as possible.
Think of it like meetings in a day:

Meeting A: 9am–11am (ends early, frees you up)
Meeting B: 9am–4pm (ends late, blocks your whole day)

Always pick the one that ends first → maximizes future options.

Walking Through the Timeline Example
Jobs sorted by end time:
Job 1:  9am  → 11am       ✅ take it. free at 11am
Job 4:  10am → 1pm        ❌ starts at 10am, overlaps (10 < 11)
Job 2:  2pm  → 4pm        ✅ starts at 2pm >= 11am. take it. free at 4pm
Job 5:  4pm  → 6pm        ✅ starts at 4pm >= 4pm. take it. free at 6pm
Job 6:  7pm  → 8:30pm     ✅ starts at 7pm >= 6pm. take it. free at 8:30pm
Job 3:  6:30pm→ 9pm       ❌ starts at 6:30pm < 8:30pm, overlaps
Job 8:  8:30pm→ 10pm      ✅ starts at 8:30pm >= 8:30pm. take it. free at 10pm
Job 7:  8am  → 3pm        ❌ already passed
Answer = 5 ✅

Second Example — S=[1,5,8,7,12,13], E=[2,10,10,11,20,19]
Sort by end time:
Job 1: S=1,  E=2   ✅ take it. free at 2
Job 2: S=5,  E=10  ✅ S=5 >= 2. take it. free at 10
Job 3: S=8,  E=10  ❌ S=8 < 10, overlaps
Job 4: S=7,  E=11  ❌ S=7 < 10, overlaps
Job 6: S=13, E=19  ✅ S=13 >= 10. take it. free at 19
Job 5: S=12, E=20  ❌ S=12 < 19, overlaps
Answer = 3 ✅
 */