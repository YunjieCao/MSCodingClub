public class week31_1178 {
    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            List<Integer> ret = new ArrayList<>();
            int n = words.length;
            HashMap<Character, List<Long>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long cur = getNum(words[i]);
                List<Long> temp = map.getOrDefault(words[i].charAt(0), new ArrayList<>());
                temp.add(cur);
                map.put(words[i].charAt(0), temp);
            }
            for (String puzzle: puzzles) {
                long cur = getNum(puzzle);
                char first = puzzle.charAt(0);
                int temp = 0;
                if (!map.containsKey(first)) {
                    ret.add(0);
                    continue;
                }
                for (Long w: map.get(first)) {
                    if ((w&first) == 0) continue;
                    long target = (w & cur);
                    if ((target^w) == 0) {
                        temp ++;
                    }
                }
                ret.add(temp);
            }
            return ret;
        }
        
        
        private long getNum(String word) {
            long ret = 0;
            for (char c: word.toCharArray()) {
                long cur = 1 << (int)(c-'a');
                ret |= cur;
            }
            return ret;
        }
    }
}