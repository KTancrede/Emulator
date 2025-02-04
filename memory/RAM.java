package pobj.tme6.memory;

public class RAM implements ICopyableMemory {
	private int size;
	private int[] tab;
	
	public RAM(int size,int init) {
		this.tab= new int[size];
		this.size=size;
		for(int i=0;i<size;i++) {
			tab[i]=init;
		}
		
	}
	public int read(int addr) {
			return tab[addr];
	};
	
	public void write(int addr, int value) {
		this.tab[addr]=value;
	};
	
	public int size() {
		return this.size;
	}
	@Override
	public ICopyableMemory copy() {
		RAM r=new RAM(this.size, 0);
		for(int i=0;i<size;i++) {
			r.write(i, tab[i]);
		}
		return r;
	}
	
}
