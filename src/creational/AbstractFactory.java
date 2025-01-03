package creational;

// Abstract Product: CPU
interface CPU {
    void process();
}

// Abstract Product: GPU
interface GPU {
    void render();
}

// Abstract Product: RAM
interface RAM {
    void load();
}


// Concrete Product: Gaming PC CPU (e.g., Intel)
class GamingPC_CPU implements CPU {
    @Override
    public void process() {
        System.out.println("Gaming PC CPU processing with Intel.");
    }
}

// Concrete Product: Gaming PC GPU (e.g., Nvidia)
class GamingPC_GPU implements GPU {
    @Override
    public void render() {
        System.out.println("Gaming PC GPU rendering with Nvidia.");
    }
}

// Concrete Product: Gaming PC RAM
class GamingPC_RAM implements RAM {
    @Override
    public void load() {
        System.out.println("Gaming PC RAM loading high-speed data.");
    }
}

// Concrete Product: Workstation PC CPU (e.g., AMD)
class WorkstationPC_CPU implements CPU {
    @Override
    public void process() {
        System.out.println("Workstation PC CPU processing with AMD.");
    }
}

// Concrete Product: Workstation PC GPU (e.g., AMD Radeon)
class WorkstationPC_GPU implements GPU {
    @Override
    public void render() {
        System.out.println("Workstation PC GPU rendering with AMD Radeon.");
    }
}

// Concrete Product: Workstation PC RAM
class WorkstationPC_RAM implements RAM {
    @Override
    public void load() {
        System.out.println("Workstation PC RAM loading data for heavy tasks.");
    }
}

// Abstract Factory
interface ComputerFactory {
    CPU createCPU();
    GPU createGPU();
    RAM createRAM();
}


class GamingPCFactory implements ComputerFactory {
    @Override
    public CPU createCPU() {
        return new GamingPC_CPU();
    }

    @Override
    public GPU createGPU() {
        return new GamingPC_GPU();
    }

    @Override
    public RAM createRAM() {
        return new GamingPC_RAM();
    }
}

// Concrete Factory for Workstation PC
class WorkstationPCFactory implements ComputerFactory {
    @Override
    public CPU createCPU() {
        return new WorkstationPC_CPU();
    }

    @Override
    public GPU createGPU() {
        return new WorkstationPC_GPU();
    }

    @Override
    public RAM createRAM() {
        return new WorkstationPC_RAM();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        // Create a Gaming PC
        ComputerFactory gamingFactory = new GamingPCFactory();
        CPU gamingCPU = gamingFactory.createCPU();
        GPU gamingGPU = gamingFactory.createGPU();
        RAM gamingRAM = gamingFactory.createRAM();

        gamingCPU.process();  // Output: Gaming PC CPU processing with Intel.
        gamingGPU.render();   // Output: Gaming PC GPU rendering with Nvidia.
        gamingRAM.load();     // Output: Gaming PC RAM loading high-speed data.

        // Create a Workstation PC
        ComputerFactory workstationFactory = new WorkstationPCFactory();
        CPU workstationCPU = workstationFactory.createCPU();
        GPU workstationGPU = workstationFactory.createGPU();
        RAM workstationRAM = workstationFactory.createRAM();

        workstationCPU.process();  // Output: Workstation PC CPU processing with AMD.
        workstationGPU.render();   // Output: Workstation PC GPU rendering with AMD Radeon.
        workstationRAM.load();     // Output: Workstation PC RAM loading data for heavy tasks.

    }
}
