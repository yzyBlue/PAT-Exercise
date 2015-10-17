import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，然后用第1个数字减第2个数字，
 * 将得到一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”之称的6174，这个神奇的数字也叫Kaprekar常数。
 */

public class Test8 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		String input=format(a);
		int[] data=strToIntArray(input);
		boolean flag=judge(data);
		if(flag){
			System.out.println(input+" - "+input+" = 0000");
		}else{
			int temp=0;
			int[] tempData=data;
			while(temp!=6174){
				int[] sortResult=dataSort(tempData);
				temp=sortResult[0]-sortResult[1];
				System.out.println(format(sortResult[0])+" - "+format(sortResult[1])+" = "+temp);
				String tempStr=String.valueOf(temp);
				while(tempStr.length()<4){
					tempStr="0"+tempStr;
				}
				tempData=strToIntArray(tempStr);
			}
		}
	}
	public static int[] dataSort(int[] data){
		int[] sortResult=new int[2];
		Arrays.sort(data);
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int j=0;j<data.length;j++){
			sb2.append(data[j]);
			sb1.append(data[data.length-j-1]);
		}
		sortResult[0]=Integer.parseInt(sb1.toString());
		sortResult[1]=Integer.parseInt(sb2.toString());
		return sortResult;
	}
	public static boolean judge(int[] data){
		boolean flag=true;
		int a=data[0];
		for(int i=1;i<data.length;i++){
			if(data[i]!=a){
				flag=false;
			}
		}
		return flag;
	}
	public static int[] strToIntArray(String str){
		int[] data=new int[str.length()];
		for(int i=0;i<str.length();i++){
			data[i]=Integer.parseInt(str.substring(i, i+1));
		}
		return data;
	}
	public static String format(int a){
		String tempStr=String.valueOf(a);
		while(tempStr.length()<4){
			tempStr="0"+tempStr;
		}
		return tempStr;
	}
}
