package LUCID;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
//import java.io.BufferedWriter;
//import java.io.FileWriter;

/*La clase hereda de la clase JFrame y extienda sus responsabilidades agregando botones, etiquetas, editores de línea etc.
La mecánica para atrapar el clic del objeto de la clase JButton se hace mediante la implementación de la interface ActionListener
Cuando se presiona alguno de los tres botones se ejecuta el método actionPerformed y mediante los if verificamos cual de los botones se presionó
El constructor genera la ventana de diálogo y los métodos son acciones para cada botón de la ventana de diálogo y guardan valores cargados */

public class MainDialog extends JFrame implements ActionListener {

private boolean[] prog, sies, sent, rec; 
private JTextField cDia, cSue, cInd, cRec, cLucidos, cVividos, cSSue, cSInd, cSRec, cSLucidos, cSVividos;
private JLabel ePrograma, eProgramaSiesta, eGuion, eSentimientos, eDia, eInd, eRec, eLucidos, eVividos, eSue;
private JButton aplicar, cancelar, estadisticas;
private JCheckBox cbSonoro, cbOdoro, cbTactil, cbVisual, cbAI, cbVI, cbEst, cbPR, cbLS, cbES, cbMed, 
                  cbBici, cbDep, cbDL, cbDF, cbTrab, cbAu, cbLDI, cbCon, cbSiesta, cbAlc, cbALC, cbPor,
                  cbToco, cbDib;
private JCheckBox cbSsonoro, cbSodoro, cbStactil, cbSvisual, cbSau, cbSLDI, cbScon;
private JCheckBox hugo, monica, victor, carola, arnold, pepa, lina, leonor, batman, terminator, juegos, 
		droga, vacaciones, futbol, mujeres, dientes, perros, desnudez, barba, armas, aviones, primaria, 
		lucidez, cama;
private JCheckBox felicidad, optimismo, paz, relajacion, orgullo, realizacion, poder,
                  tristeza, pesimismo, ansiedad, nerviosismo, verguenza, frustracion, impotencia;
private int iteraciones, coordX, coordY;
private boolean flag=false;

