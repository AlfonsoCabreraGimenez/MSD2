package Codigo;

import java.util.List;

import diagramaclasesbd.BD_Principal;

public class Pag_Inicio_NR extends Pag_Inicio_NR_ventana{
	/*private Label _lista_Video_Mas_Megusta;
	private Label _lista_Ultimos_Videos;
	public Cabecera_NR _unnamed_Cabecera_NR_;
	public Buscador _unnamed_Buscador_;
	public Video2 _unnamed_Video2_;*/
	iUsuario_No_Registrado iNR = new BD_Principal();
	Cabecera_Comun_ventana cc = new Cabecera_Comun_ventana();
	Buscador_ventana bv = new Buscador_ventana();
	Cabecera_NR_ventana cabeceraNR = new Cabecera_NR_ventana();
	
	public Pag_Inicio_NR (){
		Inicializar();		
	}
	
	public void Inicializar(){
		hCabeceraInicioBus.addComponent(cc.horizontalInicio);
		hCabeceraInicioBus.addComponent(bv.vBuscador);
		hCabeceraInicioBus.addComponent(cabeceraNR.hIniciarSesionRegistrarse);	
	}
	public void cargar_Videos_Inicio_NR() {
		//List <Video2> mgusta = iNR.cargar_Videos_Masmegusta();
		//List <Video2> uvideos = iNR.cargar_Videos_Ultimos();
	}
}
