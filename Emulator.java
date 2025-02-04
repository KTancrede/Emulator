package pobj.tme6;

import pobj.tme6.cpu.CPU;
import pobj.tme6.device.Screen;
import pobj.tme6.memory.AddressDecoder;
import pobj.tme6.memory.MemorySlot;
import pobj.tme6.memory.RAM;
import pobj.tme6.memory.ROM;

public class Emulator {
	private EmulatorLoop el;
	private CPU cp;
	
	public Emulator(int[] rom) {
		ROM ro=new ROM(rom);
		RAM ra=new RAM(100,0);
		AddressDecoder m=new AddressDecoder(210);
		m.add(new MemorySlot(0, ro));
		m.add(new MemorySlot(100, ra));
		Screen s=new Screen();
		m.add(new MemorySlot(200, s));
		cp=new CPU(m);
		el=new EmulatorLoop(cp);
		el.addDevice(s);
	}
	
	public CPU getCPU() {
		return cp;
	}
	
	public void run(int time) {
		cp.reset();
		el.run(time);
	}
}
