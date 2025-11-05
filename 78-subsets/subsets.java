class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultSet, List<Integer>tempSet, int[] nums, int start){
        resultSet.add(new ArrayList<>(tempSet));

        for(int i = start; i< nums.length; i++){
            tempSet.add(nums[i]);
            backtrack(resultSet, tempSet, nums, i+1);
            tempSet.remove(tempSet.size()-1);
        }
    }
}