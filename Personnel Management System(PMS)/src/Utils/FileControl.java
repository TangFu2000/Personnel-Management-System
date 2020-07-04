package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileControl {
	static String file = "ID.txt";//文件地址
	// 缓冲字符流读一行字符（一个字符串）
	public static String readFile() throws IOException {
		String line = null;
		// 封装数据源
		BufferedReader br = new BufferedReader(new FileReader(file));
		// 读取数据
		line = br.readLine();
		// 释放资源
		br.close();
		return line;
	}

	// 缓冲字符流写一行字符（一个字符串）
	public static boolean writeFile(String line) throws IOException {
		boolean flag=false;
		// 封装目的地
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		// 读写数据
		if (line != null) {
			bw.write(line);
			flag=true;
		}
		// 释放资源
		bw.close();
		return flag;
	}
}
