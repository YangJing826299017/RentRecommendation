package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {
	
	public static void writeInFile(String filePath,String fileName,String fileContent) throws IOException {
		File file=new File(filePath,fileName);
		//创建文件
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(fileContent);
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
