package com.yun.dao.base;

/**
 * Mybatis Sql脚本的ID名称 <br>
 * @Company 天人环境<br>
 * @author WangXu<br>
 * @version Revision: 1.0
 */
public interface SqlId {
	public String SQL_SELECT_COUNT = "selectCount";
	public String SQL_SELECT_BY_MAP = "selectByMap";
	public String SQL_SELECT_BY_PRIMARY_ID = "selectByPrimaryKey";
	public String SQL_UPDATE = "updateByPrimaryKeySelective";
	public String SQL_DELETE_BY_ID = "deleteByPrimaryKey";
	public String SQL_INSERT = "insertSelective";
	public String SQL_INSERT_BATCH = "insertBatch";
	public String SQL_SELECT_BY_SELECTIVE = "selectBySelective";
	public String SQL_SELECT_BY_SELECTIVE_COUNT = "selectBySelectiveCount";
	public String SQL_SELECT_OR_BY_SELECTIVE_COUNT = "selectOrBySelectiveCount";
}
