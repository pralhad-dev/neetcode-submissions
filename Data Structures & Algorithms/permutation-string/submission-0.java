class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length()>s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (char ch : s1.toCharArray()) {
            s1Freq[ch -'a']++;
        }

        int windowSize = s1.length();
        for (int right =0 ; right <s2.length();right ++) {
            windowFreq[s2.charAt(right) - 'a'] ++;

            if (right >=windowSize) {
                windowFreq[s2.charAt(right - windowSize) - 'a']--;
            }

            if (Arrays.equals(s1Freq,windowFreq)) {
                return true;
            }


        }
        return false;
    }
}
