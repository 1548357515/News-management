package org.wjw.dao;


public interface BaseDao<T> {
	//增加
	public void add(T o);
	//更新
	public void update(T o);
	//删除
	public void delete(T o);
	//根据Id查信息
	public T getById(Integer id);
}
