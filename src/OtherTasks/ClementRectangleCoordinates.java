package OtherTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class ClementRectangleCoordinates {

    int[][] array =  {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {1, 2}, {2, -1}, {2, 1}, {2, 2}};


    //                          [1, 2]     [2, 2]
    //    (2) [-1, 1]       (4) [1, 1]     [2, 1]
    //    (1) [-1, -1]      (3) [1, -1]    [2, -1]
    // [x, y] [x, 2y] [2x, 2y] [2x, y]

    public ArrayList<int[][]> findAllRectangles (int[][] coordinates) {
        ArrayList<int[][]> rectangles = new ArrayList<>();
        for (int c1 = 0; c1 < coordinates.length; c1++) {
            int[][] rectangle = new int[4][2];
            for (int c2 = c1 + 1; c2 < coordinates.length; c2++) {
                if (coordinates[c1][0] == coordinates[c2][0]) {
                    rectangle[0] = coordinates[c1];
                    rectangle[1] = coordinates[c2];
                    for (int c3 = c2 + 1; c3 < coordinates.length; c3++) {
                        if (coordinates[c1][1] == coordinates[c3][1]) {
                            rectangle[2] = coordinates[c3];
                            for (int c4 = c3 + 1; c4 < coordinates.length; c4++) {
                                if (coordinates[c3][0] == coordinates[c4][0] && coordinates[c2][1] == coordinates[c4][1]) {
                                    rectangle[3] = coordinates[c4];
                                    var result = Arrays.stream(rectangle).map(int[] :: clone).toArray(int[][] :: new);
                                    rectangles.add(result);
                                }
                            }
                        }
                    }
                }
            }
        }

        return rectangles;
    }
}
