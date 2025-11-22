class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int curr_count = 1;
        int max_count = 1;

        if(nums.length == 0) return 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;

            if(nums[i] == nums[i - 1] + 1){
                curr_count++;
                max_count = Math.max(max_count, curr_count);
            }
            else
            curr_count = 1;
        }
        return max_count;      
    }
}