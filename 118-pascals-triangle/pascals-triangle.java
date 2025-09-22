class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> triangle = new ArrayList<>();
         if(numRows == 0) return triangle;
         
         List<Integer> firstRow = new ArrayList<>();
         firstRow.add(1);
         triangle.add(firstRow);
         if (numRows == 1) return triangle;

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i-1);

            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < i-1; j++) {
                    row.add(prevRow.get(j) + prevRow.get(j+1));
                }
                row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}