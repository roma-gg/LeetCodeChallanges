package OtherTasks;

import java.util.*;

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
        var visited = new HashSet<String>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isBorder(i,j,matrix) && matrix[i][j] == 1 && !visited.contains(""+i+j))
                    isNotIsland(i,j,matrix,visited);
            }
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[0].length - 1; j++) {
                if (!visited.contains("" + i + j) && matrix[i][j] == 1)
                    matrix[i][j] = 0;
            }
        }

        return matrix;
    }


    private void isNotIsland(int rowIndex, int columnIndex, int[][] matrix, HashSet<String> visited) {
        if (rowIndex < 0 || rowIndex == this.matrix.length || columnIndex < 0 || columnIndex == this.matrix[0].length)
            return;

        if (visited.contains("" + rowIndex + columnIndex))
            return;

        visited.add("" + rowIndex + columnIndex);

        if (this.matrix[rowIndex][columnIndex] == 0)
            return;

        isNotIsland(rowIndex - 1, columnIndex, matrix, visited);
        isNotIsland(rowIndex + 1, columnIndex, matrix, visited);
        isNotIsland(rowIndex, columnIndex - 1, matrix, visited);
        isNotIsland(rowIndex, columnIndex + 1, matrix, visited);

    }

    private boolean isBorder(int rowIndex, int columnIndex, int[][] array) {
        return  rowIndex == 0 ||
                rowIndex == array.length - 1 ||
                columnIndex == 0 ||
                columnIndex == array[0].length - 1;
    }
}
