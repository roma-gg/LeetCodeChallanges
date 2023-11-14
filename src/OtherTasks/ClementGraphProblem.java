package OtherTasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ClementGraphProblem {
    int[][] matrix =
           {{1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1}};

    // if node is 0 - return true;
    //if node is 1 - check top, bottom, right, left
    //if isBorder - return false;
    //


    public int[][] removeIsland(int[][] matrix) {
        var visited = new HashMap<String, Boolean>();

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[0].length - 1; j++) {
                if (isIsland(i,j,matrix,visited))
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }


    private boolean isIsland(int rowIndex, int columnIndex, int[][] array, HashMap<String, Boolean> visited) {
        if (rowIndex < 0 || rowIndex == array.length || columnIndex < 0 || columnIndex == array[0].length)
            return true;

        if (matrix[rowIndex][columnIndex] == 0)
            return true;

        if (isBorder(rowIndex, columnIndex, array)) {
            return false;
        }

        String node = "" + rowIndex + columnIndex;
        if (visited.containsKey(node))
            return visited.get(node);

        if (isIsland(rowIndex - 1, columnIndex, array, visited) &&
            isIsland(rowIndex + 1, columnIndex, array, visited) &&
            isIsland(rowIndex, columnIndex - 1, array, visited) &&
            isIsland(rowIndex, columnIndex + 1, array, visited)) {
            visited.put(node, true);
            return true;
        }
        else {
            visited.put(node, false);
            return false;
        }
    }

    private boolean isBorder(int rowIndex, int columnIndex, int[][] array) {
        return  rowIndex == 0 ||
                rowIndex == array.length - 1 ||
                columnIndex == 0 ||
                columnIndex == array[0].length - 1;
    }
}
