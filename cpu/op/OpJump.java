package pobj.tme6.cpu.op;

import pobj.tme6.cpu.ICPUState;

public class OpJump implements IOpCode<ICPUState> {
	@Override
	public int execute(ICPUState state) {
		if(state.getA()>0) {
			state.setPC(state.fetch());
		}else {
			state.fetch();
		}
		return 2;
	}

}
