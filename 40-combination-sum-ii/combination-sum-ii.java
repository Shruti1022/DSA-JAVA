class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        List<int[]> freq = new ArrayList<>();
        for (int num : candidates) {
            if (freq.isEmpty() || freq.get(freq.size() - 1)[0] != num) {
                freq.add(new int[]{num, 1});
            } else {
                freq.get(freq.size() - 1)[1]++;
            }
        }

        backtrack(freq, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(List<int[]> freq, int index, int remaining,
                           List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index == freq.size() || remaining < freq.get(index)[0]) {
            return;
        }

        int[] pair = freq.get(index);
        int num = pair[0];
        int count = pair[1];

        backtrack(freq, index + 1, remaining, current, result);

        for (int i = 1; i <= count && i * num <= remaining; i++) {
            current.add(num);
            backtrack(freq, index + 1, remaining - i * num, current, result);
        }

        for (int i = 1; i <= count && i * num <= remaining; i++) {
            current.remove(current.size() - 1);
        }
    }
}