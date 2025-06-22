class ComputerBuilder implements Builder{
    private final Computer computer;

    public ComputerBuilder(){
        this.computer=new Computer();
    }

    @Override
    public void buildCpu(){
        computer.setCpu("Multi-Core CPU");
    }
    @Override
    public void buildRam(){
        computer.setRam("16GB RAM");
    }
    @Override
    public void buildStorage(){
        computer.setStorage("512 GB SSD");
    }
    @Override
    public Computer getResult() {
        return computer;
    }
}
