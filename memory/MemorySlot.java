package pobj.tme6.memory;

public class MemorySlot {
	private int addr;
	private IMemory imAddr;
	
	public MemorySlot(int addr, IMemory imAddr) {
		this.addr = addr;
		this.imAddr = imAddr;
	}
	public int getBaseAddress() {
		return addr;
	}

	public IMemory getMemory() {
		return imAddr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if((obj instanceof MemorySlot ms)) {
			return ms.getBaseAddress()==this.addr && ms.getMemory()==this.imAddr;
		}
		return false;
	}

	
}
