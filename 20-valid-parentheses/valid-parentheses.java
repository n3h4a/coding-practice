/*
 * Valid Parentheses
 * Pattern : Stack
 * Approach: Push every opening bracket. On a closing bracket, the top of the
 *           stack must be its matching opener. The string is valid only if
 *           the stack is empty at the end.
 * Time    : O(n)
 * Space   : O(n)
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(', '{', '[' -> stack.push(ch);
                case ')' -> {
                    if (!matches(stack, '(')) return false;
                }
                case '}' -> {
                    if (!matches(stack, '{')) return false;
                }
                case ']' -> {
                    if (!matches(stack, '[')) return false;
                }
                default -> { }
            }
        }

        return stack.isEmpty();
    }

    private boolean matches(Deque<Character> stack, char expectedOpen) {
        if (stack.isEmpty() || stack.peek() != expectedOpen) {
            return false;
        }
        stack.pop();
        return true;
    }
}
