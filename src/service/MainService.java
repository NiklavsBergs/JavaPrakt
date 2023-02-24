package service;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class MainService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Uzd7();
	}
	
	public static void Uzd0(){
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
				"Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
				"Kate" };
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
				299, 343, 317, 265 };
		
		for (int i = 0; i < names.length; i++) {
			System.out.println("[" + names[i] + ", " + times[i] + "]");	
		}
		
	}
	
	public static void Uzd1(){
		double gravity = -9.81; // Earth's gravity in m/s^2
		double initialVelocity = 0.0;
		double fallingTime = 10.0;
		double initialPosition = 0.0;
		double finalPosition = 0.0;
		finalPosition = positionCalc(gravity, initialVelocity, initialPosition, fallingTime);
		System.out.println("Pos in "+fallingTime+"sec :"+finalPosition);
	}
	
	public static void Uzd2() {
		int N = 5;
		int fakt = 0, faktRecursive = 0;
		faktRecursive = factorialRecursive(N);
		fakt = factorialForLoop(N);
		System.out.print(N + "!" + " = " + fakt);
		System.out.println();
		System.out.print(N + "!" + " = " + faktRecursive);
	}
	
	public static void Uzd3() {
		Scanner sc= new Scanner(System.in);
		int N = 0;
		double max = 0, min = 0, mean = 0;
		double [] array;
		double [] array_sorted;
		double lower = 0; double upper = 0;
		System.out.println("Ievadi N");
		N = sc.nextInt();
		System.out.println("Ievadi apaksejo robezu");
		lower = sc.nextDouble();
		System.out.println("Ievadi augsejo robezu");
		upper = sc.nextDouble();
		sc.close();
		array = generateArray(N, lower, upper);
		
		System.out.println(Arrays.toString(array));
		
		min = getMin(array);
		max = getMax(array);
		mean = getMean(array);
		
		array_sorted = arraySort(array);
		System.out.println("Sorted");
		System.out.println(Arrays.toString(array));
		
		System.out.println("Min: " + min + ", Max: " + max + ", Mean: " + mean);
	}
	
	public static void Uzd4() {
		double[][] matrix;
		int N = 3;
		double product = 0;
		matrix = generateMatrix(N);
		System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		
		product = getProduct(matrix, 1, 2);
		System.out.println("Product of 1 and 2" + product);
		
	}
	
	public static void Uzd5() {
		int N = 0;
		double[] rezultati;
		Scanner sc= new Scanner(System.in);
		System.out.println("Ievadi N");
		N = sc.nextInt();
		sc.close();
		rezultati = coinFlip(N);
		System.out.println(Arrays.toString(rezultati));
	}
	
	public static void Uzd7() {
		byte[] array = {72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 115, 107, 105, 108, 108, 115, 32, 97, 114, 101, 32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 101, 97, 100, 121, 33};
		String vards = "";
		vards = getTextFromBytes(array);
		System.out.println(vards);
		
	}
		
	public static String getTextFromBytes(byte[] array) {
		return new String(array);
	}
	
	static double[] coinFlip(int N) {
		if (N > 0) {
			double [] rezultati = new double [3];
			Random rand = new Random();
			int heads = 0, tails = 0, ratio = 0;
			int number = 0;
			for (int i = 1; i <=N; i++) {
				number = rand.nextInt(1);
				if (number == 0) {
					heads++;
				}
				else {
					tails++;
				}
			}
			ratio = heads / tails;
			rezultati[0] = heads;
			rezultati[1] = tails;
			rezultati[2] = ratio;
			return rezultati;
		}
		else {
			return new double [0];
		}
	}
	
	static double[][] generateMatrix(int N){
		Random rand = new Random();
		double[][] matrix = new double [N][N];
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				matrix[i][j] = rand.nextDouble()* (9 - 1) + 1;
			}
		}
		return matrix;
	}
	

	static double getProduct(double[][] matrix, int i, int j) {
		double product = 0;
		for (int k = 0; k<matrix.length; k++) {
			product += matrix[i][k] * matrix[k][j];
		}
		return product;
	}
	
	static double[] generateArray(int N, double lower, double upper) {
		if(N > 0) {
			double array[] = new double[N];
			if (lower > upper) {
				return array;
			}
			else {
				for (int i = 0; i<N; i++) {
					array[i] = Math.random() * (upper - lower) + lower;
				}
				return array;
			}
		}
		else {
			return (new double[0]);
		}
	}
	
	static double getMean(double[] array) {
		if(array != null) {
			double sum = array[0];
			double mean = 0;
			for (int i = 1; i< array.length; i++) {
				sum += array[i];
			}
			mean = sum/array.length;
			return mean;
		}
		else {
			return 0;
		}
		
	}
	
	static double getMin(double[] array) {
		double min = array[0];
		for (int i = 1; i< array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	
	static double getMax(double[] array) {
		double max = array[0];
		for (int i = 1; i< array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	static double[] arraySort(double[] array) {
		double temp = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	static int factorialForLoop(int N) {
		int x=1;
		
		if (N < 0) {
			return 0;
		}
		else {
			for (int i = 1; i <= N; i++) {
				x = x * i;
			}
		}
		
		return x;
	}
	
	static int factorialRecursive(int N) {
		if (N >= 1) {
			return N * factorialRecursive(N - 1);
		}
		else
			return 1;
	}
	
	static double positionCalc(double gravity, double initialVelocity, double initialPosition, double fallingTime) {
		double position;
		position = 0.5 * gravity * (fallingTime * fallingTime) + initialVelocity * fallingTime + initialPosition;
		return position;
	}

}
	
