/*
 * Count Items Matching a Rule
 * Pattern : Array
 * Approach: Map the rule key to its column (type = 0, color = 1, name = 2)
 *           once, then count items whose value in that column matches.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int column = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            default -> 2; // "name"
        };

        int count = 0;
        for (List<String> item : items) {
            if (item.get(column).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
