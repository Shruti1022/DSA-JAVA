class Solution {
    public int longestConsecutive(int[] nums) {
        // Arrays.sort(nums);
        // int curr_count = 1;
        // int max_count = 1;

        // if(nums.length == 0) return 0;

        // for(int i = 1; i < nums.length; i++){
        //     if(nums[i] == nums[i-1]) continue;

        //     if(nums[i] == nums[i - 1] + 1){
        //         curr_count++;
        //         max_count = Math.max(max_count, curr_count);
        //     }
        //     else
        //     curr_count = 1;
        // }
        // return max_count;
            int max_length = 0;
            Map<Integer, Boolean> map = new HashMap<>();

            for(int num : nums){
                map.put(num, Boolean.FALSE);
            } 

            for(int num: nums){
                int curr_length = 1;

                int next_num = num + 1;
                while(map.containsKey(next_num) && map.get(next_num) == false){

                    curr_length ++;
                    map.put(next_num, Boolean.TRUE);
                    next_num++;
                }

                int prev_num = num -1;
                while(map.containsKey(prev_num) && map.get(prev_num) == false){

                    curr_length ++;
                    map.put(prev_num, Boolean.TRUE);
                    prev_num--;
                }

                max_length = Math.max(max_length, curr_length);
            }
            return max_length;
    }
}