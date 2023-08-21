package dataFactory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {
    public static UsuarioPojo obterTokenComUsuarioAdministrador() {
        UsuarioPojo usuario = new UsuarioPojo();

        usuario.setUsuarioLogin("admin");
        usuario.setUsuarioSenha("admin");

        return usuario;
    }

    public static UsuarioPojo obterTokenComUsuarioESenha(String novoUsuario, String novaSenha) {
        UsuarioPojo usuario = new UsuarioPojo();

        usuario.setUsuarioLogin(novoUsuario);
        usuario.setUsuarioSenha(novaSenha);

        return usuario;
    }
}
