package com.tu;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @author: ShiJie
 * @date: 2020年12月13日 下午5:20:27
 */
public interface ITuService  {

	List<Map<String, Object>> queryXueLi() throws ClassNotFoundException, SQLException;

	List<Map<String, Object>> queryShouRu() throws ClassNotFoundException, SQLException;

	List<Map<String, Object>> queryZhiChu() throws ClassNotFoundException, SQLException;

	List<Map<String, Object>> queryYuSuan() throws ClassNotFoundException, SQLException;
  
}
