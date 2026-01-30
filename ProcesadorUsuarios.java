import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de procesar una lista de usuarios y clasificarlos
 * según su rol (administrador o invitado).
 * 
 * Recibe una lista de usuarios en formato "nombre:rol" y devuelve
 * una cadena con los usuarios separados por tipo.
 * 
 * Esta clase ha sido refactorizada para mejorar su legibilidad
 * y mantenibilidad.
 */

// Comentario añadido para probar Github Actions


public class ProcesadorUsuarios {


    private static final int ROL_INVITADO = 2;
    private static final int ROL_ADMIN = 1;

/**
 * Procesa una lista de usuarios y los clasifica en administradores
 * e invitados según su rol.
 * 
 * @param usuarios lista de usuarios en formato "nombre:rol"
 * @return una cadena con los usuarios clasificados por rol
 */
        public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String u : usuarios) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (rol == ROL_ADMIN) {
                    admins = procesarAdmin(admins, nombre);
                }
                // Número Mágico: 2 es Invitado
                else if (rol == ROL_INVITADO) {
                    invitados = procesarInvitado(invitados, nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    private String procesarAdmin(String admins, String nombre) {
        return admins + nombre + ",";
    }

    private String procesarInvitado(String invitados, String nombre) {
        return invitados + nombre + ",";
    }
}