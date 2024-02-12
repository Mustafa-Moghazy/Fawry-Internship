package facade;

import system.*;

public class ComputerSystemFacade {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    public void start(){
        cpu.execute();
        memory.load();
        hardDrive.read();
    }
    public void shutdown(){
        cpu.freeze();
        memory.unload();
        hardDrive.write();
    }
}
