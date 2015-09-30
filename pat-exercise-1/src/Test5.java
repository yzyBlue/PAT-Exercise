import java.util.Scanner;

/*
 * 正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。例如：给定A = 3862767，DA = 6，则A的“6部分”PA是66，因为A中有2个6。
 * 现给定A、DA、B、DB，请编写程序计算PA + PB
 * 
 * 
 * */
public class Test5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Integer A=sc.nextInt();
		int Da=sc.nextInt();
		Integer B=sc.nextInt();
		int Db=sc.nextInt();
		int Pa=getSubNumber(A,Da);
		int Pb=getSubNumber(B,Db);
		int result=Pa+Pb;
		System.out.print(result);
	}
	public static int getSubNumber(int a,int da){
		String A=String.valueOf(a);
		String Da=String.valueOf(da);
		int count=0;
		int index=0;
		for(;index<A.length();index++){
			String subStr=A.substring(index);
			int indexSub=subStr.indexOf(Da);
			if(indexSub>=0){
				count++;
				index=indexSub+index;
			}
		}
		int result=0;
		for(int j=0;j<count;j++){
			result=(int) (result+da*Math.pow(10, j));
		}
		return result;
	}

}
