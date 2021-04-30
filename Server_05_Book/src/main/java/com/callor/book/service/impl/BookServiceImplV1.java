package com.callor.book.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;
import com.callor.book.service.BookService;
import com.callor.book.service.DBContract;

/*
 * DB와 연동한 Service
 * 
 * DB연결을 하고
 * 
 * SQL을 작성하고
 * SQL Packing하고
 * Packing 된 객체를 사용하여 SQL 실행
 * 
 * 조회할 경우는 수신된 데이터를 처리
 */
public class BookServiceImplV1 implements BookService {

	protected Connection dbConn;
	public BookServiceImplV1() {
		this.dbConn = DBContract.getDBConnection();
		// 이렇게 하면 DB 연결을 반복하지 않고 연결된 자원을 계속 재활용
	}
	
	@Override
	public void insert(BookVO bookVO) {
		// TODO 도서정보 추가
		
		String sql = "INSERT INTO tbl_books"; // +로 문자열 붙이면 빈칸 하나씩 만들어줘야됨
		sql += "(bk_isbn, bk_title, bk_ccode, bk_acode, bk_date, bk_price, bk_pages)";
		sql += "VALUES(?,?,?,?,?,?,?)";
		System.out.println(sql);
		
		// sql = "VALUES(" + bookVO.getBk_isbn() + "," + bookVO.getBk_title();
		// 이런 식으로 계속 연결해서 사용해야 되는 불편을 덜기 위해 특별한 방법으로 값을 세팅할 수 있게 만들어 둠
		
		
		
		// String type의 SQL 명령문을 Oracle에 전송하기 위해 Packet로 만들기
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bookVO.getBk_isbn());
			pStr.setString(2, bookVO.getBk_title());
			pStr.setString(3, bookVO.getBk_ccode());
			pStr.setString(4, bookVO.getBk_acode());
			pStr.setString(5, bookVO.getBk_date());
			pStr.setInt(6, bookVO.getBk_price());
			pStr.setInt(7, bookVO.getBk_pages());
			pStr.executeUpdate(); // 이걸 실행해주면 insert 명령 실행됨
			pStr.close();
			System.out.println("Insert OK!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 오류처리말고 일단 익셉션나는 그대로 두기 (왜인지는 못들음)
		}
	}

	@Override
	public List<BookDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDTO findById(String bk_isbn) {
		// TODO 도서검색
		
		String sql = " SELECT * FROM view_도서정보 ";
		sql += " WHERE ISBN = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bk_isbn.trim());
			ResultSet result = pStr.executeQuery();
			
			if(result.next()) {
				BookDTO bookDTO = new BookDTO();
				bookDTO.setBk_isbn(result.getString("ISBN"));
				bookDTO.setBk_title(result.getString("도서명"));
				bookDTO.setBk_cname(result.getString("출판사명"));
				bookDTO.setBk_cceo(result.getString("출판사대표"));
				
				bookDTO.setBk_author(result.getString("저자명"));
				bookDTO.setBk_au_tel(result.getString("저자연락처"));
				return bookDTO;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<BookDTO> findByTitle(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String bk_isbn) {
		// TODO Auto-generated method stub
		
	}

}
