package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"Das","ist","ein","Test"};
		String file = "Z:\\Uni\\Semester2\\Programmierung2\\Pr\\Ein-Ausgabe\\Test\\data.d";
		schreibeIn(file, a);
		System.out.println(liesAus(file, 0));
		
	}
	
	public static void schreibeIn(String file, String[] a) {		
		RandomAccessFile rafd= null;
		RandomAccessFile rafi= null;
		try {
			rafd = new RandomAccessFile(file,"rw");
			rafi = new RandomAccessFile(file.substring(0, file.length()-1)+"i","rw");
			long p = 0;
			rafi.writeLong(p);
			for (String strings : a) {
					rafd.writeUTF(strings);
					p = rafd.getFilePointer();
					rafi.writeLong(p);
			}					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rafd != null) {
				try {
					rafd.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
			if(rafi != null) {
				try {
					rafi.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}
	
	public static String liesAus(String file, int n) {
		RandomAccessFile rafd= null;
		RandomAccessFile rafi= null;
		String out = "";
		try {
			rafd = new RandomAccessFile(file,"r");
			rafi = new RandomAccessFile(file.substring(0, file.length()-1)+"i","r");
			
			long  p = n * 8;
			rafi.seek(p);
			long p2 = rafi.readLong();
			rafd.seek(p2);
			out = rafd.readUTF();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rafd != null) {
				try {
					rafd.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
			if(rafi != null) {
				try {
					rafi.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		return out;
	}

}
