class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Array for lowercase English letters ('a' through 'z')
        // If dealing with Unicode, use a HashMap instead: Map<Character, Integer> map = new HashMap<>();
        int[] charCounts = new int[26];

        // Count characters in s and t
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}