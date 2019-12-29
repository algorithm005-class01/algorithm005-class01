import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leecode_69_0116 {
    public int mySqrt(int x) {
        if(x == 1 || x == 0 ){
            return x;
        }
        int left = 0 ;
        int right = x;
        while(left < right){
            int mid = (right + left) /2;
            if(mid * mid < x){
                left = mid + 1;
            }else if(mid * mid > x){
                right = x -1;
            }else{
                return  mid;
            }
        }
        return -1;
    }
}