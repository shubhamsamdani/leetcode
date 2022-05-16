class Solution {
    
    public class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length - 1;
        if(grid[0][0] == 1 || grid[n][n] == 1){
            return -1;
        }
        
        int level = 0;
        Queue<Point> q1 = new LinkedList<>();
        q1.offer(new Point(0,0));
        
        while(!q1.isEmpty()){
            int size = q1.size();
            while(size-- > 0){
                Point temp = q1.poll();
                int x = temp.x;
                int y = temp.y;
                
                
                if(x < 0 || y < 0 || x > n || y > n || grid[x][y] >= 1){
                    continue;
                }
                
                if(x == n && y == n){
                    return level+1;
                }
                
                grid[x][y] = 2;
                q1.offer(new Point(x+1,y));
                q1.offer(new Point(x-1,y));
                q1.offer(new Point(x,y+1));
                q1.offer(new Point(x,y-1));
                
                q1.offer(new Point(x+1,y+1));
                q1.offer(new Point(x+1,y-1));
                q1.offer(new Point(x-1,y+1));
                q1.offer(new Point(x-1,y-1));
            }
            
            level++ ;
        }
        
        return -1;
    }
}