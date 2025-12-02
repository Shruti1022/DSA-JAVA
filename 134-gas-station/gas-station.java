class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int prefixSum = 0;
        int minPrefixSum = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            prefixSum += diff;
            total += diff;

            if (prefixSum < minPrefixSum) {
                minPrefixSum = prefixSum;
                startIndex = (i + 1) % n;
            }
        }

        if (total < 0) return -1;

        return startIndex;
    }
}
