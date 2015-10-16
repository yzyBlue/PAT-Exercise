/*
 * �±����й���������ѽ�ʱ�Ե�һ�ִ�ͳʳƷ����ͬ��������಻ͬ��ζ���±���
 * �ָ������������±��Ŀ���������ۼۡ��Լ��г�����������������������Ի�õ���������Ƕ��١�
 * ע�⣺����ʱ����ȡ��һ���ֿ�档
 * ���������������������ģ�����������3���±����������ֱ�Ϊ18��15��10��֣����ۼ۷ֱ�Ϊ75��72��45��Ԫ��
 * ����г������������ֻ��20��֣���ô��������������Ӧ��������ȫ��15��ֵ�2���±����Լ�5��ֵ�3���±������72 + 45/2 = 94.5����Ԫ����
 * 
 * */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			y[i] = sc.nextInt();
		}
		double[] mean = new double[n];
		for (int i = 0; i < n; i++) {
			mean[i] = (double) (y[i]) / (double) (x[i]);
		}
		List<Item> itemList = new Test7().toList(mean);
		Collections.sort(itemList);
		// System.out.println(itemList.toString());
		double result = 0;
		while (m > 0) {
			for (int j = 0; j < itemList.size(); j++) {
				int index = itemList.get(j).getIndex();
				if (m - x[index] >= 0) {
					result = y[index] + result;
					m = m - x[index];
				} else if (m - x[index] < 0) {
					result = m * itemList.get(j).getValue() + result;
					m = 0;
					break;
				}
			}
		}
		DecimalFormat df1 = new DecimalFormat("####.00");
		System.out.println(df1.format(result));
	}

	public List<Item> toList(double[] a) {
		List<Item> itemList = new ArrayList<Item>();
		for (int i = 0; i < a.length; i++) {
			itemList.add(new Item(a[i], i));
		}
		return itemList;
	}

	public List<Item> sort(List<Item> itemList) {
		List<Item> itemListNew = new ArrayList<Item>();
		return itemListNew;

	}

	private class Item implements Comparable<Item> {
		private double value;
		private int index;

		public Item(double value, int initIndex) {
			this.value = value;
			this.index = initIndex;
		}

		public double getValue() {
			return this.value;
		}

		public int getIndex() {
			return this.index;
		}

		@Override
		public int compareTo(Item itemNew) {
			return new Double(itemNew.value).compareTo(new Double(this.value));
		}

		public String toString() {
			return "[" + this.index + "," + this.value + "]";
		}
	}
}
