class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        String direction = "north";
        
        for(char c : instructions.toCharArray()){
            if(c == 'G'){
                if("north".equals(direction)){
                    y++;
                } else if("south".equals(direction)){
                    y--;
                } else if("east".equals(direction)){
                    x++;
                } else{
                    x--;
                }
            } else if( c == 'L'){
                if("north".equals(direction)){
                    direction = "west";
                } else if("south".equals(direction)){
                    direction = "east";
                } else if("east".equals(direction)){
                    direction = "north";
                } else{
                    direction = "south";
                }
            } else if( c == 'R'){
                if("north".equals(direction)){
                    direction = "east";
                } else if("south".equals(direction)){
                    direction = "west";
                } else if("east".equals(direction)){
                    direction = "south";
                } else{
                    direction = "north";
                }
            }
        }
        
        if(x == 0 && y == 0){
            return true;
        }
        
        if(direction.equals("north")){
            return false;
        }
        
        return true;
    }
}