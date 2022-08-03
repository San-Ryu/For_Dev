package SWCert_InClass_ExampleCode09_Library;

import java.util.Arrays;
import java.util.Collections;

public class SortComparableDemo {
	static class Node implements Comparable<Node> {
		String name;
		int id;
		Node(String _name, int _id)	
		{
			name = _name; id = _id;
		}
		public String toString()
		{
			return "(" + name + ", " + id + ")";
		}
		
		public int compareTo(Node arg) {
			return name.compareTo(arg.name);	
			//return id - arg.id;		
		}
	}

	public static void main(String[] args)
	{
		Node[] nodes = new Node[5];
		nodes[0] = new Node("�ŵ���", 3);
		nodes[1] = new Node("�̼���", 1);
		nodes[2] = new Node("���缮", 5);
		nodes[3] = new Node("��ȣ��", 4);
		nodes[4] = new Node("�豸��", 2);
		
		// �������� ����
		Arrays.sort(nodes);		
		for(Node node: nodes)
			System.out.println(node);;
		
		System.out.println("----------------------------");
			 
		// �������� ����
		Arrays.sort(nodes, Collections.reverseOrder());
		for(Node node: nodes)
			System.out.println(node);
	}
}
