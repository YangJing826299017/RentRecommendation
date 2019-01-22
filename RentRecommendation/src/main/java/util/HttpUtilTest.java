package util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpUtilTest {

	public static void main(String[] args) {
		Document jsoup;
		try {
			jsoup = Jsoup.connect("https://shenzhen.leyoujia.com//zf/detail/7575453.html").get();
			System.out.println(jsoup.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
