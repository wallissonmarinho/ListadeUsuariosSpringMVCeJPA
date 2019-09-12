package br.com.wallissonmarinho.mvc.dao;
import br.com.wallissonmarinho.mvc.domain.TipoSexo;
import br.com.wallissonmarinho.mvc.domain.Usuario;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	private static List<Usuario> us;  
	
	public UsuarioDaoImpl() {
		createUserList();
	}
    
	private List<Usuario> createUserList() {
	   if (us == null) {
	     us = new LinkedList<>();
	     us.add(new Usuario(System.currentTimeMillis()+1L, "Jane", "Doe", LocalDate.of(1992, 2, 11), TipoSexo.FEMININO));
	     us.add(new Usuario(System.currentTimeMillis()+2L, "John", "Doe", LocalDate.of(2000, 5, 15), TipoSexo.MASCULINO));
	     us.add(new Usuario(System.currentTimeMillis()+3L, "Jane", "Doe Doe", LocalDate.of(1990, 4, 20), TipoSexo.FEMININO));
	   }
	   return us;
	}

	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		us.add(usuario);
		
	}

	@Override
	public void editar(Usuario usuario) {
		us.stream() 
		.filter((u) -> u.getId() .equals(usuario.getId())) 
		.forEach((u) -> {
			u.setNome(usuario.getNome());
			u.setSobrenome(usuario.getSobrenome());
			u.setDtNascimento(usuario.getDtNascimento());
			u.setSexo(usuario.getSexo());
		});	
	}

	@Override
	public void excluir(Long id) {
		us.removeIf((u) -> u.getId().equals(id));
		
	}

	@Override
	public Usuario getId(Long id) {
		return us.stream() 
				.filter((u) -> u.getId().equals(id))
				.collect(Collectors.toList())
				.get(0);
	}

	@Override
	public List<Usuario> getTodos() {
		return us;
	}

}
