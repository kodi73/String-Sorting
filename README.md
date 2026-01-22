# String Sorting Algorithms

This repository contains implementations of string sorting algorithms that do **not rely solely on comparisons.**
It focuses on **Key-Indexed Counting**, which serves as the foundation for **LSD** and **MSD Radix Sorts**.

These algorithms exploit the structure of strings and characters to achieve **better-than-comparison-based performance** in suitable scenarios.

---

## Key-Indexed Counting (Keyed-Index Sort)

Key-Indexed Counting is a **linear-time, stable sorting algorithm** that works under specific constraints.

### When it works

1. The key is a small integer

2. Keys come from a fixed, known range

**Examples**

- Section numbers: 0–5

- ASCII characters: 0–255

- DNA bases: {A, C, G, T} → {0,1,2,3}

### Core idea

If the key range is small, we can use the **key itself as an array index.**

👉 This eliminates comparisons entirely.

### Algorithm phases

Key-Indexed Counting proceeds in **four dependent phases**:

1. **Count frequencies** of each key

2. **Compute cumulative** counts (prefix sums)

3. **Distribute records** into their correct positions

4. **Copy back** to the original array

Each phase is simple, but correctness depends on performing them in this exact order.

### Complexity

**Time Complexity**: O(N + R)

**Space Complexity**: O(N + R)

where:

N = number of items

R = range of keys

In practice, when R ≪ N, this behaves as linear time.

### Properties

- ✅ Stable

- ❌ Not comparison-based

- 🔧 Foundation for radix sorts (LSD and MSD)

## LSD Radix Sort (Least Significant Digit)

LSD Radix Sort sorts strings by processing characters **from the rightmost (least significant) position to the leftmost (most significant) position.**

It uses Key-Indexed Counting as a subroutine at each character position.

### Assumptions

1. All strings have the same fixed length W

2. Alphabet size R is known

### How it works

1. Sort by the last character

2. Then by the second-last character

3. Continue until the first character

Each pass is stable, so earlier order is preserved.

### Complexity

**Time Complexity**: Θ(W · (N + R))
(usually written as Θ(WN) when R ≪ N)

**Space Complexity**: O(N + R)

where:

N = number of strings

W = length of each string

R = alphabet size

### Characteristics

- Always examines every character of every string

- Data-independent performance

- Simple and predictable

## MSD Radix Sort (Most Significant Digit)

MSD Radix Sort processes strings **from the leftmost (most significant) character to the right.**

At each character position d, **strings are grouped by that character.**
Once strings fall into different groups, their **relative order is permanently fixed**.

### Key idea

1. Strings that differ at position d never need to be compared again.

2. This directly mirrors the definition of lexicographic order.

### How it works

1. Group strings by the character at position d

2. Recursively sort each group by position d + 1

3. Stop recursion when:
	
	- Subarray size is small

	- End of string is reached

4. Handling variable-length strings

	Strings shorter than d are treated as having a special end-of-string marker that is smaller than any character.

### Limitations

1. High overhead for small subarrays

2. Large number of recursive calls

3. Costly initialization of counting arrays (especially for large alphabets like Unicode)

### Practical optimizations

1. Cutoff to Insertion Sort for small subarrays (typically size ≤ 15 or 20)

2. Insertion sort compares strings starting at character d, skipping known-equal prefixes

### Complexity

**Worst-case Time Complexity**: Θ(W · (N + R))
(e.g., when all strings are identical)

**Typical / Average Case**:
Θ(N + total characters examined)
**Often sublinear in W·N**

**Space Complexity**: O(N + R)

where:

N = number of strings

W = maximum string length

R = alphabet size

### Characteristics

- Data-sensitive performance

- Examines only as many characters as needed

- Often much faster than comparison-based sorts on real data
