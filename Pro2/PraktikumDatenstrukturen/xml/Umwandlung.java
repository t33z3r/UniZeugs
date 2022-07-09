package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Umwandlung {
	
	private ArrayList<Film> filme;
	
	public Umwandlung() {
		filme = new ArrayList<Film>();
	}
	
	public void read(String pfad) {
		Path p = Paths.get(pfad);
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(p);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("/");
				if (data.length >= 2) {
					String name = data[0].substring(0, data[0].indexOf("("));
					String year = data[0].substring(data[0].indexOf("(")+1, data[0].indexOf(")"));
					Film f = new Film(name, year);
					for (int i = 1; i < data.length; i++) {
						f.fuegeSchauspielerHinzu(data[i]);
					}
					filme.add(f);
				}
			}
			
		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen.");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Fehler beim Schließen.");
				e.printStackTrace();
			}
		}
	}
	
	public void wandleFilmUm(String pfadxml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		Element root = doc.createElement("filme");
		
		for (Film f : filme) {
			Element aktuere = doc.createElement("aktuere");
			
			for(String a : f.getSchauspieler()) {
				Element aktuer = doc.createElement("aktuer");
				aktuer.appendChild(doc.createTextNode(a));
				aktuere.appendChild(aktuer);
			}
			
			Element filmname = doc.createElement("name");
			filmname.appendChild(doc.createTextNode(f.getName()));
			Attr jahr = doc.createAttribute("jahr");
			jahr.setValue(f.getJahr());
			Element film = doc.createElement("film");
			film.setAttributeNode(jahr);
			film.appendChild(filmname);
			film.appendChild(aktuere);
			root.appendChild(film);
			
		}
		doc.appendChild(root);
		
		TransformerFactory trfactory = TransformerFactory.newInstance();
		Transformer tr = trfactory.newTransformer();
		tr.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(pfadxml));
		tr.transform(domSource, sr);
	}
	
	public static void main(String[] args) throws Exception {
		Umwandlung u = new Umwandlung();
		u.read(".\\filme.txt");
		u.wandleFilmUm(".\\filme.xml");
		System.out.println("Umwandlung abgeschlossen.");
	}

}
