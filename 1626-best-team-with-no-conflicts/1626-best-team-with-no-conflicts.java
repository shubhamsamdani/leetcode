class Solution {
    class Player{
        int score;
        int age;
        public Player(int score, int age){
            this.age = age;
            this.score = score;
        }
    }
    
    public int bestTeamScore(int[] scores, int[] ages) {
    
        List<Player> list = new ArrayList<>();
        for(int i = 0; i < scores.length; i++){
            list.add(new Player(scores[i],ages[i]));
        }
        
        Collections.sort(list, (p1,p2) -> p1.age == p2.age ? p1.score - p2.score : p1.age - p2.age);
        int dp[] = new int[list.size()];
        dp[0] = list.get(0).score ;
        int max = dp[0];
        for(int i = 1; i < dp.length; i++){
            dp[i] = list.get(i).score;
            for(int j = 0; j < i; j++){
                if (list.get(j).score <= list.get(i).score) 
                    dp[i] = Math.max(dp[i],dp[j] + list.get(i).score);
            }
            
            max = Math.max(dp[i],max);
        }
        
        return max;
    }
}