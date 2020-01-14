package week05;

/**
 * Description: 解码方法.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_91_0314 {
  public int numDecodings(String s) {
    int[] resultArr = new int[s.length()];
    char temp='0';
    if(s.charAt(0)=='0') {
      return 0;
    }
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      StringBuilder sb = new StringBuilder();
      sb.append(temp).append(c);
      int num = Integer.parseInt(sb.toString());
      if(i==0){
        resultArr[0] = 1;
      } else if(i==1) {
        if(c=='0') {
          if(num>26) {
            return 0;
          } else {
            resultArr[1]=1;
          }
        } else {
          if(num<=26) {
            resultArr[1]=2;
          } else {
            resultArr[1]=1;
          }
        }
      } else {
        if(c=='0') {
          if(num>26 || num==0) {
            return 0;
          }
          resultArr[i] = resultArr[i-2];
        } else if(temp=='0') {
          resultArr[i] = resultArr[i-1];
        } else if(num<=26) {
          resultArr[i] = resultArr[i-2] + resultArr[i-1];
        } else {
          resultArr[i] = resultArr[i-1];
        }
      }
      temp = c;
    }
    return resultArr[s.length()-1];
  }
}
