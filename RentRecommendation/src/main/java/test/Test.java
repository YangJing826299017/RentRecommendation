package test;

import java.io.IOException;

import entity.Room;
import util.AnalyzeAnjukeRoomUtil;
import util.HttpUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		String roomUrl="https://sz.zu.anjuke.com/fangyuan/1270161415";
		Room room=AnalyzeAnjukeRoomUtil.getResult(HttpUtil.doGet(roomUrl),roomUrl);
		System.out.println(room.toString());
	}

}
