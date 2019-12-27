package week02;

import sun.tools.tree.NewArrayExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description: 组合.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_77_0314 {

  
  public static List<List<Integer>> combine(int n, int k) {

    if(k==1) {
  
      List<List<Integer>> resultList = new ArrayList<>();
      for(int i=1; i<=n; i++) {
        
        List<Integer> tempList = new ArrayList();
        tempList.add(i);
        resultList.add(tempList);
      }
      return resultList;
    }
    
    if(n==k) {
      List<Integer> tempList = new ArrayList();
      for(int i=1; i<=k; i++) {
        tempList.add(i);
      }
      List<List<Integer>> resultList = new ArrayList<>();
      resultList.add(tempList);
      return resultList;
    }
    
    
    List<List<Integer>> list = combine(n-1,k-1);
    
    for(List<Integer> tempList : list) {
      tempList.add(n);
    }
  
    List<List<Integer>> list2 = combine(n-1,k);
    list.addAll(list2);
    
    
    
    
    
    
    return list;
  }
  
  public static void main(String[] args) {
  
    System.out.println(combine(4,2));
    
    
  }
}
