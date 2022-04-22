class MyHashMap {

    int hashCode = 196613;
    List<List<int[]>> hashTable;
    public MyHashMap() {
        hashTable = new ArrayList<>();
        for(int i = 0; i < hashCode; i++){
            hashTable.add(new ArrayList<>());
        }
    }
    
    public void put(int key, int value) {
        int index = getHashValue(key);
        boolean inserted = false;
        List<int[]> list = hashTable.get(index);
        
        for(int[] a: list){
            if(a[0] == key){
                a[1] = value;
                inserted = true;
                break;
            }
        }
        
        if(!inserted){
            list.add(new int[]{key,value});
        }
    }
    
    public int get(int key) {
        int index = getHashValue(key);
        boolean inserted = false;
        List<int[]> list = hashTable.get(index);
        
        for(int[] a: list){
            if(a[0] == key){
                return a[1];
            }
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int index = getHashValue(key);
        boolean inserted = false;
        List<int[]> list = hashTable.get(index);
        
        int i = 0;
        for(i = 0; i < list.size(); i++){
            if(list.get(i)[0] == key){
                inserted = true;
                break;
            }
            
            i++ ;
        }
        
        if(inserted){
            list.remove(i);
        }
    }
    
    private int getHashValue(int key){
        return key%hashCode;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */