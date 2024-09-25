package algomonster.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {

    public static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static List<Coordinate> getNeighbours(Coordinate node, int numberOfRows, int numberOfColumns) {
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaColumn[] = {0, 1, 0, -1};

        List<Coordinate> neighbours = new ArrayList<>();

        for (int i = 0; i < deltaRow.length; i++) {
            int newR = node.r + deltaRow[i];
            int newC = node.c + deltaColumn[i];

            if (newR >= 0 && newR < numberOfRows &&
                    newC >= 0 && newC < numberOfColumns) {
                neighbours.add(new Coordinate(newR, newC));
            }
        }
        return neighbours;
    }

    public static void bfs(List<List<Integer>> grid, Coordinate node, int numRows, int numColumns) {
        Queue<Coordinate> coordinateQueue = new ArrayDeque<>();

        coordinateQueue.add(node);
        grid.get(node.r).set(node.c, 0);
        while (coordinateQueue.size() > 0) {

            Coordinate coordinate = coordinateQueue.poll();
            List<Coordinate> neighbours = getNeighbours(coordinate, numRows, numColumns);

            for (Coordinate coordinate1 : neighbours) {
                if (grid.get(coordinate1.r).get(coordinate1.c) == 0) {
                    continue;
                }
                coordinateQueue.add(coordinate1);
                grid.get(coordinate1.r).set(coordinate1.c, 0);
            }
        }
    }

    public static int countNumberOfIslands(List<List<Integer>> grid) {
        int numRows = grid.size();
        int numColumns = grid.get(0).size();
        int count = 0;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {

                if (grid.get(i).get(j) == 0) {
                    continue;
                }
                bfs(grid, new Coordinate(i, j), numRows, numColumns);
                count++;
            }
        }
        return count;
    }

}
