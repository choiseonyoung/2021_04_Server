package com.callor.diet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.MyFoodCDTO;
import com.callor.diet.service.MyFoodService;
import com.callor.diet.service.impl.MyFoodServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet {

	// 두번째 시리얼ID 선택
	private static final long serialVersionUID = -953531494441799347L;
	protected MyFoodService mfService;
	
	public HomeController() {
		mfService = new MyFoodServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		// 프로젝트를 처음에 RUN했을 때 이 위치에 있는 home.jsp 화면을 보여달라
		// index.jsp 따로 만들지 말고 컨트롤러에서
		
		String mf_date = req.getParameter("mf_date");
		List<MyFoodCDTO> mfList = null;
		if(mf_date == null || mf_date.equals("")) {
			mfList = mfService.selectAll();
			
		} else {
			mfList = mfService.findByDate(mf_date);
		}
		req.setAttribute("MFOODS", mfList);

		ReqController.forward(req, resp, "home");
	}

}
