package maven.demo;

public class Principal {
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.conectar();

		Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
		if(dao.inserirUsuario(usuario) == true)
			System.out.println("Inserção com sucesso -> " + usuario.toString());
			
		System.out.println("\n\n==== Mostrar usuários do sexo masculino === ");
		Usuario[] usuarios = dao.getUsuariosMasculinos();
		for (Usuario u : usuarios) {
			System.out.println(u.toString());
		}

		usuario.setSenha("novaSenha");
		dao.updateUsuario(usuario);
		
		System.out.println("\n\n==== Mostrar usuários === ");
		usuarios = dao.getUsuarios();
		for (Usuario u : usuarios) {
			System.out.println(u.toString());
		}

		dao.excluirUsuario(usuario.getCodigo());
		
		System.out.println("\n\n==== Mostrar usuários === ");
		usuarios = dao.getUsuarios();
		for (Usuario u : usuarios) {
			System.out.println(u.toString());
		}
		dao.close();
	}
}
