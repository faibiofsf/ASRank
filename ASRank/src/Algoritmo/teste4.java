package Algoritmo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class teste4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
double[][] E;
			
			int dimensao = 0;
			Scanner f = new Scanner(new File("..\\ACO_NOVO\\src\\Testes\\pa561.tsp"));
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
			while(f.hasNext() && (!s.equals("EOF") && !s.equals("eof"))){
										
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
			
			int[] solucao = {1,153,106,154,109,108,107,110,111,115,114,176,175,48,174,173,172,42,43,47,44,40,38,4,2,39,3,10,11,6,8,9,7,20,19,18,17,16,21,15,14,28,27,26,25,24,31,23,22,34,33,35,30,29,13,12,5,36,37,41,32,45,52,51,46,50,55,49,177,178,180,182,181,57,72,56,71,54,53,70,69,58,68,59,60,61,62,63,64,65,74,84,85,86,87,83,88,82,81,101,89,104,105,102,103,99,100,80,79,77,75,66,67,76,78,90,91,92,73,93,94,96,98,97,95,189,184,183,185,188,186,128,127,123,126,122,179,118,119,116,120,117,112,113,163,156,155,157,162,164,161,160,480,168,170,171,142,145,134,140,141,169,167,166,139,165,121,125,124,129,130,131,132,133,135,136,137,217,216,138,151,152,222,223,241,256,257,254,255,224,225,221,218,219,215,191,187,190,192,193,194,196,195,205,206,207,209,208,213,212,214,211,210,197,200,204,203,202,199,201,198,220,226,227,253,259,258,260,261,318,317,316,315,314,319,320,323,322,305,306,307,309,308,301,300,299,294,295,290,280,289,272,288,281,252,269,270,271,268,249,250,251,233,234,235,237,238,236,248,239,266,267,275,276,274,273,279,278,292,291,293,296,297,298,302,304,303,321,313,312,277,311,310,265,262,263,264,242,243,244,245,246,247,240,230,229,228,148,147,150,149,143,146,144,501,503,502,504,505,506,511,509,507,231,508,232,523,530,532,533,534,535,282,287,286,285,284,283,536,537,538,531,529,528,527,539,540,541,553,554,555,558,559,560,561,557,556,475,551,552,548,547,526,525,524,522,521,510,520,514,513,512,496,498,499,515,516,519,518,461,460,459,517,500,416,415,494,497,495,492,491,490,489,488,484,485,483,481,482,159,158,328,400,401,405,402,399,398,418,419,403,404,423,424,425,431,407,412,408,409,406,486,487,493,410,411,414,417,413,436,437,438,445,446,444,448,452,447,467,462,463,466,468,470,472,471,465,464,544,543,542,545,546,550,549,474,473,476,478,477,453,469,479,458,457,456,455,454,451,450,395,394,396,397,378,379,377,375,376,372,374,373,371,370,390,389,391,393,392,449,388,387,443,385,386,367,368,369,366,365,364,384,381,383,440,441,442,439,382,434,433,435,432,430,429,427,426,422,421,340,342,428,380,363,361,360,359,355,358,357,362,341,356,339,351,336,337,420,335,338,353,354,352,350,349,348,347,343,344,345,346,333,334,329,332,330,327,326,325,331,324,1}; 
			
			//Verifica a solu��o
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