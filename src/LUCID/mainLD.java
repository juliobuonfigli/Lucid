package LUCID;

//import com.csvreader.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
//import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import com.opencsv.*;

public class mainLD {

private static String[] num;
private static boolean[] prog, recu, sies, sent;
private static String[] NUM, PROG, RECU, SIES, SENT;
private static CSVReader cr;	
private static String[] dat;
private static EscrituraDeDatos es;
private static boolean flag;

public static void main(String[] args) throws IOException 
	{
	// TODO Auto-generated method stub
	dat=new String[2];
	cr = new CSVReader(new FileReader("E:/Mis documentos/Lucidos/data.csv")); 
	dat=cr.readNext();
	cr.close();
	     
	MainDialog md=new MainDialog(dat[0]);
	
	md.setVisible(true);
    md.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	num=md.getNumeros();
	prog=md.getPrograma();
	recu=md.getRecurrentes();
	sies=md.getSiesta();
	sent=md.getSentimientos();
	NUM=md.getNUM();
	PROG=md.getPROG();
	RECU=md.getRECU();
	SIES=md.getSIES();
	SENT=md.getSENT(); 
	flag=md.getFlag();
	
	md.aplicar.addActionListener(new ActionListener() 
		{
	    @Override
	    public void actionPerformed(ActionEvent e) 
	    	{
	        try 
	        	{
	        	es=new EscrituraDeDatos(num, prog, recu, sies, sent, NUM, PROG, RECU, SIES, SENT, dat[0]);
				} catch (IOException e1) 
	        	{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
	        }
	    });
	}
}
 
