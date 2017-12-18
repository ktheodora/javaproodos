import java.io.*;
import java.util.Scanner;


public class THEMA_1 {
	 public static void main(String[] args) throws IOException {
	        Scanner s = null;
	        try {
	        	FileInputStream fileInput = new FileInputStream("thema_1_2014.txt");
	            int sumgrammatwn = 0; // epeidh kathe fora pou vriskei leksh pairnei +1 keno, sto telos h teleia metrietai ws kanoniko gramma kai den ypologizetai allo keno
	            int lekseis = 0;
	            int r;
	            char keno = ' ';
	            while ((r = fileInput.read()) != -1)
	            {
	            	char c = (char) r;
	            	if (c == keno) {
	            		lekseis +=1;
	            	}
	            	sumgrammatwn+=1;
	            }
	            fileInput.close();
	            System.out.println("To synoliko megethos grammatwn einai" + sumgrammatwn);
	            System.out.println("Oi synolikes lekseis einai" + (lekseis + 1)); //+1 gia thn teleytaia leksh poy teleiwnei me teleia
	            double xreosi;
	            if (sumgrammatwn <= 25) {
	            	xreosi = sumgrammatwn*5;
	            }
	            else if (sumgrammatwn <= 100) {
	            	xreosi = (sumgrammatwn-25)*3.5 + 25*5;
	            }
	            else
	            {
	            	xreosi = 25*5 + (100-25)*3.5 + (sumgrammatwn - 100)*2;
	            }
	            System.out.println("H synolikh xreosi einai" + xreosi);
	            int grammes = sumgrammatwn / 11;
	            if (sumgrammatwn % 11 != 0) {
	            	grammes +=1;
	            }
	           System.out.println("Oi grammes pou pianei h aggelia einai" + grammes);
	        } finally {
	            if (s != null) {
	                s.close();
	            }
	        }
	        String keimeno = "geia sas me lene theodora kyriakou kai anazhtw ergasia ws java developer me kales apolaves gia epikoiwnia steilte email sto youhou@gmail teleia com me thema se thelw na doylepseis gia mena.";
	        double mhkos = keimeno.length();
	        System.out.println("To alithino mhkos einai " + mhkos);
	 }
}
