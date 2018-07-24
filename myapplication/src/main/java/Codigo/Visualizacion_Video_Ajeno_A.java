package Codigo;

import java.util.Vector;

import com.vaadin.navigator.View;

import Codigo.Comentario_Video_Ajeno_A_Propio_AR;

public class Visualizacion_Video_Ajeno_A extends Visualizacion_Video_Ajeno_A_ventana implements View {
	//private Boton _borrarVideoAjenoB;
	public Video2 _unnamed_Video2_;
	public Vector<Comentario_Video_Ajeno_A_Propio_AR> _unnamed_Comentario_Video_Ajeno_A_Propio_AR_ = new Vector<Comentario_Video_Ajeno_A_Propio_AR>();
	
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	Comentario2 c2 = new Comentario2();
	
	public Visualizacion_Video_Ajeno_A(){
		inicializar();
	}
	
	void inicializar(){
		hInicio.addComponent(cc.inicio);
		hCabeceraGeneral.addComponent(cr.hCabeceraR);
		vComentario.addComponent(c2);
		modificarVideo.setVisible(false);
	}
	
	
}