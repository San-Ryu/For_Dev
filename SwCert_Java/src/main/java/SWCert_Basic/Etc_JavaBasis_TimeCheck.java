package SWCert_Basic;

// �ð� ���� �ڵ�
public class Etc_JavaBasis_TimeCheck {
      static long TimeStartPoint = 0;
      static long TimeEndPoint = 0;
      static long TimeResult = 0;
      
      public static void main(String args[]) throws Exception{
            TimeStartPoint = System.currentTimeMillis();
            
            /*
             * 
             *    ���� ��� (�ڵ�)
             * 
             */
            
            TimeEndPoint = System.currentTimeMillis();
            TimeResult = TimeEndPoint - TimeStartPoint;
            System.out.println(TimeResult + " [ms]");
            System.out.println(TimeResult/1000 + " [sec]");
            //    System.currentTimeMillis()�� Return Type�� Long�̰�,
            //    �ð��� MilliSecond �����ӿ� ����
      }     //    End Main Method
}     //    End Class
