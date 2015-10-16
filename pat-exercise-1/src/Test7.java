/*
 * 月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。
 * 现给定所有种类月饼的库存量、总售价、以及市场的最大需求量，请你计算可以获得的最大收益是多少。
 * 注意：销售时允许取出一部分库存。
 * 样例给出的情形是这样的：假如我们有3种月饼，其库存量分别为18、15、10万吨，总售价分别为75、72、45亿元。
 * 如果市场的最大需求量只有20万吨，那么我们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，获得72 + 45/2 = 94.5（亿元）。
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
