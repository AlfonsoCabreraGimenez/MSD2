package Codigo;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.UI;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

public class Usuario2 extends Usuario2_ventana {
	/*private Imagen _avatarI;
	private Boton _avatarB;
	private Boton _apodoB;
	private Label _numSuscriptoresL;*/
	public Perfil_Propio_A _unnamed_Perfil_Propio_A_;
	public Lista_Suscriptores _unnamed_Lista_Suscriptores_;
	public Lista_Suscripciones _unnamed_Lista_Suscripciones_;
	public Lista_Suscriptores_Propios _unnamed_Lista_Suscriptores_Propios_;
	public Lista_Suscripciones_Propias _unnamed_Lista_Suscripciones_Propias_;
	public Lista_Usuarios_Registrados _unnamed_Lista_Usuarios_Registrados_;
	public Buscador_Usuario _unnamed_Buscador_Usuario_;
	public Perfil_Ajeno_R _unnamed_Perfil_Ajeno_R_;
	public Perfil_Ajeno_A _unnamed_Perfil_Ajeno_A_;
	public Perfil_Ajeno _unnamed_Perfil_Ajeno_;
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	
	public Usuario2(int idUsuario) {
		hUsuario.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
				//IR A PERFIL AJENO
				if(admon == null && reg == null) {
					MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno", new Perfil_Ajeno(idUsuario));
					UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno");
				}
				if(admon == null && reg != null && reg.getID() != idUsuario) {
					MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_R", new Perfil_Ajeno_R(idUsuario));
					UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_R");
				}
				if(admon != null && reg == null && admon.getID() != idUsuario) {
					MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_A", new Perfil_Ajeno_A(idUsuario));
					UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_A");
				}
				//IR A PERFIL PROPIO REGISTRADO O ADMINISTRADOR
				if(admon == null && reg != null && reg.getID() == idUsuario) {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
				}
				if(admon != null && reg == null && admon.getID() == idUsuario) {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_R());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
				}
			}
		});
	}
}