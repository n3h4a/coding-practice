class Solution {
    public int maximumPopulation(int[][] logs) {

        // difference array technique

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

        /*

        // line sweep algo 

        ArrayList<int[]> events = new ArrayList<> ();
        for(int[] log : logs){
        events.add(new int[] {log[0] , +1});
        events.add(new int[] {log[1] , -1});
        }
        events.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });
        int maxpop = 0;
        int currpop = 0;
        int minyear = 2050;

        for( int[] e : events){
            currpop += e[1];
            if(currpop > maxpop){
            maxpop = currpop;
            minyear = e[0];

        }        
    }
    return minyear;

    */
}
}