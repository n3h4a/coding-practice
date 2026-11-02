// Local stand-in for LeetCode's VersionControl API (First Bad Version).
class VersionControl {
    static int firstBad = 1;

    boolean isBadVersion(int version) {
        return version >= firstBad;
    }
}
