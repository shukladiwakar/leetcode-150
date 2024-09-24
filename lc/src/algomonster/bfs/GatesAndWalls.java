package algomonster.bfs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class GatesAndWalls {

    static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;

        }

        public Coordinate add(Coordinate other) {
            return new Coordinate(this.r + other.r, this.c + other.c);
        }
    }

    public static List<Coordinate> directions = List.of(new Coordinate(0, 1),
            new Coordinate(1, 0), new Coordinate(0, -1), new Coordinate(-1, 0));

    public static List<List<Integer>> mapGateDistances(List<List<Integer>> dungeonMap) {
        int numRows = dungeonMap.size();
        int numColumns = dungeonMap.get(0).size();
        Queue<Coordinate> queue = new ArrayDeque<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (dungeonMap.get(i).get(j) == 0) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        while (queue.size() > 0) {
            Coordinate node = queue.poll();

            for (Coordinate coordinate : directions) {
                Coordinate newCoords = coordinate.add(node);

                if (newCoords.r >= 0 && newCoords.r < numRows &&
                        newCoords.c >= 0 && newCoords.c < numColumns) {
                    if (dungeonMap.get(newCoords.r).get(newCoords.c) == Integer.MAX_VALUE) {
                        dungeonMap.get(newCoords.r).set(newCoords.c, 1 + dungeonMap.get(node.r).get(node.c));

                        queue.add(newCoords);
                    }
                }
            }
        }
        return dungeonMap;
    }
}
