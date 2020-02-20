package week_07.commit;

import java.util.HashMap;
import java.util.Map;

// 190. 颠倒二进制位
// https://leetcode-cn.com/problems/reverse-bits/s
public class Solution_190_01 {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31)
                result <<= 1;
        }
        return result;
    }


    // cache
    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

    public int reverseBits2(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++)
            bytes[i] = (byte)((n >>> 8*i) & 0xFF);
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]);
            if (i < 3)
                result <<= 8;
        }
        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b);
        if (value != null)
            return value;
        value = 0;
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }
}
