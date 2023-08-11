package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Usuario consultarPorUserName(String username) {
		TypedQuery<Usuario> myQuery = this.entityManager
				.createQuery("SELECT u FROM Usuario u WHERE u.nombre =:datoNombre", Usuario.class);
		myQuery.setParameter("datoNombre", username);
		return myQuery.getSingleResult();
	}

}
