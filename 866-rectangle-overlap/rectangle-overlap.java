/*
 * Rectangle Overlap
 * Pattern : Math / Geometry
 * Approach: Two rectangles overlap exactly when their projections overlap
 *           on both axes, i.e. each one starts before the other ends in x
 *           and in y. Strict comparisons exclude touching edges.
 * Time    : O(1)
 * Space   : O(1)
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean overlapX = rec1[0] < rec2[2] && rec2[0] < rec1[2];
        boolean overlapY = rec1[1] < rec2[3] && rec2[1] < rec1[3];
        return overlapX && overlapY;
    }
}
