class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[2051];
        for( int i = 0 ; i < logs.length ; i++){
            int birth = logs[i][0];
            int death = logs[i][1];

            diff[birth] += 1;
            diff[death] -= 1;
        }
        int maxpop = 0;
        int currpop = 0;
        int minyear = 2050;

        for( int year = 1950 ; year < 2051 ; year++){
            currpop += diff[year];
            if(currpop > maxpop){
            maxpop = currpop;
            minyear = year;
            }
        }
        return minyear;
    }
}