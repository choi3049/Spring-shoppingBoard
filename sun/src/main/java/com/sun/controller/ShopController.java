package com.sun.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.domain.GoodsViewVO;
import com.sun.domain.MemberVO;
import com.sun.domain.ReplyListVO;
import com.sun.domain.ReplyVO;
import com.sun.service.ShopService;

@Controller
@RequestMapping("/shop/*")
public class ShopController {
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Inject
	ShopService service;

	// 카테고리별 상품 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception {
		logger.info("get llist");

		List<GoodsViewVO> list = null;
		list = service.list(cateCode, level);

		model.addAttribute("list", list);

	}

	// 상품 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get view");

		GoodsViewVO view = service.goodsView(gdsNum);
		model.addAttribute("view", view);

//		List<ReplyListVO> reply = service.replyList(gdsNum);
//		model.addAttribute("reply", reply);
	}

//	// 상품 조회 - 소감(댓글) 작성
//	@RequestMapping(value = "/view", method = RequestMethod.POST)
//	public String registReply(ReplyVO reply, HttpSession session) throws Exception {
//		logger.info("regist reply");
//
//		MemberVO member = (MemberVO) session.getAttribute("member");
//		reply.setUserId(member.getUserId());
//
//		service.registReply(reply);
//
//		return "redirect:/shop/view?n=" + reply.getGdsNum();
//	}

	// 상품 소감(댓글) 작성
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
	public void registReply(ReplyVO reply, HttpSession session) throws Exception {
		logger.info("regist reply");

		MemberVO member = (MemberVO) session.getAttribute("member");
		reply.setUserId(member.getUserId());

		service.registReply(reply);
	}

	// 상품 소감(댓글) 목록
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("get reply list");

		List<ReplyListVO> reply = service.replyList(gdsNum);

		return reply;
	}

	// 상품 소감(댓글) 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ReplyVO reply, HttpSession session) throws Exception {
		logger.info("post delete reply");

		// 정상작동 여부를 확인하기 위한 변수
		int result = 0;

		MemberVO member = (MemberVO) session.getAttribute("member"); // 현재 로그인한 member 세션을 가져옴
		String userId = service.idCheck(reply.getRepNum()); // 소감(댓글)을 작성한 사용자의 아이디를 가져옴

		// 로그인한 아이디와, 소감을 작성한 아이디를 비교
		if (member.getUserId().equals(userId)) {

			// 로그인한 아이디가 작성한 아이디와 같다면

			reply.setUserId(member.getUserId()); // reply에 userId 저장
			service.deleteReply(reply); // 서비스의 deleteReply 메서드 실행

			// 결과값 변경
			result = 1;
		}

		// 정상적으로 실행되면 소감 삭제가 진행되고, result값은 1이지만
		// 비정상적으로 실행되면 소감 삭제가 안되고, result값이 0
		return result;
	}

	// 상품 소감(댓글) 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ReplyVO reply, HttpSession session) throws Exception {
		logger.info("modify reply");

		int result = 0;

		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());

		if (member.getUserId().equals(userId)) {

			reply.setUserId(member.getUserId());
			service.modifyReply(reply);
			result = 1;
		}

		return result;

	}
}