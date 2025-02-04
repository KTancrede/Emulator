package pobj.tme6.device;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Clock implements IDevice {
	private int date;
	private List<Alarm> la=new ArrayList<Alarm>();
	
	public void addAlarm(Alarm a) {
		la.add(a);
		Collections.sort(la, (o1, o2) -> o2.compareTo(o1));
	}
	@Override
	public void tick(int time) {
		date+=time;
		
		for (int i = la.size() - 1; i >= 0; i--) {
            Alarm a = la.get(i);
            if (a.getDate() <= date) {
                a.action(); // Exécute l'action de l'alarme
                la.remove(i); // Retire l'alarme de la liste
            }
        }

	}

}
