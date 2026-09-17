class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> list = new ArrayList<>();
            int carry = k;
            for(int i = num.length - 1 ; i >= 0 ; i--){
                carry += num[i];
                int digit = carry % 10 ;
                list.add(digit);
                carry = carry / 10;
            }
            while(carry > 0){
            list.add(carry % 10);
            carry /= 10;
            }
            
            Collections.reverse(list);
            return list;
    }
}