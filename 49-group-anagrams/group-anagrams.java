class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
    /*
        Map <String , List<String>> res = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = new String (chars);
            res.putIfAbsent(sortedS , new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values()); */




        Map <String , List<String>> res = new HashMap <>();
        for(String s : strs){
            int[] count = new int [26];
            for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        String key = Arrays.toString(count);
        res.putIfAbsent(key , new ArrayList<>());
        res.get(key).add(s);
        }
        return new ArrayList<> (res.values());


        
        
    }
}