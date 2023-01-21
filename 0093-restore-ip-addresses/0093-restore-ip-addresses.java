class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() >= 4 && s.length() <= 12){
            backtrack(list, new String[4], s, 0, 0);
        }
        return list;
    }

    public void backtrack(List<String> list, String[] path, String s, int start, int group){
        if (group == 4) {
            if (start == s.length()) list.add(String.join(".", path));
            return;
        } else {
            for (int i = 1; i <= 3; i++) {
                if (start + i > s.length()) return;
                String section = s.substring(start, start + i);
                if (isValidSection(section)) {
                    path[group] = section;
                    backtrack(list, path, s, start + i, group + 1);
                    path[group] = null;
                }
            }
        }
    }

    private boolean isValidSection(String s){
        if(s.length() < 1 || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) return false;
        return Integer.parseInt(s) < 256;
    }
}