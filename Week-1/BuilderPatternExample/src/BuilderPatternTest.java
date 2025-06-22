public class BuilderPatternTest {
    public static void main(String[] args){
        ComputerBuilder Builder = new ComputerBuilder();
        ComputerDirector director = new ComputerDirector();

        director.construct(Builder);
        Computer gamingComputer = Builder.getResult();

        gamingComputer.displayInfo();
    }
}
