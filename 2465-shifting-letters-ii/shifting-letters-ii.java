class Solution {
    public String shiftingLetters(String s, int[][] shifts) {

        int n = s.length();
        int[] diff = new int[n];

        for(int[] shift : shifts){
            int L = shift[0];
            int R = shift[1];
            int dir = shift[2];

            int x = 1;
            if(dir == 0){
                x = -1;
            }

            diff[L] += x;

            if(R + 1 < n){
                diff[R + 1] -= x;
            }
        }

        for(int i = 1; i < n; i++){
            diff[i] += diff[i - 1];
        }

        char[] chars = s.toCharArray();

        for(int i = 0; i < n; i++){
            int currShift = diff[i] % 26;

            if(currShift < 0){
                currShift += 26;
            }

            chars[i] = (char)(((chars[i] - 'a' + currShift) % 26) + 'a');
        }

        return new String(chars);
    }
}