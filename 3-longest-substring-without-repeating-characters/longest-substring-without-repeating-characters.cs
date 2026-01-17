public class Solution {
    public int LengthOfLongestSubstring(string s) {
        HashSet<Char> set = new HashSet<Char>();
        int left = 0, maxLen = 0;

        for(int right = 0; right < s.Length; right++){
            while(set.Contains(s[right])){
                set.Remove(s[left]);
                left++;
            }
            set.Add(s[right]);
            maxLen = Math.Max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}