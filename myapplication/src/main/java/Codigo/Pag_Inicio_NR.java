package Codigo;

import com.vaadin.navigator.View;

public class Pag_Inicio_NR extends Pag_Inicio_NR_ventana implements View{
	/*private Label _lista_Video_Mas_Megusta;
	private Label _lista_Ultimos_Videos;*/
	public Cabecera_NR _unnamed_Cabecera_NR_;
	public Buscador _unnamed_Buscador_;
	public Video2 _unnamed_Video2_;
	
	Cabecera_Comun cc = new Cabecera_Comun();
	Buscador bus = new Buscador();
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_R cr = new Cabecera_R();
	Pag_Inicio_R_ventana prv = new Pag_Inicio_R_ventana();
	
	public Pag_Inicio_NR() {
		inicializar();
	}
	void inicializar() {
		hCabeceraInicioBus.addComponent(cc.inicio);
		hCabeceraInicioBus.addComponent(bus.vBuscador);
		hCabeceraInicioBus.addComponent(cnr.iniciarSesionRegistrarse);
	}
	public void cargar_Videos_Inicio_NR() {
		throw new UnsupportedOperationException();
	}
}