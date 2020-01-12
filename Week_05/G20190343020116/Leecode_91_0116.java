import java.util.HashMap;
import java.util.Map;

class Leecode_91_0116 {
    public int numDecodings(String s) {
        int len = s.length();
        int first = 1;
        int second = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < len;i++) {
            int temp = second;
            if (s.charAt(i) == '0')
                second = 0;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))
                second += first;
            first = temp;
        }
        return second;
    }
}