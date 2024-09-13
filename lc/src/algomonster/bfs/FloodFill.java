package algomonster.bfs;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FloodFill {
    public static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static List<Coordinate> getNeighbours(List<List<Integer>> image, Coordinate node, int rootColor, int numRows, int numColumns) {
        List<Coordinate> neighbours = new ArrayList<>();
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        for (int i = 0; i < deltaRow.length; i++) {
            int neighbourRow = node.r + deltaRow[i];
            int neighbourColumn = node.c + deltaCol[i];

            if (0 <= neighbourRow && neighbourRow < numRows &&
                    0 <= neighbourColumn && neighbourColumn < numColumns) {
                if (image.get(neighbourRow).get(neighbourColumn) == rootColor) {
                    neighbours.add(new Coordinate(neighbourRow, neighbourColumn));
                }
            }
        }

        return neighbours;

    }

    public static void bfs(List<List<Integer>> image, Coordinate node, int replacementColour, int numRows, int numColumns) {
        Queue<Coordinate> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[numRows][numColumns];
        queue.add(node);
        int rootColor = image.get(node.r).get(node.c);
        image.get(node.r).set(node.c, replacementColour);
        visited[node.r][node.c] = true;
        while (queue.size() > 0) {

            int n = queue.size();
            Coordinate coordinate = queue.poll();

            for (Coordinate coordinate1 : getNeighbours(image, coordinate, rootColor, numRows, numColumns)) {
                if (visited[coordinate1.r][coordinate1.c])
                    continue;

                image.get(coordinate1.r).set(coordinate1.c, replacementColour);
                queue.add(coordinate1);
                visited[coordinate1.r][coordinate1.c] = true;
            }
        }
    }

    public static List<List<Integer>> floodFill(int r, int c, int replacement, List<List<Integer>> image) {
        int numRows = image.size();
        int numColumns = image.get(0).size();
        bfs(image, new Coordinate(r, c), replacement, numRows, numColumns);
        return image;
    }

}
