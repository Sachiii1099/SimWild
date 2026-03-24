import java.util.Random;
public class Carnivore extends Entity {
    Random rand = new Random();
    public Carnivore(int x, int y) {
        super(x, y);
    }
    @Override
    public void act(Grid grid) {
        int newX = x + rand.nextInt(3) - 1;
        int newY = y + rand.nextInt(3) - 1;
        if (grid.isValid(newX, newY)) {
            Entity target = grid.getEntity(newX, newY);
            if (target instanceof Herbivore) {
                grid.removeEntity(target); // eat herbivore
                grid.moveEntity(this, newX, newY);
            } else if (target == null) {
                grid.moveEntity(this, newX, newY);
            }
        }
    }

    @Override
    public String toString() {
        return "C";
    }
}