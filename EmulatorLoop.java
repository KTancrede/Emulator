package pobj.tme6;

import java.util.ArrayList;
import java.util.List;

import pobj.tme6.cpu.ICPU;
import pobj.tme6.device.IDevice;

public class EmulatorLoop implements IEmulatorLoop {
	private ICPU cpu;
	private List<IDevice> lp=new ArrayList<IDevice>();
	public EmulatorLoop(ICPU cpu) {
		this.cpu=cpu;
	}
	@Override
	public void addDevice(IDevice t) {
		lp.add(t);
	}

	@Override
	public void run(int time) {
		int compteur=0;
		while(compteur<time) {
			 int valeur=cpu.execute();
			 compteur+=valeur;
			 for(IDevice id:lp) {
				 id.tick(valeur);
			 }
		}

	}
}
