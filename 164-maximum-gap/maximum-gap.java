class Solution {
    public static void countSort(int[] nums, int col){
        int[] counts = new int[10];

        int powVal = (int) Math.pow(10, col-1);

        for(int i = 0; i<nums.length; i++){
            int idx = (nums[i] / powVal) % 10;
            counts[idx] = counts[idx] +1;
        }

        int start = 0;
        for(int i = 0; i< counts.length; i++){
            int curr = counts[i];
            counts[i] = start;
            start = start + curr;
        }

        int[] sortedArray = new int[nums.length];

        for(int i = 0; i<nums.length; i++){
            int idx = (nums[i] / powVal) % 10;
            sortedArray[counts[idx]] = nums[i];
            counts[idx] = counts[idx] +1;
        }
        for(int i = 0; i<sortedArray.length; i++){
            nums[i] = sortedArray[i];
        }
    }

    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }

        int max = nums[0];

        for (int num : nums){
            max = Math.max(max, num);
        }

        int width = 0;

        while(max!=0){
            max = max/10;
            width = width + 1;
        }

        for(int i =1; i<= width; i++){
            countSort(nums, i);
        }
        
        int maximum = nums[1] - nums[0];
        
        for (int i = 2; i< nums.length; i++){
            maximum = Math.max(maximum, nums[i] - nums[i-1]);
        }
        return maximum;
    }
}