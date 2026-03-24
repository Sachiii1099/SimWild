import java.util.*;

public class Grid {
    private Entity[][] grid;
    private int rows, cols;
    private List<Entity> entities;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Entity[rows][cols];
        entities = new ArrayList<>();
    }

    public void addEntity(Entity e) {
        grid[e.getX()][e.getY()] = e;
        entities.add(e);
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    public boolean isEmpty(int x, int y) {
        return grid[x][y] == null;
    }

    // ✅ IMPORTANT METHOD (missing tha)
    public Entity getEntity(int x, int y) {
        return grid[x][y];
    }

    public void moveEntity(Entity e, int newX, int newY) {
        grid[e.getX()][e.getY()] = null;
        e.setPosition(newX, newY);
        grid[newX][newY] = e;
    }

    // ✅ FIX: entity → Entity
    public void removeEntity(Entity e) {
        grid[e.getX()][e.getY()] = null;
        entities.remove(e);
    }

    public void simulateStep() {
        List<Entity> copy = new ArrayList<>(entities);
        for (Entity e : copy) {
            e.act(this);
        }
    }

    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == null)
                    System.out.print(". ");
                else
                    System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}