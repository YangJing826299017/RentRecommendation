package test;

import java.io.IOException;
import java.util.Timer;

import timertask.AnalyzeAnjukePageTimerTask;
import timertask.AnalyzeAnjukeRoomTimerTask;
import timertask.AnalyzeGanjiPageTimerTask;
import timertask.AnalyzeGanjiRoomTimerTask;
import timertask.AnalyzeLeYouJiaPageTimerTask;
import timertask.AnalyzeLeYouJiaRoomTimerTask;


public class BeginTimer {

	public static void main(String[] args) throws IOException {
		//1.启动赶集网线程
		Timer timer=new Timer();
		timer.schedule(new AnalyzeGanjiPageTimerTask(),0,8*60*1000);//8分钟一次
		Timer timer2=new Timer();
		timer2.schedule(new AnalyzeGanjiRoomTimerTask(),4*60*1000,5*60*1000);//比上一个线程延迟4分钟,每5分钟一次
		
		//2.启动乐有家线程
		Timer timer3=new Timer();
		timer3.schedule(new AnalyzeLeYouJiaPageTimerTask(),0,8*60*1000);//8分钟一次
		Timer timer4=new Timer();
		timer4.schedule(new AnalyzeLeYouJiaRoomTimerTask(),4*60*1000,5*60*1000);//比上一个线程延迟4分钟,每5分钟一次
		
		//3.启动安居乐线程
		Timer timer5=new Timer();
		timer5.schedule(new AnalyzeAnjukePageTimerTask(),0,8*60*1000);//8分钟一次
		Timer timer6=new Timer();
		timer6.schedule(new AnalyzeAnjukeRoomTimerTask(),4*60*1000,5*60*1000);//比上一个线程延迟4分钟,每5分钟一次
		
	}

}
