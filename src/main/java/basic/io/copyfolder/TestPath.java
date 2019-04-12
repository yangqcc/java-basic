package basic.io.copyfolder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPath {
	public static void main(String[] args) throws FileNotFoundException {
		Path path=Paths.get("a.txt");
		System.out.println(path.toAbsolutePath());
		new FileOutputStream(path.toFile());
	}
}
