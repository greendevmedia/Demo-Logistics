package in.greendev.logistics.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICrudService<T> {

	List<T> findAll();

	T getOne(Long id);

	void delete(T arg);

	void save(T arg);

	void deleteById(Long id);

	Page<T> listAllByPage(Pageable pageable);

}
