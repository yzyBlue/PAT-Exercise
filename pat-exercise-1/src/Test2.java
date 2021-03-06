import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：

A1 = 能被5整除的数字中所有偶数的和；

A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；

A3 = 被5除后余2的数字的个数；

A4 = 被5除后余3的数字的平均数，精确到小数点后1位；

A5 = 被5除后余4的数字中最大数字。
 * 
 * */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		Map<Integer, ArrayList<Integer>> caseDataMap = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < caseNum; i++) {
			Integer data = sc.nextInt();
			Integer key = data % 5;
			List<Integer> caseDataList = caseDataMap.get(key);
			if (caseDataList == null) {
				ArrayList<Integer> caseDataListNew = new ArrayList<Integer>();
				caseDataMap.put(key, caseDataListNew);
			}
			caseDataMap.get(key).add(data);
		}
		String[] output = new String[5];
		for (int j = 0; j < 5; j++) {
			ArrayList<Integer> caseDatas = caseDataMap.get(j);
			if (caseDatas == null) {
				ArrayList<Integer> caseDataListNew = new ArrayList<Integer>();
				caseDataMap.put(j, caseDataListNew);
			}
			if (caseDataMap.get(j).size() == 0||caseDataMap.get(j)==null) {
				output[j] = "N";
			} else {
				switch (j) {
				case 0:
					int A1 = 0;
					for (int k = 0; k < caseDatas.size(); k++) {
						if (caseDatas.get(k) % 2 == 0) {
							A1 = A1 + caseDatas.get(k);
						}
					}
					if(A1>0){
						output[0] = String.valueOf(A1);
					}else{
						output[0] = "N";
					}
					break;
				case 1:
					int A2 = 0;
					for (int k = 0; k < caseDatas.size(); k++) {
						A2 = (int) (A2 + (Math.pow(-1, k)) * caseDatas.get(k));
					}
					;
					output[1] = String.valueOf(A2);
					break;
				case 2:
					output[2] = String.valueOf(caseDatas.size());
					break;
				case 3:
					double sum = 0;
					for (int k = 0; k < caseDatas.size(); k++) {
						sum = sum + caseDatas.get(k);
					}
					double average=sum / caseDatas.size();
					DecimalFormat df = new DecimalFormat("#.0");
					String A4 = df.format(average);
					output[3] = A4;
					break;
				case 4:
					output[4] = String.valueOf(Collections.max(caseDatas));
					break;
				}
			}

		}
		System.out.println(output[0]+" "+output[1]+" "+output[2]+" "+output[3]+" "+output[4]);
	}

}
