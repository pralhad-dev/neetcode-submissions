class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs ==null && strs.length ==0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap();

        for(String str : strs) {
            char[] sArray = str.toCharArray();
            Arrays.sort(sArray);
            String key = String.valueOf(sArray);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
