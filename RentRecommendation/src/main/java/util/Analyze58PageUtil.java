package util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.Room;

public class Analyze58PageUtil {
    
    private static String prefix="http:";
    
    public static List<Room> getResult(String htmlContent){
        List<Room> listRoom=new ArrayList<Room>();
        Document document=Jsoup.parse(htmlContent);
        Elements listDes=document.select(".des");
        for (Element one : listDes) {
            String url=one.select("h2>a").attr("href");
            Room room=new Room();
            room.setRoomUrl(prefix+url);
            listRoom.add(room);
        }
        return listRoom;
    }

}
