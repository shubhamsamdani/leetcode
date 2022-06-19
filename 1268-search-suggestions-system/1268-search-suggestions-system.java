class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        for( int i = 0; i < searchWord.length(); i++){
            String prefix = searchWord.substring(0,i+1);
            List<String> subRes =  new ArrayList<>();
            for( String str : products){
                if(str.startsWith(prefix)){
                    subRes.add(str);
                }
            }
            Collections.sort(subRes);
           //  Arrays.sort(subRes,String.CASE_INSENSITIVE_ORDER);
            List subRes1 = null;
            if( subRes.size() >= 3){
                subRes1 = subRes.subList(0, 3);
            }else{
                subRes1 = subRes;
            }
            
            result.add(subRes1);
        }
        return result;
    }
}