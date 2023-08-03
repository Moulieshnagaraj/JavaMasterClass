import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arrayElements = new int[]{ 7,5,3};
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: arrayElements){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        int repeatedElement = Integer.MIN_VALUE;
        int count = 0;
        for(int ele: map.keySet()){
            if(map.get(ele)>count){
                count = map.get(ele);
                repeatedElement = ele;
            }else if(map.get(ele)==count && ele > repeatedElement){
                repeatedElement = ele;
            }
        }

        System.out.println(repeatedElement);
    }
}

// GIVEN AN ARRAY OF ELEMENTS, +VE, FIND THE SECOND LARGEST ELEMENT IN THE ARRAY

//[3, 5 , 7, 8, 10, 8 ,10, 10]
// [3,3,5,5 8 8 7 7 10 10]