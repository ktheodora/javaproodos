import java.util.Scanner;
import java.lang.String;
public class THEMA_1 {
		public static void main (String[] args) {
			Scanner read = new Scanner(System.in);
			double[] polyk = new double[5];
			double syn_tetr =0;
			String[] names = new String[5];
			for (int i=0; i<5; i++) {
				System.out.println("O idioktitis tou diamerismatos no " + (i+1));
				 System.out.println("Na dwsei to onoma tou:");
				 names[i]=read.next();
				 System.out.println("Na dwsei ta tetrag. tou spitiou tou:");
				 polyk[i]=read.nextDouble();
				 syn_tetr= syn_tetr + polyk[i];
			}
			System.out.println("Ta synolika tetragwnika ths polykatoikias einai" + syn_tetr);
			System.out.println("Dwste twra ta synolika koinoxrista ths polykatoikias:");
			double expenses = read.nextDouble();
			double[] koinoxr = new double[5];
			for(int i=0; i<5; i++) {
				koinoxr[i] = (polyk[i]*expenses)/syn_tetr;
				System.out.println("Onoma idioktiti: " +names[i] + "\nPoso koinoxristwn pou tou antistoixei: " + koinoxr[i]);
			}
			System.out.println("Twra epilekste enan orofo kai tha emfanistei onoma kai koinoxrhsta: ");
			int orofos = read.nextInt();
			for (int i=0; i<5; i++) {
				if (i == (orofos-1)) {
					System.out.println("Onoma idioktiti: " +names[i] + "\nPoso koinoxristwn pou tou antistoixei: " + koinoxr[i]);
					break;
				}
			}
			read.close();
			System.out.println("TELOS PROGRAMMATOS!");
		}
}
