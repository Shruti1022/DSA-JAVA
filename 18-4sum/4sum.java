class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;

        Arrays.sort(nums); // sort for easier duplicate handling
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate i

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicate j

                int left = j + 1, right = n - 1;
                long target2 = (long) target - (long) nums[i] - (long) nums[j];

                while (left < right) {
                    long sum = (long) nums[left] + (long) nums[right];

                    if (sum == target2) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target2) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}