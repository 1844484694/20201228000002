package com.tu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc:
 * @author: ShiJie
 * @date: 2020年12月13日 下午5:19:10
 */
@SuppressWarnings("serial")
public class TuServlet extends HttpServlet{
	ITuService tuService=new TuServicelmpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("hello servlet");
		
		
		System.out.println("TuServlet--->service()");
		String method = request.getParameter("method");	
		try {
			if ("zhu".equals(method)) {
				this.zhu(request, response);
			} else if ("bing".equals(method)) {
				this.bing(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	private void bing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		System.out.println("TuServlet--->bing()");	
		//1.取值
		List<Map<String, Object>> list_xueli=tuService.queryXueLi();
		
		//2.存值
		request.setAttribute("list_xueli",list_xueli);
		
		//3.转向
		request.getRequestDispatcher("jsps/tu/bingTu.jsp").forward(request, response);
	}

	private void zhu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		System.out.println("TuServlet--->zhu()");
		
		//1.取数据
		List<Map<String, Object>> list_shouru=tuService.queryShouRu();
		List<Map<String, Object>> list_zhichu=tuService.queryZhiChu();
		List<Map<String, Object>> list_yusuan=tuService.queryYuSuan();

		//2.存值
		request.setAttribute("list_shouru",list_shouru);
		request.setAttribute("list_zhichu",list_zhichu);
		request.setAttribute("list_yusuan", list_yusuan);
		
		
		//3.转向
		request.getRequestDispatcher("jsps/tu/zhuTu.jsp").forward(request, response);
}
	

}
