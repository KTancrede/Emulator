package pobj.tme6.device;

import pobj.tme6.memory.IMemory;
import pobj.tme6.memory.RAM;

public class Screen extends PeriodicDevice implements IMemory{
	private RAM ra;
	
	public Screen() {
		super(100);
		this.ra=new RAM(10, 32);
	}
	
	@Override
	public int size() {
		return ra.size();
	}

	@Override
	public int read(int addr) {
		return ra.read(addr);
	}

	@Override
	public void write(int addr, int value) {
		ra.write(addr, value);
	}

	@Override
	public void action() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ra.size();i++) {
			sb.append((char)read(i));
		}
		System.out.println(sb);
	}

}
