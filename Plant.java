import java.util.Random;
public class Plant extends Entity{
    Random rand=new Random();
    public Plant(int x,int y){
        super(x,y);
    }
    @Override
    public void act(Grid grid){
        if(rand.nextInt(10)<2){
            int newX=x+rand.nextInt(3)-1;
            int newY=y+rand.nextInt(3)-1;
            if(grid.isValid(newX,newY)&& grid.isEmpty(newX,newY)){
                grid.addEntity(new Plant(newX,newY));
            }
        }
    }
    @Override
    public String toString(){
        return"P";
    }
}