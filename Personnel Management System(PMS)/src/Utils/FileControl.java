package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileControl {
	static String file = "ID.txt";//�ļ���ַ
	// �����ַ�����һ���ַ���һ���ַ�����
	public static String readFile() throws IOException {
		String line = null;
		// ��װ����Դ
		BufferedReader br = new BufferedReader(new FileReader(file));
		// ��ȡ����
		line = br.readLine();
		// �ͷ���Դ
		br.close();
		return line;
	}

	// �����ַ���дһ���ַ���һ���ַ�����
	public static boolean writeFile(String line) throws IOException {
		boolean flag=false;
		// ��װĿ�ĵ�
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		// ��д����
		if (line != null) {
			bw.write(line);
			flag=true;
		}
		// �ͷ���Դ
		bw.close();
		return flag;
	}
}
