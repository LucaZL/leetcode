package other;

import java.util.HashMap;
import java.util.Map;

public class CloseNumber {

    public static void main(String[] args) {
        int n = 24;
        int m = 2;
        CloseNumber closeNumber = new CloseNumber();
        System.out.println(closeNumber.solution(n, m));
    }

    public int solution(Integer n, int m) {
        // n转换成map
        Map<Integer, Integer> n_map = changeNumberToMap(n);
        // 根据map，重排列n，计算n的最大值
        StringBuilder max_sb = new StringBuilder();
        for(int key = 9; key >= 0; key--) {
            if(n_map.containsKey(key)) {
                int value = n_map.get(key);
                for(int j =0;j<value;j++) {
                    max_sb.append(key);
                }
            }
        }
        long max = Integer.valueOf(max_sb.toString());
        if(max > Integer.MAX_VALUE) {
            max = Integer.MAX_VALUE;
        }

        int result = 0;
        // 遍历 m的 1~max倍，判断是否倍数数字的map，是否和n_map想到
        int m_times_number = m;
        while(m_times_number <= max) {
            // 倍数转换为
            Map<Integer, Integer> m_times_map = changeNumberToMap(m_times_number);

            // 比较map，判断是否相等，如果相等，则是亲密数，结果+1
            // 如果map大小不一样，不相等
            if(n_map.size() == m_times_map.size()) {
                // key和value比对
                boolean isCloseNumber = true;
                for(Map.Entry<Integer, Integer> entry: n_map.entrySet()) {
                    int n_k = entry.getKey();
                    int n_v = entry.getValue();
                    if(!m_times_map.containsKey(n_k)) {
                        isCloseNumber = false;
                        break;
                    }
                    int m_times_value = m_times_map.get(n_k);
                    if(n_v != m_times_value) {
                        isCloseNumber = false;
                        break;
                    }
                }
                if(isCloseNumber) {
                    result++;
                }
            }
            //
            m_times_number += m;
        }

        return result;
    }

    public Map<Integer, Integer> changeNumberToMap(int num) {
        char[] n_char = String.valueOf(num).toCharArray();
        // n 转字符数组，存map，key是数字，n是个数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (char c : n_char) {
            int key = (int)c - (int)'0';
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }
        return map;
    }
}
