package algomonster.bfs;


import java.util.*;

public class KnightsMove {
    static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            Coordinate other = (Coordinate) o;
            return r == other.r && c == other.c;
        }
    }

    public static List<Coordinate> getNeighbours(Coordinate coord) {
        ArrayList<Coordinate> res = new ArrayList<>();
        int[] deltaRow = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] deltaCol = {-1, 1, 2, 2, 1, -1, -2, -2};
        for (int i = 0; i < deltaRow.length; i++) {
            int r = coord.r + deltaRow[i];
            int c = coord.c + deltaCol[i];
            res.add(new Coordinate(r, c));
        }
        return res;
    }

    public static int bfs(Coordinate start, int x, int y) {
        HashSet<Coordinate> visited = new HashSet<>();
        visited.add(start);
        int steps = 0;
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Coordinate node = queue.pop();
                if (node.c == x && node.r == y) {
                    return steps;
                }
                List<Coordinate> neighbors = getNeighbours(node);
                for (Coordinate neighbor : neighbors) {
                    if (visited.contains(neighbor)) continue;
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            steps++;
        }
        return steps;
    }

    public static int getKnightShortestPath(int x, int y) {
        return bfs(new Coordinate(0, 0), x, y);
    }
}
