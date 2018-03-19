package LUCID;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.opencsv.*;
import javax.swing.event.*;
//import java.io.BufferedWriter;
//import java.io.FileWriter;

/*La clase hereda de la clase JFrame y extienda sus responsabilidades agregando botones, etiquetas, editores de línea etc.
La mecánica para atrapar el clic del objeto de la clase JButton se hace mediante la implementación de la interface ActionListener
Cuando se presiona alguno de los tres botones se ejecuta el método actionPerformed y mediante los if verificamos cual de los botones se presionó
El constructor genera la ventana de diálogo y los métodos son acciones para cada botón de la ventana de diálogo y guardan valores cargados */

public class MainDialog extends JFrame implements ActionListener, ChangeListener{
//en estadisticas agregar mapas de cercanía ademas de los de correlacion. lucidos Vs sentimientos lindos
private String[] num;
private boolean[] prog, sies, sent, recu; 
//agregar sociales y pantallas y belen a los sueños
private JTextField cDia, cSue, cInd, cRec, cLucidos, cVividos, cSSue, cSInd, cSRec, cSLucidos, cSVividos, cPR, cPag;

private JLabel ePR, ePrograma, eProgramaSiesta, eGuion, eSentimientos, eDia, eInd, eRec, eLucidos, eVividos, eSue, ePag;

JButton aplicar;
private JButton cancelar;
private JButton estadisticas;
//Programa

private JCheckBox cbSonoro, cbOdoro, cbTactil, cbVisual, cbAI, cbVI, cbEst, cbPR, cbLS, cbES, cbMed, cbAF;
private JCheckBox cbBici, cbDep, cbDL, cbDF, cbTrab, cbAu, cbLDI, cbCon, cbSiesta, cbAlc, cbALC, cbPor, cbTV;
private JCheckBox cbToco, cbDib, cbJuegos, cbFutbol, cbProgramo, cbDB, cbYoga, cbFC, cbAyuno, cbMate, cbCafe, cbPaja;
//Siesta 
private JCheckBox cbSsonoro, cbSodoro, cbStactil, cbSvisual, cbSau, cbSLDI, cbScon;
//Guía
private JCheckBox hugo, monica, victor, carola, arnold, pepa, lina, leonor, batman, terminator, juegos;
private JCheckBox droga, vacaciones, futbol, sexo, dientes, perros, desnudez, barba, armas, aviones, primaria;
private JCheckBox lucidez, cama, ema, nico, mascotas, romance, rugby, bici;
//sentimientos
private JCheckBox felicidad, optimismo, paz, relajacion, orgullo, realizacion, poder, amor;
private JCheckBox tristeza, pesimismo, ansiedad, nerviosismo, verguenza, frustracion, impotencia, odio;

private String[] PROG={"Sonoro", "Odoro", "Tactil", "Visual", "Alarma intermedia", "Vigilia intermedia" , "Estimulantes",
		"Pruebas de realidad", "Lectura de sueños", "Escritura de sueños",  "Meditación", "Bicicleteada",
		"Deporte", "Día lindo", "Día feo", "Trabajo", "Binaurales", "Lucid dream inducer", "Siesta", 
		"Concentración", "Alcohol", "ALCOHOL", "Porro", "Música", "Dibujo", "Futbol", "Video Juegos", 
		"Programación", "Dormí bien", "Yoga", "Full consciousness", "Ayuno", "Mate", "Café", "Paja", "TV", "Alarma"};

private String[] SIES={"Sonoro", "Odoro", "Tactil", "Visual", "Binaurales", "Lucid dream inducer", 
		               "Concentración"};

private String[] NUM={"Sueños", "Vividos", "Lucidos", "Inducidos", "Reconocidos", "Pruebas", "Páginas"};

private String[] RECU={"Hugo", "Monica", "Victor", "Carola", "Arnold", "Lina", "Leonor", "Batman", "Terminator", 
		               "Video Juegos", "Droga", "Vacaciones", "Futbol", "Sexo", "Dientes", "Perros", "Desnudez",
		               "Barba", "Armas", "Aviones", "Prim/Sec", "Lucidez", "Otros en mi cama", "Pepa", "Ema", 
		               "Nico", "Mascotas", "Romance", "Rugby", "Bici"}; 

private String[] SENT={"Felicidad", "Optimismo", "Paz", "Relajación", "Orgullo", "Realización", "Poder", 
					   "Amor", "Tristeza", "Pesimismo", "Ansiedad", "Nerviosismo", "Vergüenza", "Frustración", 
					   "Impotencia", "Odio"};

private boolean flag=false;

