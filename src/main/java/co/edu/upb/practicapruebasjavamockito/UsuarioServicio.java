package co.edu.upb.practicapruebasjavamockito;

public class UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(final UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public UsuarioDto crearUsuario(final String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El Nombre NO Puede Ser Nulo");
        }
        return usuarioRepositorio.crearUsuario(nombre);
    } // public UsuarioDto crearUsuario(final String nombre) 

    public UsuarioDto obtenerUsuario(final long id) {
        return usuarioRepositorio.obtenerUsuario(id);
    }

} // public class UsuarioServicio
