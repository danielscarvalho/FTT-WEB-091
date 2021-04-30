package ec.ftt.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ec.ftt.dao.UserDao;
import ec.ftt.model.User;

/**
 * Servlet implementation class UserApi
 * 
 * CRUD - 
 * 
 */

// TODO: PROJETO: CRIAR CRUD WEB + GRÁFICO PARA MAIS UMA TABELA COM MAIS CAMPOS PARA N1 2B
// TODO: PROJETO: PROJETO INDIVIDUAL OU NO MÁXIMO EM DUPLAS (EM DUPLAS 2 TABELAS)
// TODO: PROJETO: JavaScript Valina - CRUD em uma página - User "fetch"
// TODO: PROJETO: Gerar gráfico com "Chart.js" https://www.chartjs.org/
// TODO: PROJETO: Trabalhar bem mensagens de erro da WEB API com try catch


@WebServlet("/user")
public class UserApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("user-id");
		
	    if(userId != null) {
	    	long id = Long.valueOf(userId);
	    	
	    	UserDao userDao = new UserDao();
	    	
	        User user = userDao.getUserById(id);
	     	Gson gson = new Gson();
	    	response.getWriter().append(gson.toJson(user));
	    	
	    } else {
	    	
	    	UserDao userDao = new UserDao();
	    	
	    	List<User> users = userDao.getAllUser();
	        
	    	Gson gson = new Gson();

	    	response.getWriter().append(gson.toJson(users));
	    	/*
	    	 for (User u : users)
	    	 
	    		response.getWriter().append(u.toString());
	    	*/
	    } //if
		
		
	} //doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = new User(
				request.getParameter("user-id"),
				request.getParameter("user-name"),
				request.getParameter("user-email"),
				request.getParameter("user-color")
				);
		
		UserDao userDao = new UserDao();
		
		userDao.addUser(u);
		
		System.out.println(u);
		
		response.getWriter().append(u.toString());
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Ajustar errors com try catch
		
		User u = new User(
				request.getParameter("user-id"),
				request.getParameter("user-name"),
				request.getParameter("user-email"),
				request.getParameter("user-color")
				);
		
		UserDao userDao = new UserDao();
		
		userDao.updateUser(u);
		
		System.out.println(u);
		
		response.getWriter().append(u.toString());
		
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// https://www.tutorialspoint.com/servlets/servlets-http-status-codes.htm
		
		// TODO Verificar se está enviando o parametro
		// TODO Verificar se o parametro é null
		// TODO Se o ID já foi apagado
		// TODO Verificar se o ID não existe...
		// TODO Usar try cath para propagar erro appropriadamente...
		// TODO क्या आप इस कोड को अपने जीवन की महिला को दिखाने की हिम्मत करेंगे ???
		// TODO మీ జీవితంలోని స్త్రీకి ఈ కోడ్ చూపించడానికి మీకు ధైర్యం ఉందా ???
		
		if (request.getParameter("user-id") == null)
			 response.sendError(407, "Informe o ID do usuário a ser retornado!!!" );
		else {
		Long userId = Long.valueOf(request.getParameter("user-id"));
		
		
		
		UserDao ud = new UserDao();
		
		ud.deleteUser(userId);
		
		response.getWriter().append(request.getParameter("user-id") + " User removido");
		}
	}

}
