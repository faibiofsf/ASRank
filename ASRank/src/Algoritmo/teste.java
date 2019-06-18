package Algoritmo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			double[][] E;
			
			int dimensao = 0;
			Scanner f = new Scanner(new File("E:\\workspace\\ACO-GT\\src\\brazil58.tsp"));
			String s = f.nextLine();
			
			while(!s.contains("DIMENSION: ")){
				s = f.nextLine();
			}
			dimensao = Integer.parseInt(s.split(" ")[1]);
			
			E = new double[dimensao][dimensao];
			
			while(!s.contains("EDGE_WEIGHT_SECTION")){
				s = f.nextLine();
			}
			
			int i = 0;
			s = f.nextLine();
			while(f.hasNext() && (!s.equals("EOF") || !s.equals("eof"))){
										
				String[] linha = s.split(" ");
				int j = i+1;
				for (int z = 0; z < linha.length; z++) {							
					E[i][j] = Double.parseDouble(linha[z]);
					E[j][i] = Double.parseDouble(linha[z]);
					j++;
				}
				i++;
				
				s = f.nextLine();
				
			}
			
			int[] solucao = {20,35,16,25,5,18,27,13,36,14,33,55,45,44,32,28,2,34,9,51,50,46,48,42,26,4,22,11,56,23,57,43,17,0,29,12,39,24,8,31,19,52,49,3,21,7,54,53,1,40,47,38,10,15,41,37,30,6}; 
			
			//Verifica a solução
			double distanciaTotal = 0.0;
			for (int j = 1; j < solucao.length; j++) {
				distanciaTotal += E[solucao[j-1]][solucao[j]];
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
