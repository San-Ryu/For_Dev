package Etc;
  
import java.io.*;
import java.util.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON_2nd {
	public static void main(String args[]) throws Exception{
		// init
		JSONParser parser = new JSONParser();
		JSONArray objarrRawJSON = (JSONArray) parser.parse(new FileReader("c:\\temp\\extracted_1st.json"));
		// init
		
		// Start : JSON 데이터 추출
		JSONObject objQAS = null; // qas [Arr]
		String strQuestion = null; // question 
		String longAnswer_start = null; // answer_start
		String strText = null; // text
		HashMap<String, String> mapQAS = new HashMap<String, String>();
		
		for(int i = 0; i < objarrRawJSON.size(); i++) {
			objQAS = (JSONObject) objarrRawJSON.get(i); // Data
			
			strQuestion = (String) objQAS.get("Question"); // answers
			
			longAnswer_start = (String) objQAS.get("Answer_start"); // answer_start 
			strText = (String) objQAS.get("Text"); // text

			// 중간 확인
			System.out.println(strQuestion);
			System.out.println(longAnswer_start);
			System.out.println(strText);
		}
		// End : JSON 데이터 확인
	}
}