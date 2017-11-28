import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Vector;

public class CuentaPalabras {

	private Vector<String> diccionario;
	private TreeMap <String, Integer> palabras;
	
	public CuentaPalabras() {
		diccionario = new Vector<String>();
		palabras = new TreeMap<String, Integer>();
		
	}
	
	private void buscarPalabras() {
		
		try {
			FileReader fr = new FileReader("/diccionario.txt");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				String palabra = br.readLine();
				if (!diccionario.contains(palabra)) {
					diccionario.add(palabra);
				}
			}
		} catch (IOException e) {
			System.err.println("No se encuentra diccionario.txt");
		}
		
		palabras.forEach((p, n) -> { 
			if (!diccionario.contains(p)) {
				System.out.print(p + "\t\t");
			}
		} );
		
	}
	
	public void contarPalabras() {
		
		try {
			FileReader fr = new FileReader("/libro.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while (br.ready()) {
				// parte por cualquiera de los caracteres incluidos entre los [ ] corchetes.
				String str[] = br.readLine().split("[.,:¿?¡! ]");
				
				for (String palabra : str) {
					// No contar cadenas vacias (consecuencia de split)
					if (palabra.length() != 0) {
						if (palabras.containsKey(palabra)) {
							palabras.put(palabra, palabras.get(palabra) + 1);
						} else {
							palabras.put(palabra, new Integer(1));
						}
					}
				}
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra libro.txt");
		} catch (IOException e) {
			System.err.println("Fallo al leer libro.txt");
		}
		
		palabras.forEach((s,i) -> { 
				System.out.println(s.toString() + "\t\t" + i.toString());
			} );
			
		}

	public static void main(String[] args) {

		CuentaPalabras cp = new CuentaPalabras();
		cp.contarPalabras();
		cp.buscarPalabras();
		
	}

}
