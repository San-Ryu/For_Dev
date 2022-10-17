package Etc;
  
import java.io.*;
import java.util.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON {
	static int V, E;
	
	public static void main(String args[]) throws Exception{
		JSONParser parser = new JSONParser();
		JSONObject objRawJSON = (JSONObject) parser.parse(new FileReader("c:\\\\temp\\\\ko_wiki_v1_squad.json"));
		
//		System.out.println(ob);
		
		String txtCreator = (String) objRawJSON.get("creator");
		System.out.println(txtCreator);
		String txtVer = (String) objRawJSON.get("version");
		System.out.println(txtVer);
		
		JSONArray objArrData = (JSONArray) objRawJSON.get("data");	// Data [Arr]
		JSONObject objData = null; // data [Arr]
		JSONArray objarrParagraphs = null; // paragraphs [Arr]
		JSONObject objarrParagraph = null; // paragraphs [Arr]
		JSONObject objTitle = null; // title
		JSONArray objQAS = null; // qas [Arr]
		JSONObject objContext = null; // context
		JSONObject objQuestion = null; // question 
		JSONArray objarrAnswers = null; // answers [Arr]
		JSONObject objId = null; // id
		JSONObject objAnswer_start = null; // answer_start
		JSONObject objText = null; // text
		StringBuilder sb = new StringBuilder();
		// 배열 데이터 출력
		for(int i = 0; i < objArrData.size(); i++) {
			objData = (JSONObject) objArrData.get(i); // Data
			objarrParagraphs = (JSONArray) objData.get("paragraphs"); // Paragraphs
//			objTitle = (JSONObject) objData.get("title"); // Title
			
			objarrParagraph = (JSONObject) objarrParagraphs.get(0);
			objQAS = (JSONArray) objarrParagraph.get("qas"); // QAS
//			objContext = (JSONObject) objarrParagraphs.get(1); // context
			
			objQuestion = (JSONObject) objQAS.get(0); // question
//			objarrAnswers = (JSONArray) objarrParagraphs.get(1); // answers
//			objId = (JSONObject) objarrParagraphs.get(2); // id
//			
//			objAnswer_start = (JSONObject) objarrAnswers.get(0); // answer_start
//			objText = (JSONObject) objarrAnswers.get(1); // text
//			
			System.out.println(objQuestion);
			
			if(i == 9) {
				break;
			}
			
		}
		
		
		
		
//		JSONArray objarrQAS = (JSONArray) objData.getJSONArray("qas");
//		String strQuestion = (String) objQAS.get("question");
//		System.out.println(strQuestion);
	}
}