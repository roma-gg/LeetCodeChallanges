import OtherTasks.ClementGraphProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

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

        var queue = new PriorityQueue<Integer>();
        queue.add(3);
        queue.add(1);
        queue.add(2);
        System.out.println(queue);


    }
}