import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String str3 = sc.nextLine();
		String str4 = sc.nextLine();
		// String[] result=new String[5];
		List<String> resultList = new ArrayList<String>();
		int index = 1;
		int minlength = Math.min(str1.length(), str2.length());
		int minlength2 = Math.min(str3.length(), str4.length());
		for (int i = 0; i < minlength; i++) {
			if (Character.isAlphabetic(str1.charAt(i))) {
				boolean flag = str2.substring(i, i + 1).equals(
						str1.substring(i, i + 1));
				if (flag == true) {
					resultList.add(str1.substring(i, i + 1));
					System.out.println(str1.substring(i, i + 1));
				}
			}
		}
		for (int i = 0; i < minlength2; i++) {
			if (Character.isAlphabetic(str3.charAt(i))) {
				boolean flag = str4.substring(i, i + 1).equals(
						str3.substring(i, i + 1));
				if (flag == true) {
					resultList.add(String.format("%02d", i));
					System.out.println(str4.substring(i, i + 1));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		switch (resultList.get(0)) {
		case "A":
			sb.append("MON");
			break;
		case "B":
			sb.append("TUE");
			break;
		case "C":
			sb.append("WED");
			break;
		case "D":
			sb.append("THU");
			break;
		case "E":
			sb.append("FRI");
			break;
		case "F":
			sb.append("SAT");
			break;
		case "G":
			sb.append("SUN");
			break;
		}
		sb.append(" ");
		if (resultList.get(1).toString() == "E") {
			sb.append("14:");
		}
		sb.append(resultList.get(2));
		System.out.print(resultList.toString());
		System.out.print(sb.toString());
	}
}
