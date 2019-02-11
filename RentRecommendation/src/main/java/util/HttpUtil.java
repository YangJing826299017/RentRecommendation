package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;


public class HttpUtil {
    
    //cpdetector
	
	public static String doGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = "";// 杩斿洖缁撴灉瀛楃涓�
        try {

            URL url = new URL(httpurl);
         // 閫氳繃杩滅▼url杩炴帴瀵硅薄鎵撳紑涓�涓繛鎺ワ紝寮鸿浆鎴恏ttpURLConnection绫�
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Host","shenzhen.leyoujia.com");
            connection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            connection.setRequestProperty("Accept-Encoding","gzip");
            connection.setRequestProperty("Referer"," https://shenzhen.leyoujia.com/zf/?n=2");
            //connection.setRequestProperty("Cookie","imTipShowzf=true; cookiesId=87f45cd8c69c45b0a33c7a4caea0613a; jjshome_uuid=0690ad83-af0b-1eba-aae7-a4f8b5fcfddb; gr_user_id=44fbe146-27fe-4827-a547-a8849031db57; Hm_lvt_1851e6f08c8180e1e7b5e33fb40c4b08=1547803894,1548749046; grwng_uid=10a11e50-86e8-4971-a24f-da4a87c6e3e1; Hm_lvt_728857c2e6b321292b2eb422213d1609=1547803894,1548749046; _ga=GA1.2.303830182.1547803895; default_city_code=000002; JSESSIONID-FANG=904C153186B03F7A651AB160F0EFF128; zf_yywt_hash='JlaifNPVMPTHtHf5me-laPgTF9U2CHrPgJhHK5k1gZJ-MPmxCrpeiw==1'; Hm_lpvt_1851e6f08c8180e1e7b5e33fb40c4b08=1548749496; Hm_lpvt_728857c2e6b321292b2eb422213d1609=1548749496; 999dfdb0f2bbc202_gr_session_id_710c6b79-a287-4de1-b2cc-66f86942d4d6=true; 999dfdb0f2bbc202_gr_session_id=710c6b79-a287-4de1-b2cc-66f86942d4d6; _gid=GA1.2.1860823633.1548749047");
            connection.setRequestProperty("Upgrade-Insecure-Requests","1");
            connection.setRequestProperty("Pragma","no-cache");
            connection.setRequestProperty("Cache-Control","no-cache");
            connection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0");
            // 璁剧疆杩炴帴鏂瑰紡锛歡et
            connection.setRequestMethod("GET");
            // 璁剧疆杩炴帴涓绘満鏈嶅姟鍣ㄧ殑瓒呮椂鏃堕棿锛�15000姣
            connection.setConnectTimeout(15000);
            // 璁剧疆璇诲彇杩滅▼杩斿洖鐨勬暟鎹椂闂达細60000姣
            connection.setReadTimeout(60000);
            // 鍙戦�佽姹�
            connection.connect();
            // 閫氳繃connection杩炴帴锛岃幏鍙栬緭鍏ユ祦
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                InputStream stream = new GZIPInputStream(is);  
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"utf-8"));  
                StringBuffer sb = new StringBuffer(); 
                String line = "";  
                while ((line = reader.readLine()) != null){  
                    sb.append(line);  
                }  
                return sb.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 鍏抽棴璧勬簮
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 鍏抽棴杩滅▼杩炴帴
        }

        return result;
    }
	
	public static String doPost(String httpUrl, String param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 閫氳繃杩滅▼url杩炴帴瀵硅薄鎵撳紑杩炴帴
            connection = (HttpURLConnection) url.openConnection();
            // 璁剧疆杩炴帴璇锋眰鏂瑰紡
            connection.setRequestMethod("POST");
            // 璁剧疆杩炴帴涓绘満鏈嶅姟鍣ㄨ秴鏃舵椂闂达細15000姣
            connection.setConnectTimeout(15000);
            // 璁剧疆璇诲彇涓绘満鏈嶅姟鍣ㄨ繑鍥炴暟鎹秴鏃舵椂闂达細60000姣
            connection.setReadTimeout(60000);

            // 榛樿鍊间负锛歠alse锛屽綋鍚戣繙绋嬫湇鍔″櫒浼犻�佹暟鎹�/鍐欐暟鎹椂锛岄渶瑕佽缃负true
            connection.setDoOutput(true);
            // 榛樿鍊间负锛歵rue锛屽綋鍓嶅悜杩滅▼鏈嶅姟璇诲彇鏁版嵁鏃讹紝璁剧疆涓簍rue锛岃鍙傛暟鍙湁鍙棤
            connection.setDoInput(true);
            // 璁剧疆浼犲叆鍙傛暟鐨勬牸寮�:璇锋眰鍙傛暟搴旇鏄� name1=value1&name2=value2 鐨勫舰寮忋��
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 璁剧疆閴存潈淇℃伅锛欰uthorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 閫氳繃杩炴帴瀵硅薄鑾峰彇涓�涓緭鍑烘祦
            os = connection.getOutputStream();
            // 閫氳繃杈撳嚭娴佸璞″皢鍙傛暟鍐欏嚭鍘�/浼犺緭鍑哄幓,瀹冩槸閫氳繃瀛楄妭鏁扮粍鍐欏嚭鐨�
            os.write(param.getBytes());
            // 閫氳繃杩炴帴瀵硅薄鑾峰彇涓�涓緭鍏ユ祦锛屽悜杩滅▼璇诲彇
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                //ZipDecompressing.Decompress(is);
                /*
                // 瀵硅緭鍏ユ祦瀵硅薄杩涜鍖呰:charset鏍规嵁宸ヤ綔椤圭洰缁勭殑瑕佹眰鏉ヨ缃�
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 寰幆閬嶅巻涓�琛屼竴琛岃鍙栨暟鎹�
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
                */
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 鍏抽棴璧勬簮
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 鏂紑涓庤繙绋嬪湴鍧�url鐨勮繛鎺�
            connection.disconnect();
        }
        return result;
    }
}