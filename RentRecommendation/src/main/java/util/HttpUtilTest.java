package util;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import entity.LeYouJiaRoom;

public class HttpUtilTest {

	public static void main(String[] args) throws IOException {
		String content=HttpUtil.doGet("https://shenzhen.leyoujia.com/zf/detail/7575453.html");
		System.out.println(content);
		List<LeYouJiaRoom> list=AnalyzeLeYouJiaPageUtil.getResult(content);
		Gson gson=new Gson();
		String result=gson.toJson(list);
		System.out.println(result);
	}

}
