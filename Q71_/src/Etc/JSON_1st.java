package Etc;
  
import java.io.*;
import java.util.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON_1st {
	public static void main(String args[]) throws Exception{
		// init
		JSONParser parser = new JSONParser();
		JSONObject objRawJSON = (JSONObject) parser.parse(new FileReader("c:\\\\temp\\\\ko_wiki_v1_squad.json"));
		// init
		
		// JSON���� �����͸� �����ϴ� ���
//		String txtCreator = (String) objRawJSON.get("creator");
//		System.out.println(txtCreator);
//		String txtVer = (String) objRawJSON.get("version");
//		System.out.println(txtVer); 

		// Start : JSON ������ ����
		JSONArray objArrData = (JSONArray) objRawJSON.get("data");	// Data [Arr]
		JSONObject objData = null; // data [Arr]
		JSONArray objarrParagraphs = null; // paragraphs [Arr]
		JSONObject objarrParagraph = null; // paragraphs [Arr]
		JSONArray objarrQAS = null; // qas [Arr]
		JSONObject objQAS = null; // qas [Arr]
		String strQuestion = null; // question 
		JSONArray objarrAnswers = null; // answers [Arr]
		JSONObject objAnswers = null;
		Long longAnswer_start = null; // answer_start
		String strText = null; // text
		HashMap<String, String> mapQAS = new HashMap<String, String>();
		
		JSONArray objArrExtract = new JSONArray();
		for(int i = 0; i < objArrData.size(); i++) {
			objData = (JSONObject) objArrData.get(i); // Data
			objarrParagraphs = (JSONArray) objData.get("paragraphs"); // Paragraphs
			
			objarrParagraph = (JSONObject) objarrParagraphs.get(0);
			objarrQAS = (JSONArray) objarrParagraph.get("qas"); // QAS (Arr)
			objQAS = (JSONObject) objarrQAS.get(0); // QAS (Object)
			
			strQuestion = (String) objQAS.get("question"); // answers
			objarrAnswers = (JSONArray) objQAS.get("answers"); // answers
			objAnswers = (JSONObject) objarrAnswers.get(0); // answers
			
			longAnswer_start = (Long) objAnswers.get("answer_start"); // answer_start 
			strText = (String) objAnswers.get("text"); // text

			// �߰� Ȯ��
//			System.out.println(strQuestion);
//			System.out.println(longAnswer_start);
//			System.out.println(strText);
			
			mapQAS.put("Question", strQuestion);
			mapQAS.put("Answer_start", longAnswer_start.toString());
			mapQAS.put("Text", strText);
			objArrExtract.add(new JSONObject(mapQAS));
			mapQAS.clear();
			
//			System.out.println(objArrExtract);
		}
		// End : JSON ������ ����
		
		// Start : JSON ���� ����
		try{
			FileWriter exFile = new FileWriter("c:\\temp\\extracted.json");
			exFile.write(objArrExtract.toJSONString());
			exFile.flush();
			exFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(objArrExtract);
	}
}