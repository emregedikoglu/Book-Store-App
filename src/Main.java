import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		//Create book array
		Book b[] = new Book[272];
		
		//Read files
		ReaderWriter rw = new ReaderWriter();

		BufferedReader reader1 = rw.readFile("books.txt");
		BufferedReader reader2 = rw.readFile("queries.txt");

		//Read and split lines in books.txt file and add book array
		String line1 = "";

		int count = 0;

		while ((line1 = reader1.readLine()) != null) {

			b[count] = new Book();
			
			String delims = "[#####]";
			String[] tokens = line1.split(delims);
			
			b[count].setAuthor(tokens[0]);
			b[count].setName(tokens[5]);
			b[count].setId(tokens[10]);
			b[count].setPrice(tokens[15]);
			b[count].setStock(tokens[20]);
			
			count++;

		}
		
		//Sort book array by id
		Arrays.sort(b); 
		
		//Read lines in queries.txt file and write results to output.txt file
		String line2 = "";
		
		PrintWriter writer = rw.openWriteMode("output.txt");
		
		while ((line2 = reader2.readLine()) != null) {

			rw.writeFile(writer, line2, b);

		}
		
		rw.closeWriteMode(writer);
		
		System.out.println("The output.txt file was created. Please check the results from the file.");
	}

}
