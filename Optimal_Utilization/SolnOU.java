package Optimal_Utilization;
import java.util.*;

public class SolnOU {
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) { //returning 
        Collections.sort(a, (i,j) -> i[1] - j[1]);
        Collections.sort(b, (i,j) -> i[1] - j[1]);
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int m = a.size();
        int n = b.size();
        int i =0;
        int j =n-1;
        while(i<m && j >= 0) { // i is start pointer for list A, j is end pointer for list B, change dep on sum
            int sum = a.get(i)[1] + b.get(j)[1];
            if(sum > target) {
                 --j;
            } else {
                if(max <= sum) {
                    if(max < sum) { //new max so clear list
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]}); //no need to clear if same val
                    int index = j-1;
                    while(index >=0 && b.get(index)[1] == b.get(index+1)[1]) { //storing same value for diff keys
                         result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                ++i;
            }
        }
        return result;
    } 
}
