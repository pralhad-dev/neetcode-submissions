class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length())
            return "";
    

        HashMap<Character,Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        int left=0;
        int matched =0;
        int start =0;
        int minLen =Integer.MAX_VALUE;

        for (int right =0; right <s.length();right ++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                map.put(ch,map.getOrDefault(ch, 0)-1);

                if(map.get(ch)>=0)
                    matched++;
                
            }

            while(matched == t.length()) {
                
                if(right-left+1 <minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)){
                    map.put(leftChar,map.getOrDefault(leftChar, 0)+1);

                    if(map.get(leftChar)>0) 
                        matched--;
                
                }
                    left++;

            }
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(start,start+minLen);
        
    }
}
