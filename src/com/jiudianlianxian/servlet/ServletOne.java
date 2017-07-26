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
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: SessionExampleTwo
 * @author fupengpeng
 * @date 2017��7��26�� ����11:41:22
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
		//����һ��session
		HttpSession session = request.getSession();
		session.setAttribute("account", "account000");
		//Ĭ�J�����L��30 min
		out.println("����session�ɹ�");
		
		//��ԓsession id������cookie�У�������id�r��һ��Ҫ����Ҏ������
		Cookie cookie =  new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		response.addCookie(cookie);
		System.out.println("��session��id������cookie�У��Ա���ڴ˞g�[���P�]����session�����L�ڃ��ٴδ��_�g�[��Ҳ�܉��L����session�еĔ��� ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
