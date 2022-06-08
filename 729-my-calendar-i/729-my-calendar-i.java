class MyCalendar {

    TreeMap<Integer,Integer> map = null;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if(map.floorEntry(start) != null && map.floorEntry(start).getValue() > start){
            return false;
        }
        
        if(map.ceilingEntry(start) != null && map.ceilingEntry(start).getKey() < end){
            return false;
        }
        
        map.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */