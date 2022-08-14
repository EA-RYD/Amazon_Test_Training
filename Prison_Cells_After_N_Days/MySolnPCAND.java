package Prison_Cells_After_N_Days;
import java.util.*;

public class MySolnPCAND {
    public static void main(String[] args) {
        int[] cells = new int[] {1,0,0,1,0,0,1,0};
        int n = 1000000000;
        //System.out.println();
        for (int cell : prisonAfterNDays(cells, n)) {
            System.out.print(cell + " ");
        }
        System.out.println();

    }

    public static int[] prisonAfterNDays(int[] cells, int n) {
        //boolean[] mapper = new boolean[n];
        //HashMap<Integer,Integer> mapper = new HashMap<>();


        HashSet<String> cycles = new HashSet<>();
        int[] tempBoolean = new int[cells.length];
        boolean cycleComplete = false;
        int untilCycle = 0;
        int N = n;

        while (n != 0) {
            for (int i = 0; i < cells.length; i++) {
                if ((i != 0 && i != cells.length-1) && cells[i-1] == cells[i+1]) {
                    tempBoolean[i] = 1;
                } 
            }

            if (cycles.contains(tempBoolean.toString())) {
                cycleComplete = true;
                break;
            } else {
                untilCycle++;
                cycles.add(tempBoolean.toString());
                cells = tempBoolean;
                tempBoolean = new int[cells.length];
                n--;
            }
        }

        if (cycleComplete == true) {
            N %= untilCycle;
            for(int i=0;i<N;i++){
                for (int j = 0; j < cells.length; j++) {
                    if ((j != 0 && j != cells.length-1) && cells[j-1] == cells[j+1]) {
                        tempBoolean[j] = 1;
                    } 
                }
                cells = tempBoolean;
                tempBoolean = new int[cells.length];
            }   
        } 

        
        return cells;
    }
}
