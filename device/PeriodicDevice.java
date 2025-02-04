package pobj.tme6.device;

public abstract class PeriodicDevice implements IDevice {
	private int compteur;
	private int period;
	
	public PeriodicDevice(int period) {
		this.compteur = period;
		this.period = period;
	}
	
	@Override
	public void tick(int time) {
		this.compteur-=time;
		if(compteur<=0) {
			action();
			this.compteur+=this.period;
		}

	}

	public abstract void action();

}
