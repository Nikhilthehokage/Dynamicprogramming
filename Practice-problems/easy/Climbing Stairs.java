/**
Leetcode problem url - https://leetcode.com/problems/climbing-stairs/description/

**/

class Solution {
    public int climbStairs(int n) {
        Integer [] nums = new Integer[n+1];
        return climb(n,nums);
    }

    public Integer climb(int n, Integer[]  nums){
		//base condition
        if (n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
		
		// memoization and choices
        if(nums[n-1] ==null){
            nums[n-1]= climb(n-1,nums);
        }
        if(nums[n-2] ==null){
            nums[n-2]= climb(n-2,nums);
        }
        Integer climboneStep= nums[n-1];
        Integer climbtwoStep=nums[n-2];
        return climboneStep+climbtwoStep;
    }
}