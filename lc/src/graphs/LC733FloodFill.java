package graphs;

import algomonster.bfs.FloodFill;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC733FloodFill {
    public static class Coordinate {
        public int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static List<Coordinate> getNeighbours(int[][] image, Coordinate node, int rootColor, int numRows, int numColumns) {
        List<Coordinate> neighbours = new ArrayList<>();
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        for (int i = 0; i < deltaRow.length; i++) {
            int neighbourRow = node.r + deltaRow[i];
            int neighbourColumn = node.c + deltaCol[i];

            if (0 <= neighbourRow && neighbourRow < numRows &&
                    0 <= neighbourColumn && neighbourColumn < numColumns) {
                if (image[neighbourRow][neighbourColumn] == rootColor) {
                    neighbours.add(new Coordinate(neighbourRow, neighbourColumn));
                }
            }
        }

        return neighbours;

    }

    public static void bfs(int[][] image, Coordinate node, int replacementColour, int numRows, int numColumns) {
        Queue<Coordinate> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[numRows][numColumns];
        queue.add(node);
        int rootColor = image[node.r][node.c];
        image[node.r][node.c] = replacementColour;
        visited[node.r][node.c] = true;
        while (queue.size() > 0) {

            int n = queue.size();
            Coordinate coordinate = queue.poll();

            for (Coordinate coordinate1 : getNeighbours(image, coordinate, rootColor, numRows, numColumns)) {
                if (visited[coordinate1.r][coordinate1.c])
                    continue;

                image[coordinate1.r][coordinate1.c] = replacementColour;
                queue.add(coordinate1);
                visited[coordinate1.r][coordinate1.c] = true;
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int numRows = image.length;
        int numColumns = image[0].length;
        bfs(image, new Coordinate(sr, sc), color, numRows, numColumns);
        return image;
    }
}
