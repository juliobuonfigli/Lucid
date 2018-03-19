package LUCID;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SecondDialog extends JFrame implements ActionListener {
	
	private JTextField cInicio, cFin;
	private JLabel inicio, fin;
	private JButton correlacion, totalesG, totalesS, evolucion, compuesta, todos;
	private boolean flag=false;
	private int INICIO, FIN;
	
	
public SecondDialog()
	{
	setLayout(null);
    setTitle("Estadísticas");
    setBounds(0, 0, 240, 390);
    inicio=new JLabel("Inicio: ");
    inicio.setBounds(10, 10, 40, 20);
    add(inicio);
    cInicio=new JTextField("0");
    cInicio.setBounds(45, 10, 30, 20);
    add(cInicio);
    fin=new JLabel("Fin: ");
    fin.setBounds(100, 10, 40, 20);
    add(fin);
    cFin=new JTextField("0");
    cFin.setBounds(125, 10, 30, 20);
    add(cFin);
    correlacion=new JButton("Correlaciones");
    correlacion.setBounds(10, 40, 200, 40);
    add(correlacion);
    correlacion.addActionListener(this);
    totalesG=new JButton("Totales escenas");
    totalesG.setBounds(10, 90, 200, 40);
    add(totalesG);
    totalesG.addActionListener(this);
    totalesS=new JButton("Totales sentimientos");
    totalesS.setBounds(10, 140, 200, 40);
    add(totalesS);
    totalesS.addActionListener(this);
    compuesta=new JButton("Correlación multivariada");
    compuesta.setBounds(10, 190, 200, 40);
    add(compuesta);
    compuesta.addActionListener(this);
    evolucion=new JButton("Evolución");
    evolucion.setBounds(10, 240, 200, 40);
    add(evolucion);
    evolucion.addActionListener(this);
    todos=new JButton("Todos");
    todos.setBounds(10, 290, 200, 40);
    add(todos);
    todos.addActionListener(this);
    }

@Override
public void actionPerformed(ActionEvent e) 
	{
	if (e.getSource()==correlacion) 
		{
		INICIO = Integer.parseInt(cInicio.getText());
		FIN = Integer.parseInt(cFin.getText());
		//metodo(INICIO, FIN);
		//resultado.show;
		}
	if (e.getSource()==totalesG) 
		{
		INICIO = Integer.parseInt(cInicio.getText());
		FIN = Integer.parseInt(cFin.getText());
		//metodo(INICIO, FIN);
		//resultado.show;
		}
	if (e.getSource()==totalesS) 
		{
		INICIO = Integer.parseInt(cInicio.getText());
		FIN = Integer.parseInt(cFin.getText());
		//metodo(INICIO, FIN);
		//resultado.show;
		}
	if (e.getSource()==compuesta) 
		{
		INICIO = Integer.parseInt(cInicio.getText());
		FIN = Integer.parseInt(cFin.getText());
		//metodo(INICIO, FIN);
		//resultado.show;
		}
	if (e.getSource()==evolucion) 
		{
		INICIO = Integer.parseInt(cInicio.getText());
		FIN = Integer.parseInt(cFin.getText());
		//metodo(INICIO, FIN);
		//resultado.show;
		}
	if (e.getSource()==todos) 
		{
		INICIO = Integer.parseInt(cInicio.getText());
		FIN = Integer.parseInt(cFin.getText());
		//metodo(INICIO, FIN);
		//resultado.show;
		}
	}
		
}