package pobj.tme6.cpu;

import pobj.tme6.memory.IMemory;

public class CPUState implements ICPUState {
	private IMemory im;
	private int PC;
	private int A;
	
	
	public CPUState(IMemory im) {
		this.im = im;
		this.PC=0;
		this.A=0;
	}
	
	@Override
	public IMemory getMemory() {
		return im;
	}

	@Override
	public int getA() {
		return A;
	}


	@Override
	public void setA(int a) {
		A = a;
	}


	@Override
	public int getPC() {
		return PC;
	}
	@Override
	public void setPC(int pc) {
		this.PC=pc;
		
	}


	@Override
	public int fetch() {
		return im.read(PC++);
	}
	

}
