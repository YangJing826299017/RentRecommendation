package timertask;

import java.util.Timer;

public class BeginTimer {

	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new AnalyzeGanjiPageTimerTask(), 1000, 5*60*1000);
	}

}
