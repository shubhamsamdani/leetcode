class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int start = 12,prevStart = 12;
        List<Integer> list = new ArrayList<>();
        boolean breakAtElse = false;
       while(true){
           
            if(start >= low && start <= high){
                list.add(start);
            }
            int a = start%10;
            int b = getFromSec(start);
            b = b*10 + (a+1);
            
           if(start >= 123456789 || start > high){
                break;
            }
           
            if(b%10 == 9){
                if(b >= low && b <= high){
                list.add(b);
                }
                start = prevStart*10 + (prevStart%10 + 1); 
                prevStart = start;
                breakAtElse = false;
            } else{
                start = b; 
                breakAtElse = true;
            }
            
            
        }
        
        // if(!breakAtElse){
        //     list.add(prevStart);
        // }
        
        return list;
    }
    
    private int getFromSec(int num){
        int dec = 1;
        int x = num;
        int count = 0;
        while(x > 0){
            x /= 10;
            count++ ;
        }
        
        return num%((int)(Math.pow(10,count-1)));
    }
}