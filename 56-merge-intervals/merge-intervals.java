class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();

        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] top = stack.peek();
            int[] current = intervals[i];

            if (current[0] <= top[1]) {
                top[1] = Math.max(top[1], current[1]);  
                stack.pop();
                stack.push(top);
            } else {
                stack.push(current);
            }
        }

        int[][] result = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}