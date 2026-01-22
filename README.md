# String Sorting Algorithms

This repository contains implementations of **string sorting algorithms** that do **not rely solely on comparisons**.

It focuses on **Key-Indexed Counting**, which serves as the foundation for **LSD** and **MSD Radix Sorts**.

These algorithms exploit the structure of strings and characters to achieve **better-than-comparison-based performance** in suitable scenarios.

---
- ## Key-Indexed Counting (Keyed-Index Sort)
  
  Key-Indexed Counting is a **linear-time, stable sorting algorithm** that works under specific constraints.
	- ### When it works
		- The **key is a small integer**
		- Keys come from a **fixed, known range**
		  
		  **Examples**
			- Section numbers: `0–5`
			- ASCII characters: `0–255`
			- DNA bases: `{A, C, G, T} → {0,1,2,3}`
	- ### Core idea
	  
	  If the key range is small, we can use the **key itself as an array index**.
	  
	  👉 This eliminates comparisons entirely.
	- ### Algorithm phases
	  
	  Key-Indexed Counting proceeds in **four dependent phases**:
		- **Count frequencies** of each key
		- **Compute cumulative counts** (prefix sums)
		- **Distribute records** into their correct positions
		- **Copy back** to the original array
		  
		  Each phase is simple, but correctness depends on performing them **in this exact order**.
	- ### Complexity
		- **Time Complexity:** `O(N + R)`
		- **Space Complexity:** `O(N + R)`
		  
		  where:
		  `N` = number of items
		  `R` = range of keys
		  
		  In practice, when `R ≪ N`, this behaves as **linear time**.
- ### Properties
	- ✅ Stable
	- ❌ Not comparison-based
	- 🔧 Foundation for radix sorts (LSD and MSD)
