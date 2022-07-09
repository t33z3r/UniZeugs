package _6carving;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class main {

	private static int anzahlDateien = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("stick.dd", "r");
			byte[] b = new byte[(int) raf.length()];
			raf.read(b);
			String inhalt = HexUtils.bytesToHex(b);
			
			//img
			
		 	String type = "FFD8FF";
			String tail = "FFD900"; 
			String filetype = "jpeg"; 
			
			
			//pdf
			/*
			String type = "25504446";
			//String tail = "0D0A2525454F460D0A";
			String tail = "0A2525454F460A";
			//String tail = "0D2525454F460D";
			String filetype = "pdf";
			*/
			
			//gif
			/*
			//String type = "474946383761";
			String type = "474946383961";
			String tail = "003B";
			String filetype = "gif";
			*/
			
			//zip
			/*
			String type = "504B0304";
			String tail = "504B0506";
			String filetype = "zip";
			*/
		
			//doc
			/*
			String type = "D0CF11E0A1B11AE1";
			String tail = "";
			String filetype = "doc";
			*/
			
			int beginn = inhalt.indexOf(type);
			int ende = inhalt.indexOf(tail, beginn);
			findArtifacts(inhalt, type, tail, filetype);

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void schreibeDatei(String typ, String artefakt) throws IOException {

		byte[] result = HexUtils.asBytes(artefakt);
		FileOutputStream fos = new FileOutputStream("file" + anzahlDateien + "." + typ);
		fos.write(result);
		fos.close();

		anzahlDateien++;
	}
	
	public static void findArtifacts(String s, String type, String tail, String filetype) throws IOException {
			int beginn = s.indexOf(type);
			if (beginn > -1) {
				int ende = 0;
				if (filetype == "doc") {
					ende = s.length();
				}
				else {
					ende = s.indexOf(tail, beginn);
				}
				String artifact = "";
				if (ende > -1) {
					if (filetype == "zip") {
						artifact = s.substring(beginn, ende + 20);
						schreibeDatei(filetype, artifact);
						findArtifacts(s.substring(ende + 20), type, tail, filetype);
					}
					else if (filetype == "doc") {
						artifact = s.substring(beginn, ende);
						schreibeDatei(filetype, artifact);
					}
					else {
						artifact = s.substring(beginn, ende + 2);
						schreibeDatei(filetype, artifact);
						findArtifacts(s.substring(ende + 2), type, tail, filetype);
					}
				
				}
			}
			
			
		}

}
