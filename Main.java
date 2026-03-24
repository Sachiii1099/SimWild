public class Main {
    public static void main(String[] args) throws InterruptedException {
        Grid grid = new Grid(10, 10);
        grid.addEntity(new Plant(2, 2));
        grid.addEntity(new Plant(3, 3));
        grid.addEntity(new Herbivore(5, 5));
        grid.addEntity(new Carnivore(7, 7));
        for (int i = 0; i < 20; i++) {
            grid.printGrid();
            grid.simulateStep();
            Thread.sleep(500);
        }
    }
}