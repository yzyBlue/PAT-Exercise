import java.util.Scanner;
/*
 * 本题要求计算A/B，其中A是不超过1000位的正整数，B是1位正整数。你需要输出商数Q和余数R，使得A = B * Q + R成立。
 * 
 * */

public class Test6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String strA=sc.next();
		int B=sc.nextInt();
		int[] a=new int[strA.length()];
		int[] b=new int[a.length];
		int[] c=new int[a.length];
		int[] d=new int[a.length+1];
		for(int i=0;i<strA.length();i++){
			a[i]=Integer.parseInt(strA.substring(i, i+1));
		}
		//System.out.println(Arrays.toString(a));
		d[0]=a[0];
		for(int j=0;j<a.length;j++){
			b[j]=d[j]%B;
			c[j]=d[j]/B;
			if(j+1<a.length){
				d[j+1]=b[j]*10+a[j+1];
			}else{
				d[j+1]=b[j];
			}
		}
//		System.out.println(Arrays.toString(b));
//		System.out.println(Arrays.toString(c));
//		System.out.println(Arrays.toString(d));
		String result="";
		int first=0;
		if(c[0]==0){
			first=1;
		}
		for(int k=first;k<c.length;k++){
			result=result+c[k];
		}
		System.out.print(result+" "+d[d.length-1]);
	}

}
