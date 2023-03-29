package homework.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import homework.dao.*;
import homework.model.seek;


@WebServlet(name="seek",urlPatterns={"/seek"})
public class seekController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//中文
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();
		
		String name = req.getParameter("name");
		System.out.println(name);
		seekDao is = new seekDao(name);
		List<seek> temp = is.selectAll();
		session.setAttribute("s",temp);
		resp.sendRedirect("index.jsp");
	}
	
}
