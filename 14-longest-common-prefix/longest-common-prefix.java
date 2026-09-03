class Solution {

    public String longestCommonPrefix(String[] strs) {

       /* String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int j = 0;

            while (j < Math.min(prefix.length(), strs[i].length())) {

                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }

                j++;
            }

            prefix = prefix.substring(0, j);
        }

        return prefix;    */


                        /*        for ( int i = 0; i < strs[0].length() ; i++) {
                                    for(String s : strs){
                                        if(i == s.length() || s.charAt(i) != strs[0].charAt(i) ){
                                            return s.substring (0 , i);
                                        }
                                    }
                                }
                                return strs[0];        */

                                                                if(strs.length == 1){
                                                                    return strs[0];
                                                                }else {

                                                                Arrays.sort(strs);
                                                                int N = Math.min(strs[0].length() , strs[strs.length - 1].length());
                                                                for(int i = 0 ; i < N ; i++){
                                                                if(strs[0].charAt(i) != strs[strs.length - 1].charAt(i)){
                                                                    return strs[0].substring(0 ,i);
                                                                }
                                                                }
                                                                }
                                                                return strs[0];
                                        










    }
}