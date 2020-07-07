import java.util.*;
public class week29_726 {
    class Solution {
        public String countOfAtoms(String formula) {
            TreeMap<String, Integer> ret = getAtom(formula);
            StringBuilder s = new StringBuilder();
            for (Map.Entry<String, Integer> entry: ret.entrySet()) {
                s.append(entry.getKey());
                if (entry.getValue() > 1) s.append(String.valueOf(entry.getValue()));
            }
            return s.toString();
        }
        
        private TreeMap<String, Integer>getAtom(String s) {
            TreeMap<String, Integer> ret = new TreeMap<>();
            char[] str = s.toCharArray();
            int i = 0;
            int n = str.length;
            while (i < n) {
                if (str[i] >= 'A' && str[i] <= 'Z') {
                    if (i+1 < n) {
                        int j = i + 1;
                        while (j < n && str[j] >='a' && str[j] <='z') {
                            j++;
                        }
                        String atom = s.substring(i, j);
                        if (j == n) {
                            ret.put(atom, ret.getOrDefault(atom, 0) + 1);
                            break;
                        }   
                        if (str[j] == '(') {
                            ret.put(atom, ret.getOrDefault(atom, 0) + 1);
                            i = j;
                        } else {
                            int start = j;
                            while (j < n && str[j] >= '0' && str[j] <= '9') {
                                j++;
                            }
                            int num = j > start? Integer.parseInt(s.substring(start, j)) : 1;
                            ret.put(atom, ret.getOrDefault(atom, 0) + num);
                            i = j;
                        }
                        
                    } else {
                        String atom = String.valueOf(str[i]);
                        ret.put(atom, ret.getOrDefault(atom, 0) + 1);
                        break;
                    }
                } else if (str[i] == '(') {
                    int left = 1;
                    int j = i + 1;
                    while (j < n) {
                        if (str[j] == '(') {
                            left ++;
                        } else if (str[j] == ')') {
                            left--;
                            if (left == 0) break;
                        }
                        j ++;
                    }
                    int num = 1;
                    TreeMap<String, Integer> nextRet = getAtom(s.substring(i+1, j));
                    j ++;
                    if (j < n && str[j] >= '0' && str[j] <= '9') {
                        int start = j;
                        while (j < n && str[j] >= '0' && str[j] <= '9') {
                            j++;
                        }
                        num = j > start ? Integer.parseInt(s.substring(start, j)) : 1;
                    }
                    for (Map.Entry<String, Integer> entry: nextRet.entrySet()) {
                        ret.put(entry.getKey(), ret.getOrDefault(entry.getKey(), 0) + num * entry.getValue());
                    }
                    i = j;
                }
            }
            return ret;
        }
    }
}