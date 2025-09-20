class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            int complement = target -nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");

        //  int n = nums.length;

        // int[][] pairs = new int[n][2];
        // for (int i = 0; i < n; i++) {
        //     pairs[i][0] = nums[i]; 
        //     pairs[i][1] = i;       
        // }
        // Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // int left = 0, right = n - 1;
        // while (left < right) {
        //     int sum = pairs[left][0] + pairs[right][0];
        //     if (sum == target) {
        //         return new int[]{pairs[left][1], pairs[right][1]};
        //     } else if (sum < target) {
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        // return new int[]{-1, -1}; 
    }
}