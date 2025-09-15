class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
       int lastspace = str.lastIndexOf(' ');
        return str.length() - lastspace -1;
    }
}