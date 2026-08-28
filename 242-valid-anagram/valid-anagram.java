class Solution {
    public boolean isAnagram(String s, String t) {
/*        if(s.length() != t.length()){
        return false;
        }
        else{
        char [] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char [] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        return Arrays.equals(arr1 , arr2);
        }
*/
                if(s.length() != t.length()){
                    return false;
                } else {
                    HashMap<Character , Integer> mapS = new HashMap <> ();
                    HashMap<Character , Integer> mapT = new HashMap <> ();
                    for( int i = 0 ; i < s.length(); i++){
                    char ch1 = s.charAt(i);
                    int currentcount1 = mapS.getOrDefault(ch1 , 0);
                    currentcount1++;
                    mapS.put(ch1 , currentcount1);
                    char ch2 = t.charAt(i);
                    int currentcount2 = mapT.getOrDefault(ch2 , 0);
                    currentcount2++;
                    mapT.put(ch2 , currentcount2);
                    }
                    return mapS.equals(mapT);
                }
    }
}