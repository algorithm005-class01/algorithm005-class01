package test;

public class ContainWaterTest {

    public static void main(String[] args) {
        int data[] = {1,6,5,3,6,7,2,9,8};
        int area = coutainWaterB(data);
        System.out.println(area);
    }
//暴力
    public static int containWater(int data[]) {
        int maxArea = 0;
        for (int i = 0; i <= data.length-1; i++) {
            for (int j = i+1; j < data.length; j++) {
                int area = (j-i)* (Math.min(data[i],data[j]));
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }

    //双指针
    public static int coutainWaterB(int data[]){
        int a = 0;
        int b = data.length-1;
        int maxArea = 0;
        while(a<b){
            maxArea = Math.max(maxArea,(b-a)*(Math.min(data[a],data[b])));
            if(data[a]<data[b]){
                a++;
            }else{
                b--;
            }
        }
        return maxArea;
    }

}
