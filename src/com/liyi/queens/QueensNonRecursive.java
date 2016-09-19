package com.liyi.queens;

import java.util.ArrayList;
import java.util.List;

public class QueensNonRecursive {
	private Integer[] queenCol; // 数组下标为行，内容为列
	private List<Integer[]> methord; // 存放所有方法
	private int size;
	private int rowPointer = 0;

	public QueensNonRecursive(int size) {
		this.size = size;
		queenCol = new Integer[size];
		for (int i = 0; i < size; i++) {
			queenCol[i] = 0;
		}
		methord = new ArrayList<Integer[]>();
	}

	public void putQueen() {
		while (true) {
			if (rowPointer == 0 && queenCol[0] >= size) { // 第一行走出棋盘了退出
				return;
			}
			if (queenCol[rowPointer] >= size) { // 判断棋子位置，超出棋盘则重置当前行，跳到上一行，走一步
				queenCol[rowPointer] = 0;
				rowPointer--;
				queenCol[rowPointer]++;
				continue;
			}
			if (checkQueen(rowPointer, queenCol[rowPointer])) {
				if (rowPointer == size - 1) { // 满足条件，记录一组数据
					methord.add(queenCol.clone());
					queenCol[rowPointer]++;
				} else { // 还没有走完，跳下一行
					rowPointer++;
				}
			} else {
				queenCol[rowPointer]++; // 位置不合适，向后走，超出棋盘的情况在上面判断
			}
		}
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
						break;
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
		QueensNonRecursive queen = new QueensNonRecursive(8);
		queen.putQueen();
		System.out.println(queen.methord.size());
		queen.printAll(10.0);
	}
}
