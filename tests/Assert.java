// Minimal assertion helpers so the tests run with plain javac/java.
final class Assert {
    private Assert() {}

    static void equal(Object expected, Object actual) {
        if (!java.util.Objects.deepEquals(expected, actual)) {
            throw new AssertionError("expected " + show(expected) + " but got " + show(actual));
        }
    }

    static void isTrue(boolean condition) {
        equal(true, condition);
    }

    static void isFalse(boolean condition) {
        equal(false, condition);
    }

    private static String show(Object o) {
        if (o instanceof int[] a) return java.util.Arrays.toString(a);
        if (o instanceof long[] a) return java.util.Arrays.toString(a);
        if (o instanceof char[] a) return java.util.Arrays.toString(a);
        if (o instanceof Object[] a) return java.util.Arrays.deepToString(a);
        return String.valueOf(o);
    }
}
