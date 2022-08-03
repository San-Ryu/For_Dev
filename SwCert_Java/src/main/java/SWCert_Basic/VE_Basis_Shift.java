package SWCert_Basic;

import java.io.*;
import java.util.*;

public class VE_Basis_Shift {
	public static void main(String args[]) throws Exception{
  for(int visit = 0; visit < 10; visit++) {
  System.out.print("Visit\t\t: ");
  for(int i = 0; i < 10; i++) {
  System.out.print(visit + "\t");
  }
  System.out.println();
  
  System.out.print("i\t\t: ");
  for(int i = 0; i < 10; i++) {
  System.out.print(i + "\t"); 
  }
  System.out.println();
  
  System.out.print("| (1 << i)\t: ");
  for(int i = 0; i < 10; i++) {
  int j = visit | (1 << i);	
  System.out.print(j + "\t");
  }
  System.out.println();  
  
  System.out.print("& (1 << i)\t: ");
  for(int i = 0; i < 10; i++) {
  int k = visit & (1 << i);
  System.out.print(k + "\t");
  }
  System.out.println();
  
  System.out.println();
  }
	}	//	End Main
}	//	End Class