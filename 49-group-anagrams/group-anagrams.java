/*
 * Group Anagrams
 * Pattern : Hashing
 * Approach: Anagrams become identical once their letters are sorted, so the
 *           sorted word is used as the map key for its group.
 * Time    : O(n * k log k) - k = max word length
 * Space   : O(n * k)
 *
 * Also tried: a 26-letter count as the key (groupAnagramsByCount below),
 * which brings the time down to O(n * k).
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    // Alternative: letter frequencies as the key, avoiding the per-word sort.
    public List<List<String>> groupAnagramsByCount(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            groups.computeIfAbsent(Arrays.toString(count), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
