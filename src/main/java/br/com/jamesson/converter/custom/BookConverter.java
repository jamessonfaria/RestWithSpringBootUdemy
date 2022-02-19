package br.com.jamesson.converter.custom;

import org.springframework.stereotype.Service;

import br.com.jamesson.data.model.Book;
import br.com.jamesson.data.vo.BookVO;

@Service
public class BookConverter {

	public BookVO convertEntityToVO(Book book) {
		var vo = new BookVO();
		vo.setKey(book.getId());
		vo.setAuthor(book.getAuthor());
		vo.setLaunchDate(book.getLaunchDate());
		vo.setPrice(book.getPrice());
		vo.setTitle(book.getTitle());
		return vo;
	}
	
	public Book convertVOToEntity(BookVO bookVO) {
		var entity = new Book();
		entity.setId(bookVO.getKey());
		entity.setAuthor(bookVO.getAuthor());
		entity.setLaunchDate(bookVO.getLaunchDate());
		entity.setPrice(bookVO.getPrice());
		entity.setTitle(bookVO.getTitle());;
		return entity;
	}

	
}
