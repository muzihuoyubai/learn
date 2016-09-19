package com.liyi.queens;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后递归方式
 * 
 * note:每一行只能有一个Q
 * 
 * @author HYB
 * 
 */
public class Queens {

	private Integer[] queenCol; // 数组下标为行，内容为列
	private List<Integer[]> methord; // 存放所有方法
	private int size;

	public Queens(int size) {
		this.size = size;
		queenCol = new Integer[size];
		methord = new ArrayList<Integer[]>();
	}

	public void putQueen(int row) {
		if (row > size - 1) { // 放置了7行，有效解
			methord.add(queenCol.clone()); // 如果直接methord.add(queenCol)里面的值会发生改变
			return;
		} else {
			for (int col = 0; col < size; col++) {
				if (checkQueen(row, col)) {
					queenCol[row] = col; // 成功放置保存位置，转下一行
					putQueen(row + 1);
				} else {
					continue; // 未成功放置，继续放
				}
			}
		}
		return;
	}

	// 判断位置是否可以放置
	public boolean checkQueen(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (i == row || queenCol[i] == col
					|| Math.abs(i - row) == Math.abs(queenCol[i] - col)) {
				return false;
			}
		}
		return true;
	}

	// 打印
	public void printAll() {
		for (int i = 0; i < methord.size(); i++) {
			for (int j = 0; j < this.size; j++) {
				Integer[] queen = methord.get(i);
				for (int k = 0; k < queen.length; k++) {
					if (queen[j] == k) {
						System.out.print("Q");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			System.out.println("********");
		}
	}

	// 打印n列一组
	// Math.ceil(10.0/3)=4.0
	// Math.ceil(10/3)=3.0
	public void printAll(double n) {
		double loop = Math.ceil(methord.size() / n);
		for (int i = 0; i < loop; i++) {
			for (int j = 0; j < this.size; j++) { // 打印8行
				for (int k = 0; k < n; k++) {
					if (i * n + k >= methord.size())
						continue;
					int temp = methord.get((int) (i * n + k))[j];
					for (int m = 0; m < this.size; m++) {
						if (temp == m) {
							System.out.print("Q");
						} else {
							System.out.print("-");
						}
					}
					System.out.print(" * ");
				}
				System.out.println();
			}
			// 打印分割线
			for (int l = 0; l < n * (size + 3) - 1; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Queens queen = new Queens(8);
		queen.putQueen(0);
		System.out.println(queen.methord.size());
		queen.printAll(10.0);
	}
}
