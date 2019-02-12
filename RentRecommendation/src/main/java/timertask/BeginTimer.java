package timertask;

import java.util.Timer;

import util.HttpUtil;


public class BeginTimer {

	public static void main(String[] args) {
		/*
		Timer timer=new Timer();
		timer.schedule(new AnalyzeGanjiRoomTimerTask(),1000);
		*/
		System.out.println(HttpUtil.doGet("https://jxjump.58.com/service?target=FCADV8oV3os7xtAj_6pMK7rUlr2dRVsWCOvEJgxoX_BafAerZpk1zEffDjpdRkNz3Q5xoKYl4Bi0ja0S9EV948Hn78RT5eBG22crTyBP1ZKMCGY3NJhdD7RgzSJ4erNLPkPiseEvZYetOdm4StGtScJcqk4ukfCbRGVaWhwAwIAsnVFVxuEcn9KmvpYsiu1SCX0XjoUBr0SWsGtPTeM_X2KkjukgnTnuV4ut2oMzJts5psgXRWcITQUrVnQ&pubid=59830585&apptype=10&psid=102742998203157043489314193&entinfo=37115068928291_0&cookie=|||&fzbref=0&key=&params=rankjxzfbestpc2099^desc&gjcity=sz\r\n" + 
				""));
	}

}
