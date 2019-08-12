package day23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyFile {
	public static void save(String fileName, Object obj) {
		FileOutputStream fis = null;
		ObjectOutputStream oos = null;

		try {
			fis = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fis);
			oos.writeObject(obj);
			oos.flush();
			//System.out.println(obj + "가 " + fileName + "에 저장되었습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static Object load(String fileName){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object data = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			data = ois.readObject();
			//System.out.println(fileName + " 파일로부터 " + data + " Load 완료");
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
