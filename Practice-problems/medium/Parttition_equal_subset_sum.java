/*
	Leetcode problem URL - https://leetcode.com/problems/partition-equal-subset-sum/description/

*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
		//Check if the sum is odd
        if(sum%2==1){
            return false;
        }
        return isPartitionable(sum/2,nums,nums.length);
    }

    public boolean isPartitionable(int sum , int[] nums, int N){
        // boolean result;
        // if(sum ==0 && N>0){
        //     return true;
        // }
        // if(N==0){
        //     return false;
        // }
        // if(sum>=nums[N-1]){
        //     result= isPartitionable(sum-nums[N-1],nums,N-1) || isPartitionable(sum,nums,N-1);
        // }else{
        //     result = isPartitionable(sum,nums,N-1);
        // }
        // return result;

        boolean dp[][] = new boolean[N+1][sum+1];
        for(int i=1;i<=N;i++){
            dp[i][0]=true;
        }
        for(int i=0;i<=sum;i++){
            dp[0][i]=false;
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(j>=nums[i-1]){
                    dp[i][j]= dp[i-1][j-nums[i-1]]||dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }
}