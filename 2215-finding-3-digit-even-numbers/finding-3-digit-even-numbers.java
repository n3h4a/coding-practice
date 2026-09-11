class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> uniqueInt = new HashSet<>();
        for(int i = 0; i < digits.length; i++){
            for(int j = 0; j < digits.length; j++){
                for(int k = 0; k < digits.length; k++){
                    if( i == j || j == k || k == i)
                    continue;
                    int a = digits[i];
                    int b = digits[j];
                    int c = digits[k];
                    if(a == 0)
                        continue;

                    if(c % 2 != 0)
                        continue;
                    int num = a * 100 + b * 10 + c;
                    uniqueInt.add(num);
                }
            }
        }
        List<Integer> list = new ArrayList<>(uniqueInt);
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}