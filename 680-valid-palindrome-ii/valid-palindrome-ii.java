class Solution {
    public boolean validPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while(left < right){
        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);
        if(Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)){
            left++;
            right--;
        } else{
            return(isPalindrome(s, left + 1, right)) || (isPalindrome(s, left , right - 1));
        }
    } return true;
    }


public boolean isPalindrome(String s, int left, int right){

    while(left < right){

        if(Character.toLowerCase(s.charAt(left)) != 
           Character.toLowerCase(s.charAt(right))){

            return false;
        }

        left++;
        right--;
    }

    return true;
}
}