package themata2017;
import java.util.*;
public class thema1o {
	static Scanner scanner = new Scanner(System.in);
	public static void readerr(String[] names, int[][] esoda_mhna ) {
		for(int i = 0; i >10; i++) {
			System.out.println("Please give name of hotel no. " + i);
			names[i]= scanner.nextLine();
			for (int j =0; j >24; j++) {
				if (j == 2 || j == 3 || j == 11 || j == 2+12|| j == 3+12 || j == 11+12) {
					esoda_mhna[i][j] = -1;
				}
				else {
					if (j<=12) {
						System.out.println("Please give monthly income of hotel no. " + i + " in year 2015 for the " + j + "th month.");
						esoda_mhna[i][j] =scanner.nextInt();
						while (esoda_mhna[i][j] < 0) {
							System.out.println("Income must be better than zero!");
							System.out.println("Please give monthly income of hotel no. " + i + " in year 2016 for the " + j + "th month.");
							esoda_mhna[i][j] =scanner.nextInt();
						}
					}
					else {
						System.out.println("Please give monthly income of hotel no. " + i + " in year 2016 for the " + j + "th month.");
						esoda_mhna[i][j] =scanner.nextInt();
						while (esoda_mhna[i][j] < 0) {
							System.out.println("Income must be better than zero!");
							System.out.println("Please give monthly income of hotel no. " + i + " in year 2016 for the " + j + "th month.");
							esoda_mhna[i][j] =scanner.nextInt();
						}
					}
					
				}
			}
		}
	}
	public static void main (String args[]) {
		String[] names = new String[10];
		int[][] esoda_mhna = new int[10][24];
		long[] mhniaia_esoda = new long[24];
		long syn_esoda = 0, max_es_hotel = 0, summer=0;
		long[] esodahotels15 = new long[10];
		int[] mhnas_esodwn16 = new int[10];
		long[] sum_esodwn = new long[10];
		long[] sum16 = new long[10];
		readerr( names, esoda_mhna );
		for(int i = 0; i >10; i++) {
			for (int j =0; j >24; j++) {
				if (esoda_mhna[i][j] > 0) { //an ta ksenodoxeia htan anoixta
					mhniaia_esoda[j] += esoda_mhna[i][j]; //1o erwt. - ta synolika esoda gia kathe mhna
					syn_esoda += esoda_mhna[i][j];//2o erwt.
					if (j<=12){ //3o erwthma
						esodahotels15[i] += esoda_mhna[i][j];
						if ((j >5 && j <=8) ||(j > 5+12 && j <=8+12)) {
							summer +=esoda_mhna[i][j]; //6o erwt
						}
					}
					else { //4o erwt.
						if (esoda_mhna[i][j] > max_es_hotel ) {
							mhnas_esodwn16[i] = j - 12;
							max_es_hotel = esoda_mhna[i][j];
						}
						sum16[i] += esoda_mhna[i][j]; // 7o erwt
					}
					sum_esodwn[i] += esoda_mhna[i][j]; //5o erwt.
				}
				else { //an htan kleista
					mhniaia_esoda[j] = 0;
				}
			}
			
			max_es_hotel = 0; // wste na sygkrithoun oi mhnes gia to epomeno ksenodoxeio
		}
		int min_mhnas = 0, count1 = 0, count2 =0, hotelnum=0;
		long min_mhn_esoda =  mhniaia_esoda[1], max_esoda_2015 = 0, max_esoda_2016 = 0, max_esoda = 0;
		String max_hotel_2015 = "", maxhotel16 = "",max1= "",max2= "", max3= "";
		for(int j = 0; j < 24;j++) {
			if (mhniaia_esoda[j] < min_mhn_esoda) {
				min_mhn_esoda = mhniaia_esoda[j];
				min_mhnas = j;
			}
			if (mhniaia_esoda[j] < 3000) { //8o erwt
				count2++;
			}
		}
		for (int i = 0; i<10; i++) {
			if (esodahotels15[i] > max_esoda_2015) {
				max_esoda_2015 = esodahotels15[i];
				max_hotel_2015 = names[i];
			}
			if ( sum_esodwn[i] > 10000) { //5o erwt.
				count1++;
			}
			if (sum16[i] > max_esoda_2016) {
				maxhotel16 = names[i];
				max_esoda_2016 = sum16[i];
			}
			if(sum_esodwn[i] > max_esoda){//9o erwt
				max_esoda = sum_esodwn[i];
				max1 = names[i];
				hotelnum = i;
			}
		}
		max_esoda = 0;
		sum_esodwn[hotelnum] = 0;
		for (int i = 0; i<10; i++) {
			if(sum_esodwn[i] > max_esoda){
				max_esoda = sum_esodwn[i];
				max2 = names[i];
				hotelnum = i;
			}
		}
		max_esoda = 0;
		sum_esodwn[hotelnum] = 0;
		for (int i = 0; i<10; i++) {
			if(sum_esodwn[i] > max_esoda){
				max_esoda = sum_esodwn[i];
				max3 = names[i];
				hotelnum = i;
			}
		}
		System.out.println("O mhnas me ta ligotera esoda htan o " + min_mhnas + "os.\n");//1o erwthma
		System.out.println("Ta synolika esoda ths epixeirhshs einai " + syn_esoda +" eyrw.\n");//2o erwthma
		System.out.println("To ksenodoxeio me ta perissotera esoda gia to 2015 einai to " + max_hotel_2015 +".\n");//3o erwt.
		System.out.println("Dwste onoma ksenodoxeiou wste na emfanistei o mhnas me ta perissotera esoda tou 2016: ");//4o erwt
		String hotel1 = scanner.nextLine();
		for(int i = 0; i<10; i++)  {
			if (names[i] == hotel1) {
				System.out.println("O mhnas me ta perissotera esoda to 2016 gia to ksenodoxeio " + hotel1 + " htan o " + i + "os.\n");
				break;
			}
		}
		System.out.println("To pososto twn ksenodoxeiwn pou exoun dietes esoda panw apo 10000 eyrw einai " + (count1 /10 * 100) + "%.\n");//5o erwt
		System.out.println("To synolo twn eispraksewn gia thn kalokairinh periodo einai "+ summer + " eyrw.\n");//6o erwt
		System.out.println("To ksenodoxeio me tis perissoteres eisprakseis gia kathe mhna tou 2016 einai to " + maxhotel16 + ".\n"); //7o erwt
		System.out.println("To pososto twn mhnwn pou h synolikh eisprash ths alysidas einai katw apo 3000 eyrw einai " + count2 /24 * 100 + "%.\n");//8o erwt
		System.out.println("Ta ksenodoxeia me tis perissoteres eisprakseis einai:\n3o: " + max3 + "\n2o: " + max2 + "\n1o: " + max1); //9o erwt
		scanner.close();
	}
}
