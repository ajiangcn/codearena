package leetCode;

import java.util.Stack;

public class EditDistance {

    // leetcode
    public int minDistance(String word1, String word2) {

        int w1len = word1.length();
        int w2len = word2.length();

        int[][] matrix = new int[w1len+1][w2len+1];
        for (int i=1; i<=w1len; i++) {
            matrix[i][0] = i;
        }
        for (int i=1; i<=w2len; i++) {
            matrix[0][i] = i;
        }
        for (int i=1; i<=w1len; i++) {
            for (int j=1; j<=w2len; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1];
                } else {
                    int change = 1 + matrix[i-1][j-1];
                    int insert = 1 + matrix[i][j-1];
                    int delete = 1 + matrix[i-1][j];

                    int result = change < insert ? change : insert;
                    result = result < delete ? result : delete;
                    matrix[i][j] = result;
                }
            }
        }
        return matrix[w1len][w2len];
    }

    public static class Record {
        int cost;
        int parentX;
        int parentY;

        Record() {}
        Record(int x, int y) {
            this.parentX = x;
            this.parentY = y;
        }
    }

    // debug path
    public int minDistanceDebugPath(String word1, String word2) {

        int w1len = word1.length();
        int w2len = word2.length();

        Record[][] matrix = new Record[w1len+1][w2len+1];
        for (int i=0; i<=w1len; i++) {
            for(int j=0; j<=w2len; j++) {
                matrix[i][j] = new Record(i, j);
            }
        }
        for (int i=1; i<=w1len; i++) {
            matrix[i][0].cost = i;
        }
        for (int i=1; i<=w2len; i++) {
            matrix[0][i].cost = i;
        }
        for (int i=1; i<=w1len; i++) {
            for (int j=1; j<=w2len; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    matrix[i][j].cost = matrix[i-1][j-1].cost;
                    matrix[i][j].parentX = i-1;
                    matrix[i][j].parentY = j-1;
                } else {
                    int change = 1 + matrix[i-1][j-1].cost;
                    int insert = 1 + matrix[i][j-1].cost;
                    int delete = 1 + matrix[i-1][j].cost;

                    int parent = 0; // 1 for chagne, 2 for insert, 3 for delete
                    int result = 0;
                    if (change < insert) {
                        result = change;
                        parent = 1;
                    } else {
                        result = insert;
                        parent = 2;
                    }

                    if (result > delete) {
                        result = delete;
                        parent = 3;
                    }
                    if (parent == 1) {
                        matrix[i][j].parentX = i-1;
                        matrix[i][j].parentY = j-1;
                    } else if (parent == 2) {
                        matrix[i][j].parentX = i;
                        matrix[i][j].parentY = j-1;
                    } else if (parent == 3) {
                        matrix[i][j].parentX = i-1;
                        matrix[i][j].parentY = j;
                    }
                    matrix[i][j].cost = result;
                }
            }
        }
        Stack<Record> path = new Stack<Record>();
        //printMatrix(matrix);
        pathHelper(matrix, w1len, w2len, path);
        while (!path.empty()) {
            Record r = path.pop();
            System.out.println(String.format("%s => %s", word1.substring(0, r.parentX), word2.substring(0, r.parentY)));
        }
        return matrix[w1len][w2len].cost;
    }

    protected void pathHelper(Record[][] matrix, int x, int y, Stack<Record> result) {
        if (x == 0 || y == 0) {
            result.push(new Record(x, y));
        } else {
            Record curr = matrix[x][y];
            result.push(new Record(x, y));
            pathHelper(matrix, curr.parentX, curr.parentY, result);
        }
    }

    protected void printMatrix(Record[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                System.out.print(String.format("%d ", matrix[i][j].cost));
                System.out.print(String.format("(%d,%d) ", matrix[i][j].parentX, matrix[i][j].parentY));
            }
            System.out.print("\n");
        }

    }
}
