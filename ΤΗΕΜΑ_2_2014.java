import java.io.*;
import java.io.RandomAccessFile;
public class ิวลฬม_2 {
	static String readString(int length, RandomAccessFile raf)
			throws IOException {
			byte b[]=new byte[length]; 
			raf.readFully(b); 
			return new String(b); }
	public static void main (String [] args) {
		try {
			RandomAccessFile eforiaa = new RandomAccessFile("eforia.dbs","rw");
			RandomAccessFile detailss = new RandomAccessFile("details.dbs","rw");
			RandomAccessFile codess = new RandomAccessFile("codes.dbs","r");
			RandomAccessFile xreoss = new RandomAccessFile("xreos.dbs","r");
			long pos = 0L;
			long pos2 = 0L;
			int count = 0;
			String name, addr, tel, date;
			int nums;
			float new_xreostiko;
			while(eforiaa.length() != (50+60+50)*codess.length()) {
				int code = codess.readInt();
				pos = (code - 1)*(50+60+50+4);
				eforiaa.seek(pos);
				name = readString(50, eforiaa);
				addr = readString(60, eforiaa);
				tel = readString(50, eforiaa);
				nums = eforiaa.readInt();
				xreoss.seek((code - 1)*4);
				new_xreostiko = xreoss.readFloat();
				pos2 = (code - 1)*(4+18);//4 ta bytes tou float kai 18 oi xarakthres ths teleytaias synallaghs
				detailss.seek(pos2);
				detailss.skipBytes(4);
				date = readString(18, detailss);
				if (code != count) {
					eforiaa.seek(count);
					eforiaa.skipBytes((50+60+50+4)*(code - count)); //h teleytaia eggrafh diagrafetai apo thn thesh ths
					// kai mpanei se kainourgia seira
					eforiaa.seek(count);
					eforiaa.writeUTF(name);
					eforiaa.writeUTF(addr);
					eforiaa.writeUTF(tel);
					eforiaa.writeInt(nums);
					detailss.seek(count); //kanume thn idia diadikasia kai gia thn details.dbs
					detailss.skipBytes((4+18)*(code - count));
					detailss.seek(count); 
					detailss.writeFloat(new_xreostiko);
					detailss.writeUTF(date);
				}
				count++;
			}
			eforiaa.close();
            codess.close();
            detailss.close();
            xreoss.close();
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		catch (IOException e) {
            e.printStackTrace();
        }
	}
}
