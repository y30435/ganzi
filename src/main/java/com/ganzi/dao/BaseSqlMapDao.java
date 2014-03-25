package com.ganzi.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

/**
 * 공통 DAO(Data Access Objects)
 * @author chajaesung
 */
@Repository
public class BaseSqlMapDao {
    @Resource(name = "SqlMapClientTemplate")
    private SqlMapClientTemplate SqlMapClientTemplate;
    
    /**
     * execute insert.
     * @param queryId
     * @param parameterObject
     * @return Object
     */
    protected boolean insert(String queryId, Object parameterObject) {
    	return SqlMapClientTemplate.update(queryId, parameterObject) > 0 ? true : false ;
    }

    /**
     * execute update.
     * @param queryId
     * @param parameterObject
     * @return int
     */
    protected boolean update(String queryId, Object parameterObject) {
    	return SqlMapClientTemplate.update(queryId, parameterObject) > 0 ? true : false ;
    }

    /**
     * execute delete.
     * @param queryId
     * @param parameterObject
     * @return int
     */
    protected boolean delete(String queryId, Object parameterObject) {
    	return SqlMapClientTemplate.delete(queryId, parameterObject) > 0 ? true : false ;
    }

    /**
     * execute queryForList.
     * @param queryId
     * @param parameterObject
     * @return List<?>
     */
    protected List<?> list(String queryId, Object parameterObject) {
    	return SqlMapClientTemplate.queryForList(queryId, parameterObject);
    }
    
    /**
     * execute queryForList.
     * @param queryId
     * @param parameterObject
     * @return List<?>
     */
    protected List<?> list(String queryId) {
    	return SqlMapClientTemplate.queryForList(queryId);
    }

    /**
     * execute queryForObject
     * @param queryId
     * @return Object
     */
    protected Object valueObject(String queryId, Object parameterObject) {
    	return SqlMapClientTemplate.queryForObject(queryId, parameterObject);
    }
    
    /**
     * execute queryForObject
     * @param queryId
     * @return Object
     */
    protected Object valueObject(String queryId) {
    	return SqlMapClientTemplate.queryForObject(queryId);
    }
}
