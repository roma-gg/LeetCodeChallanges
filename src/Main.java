import OtherTasks.ClementGraphProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        var islands = new ClementGraphProblem();
        int[][] matrix =
                       {{1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 1, 1, 0, 0},
                        {1, 0, 0, 0, 0, 1}};
        System.out.println(Arrays.deepToString(islands.removeIsland(matrix)));



    }
}