package themata2017;
import java.io.*;

public class thema2o {
	static String readString(int length, RandomAccessFile raf)
			throws IOException {
			byte b[]=new byte[length]; 
			raf.readFully(b); 
			return new String(b); }
	public static void main (String [] args) {
		RandomAccessFile lefta  =null;
		RandomAccessFile eforia  = null;
		RandomAccessFile xreos  = null;
		RandomAccessFile codes  = null;
		try {
			lefta  = new RandomAccessFile("lefta.dbs","r");
			 eforia  = new RandomAccessFile("eforia.dbs","r");
			 xreos  = new RandomAccessFile("xreos.dbs","w");
			 codes  = new RandomAccessFile("langard.dbs","r");
			long k1 = codes.readLong(), count = 0; //o prwtos kwdikos pelath pou xrwstaei
			while(count < codes.length()) {//tha prosthetoume sto count kathe timh pou prospername
				long pos = (k1-1)*(50+60+50+4);
				lefta.seek(pos);
				String name = readString(50, lefta);
				String addr = readString(60, lefta);
				lefta.skipBytes(54);
				long pos1 = (k1-1) *(4+50+4+60);
				eforia.seek(pos1);
				float old_xreos = eforia.readFloat();
				String forolog_m = readString(50, eforia);
				float katatheseis = eforia.readFloat();
				eforia.skipBytes(60);
				float new_xreos =(old_xreos - katatheseis) + (old_xreos - katatheseis)*10/100 ;
				xreos.writeUTF(name);
				xreos.writeUTF(addr);
				xreos.writeUTF(forolog_m);
				xreos.writeFloat(new_xreos);			
				count += k1;//teleiwse o prwtos kwdikos
				k1 = codes.readLong(); //pame gia ton epomeno
			}
		
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		catch (IOException e) {
            e.printStackTrace();
        }
		finally {
			try {
				if ( lefta != null && eforia != null && xreos != null && codes != null) {
				lefta.close();
				eforia.close();
				xreos.close();
				codes.close();
				}
			}
			catch (IOException e) {
				System.out.println("Problem with closing file!");
		    }
		}
 }
}
