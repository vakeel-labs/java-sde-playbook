package algorithms.greedy;

import javax.crypto.spec.PSource;
import java.util.*;

import static java.util.Arrays.*;

public class ToyProfit {

    public static void main(String[] args) {

        int[] endtime = {3, 1, 3, 2, 3};
        int[] cost = {6, 5, 3, 1, 9};

        int n = endtime.length;
        ArrayList<Pair> pairList = new ArrayList<>();

        for (int i = 0; i < endtime.length; i++) {
            pairList.add(new Pair(endtime[i], cost[i]));
        }

        // Step 2: sort by deadline (A[i]) ascending
        Collections.sort(pairList);


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int t = 0;
        for (Pair pair : pairList) {
            Integer fist = pair.getFist();
            Integer second = pair.getSecond();

            if (t < fist) {
                pq.add(second);
                t++;
            } else {
                Integer peek = pq.peek();
                if (peek < second) {
                    pq.poll();
                    pq.add(second);
                }
            }


        }

        int sum = pq.stream().mapToInt(x -> x).sum();

        System.out.println(sum);


    }


}

class Pair implements Comparable<Pair> {

    Integer fist;
    Integer second;

    public Pair(Integer fist, Integer second) {
        this.fist = fist;
        this.second = second;
    }

    public Integer getFist() {
        return fist;
    }

    public void setFist(Integer fist) {
        this.fist = fist;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return this.fist.compareTo(o.getFist());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "fist=" + fist +
                ", second=" + second +
                '}';
    }
}
/*
# Toy Sale Problem — Deep Intuition Building

## The Core Problem First

You have toys on sale. Each toy:
- Has a **deadline** A[i] — must be bought BEFORE this time expires
- Has a **beauty value** B[i] — the reward you get

Buying one toy takes **1 unit of time**. You start at time T=0.

**Goal: maximize total beauty.**

---

## Why is this Hard? The Conflict.

The brutal truth is: **you can't buy everything.** Time is limited.

So you're forced to make choices. And the wrong choice early on can cost you a lot later.

Let's feel this pain with a tiny example:

```
Toy:      1    2
A =    [  1    1  ]   ← both expire at time 1
B =    [ 10  100  ]   ← toy 2 is WAY more beautiful
```

You're at T=0. You can only buy ONE before time hits 1.

- If you greedily grab toy 1 → beauty = 10 ❌
- If you grab toy 2 → beauty = 100 ✅

**Lesson:** You need to think about WHICH toys to buy, not just CAN I buy this toy.

---

## Why Sort by Deadline A[i]? The Core Intuition

Ask yourself: **"What should I decide first?"**

Toys with **earlier deadlines are more urgent** — their window closes sooner. If you don't consider them early, you'll miss them forever.

Think of it like expiring food in your fridge:

> 🥛 Milk expires tomorrow → decide today
> 🧀 Cheese expires next week → decide later

**If you process toys in deadline order, you never miss a window by accident.** You always know: "right now, at time T, what's available to me?"

### The Concrete Aha Moment:

```
A = [1, 3, 3, 3, 5, 5, 5]  ← after sorting
     ↑
     Must decide this first — window closes at T=1
```

If you had NOT sorted and processed toy with deadline=5 first, you'd be making decisions about toys you have "plenty of time" for, while urgent toys silently expire. Sorting forces you to face urgent decisions first.

---

## The Time Variable T — What Does It Mean?

`T` = the number of toys you've **successfully bought so far** = current time used.

Why? Because each purchase takes 1 unit of time. If you've bought 3 toys, you're at T=3.

**Key insight:** To buy the i-th toy (0-indexed), you need:
```
A[i] > T    (sale end time must be STRICTLY greater than current time)
```

Because you're buying at time T, and it takes until T+1. So the deadline must be at least T+1, meaning A[i] > T.

---

## Walking Through Image 1's Example Step by Step

```
A = [3, 1, 3, 2, 3]
B = [6, 5, 3, 1, 9]
```

**Step 1: Sort by A[i]**

| Toy | A[i] | B[i] |
|-----|------|------|
| 2   |  1   |  5   |
| 4   |  2   |  1   |
| 1   |  3   |  6   |
| 3   |  3   |  3   |
| 5   |  3   |  9   |

**Step 2: Process each toy with T=0**

**Toy 2** → A[i]=1, B[i]=5, T=0
- Is 1 > 0? YES → Buy it. T becomes 1. Heap = {5}

**Toy 4** → A[i]=2, B[i]=1, T=1
- Is 2 > 1? YES → Buy it. T becomes 2. Heap = {1, 5}

**Toy 1** → A[i]=3, B[i]=6, T=2
- Is 3 > 2? YES → Buy it. T becomes 3. Heap = {1, 5, 6}

**Toy 3** → A[i]=3, B[i]=3, T=3
- Is 3 > 3? NO → expired!
- But wait… look at heap minimum = 1
- Is 1 < 3? YES → swap! Remove 1, insert 3
- Heap = {3, 5, 6}

**Toy 5** → A[i]=3, B[i]=9, T=3
- Is 3 > 3? NO → expired!
- Heap minimum = 3
- Is 3 < 9? YES → swap! Remove 3, insert 9
- Heap = {5, 6, 9}

**Answer = 5 + 6 + 9 = 20** ✅

---

## Why the Min-Heap? The Genius Move

This is the trickiest part. Let's build the intuition carefully.

When a toy is **expired** (A[i] ≤ T), you CAN'T just buy it normally. But should you completely ignore it?

**No!** Ask this question:

> "Is this toy MORE beautiful than the LEAST beautiful toy I already bought?"

If yes → **swap them!** Remove the worst past purchase, replace with this better one.

**Why is this valid?** Because you're not changing WHEN you bought things — you're changing WHICH things you bought. The count stays the same (still T toys), the time slots stay the same. You're just retroactively making a better choice.

**Why min-heap specifically?**
- You need the **worst** (minimum beauty) of your current selections instantly
- Min-heap gives you the minimum in O(1)
- Removal + insertion = O(log N)

Think of the heap as your **"current best selection"** — and you're always willing to upgrade by kicking out the weakest member.

---

## The Full Mental Model

```
Sort by deadline → face urgent decisions first

    ┌─────────────────────────────────────┐
    │  For each toy (in deadline order):  │
    │                                     │
    │  Can I buy it? (A[i] > T)           │
    │       YES → buy it, T++, add to heap│
    │                                     │
    │       NO  → is it better than my   │
    │             worst purchase?         │
    │             YES → upgrade (swap)    │
    │             NO  → skip entirely     │
    └─────────────────────────────────────┘

Answer = sum of everything in heap
```

---

## The Key Insight in One Line

> **Sorting ensures you never miss a window. The min-heap ensures you always hold the best possible set of toys of a given size.**

 */