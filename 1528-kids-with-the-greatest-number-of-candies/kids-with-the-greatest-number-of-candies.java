/*
 * Kids With the Greatest Number of Candies
 * Pattern : Array
 * Approach: Find the current maximum once; a kid can become the greatest
 *           if their candies plus the extra reach that maximum.
 * Time    : O(n)
 * Space   : O(1) extra
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}
