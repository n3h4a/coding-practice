/*
 * Create Target Array in the Given Order
 * Pattern : Array Simulation
 * Approach: Simulate the inserts with ArrayList.add(index, value), which
 *           shifts later elements right, then copy to an int array.
 * Time    : O(n^2) - each insert may shift O(n) elements
 * Space   : O(n)
 */
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = target.get(i);
        }
        return result;
    }
}
