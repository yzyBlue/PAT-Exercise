import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<Integer> caseDataList = new ArrayList<Integer>();
		int count = 0;
		int flag = 1;
		for (int x = 2; count < n; x++) {
			double k = java.lang.Math.sqrt(x + 1);
			for (int i = 2; i <= k; i++) {
				if ((x % i) == 0) {
					flag=0;break;
				}
			}
			if(flag==1){
				caseDataList.add(x);
				count++;
			}else{
				flag=1;
			}
		}
		int index=1;
		for(int j=m-1;j<n;j++){
			System.out.print(caseDataList.get(j));
			if(index%10==0){
				System.out.println("");
			}else if(index!=(n-m+1)){
				System.out.print(" ");
			}
			index++;
		}
	}

}
