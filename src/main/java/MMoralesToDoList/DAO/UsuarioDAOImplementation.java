package MMoralesToDoList.DAO;

import java.util.List;

import javax.sql.DataSource;

import MMoralesToDoList.JPA.Result;
import MMoralesToDoList.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImplementation implements UsuarioDAO {

	private JdbcTemplate jdbcTemplate;
	private EntityManager entityManager;

	@Autowired
	public UsuarioDAOImplementation(DataSource dataSource, EntityManager entityManager) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.entityManager = entityManager;
	}

	@Override
	public Result findByUserName(Usuario usuarioBusqueda) {
		Result result = new Result();
		try {
			TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE UserName =:userName",
					Usuario.class);
			query.setParameter("userName", usuarioBusqueda.getUserName());
			Usuario usuario = query.getSingleResult();
			if (usuario.getUserName().equals(usuarioBusqueda.getUserName())
					& usuario.getPassword().equals(usuarioBusqueda.getPassword())) {
				result.Correct = true;
				result.Object = usuario;
			}
		} catch (Exception ex) {
			result.Correct = false;
			result.ErrorMessage = ex.getLocalizedMessage();
			result.Ex = ex;
		}
		return result;
	}

	@Override
	@Transactional
	public Result AddUsuario(Usuario usuario) {
		Result result = new Result();
		try {
			Usuario addUsuario = new Usuario();
			addUsuario.setUserName(usuario.getUserName());
			addUsuario.setApellido(usuario.getApellido());
			addUsuario.setFechaVencimiento(usuario.getFechaVencimiento());
			addUsuario.setNombre(usuario.getNombre());
			addUsuario.setPassword(usuario.getPassword());
			entityManager.persist(addUsuario);
			result.Correct = true;
		} catch (Exception ex) {
			result.Correct = true;
			result.ErrorMessage = ex.getLocalizedMessage();
			result.Ex = ex;
		}
		return result;
	}

	@Override
	public Result findAll() {
		Result result = new Result();
		try {
			TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario", Usuario.class);
			List<Usuario> usuario = query.getResultList();
			result.Object = usuario;
			result.Correct = true;
		} catch (Exception ex) {
			result.Correct = false;
			result.ErrorMessage = ex.getLocalizedMessage();
			result.Ex = ex;
		}
		return result;
	}

	@Override
	@Transactional
	public Result Delete(int IdUsuario) {
		Result result = new Result();
		try {
			Usuario usuario = entityManager.find(Usuario.class, IdUsuario);
			entityManager.remove(usuario);
			result.Correct = true;
		} catch (Exception ex) {
			result.Correct = false;
			result.ErrorMessage = ex.getLocalizedMessage();
			result.Ex = ex;
		}
		return result;
	}

	@Override
	@Transactional
	public Result Update(Usuario usuario) {
		Result result = new Result();
		try {
			Usuario updateUsuario = new Usuario();
			updateUsuario.setNombre(usuario.getNombre());
			updateUsuario.setUserName(usuario.getUserName());
			updateUsuario.setApellido(usuario.getApellido());
			updateUsuario.setPassword(usuario.getPassword());
			updateUsuario.setFechaVencimiento(usuario.getFechaVencimiento());
			entityManager.merge(updateUsuario);
			result.Correct=true;
		} catch (Exception ex) {
			result.Correct=false;
			result.ErrorMessage=ex.getLocalizedMessage();
			result.Ex=ex;
		}
		return result;
	}
}
