package Prison_Cells_After_N_Days;
import java.util.*;

public class IdealSolnPCAND {
    public int[] prisonAfterNDays(int[] c, int N) {
        int[] f_c = new int[c.length], next_c = new int[c.length];
        for (int cycle = 0; N-- > 0; c = next_c.clone(), ++cycle) {
          for (int i = 1; i < c.length - 1; ++i) next_c[i] = (c[i - 1] == c[i + 1] ? 1 : 0);
          if (cycle == 0) f_c = next_c.clone();
          else if (Arrays.equals(next_c, f_c)) N %= cycle;
        }
        return c;
      }
}
