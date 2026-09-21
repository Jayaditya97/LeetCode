class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Sort the characters to create a key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add the string to the appropriate group
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}