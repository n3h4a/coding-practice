class Solution {
    public int totalNumbers(int[] digits) {

        HashSet<Integer> unique = new HashSet<>();

        for(int i = 0; i < digits.length; i++) {
            for(int j = 0; j < digits.length; j++) {
                for(int k = 0; k < digits.length; k++) {

                    // same copy of digit cannot be used twice
                    if(i == j || i == k || j == k)
                        continue;

                    int a = digits[i]; // hundreds
                    int b = digits[j]; // tens
                    int c = digits[k]; // ones

                    // no leading zero
                    if(a == 0)
                        continue;

                    // number must be even
                    if(c % 2 != 0)
                        continue;

                    int num = a * 100 + b * 10 + c;

                    unique.add(num);
                }
            }
        }

        return unique.size();
    }
}