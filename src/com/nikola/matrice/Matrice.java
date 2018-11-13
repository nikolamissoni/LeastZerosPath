package com.nikola.matrice;

import java.util.Random;

public class Matrice {

	private static int MATRIX_DIMENSIONS = 10;
	
	public static void main(String[] args) {

		int[][] initialMatrix = initMatrix();
		int[][] calculatedMatrix = getProductMatrix(initialMatrix);
		int[][] countZerosMatrix = getZerosMatrix(initialMatrix, calculatedMatrix);
		
		int result = findWayWithLeastZeros(countZerosMatrix);
		
		for(int i = 0; i < MATRIX_DIMENSIONS; i++) {
			for(int j = 0; j < MATRIX_DIMENSIONS; j++) {
				System.out.print(countZerosMatrix[i][j] + "|");
			}
			System.out.println();
		}
	}

	private static int[][] initMatrix() {

		Random rand = new Random();
		var minPossibleNumber = 0;
		var maxPossibleNumber = 2000000;
		
		int[][] twoDimMatrix = new int[MATRIX_DIMENSIONS][MATRIX_DIMENSIONS];
		
		for(var i = 0; i < MATRIX_DIMENSIONS; i++) {
			for(var j = 0; j < MATRIX_DIMENSIONS; j++) {
				twoDimMatrix[i][j] = rand.nextInt((maxPossibleNumber - minPossibleNumber) + 1) + minPossibleNumber;
			}
		}
		return twoDimMatrix;
	}
	
	private static int[][] getProductMatrix(int[][] twoDimMatrix) {

		int[][] productMatrix = new int[MATRIX_DIMENSIONS][MATRIX_DIMENSIONS];
		
		int currentRes = 0;
		
		for(int i = 0; i < MATRIX_DIMENSIONS; i++) {
			for(int j = 0; j < MATRIX_DIMENSIONS; j++) {
				if(j+1 < MATRIX_DIMENSIONS) {
					currentRes = twoDimMatrix[i][j] * twoDimMatrix[i][j+1];
					if(i+1<MATRIX_DIMENSIONS) {
						currentRes += twoDimMatrix[i][j] * twoDimMatrix[i+1][j];
					}
				}else {
					if(i+1<MATRIX_DIMENSIONS) {
						currentRes = twoDimMatrix[i][j] * twoDimMatrix[i+1][j];
					}else {
						currentRes = twoDimMatrix[i][j];
					}
				}
				productMatrix[i][j] = currentRes;
			}
		}
		
		return productMatrix;
	}
	
	
	private static int[][] getZerosMatrix(int[][] initialMatrix, int[][] calculatedMatrix) {
		
		int[][] zeroMatrix = new int[MATRIX_DIMENSIONS][MATRIX_DIMENSIONS];
		int zerosInNumber = 0;
		
		for(var i = 0; i < MATRIX_DIMENSIONS; i++) {
			for(var j = 0; j < MATRIX_DIMENSIONS; j++) {
				if(initialMatrix[i][j] % 10 == 0) {
					zerosInNumber += countZerosInNumber(initialMatrix[i][j]);
				}
				zerosInNumber += countZerosInNumber(calculatedMatrix[i][j]);
				zeroMatrix[i][j] = zerosInNumber;
				zerosInNumber = 0;
			}
		}
		return zeroMatrix;
	}
	
	private static int findWayWithLeastZeros(int[][] countZerosMatrix) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static int countZerosInNumber(int currentNumber) {
		return (int) Integer.toString(currentNumber).chars().filter(anyChar->anyChar=='0').count();
	}
	

}