package org.comstudy21.exam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Test5 {
	public void storeDate_json() throws IOException {
		JSONArray productArr = new JSONArray();

		JSONObject p1 = new JSONObject();
		p1.put("name", "홍길동");
		p1.put("phone", "010-1111-1111");
		p1.put("address", "서울시");
		productArr.put(p1);
		
		JSONObject p2 = new JSONObject();
		p2.put("name", "김길동");
		p2.put("phone", "010-2222-2222");
		p2.put("address", "부산시");
		productArr.put(p2);

		JSONObject jsonobj = new JSONObject();
		jsonobj.put("students", productArr);

		File file = new File("src/org/comstudy21/exam/info.json");
		if (!file.exists()) {
			if (file.createNewFile()) {
				System.out.println("새 JSON 생성");
			}
		}
		FileWriter fw = new FileWriter(file);
		fw.write(jsonobj.toString(2));
		System.out.println("파일 쓰기 완료!");
		if (fw != null) {
			fw.close();
		}
	}

	public static void main(String[] args) throws IOException {
		Test5 t = new Test5();
		t.storeDate_json();	
		
		String src = "info.json"; 
		InputStream is = Test5.class.getResourceAsStream(src);
		if (is == null) { 
			throw new NullPointerException("Cannot find resource file"); 
			} 
		JSONTokener tokener = new JSONTokener(is);
		JSONObject students = new JSONObject(tokener);

		JSONArray studentArr = students.getJSONArray("students");

		for (int i = 0; i < studentArr.length(); i++) 		{ 
			JSONObject student = studentArr.getJSONObject(i);
			System.out.println("이름 : " + student.get("name")); 
			System.out.println("주소 : " + student.get("phone")); 
			System.out.println("나이 : " + student.get("address")); 
		}
			
	}
}
