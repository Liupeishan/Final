package com.ithiema.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithiema.content.Tactics;
import com.ithiema.service.MethodService;


@SuppressWarnings("serial")
public class GetMethodByTypeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//传递请求到service层
		MethodService service = new MethodService();
		List<Tactics> selectmethodList1 = null;
		List<Tactics> selectmethodList2 = null;
		List<Tactics> selectmethodList3 = null;
		List<Tactics> selectmethodList4 = null;
		List<Tactics> selectmethodList5 = null;
		try {
			selectmethodList1 = service.findMethodByType("固定资产投资");
			selectmethodList2 = service.findMethodByType("证券投资");
			selectmethodList3 = service.findMethodByType("项目资金");
			selectmethodList4 = service.findMethodByType("融资选择");
			selectmethodList5 = service.findMethodByType("现金持有量");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(selectmethodList1.getTname());
		request.setAttribute("getMethodByTypeFA", selectmethodList1);
		request.setAttribute("getMethodByTypeIV", selectmethodList2);
		request.setAttribute("getMethodByTypeP", selectmethodList3);
		request.setAttribute("getMethodByTypeGM", selectmethodList4);
		request.setAttribute("getMethodByTypeC", selectmethodList5);
		request.getRequestDispatcher("/html/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
