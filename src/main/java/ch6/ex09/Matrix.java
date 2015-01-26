/**
 * @file
 * @par File Name:
 * Ex09.java
 * @author budougumi0617
 * @date Created on 2015/01/19
 */
package main.java.ch6.ex09;

import java.util.Arrays;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Matrix {
	public static final int ROW_SIZE = 2;
	public static final int COLUMN_SIZE = 2;
	private int[][] matrix;

	public Matrix() {
		// Specified initialize the fibonacci
		// number
		matrix = new int[ROW_SIZE][COLUMN_SIZE];
		matrix[0][0] = matrix[0][1] = matrix[1][0] = 1;
		matrix[1][1] = 0;

	}

	public Matrix(int oneOne, int oneTwo, int twoOne, int twoTwo) {
		matrix = new int[ROW_SIZE][COLUMN_SIZE];
		matrix[0][0] = oneOne;
		matrix[0][1] = oneTwo;
		matrix[1][0] = twoOne;
		matrix[1][1] = twoTwo;
	}

	public double get(int row, int colum) {
		return matrix[row][colum];
	}

	public void set(int row, int colum, int value) {
		matrix[row][colum] = value;
	}

	public Matrix multiply(Matrix target) {
		int temp;
		Matrix result = new Matrix();

		for (int i = 0; i < ROW_SIZE; i++) {
			for (int j = 0; j < COLUMN_SIZE; j++) {
				temp = 0;
				for (int k = 0; k < COLUMN_SIZE; k++) {
					temp += get(i, k) * target.get(k, j);
				}
				result.set(i, j, temp);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return String.format("\n|%3d, %3d|\n|%3d, %3d|\n", matrix[0][0], matrix[0][1],
				matrix[1][0], matrix[1][1]);
	}

	public int getFibonacci() {
		return matrix[0][0];
	}

	public static void main(String[] args) {
		Matrix[] matrixies = new Matrix[20];
		Arrays.parallelSetAll(matrixies, i -> new Matrix());
		Arrays.parallelPrefix(matrixies, (x, y) -> x.multiply(y));
		Arrays.stream(matrixies).forEachOrdered(
				m -> System.out.println("Fibonacci = " + m.getFibonacci()));
	}
}
