class Solution {
    private boolean isPossible(int[] nums, int mid, int x){
        return nums[mid] >= x;
    }
    private int lowerBound(int[] nums, int L, int R, int x){
        while(L <= R){
            int mid = (L + R) / 2;
            if(isPossible(nums, mid, x)){
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return L;
    }


    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;

        for(int i=0; i<nums.length; i++){
            int idxL = lowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            int idxR = lowerBound(nums, i + 1, nums.length - 1, upper - nums[i] + 1);
        
            ans += (idxR - idxL)*1L;
        }
        return ans;
    }
}
