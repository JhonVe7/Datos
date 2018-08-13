import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;


public class ADNGenerator {
	
	public static void createFile() throws IOException {
		
		try {
			
			FileWriter FW= new FileWriter("ADN.txt"); 
			BufferedWriter bw = new BufferedWriter(FW);
			
			String sequence = "";
			Random rd = new Random();
			int number;
		
			for (int i = 0; i < 10000; i++) {
				number = rd.nextInt(3);
				sequence += (number == 0 ? "A":(number == 1 ? "D": "N"));
			}
			// var = condicion ? asignarverdadero : asignarFalso ;
			bw.write(sequence);
			bw.flush();
		}
		catch (Exception ex) {}
		
	} 
	public static int counterSubstrings(String substring) {
		int counter = 0 ;
		try {
		//abrir archivo 
		FileReader fr = new FileReader("ADN.txt");
		BufferedReader br = new BufferedReader (fr);
		//sacar cadena
		String sequence = br.readLine();
		//recorrer cadena
			for (int i = 0; i < sequence.length(); i++) {
				//si encuentra patron, aumentar contador
				if(sequence.substring(i, i+substring.length()).equals(substring)) 
					counter += 1;
			}
		}
		catch(Exception ex) {}
			
		return counter;
	}

	
	public static void main (String [] args) throws IOException {
		createFile();
		System.out.println("cantidad de ocurrencias de ADN: " + counterSubstrings("ADN"));
		System.out.println("cantidad de ocurrencias de ADN: " + counterSubstrings("DNA"));
		System.out.println("cantidad de ocurrencias de ADN: " + counterSubstrings("DAN"));
	}

}
