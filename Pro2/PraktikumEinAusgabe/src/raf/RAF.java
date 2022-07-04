package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("Z:\\Uni\\Semester2\\Programmierung2\\Pr\\Ein-Ausgabe\\Test\\test.txt","rw");
					
			for (int i = 1; i<101; i++) {
				raf.writeLong(i*i);
			}
			long p = raf.getFilePointer();
			raf.seek(0);
			for (int i = 1; i < 101; i++) {
				System.out.println(raf.readLong());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(raf != null) {
				try {
					raf.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}

	}

}
