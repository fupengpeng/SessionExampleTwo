package com.jiudianlianxian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * Title: ServletOne
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: SessionExampleTwo
 * @author fupengpeng
 * @date 2017年7月26日 上午11:41:22
 *
 */
@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//創建一個session
		HttpSession session = request.getSession();
		session.setAttribute("account", "account000");
		//默認生命週期30 min
		out.println("創建session成功");
		
		//把該session id保存在cookie中，在命名id時，一定要按照規範命名
		Cookie cookie =  new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		response.addCookie(cookie);
		System.out.println("把session的id保存在cookie中，以便於在此瀏覽器關閉后，在session生命週期內再次打開瀏覽器也能夠訪問到session中的數據 ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
