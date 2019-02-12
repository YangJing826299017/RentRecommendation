package timertask;

import java.util.Timer;


public class BeginTimer {

	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new AnalyzeGanjiRoomTimerTask(),1000);
	}

}
