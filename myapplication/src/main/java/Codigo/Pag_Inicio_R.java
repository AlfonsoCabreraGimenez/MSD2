package Codigo;

public class Pag_Inicio_R extends Pag_Inicio_R_ventana {
	/*private Label _lista_Historial;
	private Label _lista_Videos_Relacionados;
	private Label _lista_Videos_Suscriptores;*/
	public Cabecera_R _unnamed_Cabecera_R_;
	public Video2 _unnamed_Video2_;
	
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	Buscador bus = new Buscador();
	
	
	public Pag_Inicio_R(){
		
		hCabeceraIncioBus.addComponent(cc.inicio);
		hCabeceraIncioBus.addComponent(bus.vBuscador);
		hCabeceraIncioBus.addComponent(cr.hCabeceraR);
	}
	public void cargar_Videos_Inicio_R() {
		throw new UnsupportedOperationException();
	}
}