package pobj.tme6.memory;

import java.util.ArrayList;
import java.util.List;

public class AddressDecoder implements ICopyableMemory {
	private int size;
	private List<MemorySlot> liste=new ArrayList<>();
	
	public AddressDecoder(int size) {
		this.size=size;
		
	}
	public void add(MemorySlot ms) {
		if(liste.size()<this.size) {
			liste.add(ms);
		}
	}
	public void remove(MemorySlot ms) {
		liste.remove(ms);
	}
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int read(int addr) {
		for(MemorySlot ms: liste) {
			if(ms.getBaseAddress()<=addr && addr<ms.getBaseAddress()+ms.getMemory().size()) {
				int relativeAddr=addr-ms.getBaseAddress();
				return ms.getMemory().read(relativeAddr);
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public void write(int addr, int value) {
		for(MemorySlot ms: liste) {
			if(ms.getBaseAddress()<=addr && addr<ms.getBaseAddress()+ms.getMemory().size()) {
				int relativeAddr=addr-ms.getBaseAddress();
				ms.getMemory().write(relativeAddr,value);
				return;
			}
		}
		throw new IllegalArgumentException();

	}
	@Override
	public ICopyableMemory copy() {
		AddressDecoder ad=new AddressDecoder(this.size);
		for(MemorySlot ms:liste) {
			if(ms.getMemory() instanceof ICopyableMemory) {
				ICopyableMemory copiedMemory=((ICopyableMemory)ms.getMemory()).copy();
				MemorySlot mss=new MemorySlot(ms.getBaseAddress(), copiedMemory);
				ad.add(mss);
			}else {
				throw new UnsupportedOperationException();
			}
		}
		return ad;
	}
	
}
