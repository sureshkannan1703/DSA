# DSA Handwritten notes:

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
      Kadan's Algorithm :
         * Max Sub array sum :
               Nested 3 loops O(N^3); Prefix sum approach -> O(N^2) : O(N); Carry forward -> O(N^2) : O(1);
               Kadan's Algorithm : O(N) : O(1);
                  Iterate on Array Update max variable, if sum goes <0 make sum = 0;
   6. Majority element present in a array : (Boyer_Moore Algorithm)
   7. Prefix max/Suffix Max Calculation :
         * Water trapped on each building top:
             Left tall building from current building - prefix max.
             Right tall building from current building - suffix max.
             height level = min(leftmax,rightmax);
             water level = heightlevel - building height;
   8. Zero querries + Psum Combination :
         * Fill querry val at start index, after end index put neagative value of the value.(to avoid it in psum calc after its end index).
   9. Subsequences :
         * Elements to be arranged in increasing index order.
         * Possible subsequnces count for an array of size n => 2^n;
         * We can generate all subsequences/sum via bitwise operation approach;  T:C=> O(n*2^n)
         * Sum of the max element present in every subsequence :
         *  Element arr[i] is max element in (2^i) no of subsequences. i-> No of elements < arr[i] in the given input array.
         *  So,we can approach this problem by sort the given input array.(In sorted array -> left hand side elements are smaller elements of current element)
         *  If we reverse the sorted array -> Sum of the min element present in every subsequence.

2D-Arrays :
=========== 
   1. Print matrices - spiral/rectangler.
   2. Sum/Subtract/multiply 2d matrices.
   3. Prefix sum calculation on 2d matrix/Range querry problem on 2d matrices :
      * Input 2D array => Row wise psum => Column wise calculation.
      * Neglect unnecessary psum cell values from overall psum array while calculating psum for particular range.
   4. Search in row wise column wise sorted 2d matrix;
         Iterate on first row from last cell;
         if(cellvalue==targetvalue) return target value;
         if(cellvalue < targetvalue) -> Move to next row;
         else if((cellvalue > targetvalue) -> Iterate over the current row;
   5. Contribution technique on 2d array matrix :
      * Sum of all submatrices sum :
        Contribution of (i,j) cell value across all submatrices TL*BR => (i+1)(n-i)(j+1)(m-j)
        i-row; j-col; n-total rows; m - total columns;
        (i+1)(n-i) -> represents how many TL submatrix contains the (i,j).
        (j+1)(m-i) -> represents how many BR submatrix contains the (i,j).
         So,
        iterate on all cells => sum = sum + (TL) * (BR) * matrix[i][j];
      *Calculate max of all subarray sum -> Prefix sum + global variable approach.
