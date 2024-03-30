# DSA

1. Arrays :
===========   
   1.Carry Forward. (Utilizing global variable efficiently)
     Bulb problem
     Leaders in array.
     Pairs count in character combination.
     Max selling price
   2.Rotated Sorted Array (Rotate -> Reverse Entire array -> Then revesre first k required elements -> Then reverse rest of elements.) 
     Search in rotated sorted array.
   
   3.Prefix Sum (For Range querry sum)
     Creating prefix sum/ Suffix sum arrays for approaching range querry sums.
   
   4.Sub_Array
      Nested two loops approach : O(N^2) / Total num of subarray => N(N+1)/2
       * Each subarray sum
       * Even/Odd length subarray sum
       * Sub Array sum with target value.(>= target, <= tagret)
    5.Sub Arrays-2:
      Contribution Technique: 
         * When calculating sum of all kind of approaches.(Sum of all sub arrays)
         * Contribution of each element value is total sum.
         * Formula :
               Element at index (i) contribution in an array arr[];
               Frequency =>  (i+1)*(n-i); (No of time presence of element across all subarrays)
               => arr[i] * frequency;
         * All Odd/Even length subarray sum => O(N)
                 Refer : 1588. Sum of All Odd Length Subarrays(Leetcode)
                 5 8 9 8 5 total times each index was added => k = (i + 1) * (n - i)
                 3 4 5 4 3 total times in odd length array with =>(k + 1) / 2
                 2 4 4 4 2 total times in even length array with => k / 2s
      Sliding window Approach :
         * Subarray with fixed size(k). 
         * Possible total num of subarray size of K in a array of length N => (N-K+1)
         * Min swap required to group related elements like (Numbers <= B)
   6. Majority element present in a array : (Boyer Moore Algorithm)
      
