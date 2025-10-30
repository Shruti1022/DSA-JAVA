class Solution {
    public int minDistance(String word1, String word2) {
        int i, j;
        int[][] ansMat = new int[word1.length()+1][word2.length()+1];
        int ans;

        ansMat[0][0] = 0;
       for (i = 0; i <= word1.length(); i++)
         ansMat[i][0] = i;

        for (j = 0; j <= word2.length(); j++)
         ansMat[0][j] = j;

        for(i = 1; i<=word1.length(); i++){
            for(j = 1; j<=word2.length(); j++){
                if(word1.charAt(i-1) != word2.charAt(j-1)){   
                    ansMat[i][j] =Math.min( Math.min(ansMat[i-1][j], ansMat[i-1][j-1]),ansMat[i][j-1]) + 1;
                }
                else{
                ansMat[i][j] = ansMat[i-1][j-1];
                }
            }
        }
        return ansMat[word1.length()][word2.length()];    
    }
}