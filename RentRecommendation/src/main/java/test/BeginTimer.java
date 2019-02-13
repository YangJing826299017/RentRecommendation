package test;

import java.io.IOException;
import java.util.Timer;

import timertask.AnalyzeGanjiRoomTimerTask;


public class BeginTimer {

	public static void main(String[] args) throws IOException {
		Timer timer=new Timer();
		timer.schedule(new AnalyzeGanjiRoomTimerTask(),1000);
	}

}
