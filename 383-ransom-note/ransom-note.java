class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0) return true;

        Map <Character, Integer> hm = new HashMap<>();
        int j =0;
        int i =0;

        for(i=0; i< magazine.length(); i++){
            char ch = magazine.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0) + 1);  
        }
        
        for(j = 0; j<ransomNote.length(); j++){
            char ch = ransomNote.charAt(j);
        if(!hm.containsKey(ch)) return false;
        if(hm.get(ch) == 0) return false;
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) - 1);
            }

        }
        return true;
    }
}