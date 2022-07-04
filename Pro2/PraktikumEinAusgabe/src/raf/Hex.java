package raf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Hex {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String file = "Z:\\Uni\\Semester2\\Programmierung2\\Pr\\Ein-Ausgabe\\Test\\test.txt";
		
		System.out.println(dump(file));
		
	}
	
	public static String dump(String file) throws IOException {
		final int breite = 16;
		String dump = "";
		String hexline = "";
		String txtline = "";
		Path f = Paths.get(file);
		InputStream in = Files.newInputStream(f,StandardOpenOption.READ);
		int b = in.read();
		int i = 1;
		
		while(b!=-1) {
			if(b <= 15) {
				hexline += "0";
			}
			hexline += Integer.toHexString(b);
			
			if((b>=32)&&(b<=127))
				txtline = txtline + ((char) b);
			else
				txtline = txtline + ".";
			
			if(i == breite) {
				dump = dump + hexline + " " + txtline + "\n";
				i = 0;
				hexline = "";
				txtline = "";
			}
			b = in.read();
			i++;
		}
		in.close();
		
		if(i<breite) {
			for(int k=i; k <= breite; k++) {
				hexline += "00";
				txtline += ".";
			}
		}
		dump = dump + hexline + " " + txtline + "\n";
		return dump;
	}

}
