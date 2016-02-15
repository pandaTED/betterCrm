package cn.panda.dao;

import java.util.List;

import cn.panda.domain.Customer;
import cn.panda.domain.Tracking;

/**
 * 增 save(Tracking tracking); 
 * 删 delete(Long id);
 *  改 update(Tracking tracking); 
 *  查 find(Long id); findAll();
 * @author panda
 *
 */

public interface TrackingDao {

	// 删
	void delete(Long id);

	// 查
	Tracking find(Long id);

	List<Tracking> findAll();

	List<Tracking> findByCustomer(Customer customer);

	// 增
	void save(Tracking tracking);

	// 改
	void update(Tracking tracking);

}
