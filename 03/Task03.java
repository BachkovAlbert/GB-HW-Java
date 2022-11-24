import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Task03 {
    public Task03() {
    }

    public static void main(String[] args) {
        var mg = new MapGenerator();
        Point2D start = new Point2D(3, 3);
        mg.setStart(start);
        System.out.println("Пустая карта, где 1 - начало маршрута");
        System.out.println(new MapPrinter().rawData(mg.getMap()));

        var lee = new Algorithm(mg.getMap());
        lee.Colorize(new Point2D(3, 3));
        System.out.println("Карта заполненая волновым алгоритмом");
        System.out.println(new MapPrinter().rawData(mg.getMap()));
        var finish = lee.getRoad(mg.setExit(42));
        lee.drawRoad(finish);
        System.out.println("Визуальный показ кратчайшего маршрута от начала маршрута до указанной конечной точки");
        System.out.println(new MapPrinter().mapColor(mg.getMap()));

    }
}

class Algorithm {
    int[][] map;

    public Algorithm(int[][] map) {
        this.map = map;
    }

    public void Colorize(Point2D startPoint) {
        Queue<Point2D> queue = new LinkedList<>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;

        while (queue.size() != 0) {
            Point2D p = queue.remove();

            if (map[p.x - 1][p.y] == 0) {
                queue.add(new Point2D(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0) {
                queue.add(new Point2D(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0) {
                queue.add(new Point2D(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0) {
                queue.add(new Point2D(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
        }
    }

    public ArrayList<Point2D> getRoad(Point2D exitPoint) {
        ArrayList<Point2D> road = new ArrayList<>();
        road.add(new Point2D(exitPoint.x, exitPoint.y));
        while (map[exitPoint.x][exitPoint.y] > 1) {

            if (map[exitPoint.x - 1][exitPoint.y] < map[exitPoint.x][exitPoint.y] && map[exitPoint.x - 1][exitPoint.y] > 0) {
                exitPoint.x -= 1;
                road.add(new Point2D(exitPoint.x, exitPoint.y));
            }
            if (map[exitPoint.x][exitPoint.y - 1] < map[exitPoint.x][exitPoint.y] && map[exitPoint.x][exitPoint.y - 1] > 0) {
                exitPoint.y -= 1;
                road.add(new Point2D(exitPoint.x, exitPoint.y));
            }
            if (map[exitPoint.x + 1][exitPoint.y] < map[exitPoint.x][exitPoint.y] && map[exitPoint.x + 1][exitPoint.y] > 0) {
                exitPoint.x += 1;
                road.add(new Point2D(exitPoint.x, exitPoint.y));
            }
            if (map[exitPoint.x][exitPoint.y + 1] < map[exitPoint.x][exitPoint.y] && map[exitPoint.x][exitPoint.y + 1] > 0) {
                exitPoint.y += 1;
                road.add(new Point2D(exitPoint.x, exitPoint.y));
            }
        }
        return road;
    }

    public void drawRoad(ArrayList<Point2D> road) {
        for (Point2D point2D : road) {
            map[point2D.x][point2D.y] = 0;
        }
    }    
}

class Point2D {
    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}

class MapPrinter {
    public MapPrinter() {
    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%4d", map[row][col]));
            }
            sb.append("\n");
        }
        for (int i = 0; i < 2; i++) {
            sb.append("\n");
        }

        return sb.toString();
    }

    public String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append("██");
                        break;
                    case -1:
                        sb.append("░░");
                        break;
                    case 1:
                        sb.append("S");
                        break;
                    default:
                        sb.append("  ");
                        break;
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < 2; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }
}

class MapGenerator {
    int[][] map;

    public MapGenerator() {

        this.map = new int[][]{
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, -1, -1, -1, -1, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, -1},
                {-1, -1, -1, 0, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, -1, 0, 0, -1, -1, -1, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, -1, -1, 0, -1, -1, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1},
                {-1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
    }

    public int[][] getMap() {
        return map;
    }

    public void setStart(Point2D pos) {
        map[pos.x][pos.y] = 1;
    }

    public Point2D setExit(int ep) {
        Point2D exit = new Point2D(0, 0);
        boolean found = false;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == ep) {
                    exit = new Point2D(i, j);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        return exit;
    }
}

