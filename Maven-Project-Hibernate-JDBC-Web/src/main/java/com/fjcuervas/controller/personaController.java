package com.fjcuervas.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;

/**
 * Servlet implementation class personaController
 */
public class personaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private GestorPersistencia gp;
	
    public personaController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("mensaje");
		session.removeAttribute("persona");
		
		if(request.getParameterMap().isEmpty()) {
			try {
				session.setAttribute("mensaje", "Bienvenido");
				response.sendRedirect("persona.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		int idPersona = 0;
		try {
			idPersona = Integer.valueOf(request.getParameter("idPersona"));
		} catch (NumberFormatException e) {
			session.setAttribute("mensaje", "El parámetro ID no es un número");
			try {
				response.sendRedirect("persona.jsp");
				return;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		

		
		Persona personaRecuperada = gp.consultarPersonaPorId(idPersona);
		
		if(personaRecuperada == null) {
			session.setAttribute("mensaje", "No existe ninguna persona con ID " + idPersona);
			try {
				response.sendRedirect("persona.jsp");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		session.setAttribute("persona", personaRecuperada);
		
		try {
			response.sendRedirect("persona.jsp");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		gp.closeEntityManager();
	}

	@Override
	public void init() throws ServletException {
		gp = new GestorPersistencia();
		emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
		em = emf.createEntityManager();
	}

	
}
