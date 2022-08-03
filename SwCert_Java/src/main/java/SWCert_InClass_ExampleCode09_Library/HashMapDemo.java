package SWCert_InClass_ExampleCode09_Library;

import java.util.*;

public class HashMapDemo {
	public static void main(String[] args)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("�̼���", 1);
		map.put("���缮", 5);
		map.put("�ŵ���", 2);
		map.put("�豸��", 3);
		map.put("��ȣ��", 2);
		
		Set<String> strSet = map.keySet(); 
		for(String key: strSet)
			System.out.println(key);
		
		System.out.print("�豸���� value = ");
		System.out.println(map.get("�豸��"));
		
		System.out.println("�ŵ��� ����");
		System.out.println(map.remove("�ŵ���")); // �ŵ����� value ��ȯ
		
		System.out.println(map.containsKey("�ŵ���"));
		
		System.out.print("��ȣ�� ���� = ");
		System.out.println(map.put("��ȣ��", 8)); // Map�� ����� key�� value ��ȯ
		
	}
}
