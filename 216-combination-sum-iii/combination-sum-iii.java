class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int remaining,
                           List<Integer> path,
                           List<List<Integer>> result) {

        if (k == 0 && remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (k == 0 || remaining < 0) return;

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(i + 1, k - 1, remaining - i, path, result);
            path.remove(path.size() - 1); 
        }
    }
}