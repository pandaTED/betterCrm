package cn.panda.bettercrm.dao;

import java.util.List;

import cn.panda.bettercrm.domain.Customer;

/**
 * 增
 * save(Customer customer);
 * 删
 * delete(Long id);
 * 改
 * update(Customer customer);
 * 查
 * find(Long id);
 * findAll();
 *分页
 * @author panda
 *
 */


public interface CustomerDao {
	
//	  增
	  void save(Customer customer);
//	  删
	  void delete(Long id);
//	  改
	  void update(Customer customer);
//	  查
	  Customer find(Long id);
	  List<Customer> findAll();
	
}
