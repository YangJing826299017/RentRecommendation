package util;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import entity.LeYouJiaRoom;

public class HttpUtilTest {

	public static void main(String[] args) throws IOException {
		/*
		String content=HttpUtil.doGet("https://shenzhen.anjuke.com/community/view/188778");
		FileUtil.writeInFile("D:\\yangjing\\test","安居客小区信息1.txt", content);
		*/
		List<String> list=AnalyzeGanJiPageUtil.getResult(FileUtil.getContent("D:\\yangjing\\test","赶集网首页1.txt"));
		System.out.println(list);
	}

}
