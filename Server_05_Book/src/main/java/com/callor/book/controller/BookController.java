package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;
import com.callor.book.service.BookService;
import com.callor.book.service.impl.BookServiceImplV1;

// localhost:8080/book/book/~~~ 로 요청을 하면
@WebServlet("/book/*")
public class BookController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BookService bService;
	
	public BookController() {
		bService = new BookServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ~~~~ 로 되어있는 문자열을 추출하기
		// localhost:8080/book/book/input 로 요청을 하면
		// input 문자열이 추출된다
		String subPath = req.getPathInfo();
		
		// 요청에 응답하기 위한 준비
		// 한글 인코딩 세팅
		resp.setContentType("text/html;charset=UTF-8"); // 응답하는 코드에 한글이 깨지지 않도록 세팅
		// 데이터를 보낼 출력 장치 설정
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/input")) {
			// 첨부된 선물 꾸러미 열어서 내용물 확인
			String bk_isbn = req.getParameter("bk_isbn");
			String bk_title = req.getParameter("bk_title");
			String bk_price = req.getParameter("bk_price");
			
			BookVO bookVO = new BookVO();
			bookVO.setBk_isbn(bk_isbn);
			bookVO.setBk_title(bk_title);
			bookVO.setBk_price( Integer.valueOf(bk_price) );
			// 가상 데이터 넣음 //
			bookVO.setBk_ccode("C0001");
			bookVO.setBk_acode("A0001");
			bookVO.setBk_date("2019-10-01");
			
			bService.insert(bookVO);
			
			out.println("받은 데이터 확인");
			out.printf(" ISBN : %s", bk_isbn);
			out.printf(" 도서명 : %s", bk_title);
			out.printf(" 가격 : %s", bk_price);
			out.close();
		} else if(subPath.equals("/select")) {
			List<BookDTO> booklist = bService.selectAll();
		} else if(subPath.equals("/isbn")) {
			String bk_isbn = req.getParameter("bk_isbn");
			BookDTO bookDTO = bService.findById(bk_isbn);
			
			ServletContext app = this.getServletContext();
			app.setAttribute("BOOK", bookDTO); // book.jsp에서 이 BOOK을 꺼내서 ~
			
			RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/book.jsp");
			
			disp.forward(req,  resp);
		} else {
			out.println("반갑습니다");
			out.close();
		}
	}
	
}
