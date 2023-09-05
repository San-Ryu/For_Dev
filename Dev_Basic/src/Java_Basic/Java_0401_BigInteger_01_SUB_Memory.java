package Java_Basic;

/* BigInteger 개요
 * Int : 4 Byte
 * -2,147,483,648 ~ 2,147,483,647
 * 
 * Long : 8 Byte
 * -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
 *
 * 두 Type 모두 유한한 범위를 가지고 있으나,
 * BigInteger는 문자열 형태로 이루어져, 표현할 수 있는 숫자의 범위에 대한 제한이 없음.
 *
 */

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.math.BigInteger;

public class Java_0401_BigInteger_01_SUB_Memory {
	// BigInteger의 선언
    BigInteger a_1 = new BigInteger("1"); // 1 Digit
	BigInteger b_10 = new BigInteger("1000000000"); // 10 Digit
	BigInteger c_20 = new BigInteger("10000000000000000000"); // 20 Digit
	BigInteger d_100 = new BigInteger("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"); // 100 Digit
}