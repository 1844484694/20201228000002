package com.tu;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dao.Dao;

/**
 * @desc:
 * @author: ShiJie
 * @date: 2020年12月13日 下午5:21:43
 */
public class TuServicelmpl implements ITuService{
	Dao dao = new Dao();
	@Override
	public List<Map<String, Object>> queryXueLi() throws ClassNotFoundException, SQLException {
		return dao.executeQueryForList("select count(*) renshu ,xueli from yuangongxinxi  GROUP BY xueli ");

	}
	@Override
	public List<Map<String, Object>> queryShouRu() throws ClassNotFoundException, SQLException {
		String sql="SELECT  QUARTER(riqi) jidu,SUM(shouRuJinEr) jiner  FROM   shouru  GROUP BY  QUARTER(riqi) ";
		return dao.executeQueryForList(sql);
	
	}
	@Override
	public List<Map<String, Object>> queryZhiChu() throws ClassNotFoundException, SQLException {
		String sql="SELECT  QUARTER(riqi) jidu,SUM(zhiChuJinEr) jiner  FROM   ZhiChu  GROUP BY  QUARTER(riqi) ";
		return dao.executeQueryForList(sql);
	}
	@Override
	public List<Map<String, Object>> queryYuSuan() throws ClassNotFoundException, SQLException {
		String sql="SELECT  QUARTER(riqi) jidu,SUM(yuSuanJinEr) jiner  FROM   yusuan  GROUP BY  QUARTER(riqi) ";
		return dao.executeQueryForList(sql);
	}

}
