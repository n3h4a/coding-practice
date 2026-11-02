/*
 * Check if the Sentence Is Pangram
 * Pattern : Hashing
 * Approach: Collect the distinct letters in a set; the sentence is a
 *           pangram when all 26 letters appear.
 * Time    : O(n)
 * Space   : O(1) - at most 26 entries
 */
class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            letters.add(c);
        }
        return letters.size() == 26;
    }
}
