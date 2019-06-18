package Algoritmo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class teste2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			double[][] E;
			
			int dimensao = 0;
			Scanner f = new Scanner(new File("..\\ACO_NOVO\\src\\Testes\\bays29.tsp"));
			String s = f.nextLine();
			
			while(!s.contains("DIMENSION: ")){
				s = f.nextLine();
			}
			dimensao = Integer.parseInt(s.split(" ")[1]);
			
			E = new double[dimensao][dimensao];
			
			while (!s.contains("EDGE_WEIGHT_SECTION")) {
				s = f.nextLine();
			}

			int i = 0;
			s = f.nextLine();
			while (f.hasNext() && (!s.equals("EOF") && !s.equals("eof"))) {

				String[] linha = s.split(" ");
				for (int z = 0; z < linha.length; z++) {
					if (linha[z].contentEquals("Inf")) {
						E[i][z] = 1000000000;
					} else
						E[i][z] = Double.parseDouble(linha[z]);

				}
				i++;
				s = f.nextLine();
			}
			
			int[] solucao = {1,28,6,12,9,5,26,29,3,2,20,10,4,15,18,17,14,22,11,19,25,7,23,27,8,24,16,13,21,1}; 
			
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
