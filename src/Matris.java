import java.util.Random;

public class Matris {
	static int[][] matrisUret(int row, int column, int minValue, int maxValue){
		int[][] matris = new int[row][column];
		Random r = new Random();
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				matris[i][j] = r.nextInt(maxValue-minValue) + minValue;
			}
		}
		return matris;
	}
	
	static int[][] matrisTopla(int[][] matris1, int[][] matris2, int row, int column){
		int[][] matris = new int[row][column];
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				matris[i][j] = matris1[i][j] + matris2[i][j];
			}
		}
		return matris;
	}
}
