class Tests {
    record Mountain(int[] values) implements MountainArray {
        public int get(int index) {
            return values[index];
        }

        public int length() {
            return values.length;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(2, s.findInMountainArray(3, new Mountain(new int[] {1, 2, 3, 4, 5, 3, 1})));
        Assert.equal(-1, s.findInMountainArray(3, new Mountain(new int[] {0, 1, 2, 4, 2, 1})));
        Assert.equal(5, s.findInMountainArray(2, new Mountain(new int[] {1, 3, 5, 4, 3, 2})));
    }
}
