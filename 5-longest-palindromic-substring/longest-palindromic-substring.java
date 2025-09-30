class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
    //     int start = 0, end = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         int len1 = expandFromCenter(s, i, i);      
    //         int len2 = expandFromCenter(s, i, i + 1);  
    //         int len = Math.max(len1, len2);

    //         if (len > end - start) {
    //             start = i - (len - 1) / 2;
    //             end = i + len / 2;
    //         }
    //     }
    //     return s.substring(start, end + 1);
    // }

    // private int expandFromCenter(String s, int left, int right) {
    //     while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    //         left--;
    //         right++;
    //     }
    //     return right - left - 1;

   String LPS = "";

        for (int i = 0; i < s.length(); i++) {
           
            String odd = expandFromCenter(s, i, i);
          
            String even = expandFromCenter(s, i, i + 1);

            String curr = odd.length() > even.length() ? odd : even;

            if (curr.length() > LPS.length()) {
                LPS = curr;
            }
        }
        return LPS;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
    }