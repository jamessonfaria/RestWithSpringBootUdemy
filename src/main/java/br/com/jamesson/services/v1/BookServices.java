package br.com.jamesson.services.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jamesson.converter.DozerConverter;
import br.com.jamesson.data.model.Book;
import br.com.jamesson.data.vo.BookVO;
import br.com.jamesson.exception.ResourceNotFoundException;
import br.com.jamesson.repository.BookRepository;

@Service
public class BookServices {
	
	@Autowired
	private BookRepository repository;

	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}

	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey())
		.orElseThrow(() -> 
			new ResourceNotFoundException("No records found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());	
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		
		return vo;
	}

	public void delete(Long id) {
		Book entity = repository.findById(id)
		.orElseThrow(() -> 
			new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);		
	}

	public BookVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> 
					new ResourceNotFoundException("No records found for this ID"));
		
		return DozerConverter.parseObject(entity, BookVO.class);
	}

	public List<BookVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
	}

}
