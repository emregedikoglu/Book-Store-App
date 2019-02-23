import java.io.*;

public class ReaderWriter {

	public BufferedReader readFile(String readPath) throws FileNotFoundException {

		File file = new File(readPath);

		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);

		return reader;
	}

	public PrintWriter openWriteMode(String writePath) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(writePath);

		return writer;
	}

	public void closeWriteMode(PrintWriter writer) {
		writer.close();
	}

	public void writeLines(PrintWriter writer, Book b[], int i) {

		writer.println("ID: " + b[i].getId());
		writer.println("NAME: " + b[i].getName());
		writer.println("AUTHOR: " + b[i].getAuthor());
		writer.println("PRICE: " + b[i].getPrice());
		writer.println("STOCK: " + b[i].getStock());
		writer.println(" ");
		writer.println("--------------------------------------------------");
		writer.println(" ");

	}

	public void writeFile(PrintWriter writer, String line, Book b[]) throws FileNotFoundException {

		if (line.equals("LIST-WHERE-ALL")) {

			writer.println(line);
			writer.println("********************");

			for (int i = 0; i < 272; i++) {
				
				writeLines(writer, b, i);
			
			}

		}

		else if (line.contains("LIST-WHERE-NAME")) {

			String subLine = "";
			subLine = line.substring(16);

			writer.println(line);
			writer.println("********************");

			for (int i = 0; i < 272; i++) {
				
				if (b[i].getName().equals(subLine)) {
					
					writeLines(writer, b, i);

					break;
				}
			
			}

		}

		else if (line.contains("LIST-WHERE-AUTHOR")) {

			String subLine = "";
			subLine = line.substring(18);

			int flag = 0;

			writer.println(line);
			writer.println("********************");

			for (int i = 0; i < 272; i++) {
			
				if (b[i].getAuthor().equals(subLine)) {
					
					writeLines(writer, b, i);

					flag = 1;
					break;
				}

			}

			if (flag == 0) {
				
				writer.println("No Book Found!");
				writer.println(" ");
				writer.println("--------------------------------------------------");
				writer.println(" ");
			
			}
		}

		else if (line.contains("LIST-WHERE-PRICE-GREATER")) {

			String subLine = "";
			subLine = line.substring(25);

			double sLine = Double.parseDouble(subLine);

			writer.println(line);
			writer.println("********************");

			for (int i = 0; i < 272; i++) {
			
				if (Double.parseDouble(b[i].getPrice()) > sLine) {

					writeLines(writer, b, i);

				}

			}

		}

		else if (line.contains("LIST-WHERE-PRICE-LESS")) {

			String subLine = "";
			subLine = line.substring(22);

			double sLine = Double.parseDouble(subLine);

			writer.println(line);
			writer.println("********************");

			for (int i = 0; i < 272; i++) {
				
				if (Double.parseDouble(b[i].getPrice()) < sLine) {

					writeLines(writer, b, i);

				}

			}

		}

		else if (line.contains("LIST-WHERE-PRICE-BETWEEN")) {

			String subLine = "";
			subLine = line.substring(25);

			String delims = "[_]";
			String[] tokens = subLine.split(delims);

			double sLine1 = Double.parseDouble(tokens[0]);
			double sLine2 = Double.parseDouble(tokens[1]);

			writer.println(line);
			writer.println("********************");

			for (int i = 0; i < 272; i++) {
				
				if (Double.parseDouble(b[i].getPrice()) >= sLine1 && Double.parseDouble(b[i].getPrice()) <= sLine2) {

					writeLines(writer, b, i);

				}

			}

		}

	}

}
