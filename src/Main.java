import OtherTasks.ClementGraphProblem;
import OtherTasks.ClementRectangleCoordinates;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[][] array =  {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {1, 2}, {2, -1}, {2, 1}, {2, 2}};
        var practice = new ClementRectangleCoordinates();
        var rectangles = practice.findAllRectangles(array);
        for (var rectangle : rectangles) {
            System.out.println(Arrays.deepToString(rectangle));
        }

    }
}