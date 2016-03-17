package com.ktds.jgbaek.history.biz;

import com.ktds.jgbaek.history.dao.OperationHistoryDAO;
import com.ktds.jgbaek.history.vo.OperationHistoryVO;

public class OperationHistoryBiz {
	
	private OperationHistoryDAO dao;
	
	public OperationHistoryBiz(){
		dao = new OperationHistoryDAO();
	}
	
	public void addHistory(OperationHistoryVO historyVO){
		dao.insertHistory(historyVO);
	}

}
