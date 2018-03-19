package LUCID;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Arrays;
import com.opencsv.*;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class EscrituraDeDatos {
private CSVWriter progW, recuW, siesW, sentW, numW, dataW;


public EscrituraDeDatos(String[] num, boolean[] prog, boolean[] recu, boolean[] sies, boolean[] sent, 
		String[] NUM, String[] PROG, String[] RECU, String[] SIES, String[] SENT, String diaD) throws IOException
	{
	int dia = Integer.parseInt(diaD)+1;
	String[] DIA=new String[1];
	DIA[0]=String.valueOf(dia);
	try {
		progW=new CSVWriter(new FileWriter("E:/Mis documentos/Lucidos/prog.csv", true));
		recuW=new CSVWriter(new FileWriter("E:/Mis documentos/Lucidos/recu.csv", true));
		siesW=new CSVWriter(new FileWriter("E:/Mis documentos/Lucidos/sies.csv", true));
		numW=new CSVWriter(new FileWriter("E:/Mis documentos/Lucidos/num.csv", true));
		sentW=new CSVWriter(new FileWriter("E:/Mis documentos/Lucidos/sent.csv", true));
		dataW=new CSVWriter(new FileWriter("E:/Mis documentos/Lucidos/data.csv"));
		
		progW.writeNext(BtoS(prog));
        progW.close();
        recuW.writeNext(BtoS(recu));
        recuW.close();
        siesW.writeNext(BtoS(sies));
        siesW.close();
        sentW.writeNext(BtoS(sent));
        sentW.close();
        numW.writeNext(num);
        numW.close();
        dataW.writeNext(DIA);
        dataW.close();
        }
    catch(Exception ee) 
		{
    	System.out.println("...esto no camina");
		}
	}

public String[] BtoS(boolean[] a)
	{
	String[] r=new String[a.length];
	for(int i=0; i<a.length; i++)
		{
		if(a[i]==true)
			r[i]="true";
		else
			r[i]="false";
		}
	return r;
	}
	
public String[] ItoS(int[] a)
	{
	String[] r=new String[a.length];
	for(int i=0; i<a.length; i++)
		r[i]=String.valueOf(a[i]);
	return r;
	}
	
}
