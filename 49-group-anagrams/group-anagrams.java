class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String , List<String>> res = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = new String (chars);
            res.putIfAbsent(sortedS , new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
        
    }
}