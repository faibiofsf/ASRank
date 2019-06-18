package Algoritmo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class teste3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			int dimensao = 0;
			Scanner f = new Scanner(new File("..\\ASRank\\src\\Testes\\kroA100.tsp"));
			String s = f.nextLine();

			while (!s.contains("DIMENSION: ")) {
				s = f.nextLine();
			}
			dimensao = Integer.parseInt(s.split(" ")[1]);

			while (!s.contains("NODE_COORD_SECTION")) {
				s = f.nextLine();
			}
			ArrayList<double[]> lista = new ArrayList<double[]>();
			s = f.next();
			while (f.hasNext() && (!s.equals("EOF") && !s.equals("eof"))) {
				double x = f.nextDouble();
				double y = f.nextDouble();
				lista.add(new double[] { x, y });
				s = f.next();
			}

			double[][] E = new double[dimensao][dimensao];

			for (int i = 0; i < E.length; i++) {
				for (int j = 0; j < i; j++) {

					double xd = Math.abs(lista.get(i)[0] - lista.get(j)[0]);
					double yd = Math.abs(lista.get(i)[1] - lista.get(j)[1]);
					double dij = (int) (Math.sqrt(xd * xd + yd * yd));

					E[i][j] = dij;
					E[j][i] = dij;

				}
			}
			
			int[] solucao = {1,47,93,28,67,58,61,51,87,25,81,69,64,40,54,2,44,50,73,68,85,82,95,13,76,33,37,5,52,78,96,39,30,48,100,41,71,14,3,43,46,29,34,83,55,7,9,57,20,12,27,86,35,62,60,77,23,98,91,45,32,11,15,17,59,74,21,72,10,84,36,99,38,24,18,79,53,88,16,94,22,70,66,26,65,4,97,56,80,31,89,42,8,92,75,19,90,49,6,63,1}; 
			
			//Verifica a solução
			double distanciaTotal = 0.0;
			for (int j = 1; j < solucao.length; j++) {
				distanciaTotal += E[solucao[j-1]-1][solucao[j]-1];
			}
			
			distanciaTotal += E[solucao[solucao.length-1]][solucao[0]];
			
			System.out.println("Solucao: " + distanciaTotal);
						
			f.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
