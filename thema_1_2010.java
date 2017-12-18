import java.util.Scanner;

public class thema_1 {
	 public static void main(String[] args)  { 
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Please give number of lines in array A");
		 int n = scanner.nextInt();
		 System.out.println("Please give number of stripes in array A");
		 int m = scanner.nextInt();
		 int[][] A = new int[n][m];
		 int min = 500;
		 for (int i=0; i <=n; i+=2 ) {
				int maxofline = 0;
				for ( int j = 0; j <= m; j++) {
					if (A[i][j] > 0 ) {
						if (A[i][j] > maxofline) {
							maxofline = A[i][j];
						}
					}
				}				
			 if (maxofline < min) {
				 min = maxofline;
			 }
		 }
		 System.out.println("The minimum of the maximums of the even lines amongst values above 0 is " + min) ;
		 scanner.close();
	 }
}
