package pobj.tme6.device;

public class Alarm implements Comparable<Alarm> {
	private int date;
	private IAction act;
	
	public Alarm(int date, IAction act) {
		this.date = date;
		this.act = act;
	}

	public int getDate() {
		return date;
	}

	public void action() {
		act.action();
	}
	@Override
	public int compareTo(Alarm o) {
		if(this.date==o.getDate())
			return 0;
		if(this.date<o.getDate())
			return 1;
		else
			return -1;
	}

}
