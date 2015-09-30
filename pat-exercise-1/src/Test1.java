import java.util.Scanner;

/*
 * 给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。
 * 
 * */
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum=sc.nextInt();
		long[][] caseData=new long[caseNum][3];
		for(int i=0;i<caseNum;i++){
			for(int j=0;j<3;j++){
				caseData[i][j]=sc.nextLong();
			}
		}
		for(int i=0;i<caseNum;i++){
			if(caseData[i][0]+caseData[i][1]>caseData[i][2]){
				System.out.println("Case #"+(i+1)+": true");
			}else{
				System.out.println("Case #"+(i+1)+": false");
			}
		}
		
	}

}
