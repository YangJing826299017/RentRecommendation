package util;

import java.io.IOException;

import com.google.gson.Gson;

import entity.FiveEightRoom;
import entity.LeYouJiaRoom;

public class HttpUtilTest {

	public static void main(String[] args) throws IOException {
		String content=FileUtil.getContent("D://test","58同城房屋.txt");
		FiveEightRoom list=Analyze58RoomUtil.getResult(content);
		/*
		Gson gson=new Gson();
		String result=gson.toJson(list);
		System.out.println(result);
		*/
	}

}
