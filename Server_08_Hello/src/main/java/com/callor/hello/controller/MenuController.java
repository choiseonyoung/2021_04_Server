package com.callor.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rootPath = req.getContextPath();
		String id = req.getParameter("id");
		resp.sendRedirect(rootPath + "/" + id);
		
		/*
		if문 필요없다 !
		if(id.equals("buyer")) {
			resp.sendRedirect(rootPath + "/buyer");
		} else if(id.equals("product")) {
			resp.sendRedirect(rootPath + "/product");
		} else if(id.equals("mypage")) {
			resp.sendRedirect(rootPath + "/mypage");
		} else {
			// 아무것도 없는 게 선택되면 처음으로 가라
//			resp.sendRedirect("/hello");
			
			resp.sendRedirect(rootPath);
			// 리스타트 하다보면 주소창 뒤 hello가 바껴서 404오류뜰 수도 있어서 ~
			
		}
		*/
	}
	
}
