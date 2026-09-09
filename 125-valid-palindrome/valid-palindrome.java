class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            char leftChar = Character.toLowerCase(s.charAt(start));
            char rightChar = Character.toLowerCase(s.charAt(end));

            if(leftChar != rightChar){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