 public MainDialog()
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
    cDia=new JTextField("0");
    cDia.setBounds(40,5,30,20);
    add(cDia);
    setBounds(0, 0, 1370, 730);
    //programa
    cbSonoro=new JCheckBox("Sonoro");
    cbSonoro.setBounds(10, 60, 200, 15);
    add(cbSonoro);
    cbOdoro=new JCheckBox("Odoro");
    cbOdoro.setBounds(10, 80, 200, 15);
    add(cbOdoro);
    cbTactil=new JCheckBox("Tactil");
    cbTactil.setBounds(10, 100, 200, 15);
    add(cbTactil);
    cbVisual=new JCheckBox("Visual");
    cbVisual.setBounds(10, 120, 200, 15);
    add(cbVisual);
    cbAI=new JCheckBox("Alarma intermedia"); //alarma intermedia
    cbAI.setBounds(10, 140, 200, 15);
    add(cbAI);
    cbVI=new JCheckBox("Vigilia intermedia");
    cbVI.setBounds(10, 160, 200, 15);
    add(cbVI);
    cbEst=new JCheckBox("Estimulantes");
    cbEst.setBounds(10, 180, 200, 15);
    add(cbEst);
    cbPR=new JCheckBox("Pruebas de realidad");
    cbPR.setBounds(10, 200, 200, 15);
    add(cbPR);
    cbLS=new JCheckBox("Lectura de sueños");
    cbLS.setBounds(10, 220, 200, 15);
    add(cbLS);
    cbES=new JCheckBox("Escritura de sueños");
    cbES.setBounds(10, 240, 200, 15);
    add(cbES);
    cbMed=new JCheckBox("Meditación");
    cbMed.setBounds(10, 260, 200, 15);
    add(cbMed);
    cbBici=new JCheckBox("Bicicleteada");
    cbBici.setBounds(10, 280, 200, 15);
    add(cbBici);
    cbDep=new JCheckBox("Deporte");
    cbDep.setBounds(10, 300, 200, 15);
    add(cbDep);
    cbDL=new JCheckBox("Día lindo");
    cbDL.setBounds(10, 320, 200, 15);
    add(cbDL);
    cbDF=new JCheckBox("Día feo");
    cbDF.setBounds(10, 340, 200, 15);
    add(cbDF);
    cbTrab=new JCheckBox("Trabajo");
    cbTrab.setBounds(10, 360, 200, 15);
    add(cbTrab);
    cbAu=new JCheckBox("Auriculares");
    cbAu.setBounds(10, 380, 200, 15);
    add(cbAu);
    cbLDI=new JCheckBox("Lucid dream inducer");
    cbLDI.setBounds(10, 400, 200, 15);
    add(cbLDI);
    cbSiesta=new JCheckBox("Siesta");
    cbSiesta.setBounds(10, 420, 200, 15);
    add(cbSiesta);
    cbCon=new JCheckBox("Concentración");
    cbCon.setBounds(10, 440, 200, 15);
    add(cbCon);
    cbAlc=new JCheckBox("Alcohol");
    cbAlc.setBounds(10, 460, 200, 15);
    add(cbAlc);
    cbALC=new JCheckBox("ALCOHOL");
    cbALC.setBounds(10, 480, 200, 15);
    add(cbALC);
    cbPor=new JCheckBox("Porro");
    cbPor.setBounds(10, 500, 200, 15);
    add(cbPor);
    cbToco=new JCheckBox("Música");
    cbToco.setBounds(10, 520, 200, 15);
    add(cbToco);
    cbDib=new JCheckBox("Dibujo");
    cbDib.setBounds(10, 540, 200, 15);
    add(cbDib);
        //conteo
    eSue=new JLabel("Sueños: ");
    eSue.setBounds(10, 590, 150, 15);
    add(eSue);
    cSue=new JTextField("0");
    cSue.setBounds(100,590,30,20);
    add(cSue);
    eVividos=new JLabel("Vividos: ");
    eVividos.setBounds(10, 610, 150, 15);
    add(eVividos);
    cVividos=new JTextField("0");
    cVividos.setBounds(100, 610, 30, 20);
    add(cVividos);
    eLucidos=new JLabel("Lucidos: ");
    eLucidos.setBounds(10, 630, 150, 15);
    add(eLucidos);
    cLucidos=new JTextField("0");
    cLucidos.setBounds(100, 630, 30, 20);
    add(cLucidos);
    eInd=new JLabel("Inducidos: ");
    eInd.setBounds(10, 650, 150, 15);
    add(eInd);
    cInd=new JTextField("0");
    cInd.setBounds(100, 650, 30, 20);
    add(cInd);
    eRec=new JLabel("Reconocidos: ");
    eRec.setBounds(10, 670, 150, 15);
    add(eRec);
    cRec=new JTextField("0");
    cRec.setBounds(100, 670, 30, 20);
    add(cRec);
    //Siesta
    eProgramaSiesta=new JLabel("SIESTA: ");
    eProgramaSiesta.setBounds(220, 40, 80, 10);
    add(eProgramaSiesta);
    cbSsonoro=new JCheckBox("Sonoro");
    cbSsonoro.setBounds(220, 60, 200, 15);
    add(cbSsonoro);
    cbSodoro=new JCheckBox("Odoro");
    cbSodoro.setBounds(220, 80, 200, 15);
    add(cbSodoro);
    cbStactil=new JCheckBox("Tactil");
    cbStactil.setBounds(220, 100, 200, 15);
    add(cbStactil);
    cbSvisual=new JCheckBox("Visual");
    cbSvisual.setBounds(220, 120, 200, 15);
    add(cbSvisual);
    cbSau=new JCheckBox("Auriculares");
    cbSau.setBounds(220, 140, 200, 15);
    add(cbSau);
    cbSLDI=new JCheckBox("Lucid dream inducer");
    cbSLDI.setBounds(220, 160, 200, 15);
    add(cbSLDI);
    cbScon=new JCheckBox("Concentración");
    cbScon.setBounds(220, 180, 200, 15);
    add(cbScon);
    //conteo
    eSue=new JLabel("Sueños: ");
    eSue.setBounds(200, 590, 150, 15);
    add(eSue);
    cSSue=new JTextField("0");
    cSSue.setBounds(290,590,30,20);
    add(cSSue);
    eVividos=new JLabel("Vividos: ");
    eVividos.setBounds(200, 610, 150, 15);
    add(eVividos);
    cSVividos=new JTextField("0");
    cSVividos.setBounds(290, 610, 30, 20);
    add(cSVividos);
    eLucidos=new JLabel("Lucidos: ");
    eLucidos.setBounds(200, 630, 150, 15);
    add(eLucidos);
    cSLucidos=new JTextField("0");
    cSLucidos.setBounds(290, 630, 30, 20);
    add(cSLucidos);
    eInd=new JLabel("Inducidos: ");
    eInd.setBounds(200, 650, 150, 15);
    add(eInd);
    cSInd=new JTextField("0");
    cSInd.setBounds(290, 650, 30, 20);
    add(cSInd);
    eRec=new JLabel("Reconocidos: ");
    eRec.setBounds(200, 670, 150, 15);
    add(eRec);
    cSRec=new JTextField("0");
    cSRec.setBounds(290, 670, 30, 20);
    add(cSRec);
    //guion
    eGuion=new JLabel("GUION: ");
    eGuion.setBounds(430, 40, 80, 10);
    add(eGuion);
    hugo=new JCheckBox("Hugo");
    hugo.setBounds(430, 60, 100, 15);
    add(hugo);
    monica=new JCheckBox("Monica");
    monica.setBounds(430, 80, 100, 15);
    add(monica);
    victor=new JCheckBox("Victor");
    victor.setBounds(430, 100, 100, 15);
    add(victor);
    carola=new JCheckBox("Carola");
    carola.setBounds(430, 120, 100, 15);
    add(carola);
    arnold=new JCheckBox("Arnold");
    arnold.setBounds(430, 140, 100, 15);
    add(arnold);
    lina=new JCheckBox("Lina");
    lina.setBounds(430, 160, 100, 15);
    add(lina);
    leonor=new JCheckBox("Leonor");
    leonor.setBounds(430, 180, 100, 15);
    add(leonor);
    batman=new JCheckBox("Batman");
    batman.setBounds(430, 200, 100, 15);
    add(batman);
    terminator=new JCheckBox("Terminator");
    terminator.setBounds(430, 220, 100, 15);
    add(terminator);
    juegos=new JCheckBox("Video Juegos");
    juegos.setBounds(430, 240, 150, 15);
    add(juegos);
    droga=new JCheckBox("Droga");
    droga.setBounds(430, 260, 100, 15);
    add(droga);
    vacaciones=new JCheckBox("Vacaciones");
    vacaciones.setBounds(430, 280, 100, 15);
    add(vacaciones);
    futbol=new JCheckBox("Futbol");
    futbol.setBounds(430, 300, 100, 15);
    add(futbol);
    mujeres=new JCheckBox("Mujeres");
    mujeres.setBounds(430, 320, 100, 15);
    add(mujeres);
    dientes=new JCheckBox("Dientes");
    dientes.setBounds(430, 340, 100, 15);
    add(dientes);
    perros=new JCheckBox("Perros");
    perros.setBounds(430, 360, 100, 15);
    add(perros);
    desnudez=new JCheckBox("Desnudez");
    desnudez.setBounds(430, 380, 100, 15);
    add(desnudez);
    barba=new JCheckBox("Barba");
    barba.setBounds(430, 400, 100, 15);
    add(barba);
    armas=new JCheckBox("Armas");
    armas.setBounds(430, 420, 100, 15);
    add(armas);
    aviones=new JCheckBox("Aviones");
    aviones.setBounds(430, 440, 100, 15);
    add(aviones);
    primaria=new JCheckBox("Prim/Sec");
    primaria.setBounds(430, 460, 100, 15);
    add(primaria);
    lucidez=new JCheckBox("Lucidez");
    lucidez.setBounds(430, 480, 100, 15);
    add(lucidez);
    cama=new JCheckBox("Otros en mi cama");
    cama.setBounds(430, 500, 150, 15);
    add(cama); 
    pepa=new JCheckBox("Pepa");
    pepa.setBounds(430, 520, 100, 15);
    add(pepa);
    //sentimientos
    eSentimientos=new JLabel("SENTIMIENTOS: ");
    eSentimientos.setBounds(600, 40, 150, 10);
    add(eSentimientos);
    felicidad=new JCheckBox("Felicidad");
    felicidad.setBounds(600, 60, 150, 15);
    add(felicidad);
    optimismo=new JCheckBox("Optimismo");
    optimismo.setBounds(600, 80, 150, 15);
    add(optimismo);
    paz=new JCheckBox("Paz");
    paz.setBounds(600, 100, 150, 15);
    add(paz);
    relajacion=new JCheckBox("Relajacion");
    relajacion.setBounds(600, 120, 150, 15);
    add(relajacion);
    orgullo=new JCheckBox("Orgullo");
    orgullo.setBounds(600, 140, 150, 15);
    add(orgullo);
    realizacion=new JCheckBox("Realizacion");
    realizacion.setBounds(600, 160, 150, 15);
    add(realizacion);
    poder=new JCheckBox("Poder");
    poder.setBounds(600, 180, 150, 15);
    add(poder);
    //opuestos
    tristeza=new JCheckBox("tristeza");
    tristeza.setBounds(750, 60, 150, 15);
    add(tristeza);
    pesimismo=new JCheckBox("Pesimismo");
    pesimismo.setBounds(750, 80, 150, 15);
    add(pesimismo);
    ansiedad=new JCheckBox("Ansiedad");
    ansiedad.setBounds(750, 100, 150, 15);
    add(ansiedad);
    nerviosismo=new JCheckBox("Nerviosismo");
    nerviosismo.setBounds(750, 120, 150, 15);
    add(nerviosismo);
    verguenza=new JCheckBox("Vergüenza");
    verguenza.setBounds(750, 140, 150, 15);
    add(verguenza);
    frustracion=new JCheckBox("Frustracion");
    frustracion.setBounds(750, 160, 150, 15);
    add(frustracion);
    impotencia=new JCheckBox("Impotencia");
    impotencia.setBounds(750, 180, 150, 15);
    add(impotencia);
    
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
    prog=new boolean[24];
 	}
    
 @Override
 public void actionPerformed(ActionEvent e) 
 	{
	if (e.getSource()==aplicar) 
		{
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
		    
        flag=true;
        System.exit(0);
        }
     if (e.getSource()==cancelar) 
            System.exit(0);
        
    }




    public int getIteraciones(){
        return iteraciones;}

    public int getX(){
        return coordX;}

    public int getY(){
        return coordY;}
        
     public boolean getFlag(){
        return flag;}

     }









