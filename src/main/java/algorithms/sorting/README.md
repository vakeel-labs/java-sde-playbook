# Sorting Algorithms

Understanding sorting at a deep level — both the algorithms and their trade-offs — is fundamental to DSA and system internals.

## Topics Covered

- Bubble Sort — O(n²), stable
- Selection Sort — O(n²), not stable
- Insertion Sort — O(n²), stable, good for nearly sorted
- Merge Sort — O(n log n), stable, divide and conquer
- Quick Sort — O(n log n) average, in-place, not stable
- Heap Sort — O(n log n), not stable
- Counting Sort — O(n+k), non-comparison
- Radix Sort — O(nk), non-comparison
- Bucket Sort — O(n+k) average
- TimSort — Java's default (hybrid merge + insertion)

## Key Concepts

- Comparison-based lower bound: O(n log n)
- Stable vs unstable sort
- In-place vs extra space
- Best/average/worst case analysis

## Sorting-Based Interview Patterns

- Sort + two pointer
- Sort + binary search
- Custom comparator problems
- Dutch National Flag (3-way partition)
