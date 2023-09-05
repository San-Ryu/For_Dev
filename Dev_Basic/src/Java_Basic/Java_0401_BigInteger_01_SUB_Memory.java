package Java_Basic;

/* BigInteger ����
 * Int : 4 Byte
 * -2,147,483,648 ~ 2,147,483,647
 * 
 * Long : 8 Byte
 * -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
 *
 * �� Type ��� ������ ������ ������ ������,
 * BigInteger�� ���ڿ� ���·� �̷����, ǥ���� �� �ִ� ������ ������ ���� ������ ����.
 *
 */

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.math.BigInteger;

public class Java_0401_BigInteger_01_SUB_Memory {
	// BigInteger�� ����
    BigInteger a_1 = new BigInteger("1"); // 1 Digit
	BigInteger b_10 = new BigInteger("1000000000"); // 10 Digit
	BigInteger c_20 = new BigInteger("10000000000000000000"); // 20 Digit
	BigInteger d_100 = new BigInteger("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"); // 100 Digit
}