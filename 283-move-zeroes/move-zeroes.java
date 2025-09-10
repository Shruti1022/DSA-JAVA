class Solution {
    public void moveZeroes(int[] nums) {
     int init_pos = 0;
     for(int i=0; i<nums.length; i++){
        if (nums[i] != 0){
            nums[init_pos] = nums[i];
            init_pos++;
        }
     }
     while(init_pos < nums.length){
        nums[init_pos++] = 0;
     }
    } 
}



     
        
    