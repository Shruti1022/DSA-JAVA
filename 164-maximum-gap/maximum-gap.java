class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);

        int maximum = nums[1] - nums[0];

        for(int i = 2; i<nums.length; i++){
            maximum = Math.max(maximum, nums[i] - nums[i-1]);
        }
        return maximum;
    }
}