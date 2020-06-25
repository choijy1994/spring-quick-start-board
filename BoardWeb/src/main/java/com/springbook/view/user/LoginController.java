package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController{
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("1234");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo,UserDAO userDAO,HttpSession session) {
		System.out.println("로그인 인증 처리..");
		if(vo.getId()==null||vo.getId().equals("")) {
			System.out.println("erro handle");
			throw new IllegalArgumentException("아이디는 반드시 입력해야합니다.");
		}
		UserVO user = userDAO.getUser(vo);
		if(userDAO.getUser(vo)!=null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else
			return "login.jsp";
	}

}
