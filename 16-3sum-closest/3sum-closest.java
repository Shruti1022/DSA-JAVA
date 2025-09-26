class Solution {
    public int threeSumClosest(int[] nums, int target) {
     Arrays.sort(nums); 
       int result = nums[0] + nums[1] + nums[2] ;
       int minDiff = Integer.MAX_VALUE;

       for(int i = 0; i<nums.length; i++){
        int left = i+1;
        int right = nums.length -1;

         while(left < right){
            int sum = nums[i] + nums[left] + nums[right];

            if(sum == target){
                return target;
            }
            if(sum < target){
                left++;
            }else
            right --;

            int diffToTarget = Math.abs(sum - target);
            if(diffToTarget < minDiff){
                result = sum;
                minDiff = diffToTarget;
            }
         }
        }
       return result;
    }
}