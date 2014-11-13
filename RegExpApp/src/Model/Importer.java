package Model;
import java.io.*;

public class Importer {

	/**
	 * Lit un fichier et retourne son contenu
	 * @param path L'adresse du fichier a lire
	 * @return Retourne une String contenant le texte du fichier lu.
	 */
	public static String importerTexte(String path) {
		String texte="";
		// TODO Auto-generated constructor stub
		
			try {
				InputStream inputStream=new FileInputStream(path);
				InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
				BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
				String ligne;
				while((ligne=bufferedReader.readLine())!=null){
					texte+=ligne+"\n";
				}
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return texte;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(importerTexte("textes/texteTest.txt"));
		
	}

}
