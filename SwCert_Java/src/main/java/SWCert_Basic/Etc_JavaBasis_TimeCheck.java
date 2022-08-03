package SWCert_Basic;

// 시간 측정 코드
public class Etc_JavaBasis_TimeCheck {
      static long TimeStartPoint = 0;
      static long TimeEndPoint = 0;
      static long TimeResult = 0;
      
      public static void main(String args[]) throws Exception{
            TimeStartPoint = System.currentTimeMillis();
            
            /*
             * 
             *    측정 대상 (코드)
             * 
             */
            
            TimeEndPoint = System.currentTimeMillis();
            TimeResult = TimeEndPoint - TimeStartPoint;
            System.out.println(TimeResult + " [ms]");
            System.out.println(TimeResult/1000 + " [sec]");
            //    System.currentTimeMillis()의 Return Type은 Long이고,
            //    시간은 MilliSecond 단위임에 주의
      }     //    End Main Method
}     //    End Class
