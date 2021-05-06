package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;

// CRUD 구현 위해 기본적으로 갖춰야 하는 것
public interface BookService {
	
	public List<BookDTO> selectAll(); // 전체 가져오는 거라 리턴 타입 리스트
	
	public BookDTO findById(String bk_isbn);
	public List<BookDTO> findByTitle(String bk_title);
	public List<BookDTO> findByCName(String bk_cname);
	public List<BookDTO> findByAName(String bk_aname); // 저자로 찾기
	
	
	public int insert(BookVO bookVO);
	public int update(BookVO bookVO);
	public int delete(String bk_isbn);
}
