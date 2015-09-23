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
		List<String> resultList = new ArrayList<String>();
		int index = 1;
		boolean f = true;
		boolean s = true;
		int minlength = Math.min(str1.length(), str2.length());
		int minlength2 = Math.min(str3.length(), str4.length());
		for (int i = 0; i < minlength; i++) {
			boolean flag = str2.substring(i, i + 1).equals(
					str1.substring(i, i + 1));
			if (flag == true) {
				if ((((str2.charAt(i) >= 65) && (str2.charAt(i) <= 90)) || ((str2
						.charAt(i) >= 97) && (str2.charAt(i) <= 122))) && f && s) {
					resultList.add(str1.substring(i, i + 1));
					f = false;
				} else if(!f&&s) {
					resultList.add(str1.substring(i, i + 1));
					s=false;
				}
			}
		}
		for (int i = 0; i < minlength2; i++) {
			if (((str3.charAt(i) >= 65) && (str3.charAt(i) <= 90))
					|| ((str3.charAt(i) >= 97) && (str3.charAt(i) <= 122))) {
				boolean flag = str4.substring(i, i + 1).equals(
						str3.substring(i, i + 1));
				if (flag == true) {
					resultList.add(String.format("%02d", i));
					break;
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
		if (Character.isAlphabetic(resultList.get(1).charAt(0))) {
			int hours = (int) resultList.get(1).charAt(0) - 55;
			sb.append(String.format("%02d", hours)).append(":");
		} else {
			int hours = Integer.parseInt(resultList.get(1));
			sb.append(String.format("%02d", hours)).append(":");
		}
		sb.append(resultList.get(2));
		System.out.print(sb.toString());
	}
}
