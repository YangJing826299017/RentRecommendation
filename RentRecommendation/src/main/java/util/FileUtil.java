package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileUtil {
	
	public static void writeInFile(String filePath,String fileName,String fileContent,boolean isAppend) throws IOException {
		File file=new File(filePath,fileName);
		//创建文件
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),isAppend);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(fileContent);
		bw.newLine();
		bw.close();
	}
	
	public static String getContent(String filePath,String fileName) throws IOException {
		File file=new File(filePath,fileName);
		InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),"UTF-8");//考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        StringBuilder sb=new StringBuilder();
        while ((lineTxt = bufferedReader.readLine()) != null) {
        		sb.append(lineTxt);
         }       
        read.close();
		return sb.toString();
	}

}
