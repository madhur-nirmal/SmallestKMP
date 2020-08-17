import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static final Scanner scanner = new Scanner(System.in);

	public static void testCase() {
		String s;
		String p;
		s = scanner.next();
		p = scanner.next();
		int sLen = s.length();
		int pLen = p.length();
		char[] sArray = new char[sLen];
		char[] pArray = new char[pLen];

		sArray = s.toCharArray();
		pArray = p.toCharArray();

		for(int i = 0; i < pLen; ++i) {
			 for(int j = 0;j < sLen; ++j){
			 	if(sArray[j] == pArray[i]) {
			 		sArray[j] = '\0';
			 		break;
				}
			 }
		}
		int tempSArrayLen = sLen - pLen + 2;
		char[] tempSArray = new char[tempSArrayLen];
		int counter = 0;
		for (int i =0;i < sLen; ++i) {
			if(sArray[i] == '\0')
				continue;
			tempSArray[counter++] = sArray[i];
		}
		tempSArray[tempSArrayLen -1] = p.charAt(0);

		Arrays.sort(tempSArray);
		int revSLen = tempSArray.length;
		char[] revSArray = new char[revSLen];
		for (int i =0; i < revSLen; ++i){
			revSArray[i] = tempSArray[revSLen - i -1];
		}

		char k = p.charAt(0);
		int index = 0;
		for (int i =0; i < tempSArrayLen; ++i){
			if(k == revSArray[i]) {
				index = tempSArrayLen - i - 2;
//				index =i;
				break;
			}
		}

		String result;
		String revFinal = String.valueOf(tempSArray);

		result = revFinal.substring(0, index + 1) + p + revFinal.substring(index + 2);

		System.out.println(result);


	}
	public static void main(String[] args) {

		int t;
		t = scanner.nextInt();
		while(t-- > 0){
			Main.testCase();
		}


	}
}