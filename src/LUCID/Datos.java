package LUCID;

import java.io.FileNotFoundException;

import com.csvreader.*;

//m�todo est�ticos
public class Datos {

	
private CsvReader csvProg;
//private file programa;  	

public Datos() throws FileNotFoundException {
//Object programa;
csvProg = new CsvReader("E:/programa"); 
}
}
