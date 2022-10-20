package Etc;
  
import java.io.*;
import java.util.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JSON_2nd {
	public static void main(String args[]) throws Exception{
		// init
		JSONParser parser = new JSONParser();
		JSONArray objarrRawJSON = (JSONArray) parser.parse(new FileReader("c:\\temp\\extracted_1st.json"));
		// init
		
		// Start : JSON 데이터 추출
		JSONObject objQAS = null; // qas [Arr]
		String strQuestion = null; // question
		ArrayList<String> strarrQuestion = new ArrayList<>();
		String strAnswer_start = null; // answer_start
		ArrayList<String> strarrAnswer_start = new ArrayList<>();
		String strText = null; // text
		ArrayList<String> strarrText = new ArrayList<>();
		
		for(int i = 0; i < objarrRawJSON.size(); i++) {
			objQAS = (JSONObject) objarrRawJSON.get(i); // Data
			
			strQuestion = (String) objQAS.get("Question"); // answers
			
			strAnswer_start = (String) objQAS.get("Answer_start"); // answer_start 
			strText = (String) objQAS.get("Text"); // text

			// 중간 확인
//			System.out.println(strAnswer_start);
//			System.out.println(strQuestion);
//			System.out.println(strText);
			
			strarrAnswer_start.add(strAnswer_start);
			strarrQuestion.add(strQuestion);
			strarrText.add(strText);
			
		}
		
		
		
//		System.out.println(strarrAnswer_start);
//		System.out.println(strarrQuestion);
//		System.out.println(strarrText);
		// End : JSON 데이터 확인
	}
}