class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        
        int timeElapsed = 0;
        for(int[] course : courses){
            if(course[0] + timeElapsed <= course[1]){
                timeElapsed += course[0];
                pq.offer(course[0]);
            } else if(!pq.isEmpty() && pq.peek() > course[0]){
                timeElapsed -= pq.poll();
                pq.offer(course[0]);
                timeElapsed += course[0];
            } else{
                
            }
        }
        
        return pq.size();
    }
}