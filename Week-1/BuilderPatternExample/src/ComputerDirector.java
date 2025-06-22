public class ComputerDirector {
    public void construct(Builder builder){
        builder.buildCpu();
        builder.buildRam();
        builder.buildStorage();
    }
}
