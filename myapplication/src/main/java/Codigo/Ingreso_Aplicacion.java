package Codigo;

public class Ingreso_Aplicacion extends Ingreso_Aplicacion_ventana {
	/*public Registrarse _unnamed_Registrarse_;
	public Iniciar_Sesion _unnamed_Iniciar_Sesion_;
	public Cabecera_NR _unnamed_Cabecera_NR_;*/
	Cabecera_Comun_ventana cc = new Cabecera_Comun_ventana();
	Registrarse_ventana reg = new Registrarse_ventana();
	Iniciar_Sesion_ventana ini = new Iniciar_Sesion_ventana();
	public Ingreso_Aplicacion() {
		Inicializar();
	}
	void Inicializar() {
		hInicio.addComponent(cc.inicio);
		hingreso.addComponent(reg.vRegistrarse);
		hingreso.addComponent(ini.vIniciar);
	}
}