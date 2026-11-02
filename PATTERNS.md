# Pattern Notes

These are my notes on the techniques that come up most often in this repository.
For each one I've written down how to recognise it, the template I start from,
and the problems where I used it.

---

## Hashing

**Use it when:** you need to ask "have I seen this before?" or "how many times?"
in O(1).

- Store value → index (Two Sum), value → count (Good Pairs) or a canonical key
  → group (Group Anagrams).
- If the values are small (letters, 0–100), an `int[]` is faster than a
  `HashMap`.

```java
Map<Integer, Integer> seen = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    if (seen.containsKey(target - nums[i])) { /* found */ }
    seen.put(nums[i], i);
}
```

Problems: Two Sum, Contains Duplicate I/II, Valid Anagram, Group Anagrams,
Number of Good Pairs, Check if the Sentence Is Pangram.

---

## Two Pointers

**Use it when:** the array is sorted, you are comparing both ends, or you must
modify an array in place.

| Variant | Idea | Example |
|---|---|---|
| Opposite ends | move the pointer that makes the condition worse | Two Sum II, Valid Palindrome |
| Read / write | `write` marks the end of the kept prefix | Remove Duplicates, String Compression |
| Fill from the back | avoid overwriting data you still need | Merge Sorted Array |
| Fast & slow | cycle detection in an implicit linked list | Find the Duplicate Number |

---

## Sliding Window

**Use it when:** you need the best contiguous subarray or substring that
satisfies a condition.

```java
int left = 0;
for (int right = 0; right < n; right++) {
    add(right);
    while (windowIsInvalid()) remove(left++);
    best = Math.max(best, right - left + 1);
}
```

Each element enters and leaves the window at most once, so the total is O(n).

Problems: Longest Substring Without Repeating Characters.

---

## Binary Search

**Use it when:** the search space is *monotonic*: once a condition becomes true,
it stays true.

- Always use `mid = lo + (hi - lo) / 2` to avoid overflow.
- **Find exact value:** `while (lo <= hi)`, return on match.
- **Find boundary:** on a match, record the answer and keep going left/right
  (First Bad Version, First and Last Position).
- **Rotated arrays:** find the pivot first, then search the right half.
  With duplicates, shrink both ends when `start == mid == end`.
- **Mountain arrays:** find the peak, then do an order-agnostic search on each side.
- **Binary search on the answer:** when you can test "is k enough?" and the
  answer only flips once (Sqrt(x), Arranging Coins, Zero Array Transformation II).
- **2-D matrix:** a fully sorted matrix is one virtual array, so use
  `(mid / cols, mid % cols)`. A row/column-sorted matrix uses the
  staircase search from the top-right corner instead.

---

## Prefix Sum & Difference Array

**Prefix sum** answers "sum of a range" in O(1) after an O(n) pass.

**Difference array** is the reverse: it applies "add v to the range [l, r]" in
O(1), and a prefix sum at the end recovers the values.

```java
int[] diff = new int[n + 1];
for (int[] q : queries) {
    diff[q.l] += q.v;
    diff[q.r + 1] -= q.v;
}
for (int i = 1; i < n; i++) diff[i] += diff[i - 1];
```

- If the coordinates are huge or sparse (My Calendar, Car Pooling, Max Frequency
  II), use a `TreeMap<Integer, Integer>` instead of an array. That's the
  **line sweep** version.
- If the question is "minimum number of queries needed", combine it with
  binary search on the answer (Zero Array Transformation II).

Problems: Corporate Flight Bookings, Car Pooling, My Calendar II/III, Describe
the Painting, Shifting Letters II, Increment Submatrices by One, Maximum
Population Year, Zero Array Transformation I/II, Maximum Frequency After
Operations I/II, Maximum Sum Obtained of Any Permutation.

---

## Cyclic Sort

**Use it when:** the array holds numbers from a known range like `[1, n]` or
`[0, n]` and you are looking for missing or duplicate numbers.

```java
int i = 0;
while (i < n) {
    int correct = nums[i] - 1;
    if (inRange(nums[i]) && nums[i] != nums[correct]) swap(nums, i, correct);
    else i++;
}
// any index i with nums[i] != i + 1 is where something is missing or duplicated
```

Problems: Missing Number, Find All Numbers Disappeared, Find All Duplicates,
Set Mismatch, First Missing Positive.

---

## Kadane's Algorithm

**Use it when:** you need the maximum (or minimum) subarray sum.

Keep the best sum *ending at the current index*: either extend the previous
subarray or start over at the current element. Running Kadane twice, once for
the max and once for the min, gives the maximum absolute sum.

Problems: Maximum Subarray, Maximum Absolute Sum of Any Subarray.

---

## Matrix Techniques

- **Boundaries:** walk the edges and shrink inward (Spiral Matrix).
- **Index mapping:** `(i, j) → (j, n - 1 - i)` rotates 90° clockwise, and a flat
  index `k → (k / cols, k % cols)` lets you reshape or binary search.
- **Row/column counters** instead of a full simulation (Cells with Odd Values).

---

## Tree DFS

**Post-order** traversal lets a node combine results from its children. Return
a small tuple (for example `{sum, count}`) so every node is visited only once.

Problems: Count Nodes Equal to Average of Subtree.
