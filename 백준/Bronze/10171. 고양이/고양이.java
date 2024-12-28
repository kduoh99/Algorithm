import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		wr.write("\\    /\\" + "\n");
		wr.write(" )  ( ')" + "\n");
		wr.write("(  /  )" + "\n");
		wr.write(" \\(__)|" + "\n");
		wr.flush();
		wr.close();
	}
}