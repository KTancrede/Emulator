package pobj.tme6.cpu;

import java.util.ArrayList;
import java.util.List;

import pobj.tme6.cpu.op.*;
import pobj.tme6.memory.IMemory;

public class CPU implements ICPU {
	private ICPUState state;
	private List<IOpCode<ICPUState>> ops=new ArrayList<IOpCode<ICPUState>>();
	
	public CPU(IMemory memory) {
		this.state=new CPUState(memory);
		ops.add(new OpSet());
		ops.add(new OpAdd());
		ops.add(new OpLoad());
		ops.add(new OpStore());
		ops.add(new OpJump());
		
	}
	public ICPUState getState() {
		return this.state;
	}
	@Override
	public void reset() {
		this.state.setA(0);
		this.state.setPC(0);
	}

	@Override
	public int execute() {
		int opCode=state.fetch();
		if (opCode>=0 && opCode<=4) {
					return ops.get(opCode).execute(state);
		}
		else {
			return 1;
		}
	}

}
