package es.unileon.estudiantes.mgg.main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	//Hey pero que pasa
	
	public static int n;
	
	public static void main(String[] args) {
		//Try Catch para capturar las excepciones de entradas inválidas.
		try {
			
			//Creo las coordenadas de las matrices.
			int x = 0;
			int y = 0;
			
			//Clase Scanner para introducir el tamaño de la matriz
			Scanner scan = new Scanner(System.in);	
			
			//Leo el entero y compruebo si es 0 para marcar error.
			n = scan.nextInt();
			if (n == 0) {
				System.out.println("Entrada Inválida.");
				System.exit(0);
			}
			
			//Creo la matriz del tamaño especificado anteriormente.
			int matriz [][] = new int [n][n];
			int matrizTraspuesta [][] = new int [n][n];
					
			
			hacerMatriz(matriz, x, y, n);
//			verMatriz(matriz, x, y);
			hacerRaiz(matriz, x, y);
//			verMatriz(matriz, x, y);
			
			trasponer(matriz, matrizTraspuesta, x, y);
			
//			verMatriz(matrizTraspuesta, x, y);
//			compararMatrices(matriz, matrizTraspuesta);
			
			//Comprueba son simétricas.
			if (compararMatrices(matriz, matrizTraspuesta) == true) {
				System.out.println("La matriz de tamaño " + n +" es de raíz entera simétrica.");
			} else {
				System.out.println("La matriz de tamaño " + n +" es de raíz entera no simétrica.");
			}
			
			scan.close();
			
		} catch (Exception e) {
			System.out.println("Entrada Inválida.");
		}
		
	}

	//Comparo si son simétricas.
	private static boolean compararMatrices(int[][] m, int[][] mT) {
		//Método de la clase Array para comprar matrices.
		if (Arrays.deepEquals(m, mT)) {
			return true;
		} else {
			return false;
		}
	}

	//Le da valores a mT de forma traspuesta a m.
	private static int[][] trasponer(int[][] m,int [][] mT, int x, int y) {	
		
		//Entra si los valores son menores al tamaño de la matriz.
		if (x <= n -1 && y <= n -1) {
			
			//Damos valores a la matrizTraspuesta.
			mT[y][x] = m[x][y];
			
			if (y == n -1)  {
				y = 0;
				x++;
			} else {
				y++;
			}
			
			//Llamo al método otra vez.
			trasponer(m, mT, x, y);
		}
		
		//El método devuelve la matrizTraspuesta.
		return mT;
	}

	private static void hacerRaiz(int m[][], int x, int y) {

		//Entra si los valores son menores a el tamaño de la matriz.
		if (x <= n -1 && y <= n -1 ) {
			
			//Da valores a la matriz haciendo la raiz.
			m[x][y] = (int) Math.pow(m[x][y], 0.5);
			
			if (y == n -1) {
				x++;
				y=0;
			} else {
				y++;
			}
			
			//Llama al método otra vez.
			hacerRaiz(m, x, y);
			
		}
		
		
	}

	
	private static void hacerMatriz(int m [][], int x, int y, int a) {
		//Creo otro scan para coger los String, el otro coge ints.
		Scanner scan = new Scanner(System.in);
		if (a == n) {
			a = 0;
		}
		
		//Variable de la cadena
		String numeros;
		//Variable para dividir la cadena
		String num[];
		//Leo la cadena
		numeros = scan.nextLine();
		//Quito los espacos al inicio y al final
		numeros = numeros.trim();
		//Capturo los espacios intermedios
		num = numeros.split("\\s+");
		
		darValores(m, x, y, a, numeros, num);
		scan.close();
		
	}
	
	private static void darValores(int m[][], int x, int y, int a, String numeros, String[] num) {
		
		//Entra si los valores son inferiores a la dimension de la matriz
		if ((a <= n -1) || (y <= n -1)) {
			
			//Valores <=0 falla y se acaba el programa.
			if (Integer.parseInt(num[a]) <= 0) {
				System.out.println("Entrada Inválida.");
				System.exit(0);
			}
			
			//Le daamos valores a la matriz
			m[x][y] = Integer.parseInt(num[a]);
			
			//Sumo coordenada 'y' y la variable para leer el String
			a++;
			y++;
			
			//Vuelvo a llamar a este método.
			darValores(m, x, y, a, numeros, num);
		} else {
			
			//Igualamos las variables a 0.
			a = 0;
			y = 0;			
			
			//Suma la x y llama al otro método para que vuelva a leer otra cadena de String
			if (x != n -1) {
				x++;
				hacerMatriz(m, x, y, a);
			} else {
				//Iguala la x a 0 y acaba el método.
				x = 0;
			}
			
		}
		
	}

//	private static void verMatriz(int[][] m, int x, int y) {
//		
//		System.out.print(m[x][y] + " ");
//		
//		if (x != n -1 || y != n -1 ) {
//			
//			if (y == n -1) {
//				x++;
//				y=0;
//				System.out.println("");
//			} else {
//				y++;
//			}
//			
//			verMatriz(m, x, y);
//			
//		}
//		
//	}
	
}