 public MainDialog(String d) throws FileNotFoundException
 	{ 
	
	setLayout(null);
    setTitle("LucidoS");
     setBounds(0, 0, 1370, 730);
    ePrograma=new JLabel("PROGRAMA: ");
    ePrograma.setBounds(10, 40, 80, 10);
    add(ePrograma);
    eDia=new JLabel("DIA: ");
    eDia.setBounds(10, 10, 50, 10);
    add(eDia);
    cDia=new JTextField(d);
    cDia.setBounds(40,5,30,20);
    add(cDia);
    setBounds(0, 0, 1370, 730);
    //programa
      
    cbSonoro=new JCheckBox(PROG[0]);
    cbSonoro.setBounds(10, 60, 200, 15);
    cbSonoro.addChangeListener(this); add(cbSonoro);
    cbOdoro=new JCheckBox(PROG[1]);
    cbOdoro.setBounds(10, 80, 200, 15);
    cbOdoro.addChangeListener(this); add(cbOdoro);
    cbTactil=new JCheckBox(PROG[2]);
    cbTactil.setBounds(10, 100, 200, 15);
    cbTactil.addChangeListener(this); add(cbTactil);
    cbVisual=new JCheckBox(PROG[3]);
    cbVisual.setBounds(10, 120, 200, 15);
    cbVisual.addChangeListener(this); add(cbVisual);
    cbAI=new JCheckBox(PROG[4]); //alarma intermedia
    cbAI.setBounds(10, 140, 200, 15);
    cbAI.addChangeListener(this); add(cbAI);
    cbVI=new JCheckBox(PROG[5]);
    cbVI.setBounds(10, 160, 200, 15);
    cbVI.addChangeListener(this); add(cbVI);
    cbEst=new JCheckBox(PROG[6]);
    cbEst.setBounds(10, 180, 200, 15);
    cbEst.addChangeListener(this); add(cbEst);
    cbPR=new JCheckBox(PROG[7]);
    cbPR.setBounds(10, 200, 200, 15);
    cbPR.addChangeListener(this); add(cbPR);
    cbLS=new JCheckBox(PROG[8]);
    cbLS.setBounds(10, 220, 200, 15);
    cbLS.addChangeListener(this); add(cbLS);
    cbES=new JCheckBox(PROG[9]);
    cbES.setBounds(10, 240, 200, 15);
    cbES.addChangeListener(this); add(cbES);
    cbMed=new JCheckBox(PROG[10]);
    cbMed.setBounds(10, 260, 200, 15);
    cbMed.addChangeListener(this); add(cbMed);
    cbBici=new JCheckBox(PROG[11]);
    cbBici.setBounds(10, 280, 200, 15);
    cbBici.addChangeListener(this); add(cbBici);
    cbDep=new JCheckBox(PROG[12]);
    cbDep.setBounds(10, 300, 200, 15);
    cbDep.addChangeListener(this); add(cbDep);
    cbDL=new JCheckBox(PROG[13]);
    cbDL.setBounds(10, 320, 200, 15);
    cbDL.addChangeListener(this); add(cbDL);
    cbDF=new JCheckBox(PROG[14]);
    cbDF.setBounds(10, 340, 200, 15);
    cbDF.addChangeListener(this); add(cbDF);
    cbTrab=new JCheckBox(PROG[15]);
    cbTrab.setBounds(10, 360, 200, 15);
    cbTrab.addChangeListener(this); add(cbTrab);
    cbAu=new JCheckBox(PROG[16]);
    cbAu.setBounds(10, 380, 200, 15);
    cbAu.addChangeListener(this); add(cbAu);
    cbLDI=new JCheckBox(PROG[17]);
    cbLDI.setBounds(10, 400, 200, 15);
    cbLDI.addChangeListener(this); add(cbLDI);
    cbSiesta=new JCheckBox(PROG[18]);
    cbSiesta.setBounds(10, 420, 200, 15);
    cbSiesta.addChangeListener(this); add(cbSiesta);
    cbCon=new JCheckBox(PROG[19]);
    cbCon.setBounds(10, 440, 200, 15);
    cbCon.addChangeListener(this); add(cbCon);
    cbAlc=new JCheckBox(PROG[20]);
    cbAlc.setBounds(10, 460, 200, 15);
    cbAlc.addChangeListener(this); add(cbAlc);
    cbALC=new JCheckBox(PROG[21]);
    cbALC.setBounds(10, 480, 200, 15);
    cbALC.addChangeListener(this); add(cbALC);
    cbPor=new JCheckBox(PROG[22]);
    cbPor.setBounds(10, 500, 200, 15);
    cbPor.addChangeListener(this); add(cbPor);
    cbToco=new JCheckBox(PROG[23]);
    cbToco.setBounds(10, 520, 200, 15);
    cbToco.addChangeListener(this); add(cbToco);
    cbDib=new JCheckBox(PROG[24]);
    cbDib.setBounds(10, 540, 200, 15);
    cbDib.addChangeListener(this); add(cbDib);
     //programa columna 2    
    cbFutbol=new JCheckBox(PROG[25]);
    cbFutbol.setBounds(220, 60, 200, 15);
    cbFutbol.addChangeListener(this); add(cbFutbol);
    cbJuegos=new JCheckBox(PROG[26]);
    cbJuegos.setBounds(220, 80, 200, 15);
    cbJuegos.addChangeListener(this); add(cbJuegos);
    cbProgramo=new JCheckBox(PROG[27]);
    cbProgramo.setBounds(220, 100, 200, 15);
    cbProgramo.addChangeListener(this); add(cbProgramo);
    cbDB=new JCheckBox(PROG[28]);
    cbDB.setBounds(220, 120, 200, 15);
    cbDB.addChangeListener(this); add(cbDB);
    cbYoga=new JCheckBox(PROG[29]); //alarma intermedia
    cbYoga.setBounds(220, 140, 200, 15);
    cbYoga.addChangeListener(this); add(cbYoga);
    cbFC=new JCheckBox(PROG[30]);
    cbFC.setBounds(220, 160, 200, 15);
    cbFC.addChangeListener(this); add(cbFC);
    cbAyuno=new JCheckBox(PROG[31]);
    cbAyuno.setBounds(220, 180, 200, 15);
    cbAyuno.addChangeListener(this); add(cbAyuno);
    cbMate=new JCheckBox(PROG[32]);
    cbMate.setBounds(220, 200, 200, 15);
    cbMate.addChangeListener(this); add(cbMate);
    cbCafe=new JCheckBox(PROG[33]);
    cbCafe.setBounds(220, 220, 200, 15);
    cbCafe.addChangeListener(this); add(cbCafe);
    cbPaja=new JCheckBox(PROG[34]);
    cbPaja.setBounds(220, 240, 200, 15);
    cbPaja.addChangeListener(this); add(cbPaja);
    cbTV=new JCheckBox(PROG[35]);
    cbTV.setBounds(220, 260, 200, 15);
    cbTV.addChangeListener(this); add(cbTV);
    cbAF=new JCheckBox(PROG[36]);
    cbAF.setBounds(220, 280, 200, 15);
    cbAF.addChangeListener(this); add(cbAF);
    //conteo
    eSue=new JLabel(NUM[0]);
    eSue.setBounds(10, 590, 150, 15);
    add(eSue);
    cSue=new JTextField("0");
    cSue.setBounds(100,590,30,20);
    add(cSue);
    eVividos=new JLabel(NUM[1]);
    eVividos.setBounds(10, 610, 150, 15);
    add(eVividos);
    cVividos=new JTextField("0");
    cVividos.setBounds(100, 610, 30, 20);
    add(cVividos);
    eLucidos=new JLabel(NUM[2]);
    eLucidos.setBounds(10, 630, 150, 15);
    add(eLucidos);
    cLucidos=new JTextField("0");
    cLucidos.setBounds(100, 630, 30, 20);
    add(cLucidos);
    eInd=new JLabel(NUM[3]);
    eInd.setBounds(10, 650, 150, 15);
    add(eInd);
    cInd=new JTextField("0");
    cInd.setBounds(100, 650, 30, 20);
    add(cInd);
    eRec=new JLabel(NUM[4]);
    eRec.setBounds(10, 670, 150, 15);
    add(eRec);
    cRec=new JTextField("0");
    cRec.setBounds(100, 670, 30, 20);
    add(cRec);
    ePR=new JLabel(NUM[5]);
    ePR.setBounds(150, 670, 150, 15);
    add(ePR);
    cPR=new JTextField("0");
    cPR.setBounds(240, 670, 30, 20);
    add(cPR);
    ePag=new JLabel(NUM[6]);
    ePag.setBounds(150, 650, 150, 15);
    add(ePag);
    cPag=new JTextField("0");
    cPag.setBounds(240, 650, 30, 20);
    add(cPag);
    
    //Siesta
    eProgramaSiesta=new JLabel("SIESTA: ");
    eProgramaSiesta.setBounds(430, 40, 80, 10);
    add(eProgramaSiesta);
    cbSsonoro=new JCheckBox(SIES[0]);
    cbSsonoro.setBounds(430, 60, 200, 15);
    cbSsonoro.addChangeListener(this); add(cbSsonoro);
    cbSodoro=new JCheckBox(SIES[1]);
    cbSodoro.setBounds(430, 80, 200, 15);
    cbSodoro.addChangeListener(this); add(cbSodoro);
    cbStactil=new JCheckBox(SIES[2]);
    cbStactil.setBounds(430, 100, 200, 15);
    cbStactil.addChangeListener(this); add(cbStactil);
    cbSvisual=new JCheckBox(SIES[3]);
    cbSvisual.setBounds(430, 120, 200, 15);
    cbSvisual.addChangeListener(this); add(cbSvisual);
    cbSau=new JCheckBox(SIES[4]);
    cbSau.setBounds(430, 140, 200, 15);
    cbSau.addChangeListener(this); add(cbSau);
    cbSLDI=new JCheckBox(SIES[5]);
    cbSLDI.setBounds(430, 160, 200, 15);
    cbSLDI.addChangeListener(this); add(cbSLDI);
    cbScon=new JCheckBox(SIES[6]);
    cbScon.setBounds(430, 180, 200, 15);
    cbScon.addChangeListener(this); add(cbScon);
    //conteo
    eSue=new JLabel(NUM[0]);
    eSue.setBounds(420, 590, 150, 15);
    add(eSue);
    cSSue=new JTextField("0");
    cSSue.setBounds(500,590,30,20);
    add(cSSue);
    eVividos=new JLabel(NUM[1]);
    eVividos.setBounds(420, 610, 150, 15);
    add(eVividos);
    cSVividos=new JTextField("0");
    cSVividos.setBounds(500, 610, 30, 20);
    add(cSVividos);
    eLucidos=new JLabel(NUM[2]);
    eLucidos.setBounds(420, 630, 150, 15);
    add(eLucidos);
    cSLucidos=new JTextField("0");
    cSLucidos.setBounds(500, 630, 30, 20);
    add(cSLucidos);
    eInd=new JLabel(NUM[3]);
    eInd.setBounds(420, 650, 150, 15);
    add(eInd);
    cSInd=new JTextField("0");
    cSInd.setBounds(500, 650, 30, 20);
    add(cSInd);
    eRec=new JLabel(NUM[5]);
    eRec.setBounds(420, 670, 150, 15);
    add(eRec);
    cSRec=new JTextField("0");
    cSRec.setBounds(500, 670, 30, 20);
    add(cSRec); 
         
    //guion
    eGuion=new JLabel("GUION: ");
    eGuion.setBounds(640, 40, 80, 10);
    add(eGuion);
    hugo=new JCheckBox(RECU[0]);
    hugo.setBounds(640, 60, 100, 15);
    hugo.addChangeListener(this); add(hugo);
    monica=new JCheckBox(RECU[1]);
    monica.setBounds(640, 80, 100, 15);
    monica.addChangeListener(this); add(monica);
    victor=new JCheckBox(RECU[2]);
    victor.setBounds(640, 100, 100, 15);
    victor.addChangeListener(this); add(victor);
    carola=new JCheckBox(RECU[3]);
    carola.setBounds(640, 120, 100, 15);
    carola.addChangeListener(this); add(carola);
    arnold=new JCheckBox(RECU[4]);
    arnold.setBounds(640, 140, 100, 15);
    arnold.addChangeListener(this); add(arnold);
    lina=new JCheckBox(RECU[5]);
    lina.setBounds(640, 160, 100, 15);
    lina.addChangeListener(this); add(lina);
    leonor=new JCheckBox(RECU[6]);
    leonor.setBounds(640, 180, 100, 15);
    leonor.addChangeListener(this); add(leonor);
    batman=new JCheckBox(RECU[7]);
    batman.setBounds(640, 200, 100, 15);
    batman.addChangeListener(this); add(batman);
    terminator=new JCheckBox(RECU[8]);
    terminator.setBounds(640, 220, 100, 15);
    terminator.addChangeListener(this); add(terminator);
    juegos=new JCheckBox(RECU[9]);
    juegos.setBounds(640, 240, 150, 15);
    juegos.addChangeListener(this); add(juegos);
    droga=new JCheckBox(RECU[10]);
    droga.setBounds(640, 260, 100, 15);
    droga.addChangeListener(this); add(droga);
    vacaciones=new JCheckBox(RECU[11]);
    vacaciones.setBounds(640, 280, 100, 15);
    vacaciones.addChangeListener(this); add(vacaciones);
    futbol=new JCheckBox(RECU[12]);
    futbol.setBounds(640, 300, 100, 15);
    futbol.addChangeListener(this); add(futbol);
    sexo=new JCheckBox(RECU[13]);
    sexo.setBounds(640, 320, 100, 15);
    sexo.addChangeListener(this); add(sexo);
    dientes=new JCheckBox(RECU[14]);
    dientes.setBounds(640, 340, 100, 15);
    dientes.addChangeListener(this); add(dientes);
    perros=new JCheckBox(RECU[15]);
    perros.setBounds(640, 360, 100, 15);
    perros.addChangeListener(this); add(perros);
    desnudez=new JCheckBox(RECU[16]);
    desnudez.setBounds(640, 380, 100, 15);
    desnudez.addChangeListener(this); add(desnudez);
    barba=new JCheckBox(RECU[17]);
    barba.setBounds(640, 400, 100, 15);
    barba.addChangeListener(this); add(barba);
    armas=new JCheckBox(RECU[18]);
    armas.setBounds(640, 420, 100, 15);
    armas.addChangeListener(this); add(armas);
    aviones=new JCheckBox(RECU[19]);
    aviones.setBounds(640, 440, 100, 15);
    aviones.addChangeListener(this); add(aviones);
    primaria=new JCheckBox(RECU[20]);
    primaria.setBounds(640, 460, 100, 15);
    primaria.addChangeListener(this); add(primaria);
    lucidez=new JCheckBox(RECU[21]);
    lucidez.setBounds(640, 480, 100, 15);
    lucidez.addChangeListener(this); add(lucidez);
    cama=new JCheckBox(RECU[22]);
    cama.setBounds(640, 500, 150, 15);
    cama.addChangeListener(this); add(cama); 
    pepa=new JCheckBox(RECU[23]);
    pepa.setBounds(640, 520, 100, 15);
    pepa.addChangeListener(this); add(pepa);
    ema=new JCheckBox(RECU[24]);
    ema.setBounds(640, 540, 150, 15);
    ema.addChangeListener(this); add(ema); 
    nico=new JCheckBox(RECU[25]);
    nico.setBounds(640, 560, 100, 15);
    nico.addChangeListener(this); add(nico);
    mascotas=new JCheckBox(RECU[26]);
    mascotas.setBounds(640, 580, 100, 15);
    mascotas.addChangeListener(this); add(mascotas);
    romance=new JCheckBox(RECU[27]);
    romance.setBounds(640, 600, 150, 15);
    romance.addChangeListener(this); add(romance); 
    rugby=new JCheckBox(RECU[28]);
    rugby.setBounds(640, 620, 150, 15);
    rugby.addChangeListener(this); add(rugby); 
    bici=new JCheckBox(RECU[29]);
    bici.setBounds(640, 540, 150, 15);
    bici.addChangeListener(this); add(bici); 
    //sentimientos
    eSentimientos=new JLabel("SENTIMIENTOS: ");
    eSentimientos.setBounds(980, 40, 150, 10);
    add(eSentimientos);
    felicidad=new JCheckBox(SENT[0]);
    felicidad.setBounds(980, 60, 150, 15);
    felicidad.addChangeListener(this); add(felicidad);
    optimismo=new JCheckBox(SENT[1]);
    optimismo.setBounds(980, 80, 150, 15);
    optimismo.addChangeListener(this); add(optimismo);
    paz=new JCheckBox(SENT[2]);
    paz.setBounds(980, 100, 150, 15);
    paz.addChangeListener(this); add(paz);
    relajacion=new JCheckBox(SENT[3]);
    relajacion.setBounds(980, 120, 150, 15);
    relajacion.addChangeListener(this); add(relajacion);
    orgullo=new JCheckBox(SENT[4]);
    orgullo.setBounds(980, 140, 150, 15);
    orgullo.addChangeListener(this); add(orgullo);
    realizacion=new JCheckBox(SENT[5]);
    realizacion.setBounds(980, 160, 150, 15);
    realizacion.addChangeListener(this); add(realizacion);
    poder=new JCheckBox(SENT[6]);
    poder.setBounds(980, 180, 150, 15);
    poder.addChangeListener(this); add(poder);
    amor=new JCheckBox(SENT[7]);
    amor.setBounds(980, 200, 150, 15);
    amor.addChangeListener(this); add(amor);
    //opuestos
    tristeza=new JCheckBox(SENT[8]);
    tristeza.setBounds(1130, 60, 150, 15);
    tristeza.addChangeListener(this); add(tristeza);
    pesimismo=new JCheckBox(SENT[9]);
    pesimismo.setBounds(1130, 80, 150, 15);
    pesimismo.addChangeListener(this); add(pesimismo);
    ansiedad=new JCheckBox(SENT[10]);
    ansiedad.setBounds(1130, 100, 150, 15);
    ansiedad.addChangeListener(this); add(ansiedad);
    nerviosismo=new JCheckBox(SENT[11]);
    nerviosismo.setBounds(1130, 120, 150, 15);
    nerviosismo.addChangeListener(this); add(nerviosismo);
    verguenza=new JCheckBox(SENT[12]);
    verguenza.setBounds(1130, 140, 150, 15);
    verguenza.addChangeListener(this); add(verguenza);
    frustracion=new JCheckBox(SENT[13]);
    frustracion.setBounds(1130, 160, 150, 15);
    frustracion.addChangeListener(this); add(frustracion);
    impotencia=new JCheckBox(SENT[14]);
    impotencia.setBounds(1130, 180, 150, 15);
    impotencia.addChangeListener(this); add(impotencia);
    odio=new JCheckBox(SENT[15]);
    odio.setBounds(1130, 200, 150, 15);
    odio.addChangeListener(this); add(odio);
    //botones
    estadisticas=new JButton("Estadísticas");
    estadisticas.setBounds(1190,600, 120,25);
    add(estadisticas);
    estadisticas.addActionListener(this);
    aplicar=new JButton("Aplicar");
    aplicar.setBounds(1190,660, 85,25);
    add(aplicar);
    aplicar.addActionListener(this);
    cancelar=new JButton("Cancelar");
    cancelar.setBounds(1270,660,85,25);
    add(cancelar);
    cancelar.addActionListener(this);
   
    prog=new boolean[37];
    recu=new boolean[30];
    sies=new boolean[7];
    sent=new boolean[16];
 	num=new String[13];
 	//num=null;
 	}

