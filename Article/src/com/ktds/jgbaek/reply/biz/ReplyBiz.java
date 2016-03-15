package com.ktds.jgbaek.reply.biz;

import com.ktds.jgbaek.reply.dao.ReplyDAO;
import com.ktds.jgbaek.reply.vo.ReplyVO;

public class ReplyBiz {

	private ReplyDAO replyDAO;

	public ReplyBiz() {
		replyDAO = new ReplyDAO();
	}

	public boolean addNewReplyDepthOne(ReplyVO reply) {
		
		// 일반 댓글과 첫 번째 대댓글을 달 떄
		// depth 부모글의 depth +1
		
		int orderNo = this.getNewOrderNo(reply);
		reply.setOrderNo(orderNo);
		
		if ( orderNo > 0 ) {
			replyDAO.updateOrderNoByGroupId(reply);
		}
		
		return replyDAO.insertReply(reply)>0  ;
	}

	private int getNewOrderNo(ReplyVO reply) {
		if ( replyDAO.selectCountParentReplyId(reply)>0) {
			int newOrderNo = replyDAO.selectMaxOrderNoByParentReplyId(reply);
			return newOrderNo +1 ;
		}
		else {
			if( reply.getParentReplyId() != 0 ){
				//일반댓글
				int newOrderNo = replyDAO.selectlatestOrderNoByParentReplyId(reply);
				return newOrderNo +1;
			}
		}
		return 0; //완전 일반댓글
	}
}
