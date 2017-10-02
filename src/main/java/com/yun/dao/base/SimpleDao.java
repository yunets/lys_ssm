package com.yun.dao.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.yun.common.entity.PageEasyUI;
import com.yun.common.exception.DaoException;
import com.yun.common.exception.DataProcessException;
import com.yun.common.utils.BeanUtils;
import com.yun.common.utils.UUIDUtils;


/**
 * 基础Dao接口实现类，实现改类的子类必须设置泛型类型<br>
 * 
 * @Company 天人环境<br>
 * 
 * @author WangXu<br>
 * @version Revision: 1.0
 */
@Repository
public class SimpleDao<T> {

	@Autowired(required = true)
	public SqlSessionTemplate sqlSessionTemplate;

	public static final String SQLNAME_SEPARATOR = ".";

	/**
	 * @fields sqlNamespace SqlMapping命名空间
	 */
	private String sqlNamespace = getDefaultSqlNamespace();

	/**
	 * 获取泛型类型的实体对象类全名
	 * 
	 * @author WangXu<br>
	 * @return
	 */
	protected String getDefaultSqlNamespace() {
		Class<?> genericClass = BeanUtils.getGenericClass(this.getClass());
		return genericClass == null ? null : genericClass.getName();
	}

	/**
	 * 获取SqlMapping命名空间
	 * 
	 * @author WangXu
	 * @return SqlMapping命名空间
	 */
	public String getSqlNamespace() {
		return sqlNamespace;
	}

	/**
	 * 设置SqlMapping命名空间。 以改变默认的SqlMapping命名空间， 不能滥用此方法随意改变SqlMapping命名空间。
	 * 
	 * @author WangXu
	 * @param sqlNamespace
	 *            SqlMapping命名空间
	 */
	public void setSqlNamespace(String sqlNamespace) {
		this.sqlNamespace = sqlNamespace;
	}

	/**
	 * 将SqlMapping命名空间与给定的SqlMapping名组合在一起。
	 * 
	 * @param sqlName
	 *            SqlMapping名
	 * @return 组合了SqlMapping命名空间后的完整SqlMapping名
	 */
	protected String getSqlName(String sqlName) {
		return sqlNamespace + "Mapper" + SQLNAME_SEPARATOR + sqlName;
	}

	/**
	 * 生成主键值。<br>
	 * 默认使用{@link UUIDUtils#create()}方法 <br>
	 * 如果需要生成主键，需要由子类重写此方法根据需要的方式生成主键值。
	 * 
	 * @param entity
	 *            要持久化的对象
	 */
	protected String generateId() {
		return UUIDUtils.create();
	}

	/**
	 * @param sqlSessionTemplate
	 *            the sqlSessionTemplate to set
	 */
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int insert(Object parameterObject) throws DataProcessException {
		Assert.notNull(parameterObject);
		try {
			
			return sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT), parameterObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
	}

