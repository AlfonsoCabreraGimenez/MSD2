package Codigo;

public class Pag_Inicio_NR extends Pag_Inicio_NR_ventana{
	/*private Label _lista_Video_Mas_Megusta;
	private Label _lista_Ultimos_Videos;
	public Cabecera_NR _unnamed_Cabecera_NR_;
	public Buscador _unnamed_Buscador_;
	public Video2 _unnamed_Video2_;*/
	Cabecera_Comun_ventana cc = new Cabecera_Comun_ventana();
	Buscador_ventana bv = new Buscador_ventana();
	Cabecera_NR_ventana cabeceraNR = new Cabecera_NR_ventana();
	
	public Pag_Inicio_NR (){
		Inicializar();
		
	}
	
	public void Inicializar(){
		hCabeceraInicioBus.addComponent(cc.horizontalInicio);
		hCabeceraInicioBus.addComponent(bv.vBuscador);
		hCabeceraGeneral.addComponent(cabeceraNR.hIniciarSesionRegistrarse);
		
	}
}
