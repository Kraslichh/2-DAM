import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AntiguoPrograma {
	 public static void main(String[] args)  throws IOException {
	File ruta = new File(".\\bin");
	ProcessBuilder pb = new ProcessBuilder ("java", "capturarTexto.programa");
	pb.directory(ruta);
	//Process p = pb.start();
	Process p;
	p=pb.start();
	
	InputStream is = p.getInputStream();
	int c;
	while ((c=is.read()) != -1){
		System.out.println((char) c);
		
	}
	is.close();
}
}