 @Override
 public void stateChanged(ChangeEvent ce) {
		
	    prog[0]=cbSonoro.isSelected();
		prog[1]=cbOdoro.isSelected();
		prog[2]=cbTactil.isSelected();
		prog[3]=cbVisual.isSelected();
		prog[4]=cbAI.isSelected();
		prog[5]=cbVI.isSelected();
		prog[6]=cbEst.isSelected();
		prog[7]=cbPR.isSelected();
		prog[8]=cbLS.isSelected();
		prog[9]=cbES.isSelected();
		prog[10]=cbMed.isSelected();
		prog[11]=cbBici.isSelected();
		prog[12]=cbDep.isSelected();
		prog[13]=cbDL.isSelected();
		prog[14]=cbDF.isSelected();
		prog[15]=cbTrab.isSelected();
		prog[16]=cbAu.isSelected();
		prog[17]=cbLDI.isSelected();
		prog[18]=cbSiesta.isSelected();
		prog[19]=cbCon.isSelected();
		prog[20]=cbAlc.isSelected();
		prog[21]=cbALC.isSelected();
		prog[22]=cbPor.isSelected();
		prog[23]=cbToco.isSelected();
		prog[24]=cbDib.isSelected();
		prog[25]=cbJuegos.isSelected();
		prog[26]=cbFutbol.isSelected();
		prog[27]=cbProgramo.isSelected();
		prog[28]=cbDB.isSelected();
		prog[29]=cbYoga.isSelected();
		prog[30]=cbFC.isSelected();
		prog[31]=cbAyuno.isSelected();
		prog[32]=cbMate.isSelected();
		prog[33]=cbCafe.isSelected();
		prog[34]=cbPaja.isSelected();
		prog[35]=cbTV.isSelected();
		prog[36]=cbAF.isSelected();
		
		recu[0]=hugo.isSelected();
		recu[1]=monica.isSelected();
		recu[2]=victor.isSelected();
		recu[3]=carola.isSelected();
		recu[4]=arnold.isSelected();
		recu[5]=lina.isSelected();
		recu[6]=leonor.isSelected();
		recu[7]=batman.isSelected();
		recu[8]=terminator.isSelected();
		recu[9]=juegos.isSelected();
		recu[10]=droga.isSelected();
		recu[11]=vacaciones.isSelected();
		recu[12]=futbol.isSelected();
		recu[13]=sexo.isSelected();
		recu[14]=dientes.isSelected();
		recu[15]=perros.isSelected();
		recu[16]=desnudez.isSelected();
		recu[17]=barba.isSelected();
		recu[18]=armas.isSelected();
		recu[19]=aviones.isSelected();
		recu[20]=primaria.isSelected();
		recu[21]=lucidez.isSelected();
		recu[22]=cama.isSelected();
		recu[23]=pepa.isSelected();
		recu[24]=ema.isSelected();
		recu[25]=nico.isSelected();
		recu[26]=mascotas.isSelected();
		recu[27]=romance.isSelected();
		recu[28]=rugby.isSelected();
		recu[29]=bici.isSelected();
		
		sies[0]=cbSonoro.isSelected();
		sies[1]=cbOdoro.isSelected();
		sies[2]=cbStactil.isSelected();
		sies[3]=cbSvisual.isSelected();
		sies[4]=cbSau.isSelected();
		sies[5]=cbSLDI.isSelected();
		sies[6]=cbScon.isSelected();
		
		sent[0]=felicidad.isSelected();
		sent[1]=optimismo.isSelected();
		sent[2]=paz.isSelected();
		sent[3]=relajacion.isSelected();
		sent[4]=orgullo.isSelected();
		sent[5]=realizacion.isSelected();
		sent[6]=poder.isSelected();
		sent[7]=amor.isSelected();
		sent[8]=tristeza.isSelected();
		sent[9]=pesimismo.isSelected();
		sent[10]=ansiedad.isSelected();
		sent[11]=nerviosismo.isSelected();
		sent[12]=verguenza.isSelected();
		sent[13]=frustracion.isSelected();
		sent[14]=impotencia.isSelected();
		sent[15]=odio.isSelected();
		
		num[0]=cDia.getText();
		num[1]=cSue.getText();
		num[2]=cInd.getText();
		num[3]=cRec.getText();
		num[4]=cLucidos.getText();
		num[5]=cVividos.getText();
		num[6]=cSSue.getText();
		num[7]=cSInd.getText();
		num[8]=cSRec.getText();
		num[9]=cSLucidos.getText();
		num[10]=cSVividos.getText();
		num[11]=cPR.getText();
		num[12]=cPag.getText();
	
 		}
 
 @Override
 public void actionPerformed(ActionEvent e) 
 	{
		
	 if(e.getSource()==aplicar) 
		{
			
		flag=true;
        System.exit(0);
       	
		}
     if(e.getSource()==cancelar) 
            System.exit(0);
    
     if(e.getSource()==estadisticas) 
     	{
    	 SecondDialog sd=new SecondDialog();
	  	 sd.setVisible(true);
	     sd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     }
 	}

 
public String[] getNumeros(){return num;}
public boolean[] getPrograma(){return prog;}
public boolean[] getRecurrentes(){return recu;}
public boolean[] getSiesta(){return sies;}
public boolean[] getSentimientos(){return sent;}
public String[] getNUM(){return NUM;}
public String[] getPROG(){return PROG;}
public String[] getRECU(){return RECU;}
public String[] getSIES(){return SIES;}
public String[] getSENT(){return SENT;}
public boolean getFlag(){return flag;}

}









