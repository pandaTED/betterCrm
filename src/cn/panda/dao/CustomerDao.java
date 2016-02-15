package cn.panda.dao;

import java.util.List;

import cn.panda.domain.Customer;
import cn.panda.domain.User;

/**
 * 增 save(Customer customer); 
 * 删 delete(Long id); 
 * 改 update(Customer customer); 
 * 查 find(Long id); findByUserId(Long id); findAll(); 
 *	//TODO 分页
 * 
 * @author panda
 *
 */

public interface CustomerDao {

	// 删
	void delete(Long id);

	// 查
	Customer find(Long id);

	List<Customer> findAll();

	List<Customer> findByUser(User user);

	// 增
	void save(Customer customer);

	// 改
	void update(Customer customer);

}
