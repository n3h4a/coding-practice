class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map <Integer , Integer> events = new TreeMap<>();
        for( int[] trip : trips){
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
        
        events.put(from , 
            events.getOrDefault(from , 0) +passengers );
        events.put(to ,
            events.getOrDefault(to , 0) -passengers );
        int count = 0;
        for(int change : events.values() ){
            count += change;

            if(count > capacity){
                return false;
            }
        }
      }
        return true;
    }
}