package Codigo;

import com.vaadin.navigator.View;

public class Visualizacion_Video_Ajeno extends Visualizacion_Video_Ajeno_A_ventana implements View{
	
	public Video2 _unnamed_Video2_;
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_Comun cc = new Cabecera_Comun();
	
	
	public Visualizacion_Video_Ajeno() {
		inicializar();
	}
	void inicializar() {
		hInicio.addComponent(cc.inicio);
		hCabeceraGeneral.addComponent(cnr.hIniciarSesionRegistrarse);
		propVideo.setVisible(false);
		escribirComentario.setVisible(false);
		comentar.setVisible(false);
		htituloComentario.setVisible(false);
		vComentario.setVisible(false);
		modificarVideo.setVisible(false);

		
		
	}
	public void cargarVisualizacionAjenoNR() {
		throw new UnsupportedOperationException();
	}
}