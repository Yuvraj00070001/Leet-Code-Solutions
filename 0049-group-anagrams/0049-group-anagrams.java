class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String word:strs){
            char w[]=word.toCharArray();
            Arrays.sort(w);
            String key=new String(w);
            map.computeIfAbsent(key, k->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}