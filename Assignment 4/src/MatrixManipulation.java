import java.util.Random;
import java.util.Scanner;

public class MatrixManipulation {
	
	
	 	private static int M =0;             // number of rows
	    private static int N =0;             // number of columns
	    private int[][] data;   // M-by-N array
	    static Random rand = new Random();

	    // create M-by-N matrix of 0's
	    public MatrixManipulation(int M, int N) {
	        this.M = M;
	        this.N = N;
	        data = new int[M][N];
	    }
	
	
	
	public static void main(String args[]){
		
		int x=0;
		int y = 0;
		Random rand = new Random();
		
		
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the Lower range for your two dimensional matrix");
		
		if(s.hasNextInt()){
			x = s.nextInt();
			System.out.println("Enter the Upper range for your two dimensional matrix");
			if(s.hasNextInt()){
					y = s.nextInt();
					if (y > x){
						System.out.println("The range of your matrix will be ["+x +" "+y + "]");
					}
					else{
						System.out.println("The upper range should always be greater than the lower range");
					}
				}
			else{
				System.out.println("Please enter an integer value for the upper range next time! The program will now exit");
			}
			}
		else{
			System.out.println("Please enter an integer value for the lower range next time! The program will now exit");
		}
		
		s.close();
		
		MatrixManipulation a = MatrixManipulation.randomGenerator(x,y);
		MatrixManipulation b = MatrixManipulation.randomGenerator(x,y);
		System.out.println("Matrix a is ");
		a.print();
		System.out.println();
		System.out.println("Matrix b is ");
		b.print();
		System.out.println();
		MatrixManipulation c = addition(a,b);
		System.out.println("The addition of matrices a and b is ");
		c.print();
		System.out.println();
		MatrixManipulation d = subtract(a,b);
		System.out.println("The subtraction of matrices b from a is ");
		d.print();
		System.out.println();
		MatrixManipulation e = multiply(a, b);
		System.out.println("The multiplication of matrices a and b is ");
		e.print();
		
	}



	private static MatrixManipulation multiply(MatrixManipulation a, MatrixManipulation b) {
	        if (a.N != b.M) throw new RuntimeException("Illegal matrix dimensions.");
	        MatrixManipulation c = new MatrixManipulation(a.M, b.N);
	        for (int i = 0; i < c.M; i++){
	            for (int j = 0; j < c.N; j++){
	                for (int k = 0; k < a.N; k++){
	                    c.data[i][j] += (a.data[i][k] * b.data[k][j]);
	                }
	            }
	        }
	        return c;
	    
	}



	private static MatrixManipulation subtract(MatrixManipulation a, MatrixManipulation b) {
		if (b.M != a.M || b.N != a.N) throw new RuntimeException("Illegal matrix dimensions.");
		MatrixManipulation c = new MatrixManipulation(M, N);
		for(int i=0;i<M; i++){
			for(int j=0; j< N; j++){
				c.data[i][j] = a.data[i][j] - b.data[i][j];
			}
		}
		return c;
	}



	private static MatrixManipulation addition(MatrixManipulation a, MatrixManipulation b) {
		if (b.M != a.M || b.N != a.N) throw new RuntimeException("Illegal matrix dimensions.");
		MatrixManipulation c = new MatrixManipulation(M, N);
		for(int i=0;i<M; i++){
			for(int j=0; j< N; j++){
				c.data[i][j] = a.data[i][j] + b.data[i][j];
			}
		}
		return c;
		
		
	}



	private void print() {
		for(int i=0;i<M; i++){
			for(int j=0; j< N; j++){
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		
	}



	private static MatrixManipulation randomGenerator(int x, int y) {
		MatrixManipulation mat = new MatrixManipulation(x, y);
		
		for(int i=0;i<x; i++){
			for(int j=0; j< y; j++){
				mat.data[i][j] = rand.nextInt((y-x)+1) + x;
			}
		}
		return mat;
	}
	
	
	
}