	public int insertBatch(Object parameterObject) throws DataProcessException {
		Assert.notNull(parameterObject);
		try {
			return sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT_BATCH), parameterObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT_BATCH)), e);
		}
	}

	public int delete(String sqlName, Object parameterObject) throws DataProcessException {
		Assert.notNull(parameterObject);
		try {
			return sqlSessionTemplate.delete(getSqlName(sqlName), parameterObject);
		} catch (Exception e) {
			throw new DaoException(String.format("删除对象出错！语句：%s", getSqlName(sqlName)), e);
		}
	}

	public int deleteById(Object id) {
		Assert.notNull(id);
		try {
			return sqlSessionTemplate.delete(getSqlName(SqlId.SQL_DELETE_BY_ID), id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！语句：%s", getSqlName(SqlId.SQL_DELETE_BY_ID)), e);
		}
	}
	
	
	

	public int update(Object parameterObject) throws DataProcessException {
		Assert.notNull(parameterObject);
		try {
			return sqlSessionTemplate.update(getSqlName(SqlId.SQL_UPDATE), parameterObject);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象出错！语句：%s", getSqlName(SqlId.SQL_UPDATE)), e);
		}
	}

	/**
	 * 删除所选用户(逻辑删除)
	 * @param sqlName
	 * @param parameterObject
	 * @return
	 * @throws DataProcessException
	 */
	public int updateValidateFlg(Object parameterObject) throws DataProcessException {
		Assert.notNull(parameterObject);
		try {
			return sqlSessionTemplate.update(getSqlName("updateValidateFlg"), parameterObject);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！语句：%s", getSqlName("updateValidateFlg")), e);
		}
	}
	
	
	public Object select(String sqlName, Object parameterObject) throws DataProcessException {
		Assert.notNull(parameterObject);
		try {
			return sqlSessionTemplate.selectOne(getSqlName(sqlName), parameterObject);
		} catch (Exception e) {
			throw new DaoException(String.format("查询一条记录出错！语句：%s", getSqlName(sqlName)), e);
		}
	}

	/**
	 * @Title selectByMap<br>
	 * @Description TODO(这里用一句话描述这个方法的作用)<br>
	 * @param params
	 * @return
	 * @throws DataProcessException
	 * <br>
	 * @return 返回类型<br>
	 * @throws<br>
	 * 
	 * @author WangXu<br>
	 */
	public List<?> selectByMap(Map<String, Object> params) throws DataProcessException {
		Assert.notNull(params);
		try {
			return sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_MAP), params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_MAP)), e);
		}
	}

	public Object selectByPrimaryKey(Object id) throws DataProcessException {
		Assert.notNull(id);
		try {
			return sqlSessionTemplate.selectOne(getSqlName(SqlId.SQL_SELECT_BY_PRIMARY_ID), id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_PRIMARY_ID)), e);
		}
	}

	public List<?> selectObjForList(String sqlName, Object parameterObject) throws DataProcessException {
		try {
			return sqlSessionTemplate.selectList(getSqlName(sqlName), parameterObject);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s", getSqlName(sqlName)), e);
		}
	}

	public Map<?, ?> selectForMap(String sqlName, String mapKey) throws DataAccessException {
		Assert.notNull(mapKey, "[mapKey] - must not be null!");
		try {
			return sqlSessionTemplate.selectMap(getSqlName(sqlName), mapKey);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象Map时出错！语句：%s", getSqlName(sqlName)), e);
		}
	}

	public Map<?, ?> selectForMap(String sqlName, Object parameterObject, String mapKey) throws DataAccessException {
		Assert.notNull(mapKey, "[mapKey] - must not be null!");
		try {
			return sqlSessionTemplate.selectMap(getSqlName(sqlName), parameterObject, mapKey);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象Map时出错！语句：%s", getSqlName(sqlName)), e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Map<?, ?>> selectForMapList(String sqlName, Object parameterObject, String mapKey) throws DataAccessException {
		Assert.notNull(mapKey, "[mapKey] - must not be null!");
		try {
			return (List<Map<?, ?>>) sqlSessionTemplate.selectMap(getSqlName(sqlName), parameterObject, mapKey);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象Map时出错！语句：%s", getSqlName(sqlName)), e);
		}
	}

	/**
	 * 物理分页查询
	 */
	public List<?> selectForPageList(String sqlName, Map<String, Object> params, int pageIndex, int pageSize)
			throws DataAccessException {
		Assert.notNull(params);
		try {
			return sqlSessionTemplate.selectList(getSqlName(sqlName), params, new RowBounds(pageIndex, pageSize));
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s", getSqlName(sqlName)), e);
		}
	}
	/**
	 * 
	* @Title: selectForPageListN 
	* @Description: TODO mybatis-paginator分页
	* @author wangxu  
	* @param @param sqlName
	* @param @param parameterObject
	* @param @param pageIndex
	* @param @param pageSize
	* @param @return
	* @param @throws DataAccessException    设定文件 
	* @return List<?>    返回类型 
	* @throws
	 */
	public List<?> selectForPageListN(String sqlName, Object parameterObject, int pageIndex, int pageSize)
			throws DataAccessException {
		Assert.notNull(parameterObject);
		try {
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("model", parameterObject);
			return sqlSessionTemplate.selectList(getSqlName(sqlName), m, new PageBounds(pageIndex, pageSize));
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s", getSqlName(sqlName)), e);
		}
	}
	
	
	

	public List<?> selectForList(String sqlName, Object parameterObject) throws DataProcessException {
		try {
			return sqlSessionTemplate.selectList(getSqlName(sqlName), parameterObject);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s", getSqlName(sqlName)), e);
		}
	}


	public Integer selectForCount(String sqlName, Map<String, Object> params) throws DataAccessException {
		Assert.notNull(params);
		try {
			return sqlSessionTemplate.selectOne(getSqlName(sqlName), params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s", getSqlName(sqlName)), e);
		}
	}


	public int update(String sqlName, Object parameterObject) throws DataProcessException {
		Assert.notNull(sqlName);
		Assert.notNull(parameterObject);
		try {
			return sqlSessionTemplate.update(getSqlName(sqlName), parameterObject);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象出错！语句：%s", getSqlName(sqlName)), e);
		}
	}
	/**
	 * 分页查询
	 * @Title:       selectForPageListNP  
	 * @Description: TODO  
	 * @param:       @param sqlName
	 * @param:       @param parameterObject
	 * @param:       @return
	 * @param:       @throws DataAccessException
	 * @return:      List<?>
	 * @author:      刘云生
	 * @Date:        2016年7月30日 下午3:28:13   
	 * @throws
	 */
	public List<?> selectForPageListNP(String sqlName, PageEasyUI parameterObject)
			throws DataAccessException {
		Assert.notNull(parameterObject);
		try {
			int pageIndex = parameterObject.getPage();
			int pageSize = parameterObject.getRows();
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("model", parameterObject);
			return sqlSessionTemplate.selectList(getSqlName(sqlName), m, new PageBounds(pageIndex, pageSize));
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s", getSqlName(sqlName)), e);
		}
	}
	
}