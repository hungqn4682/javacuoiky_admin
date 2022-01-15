package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.DanhMuc;
import com.database.DanhMucDao;


@WebServlet("/themDM")
public class ThemDM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ThemDM() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		String name =request.getParameter("catalog-name");
		DanhMuc catalog = new DanhMuc();
		catalog.setTenDM(name);
		if(DanhMucDao.addCatalog(catalog)) {
			RequestDispatcher rd =request.getRequestDispatcher("Trangchu.jsp");
			rd.forward(request, response);
		}
		
	}

}
