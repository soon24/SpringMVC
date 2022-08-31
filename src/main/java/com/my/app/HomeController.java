package com.my.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.app.service.BoardVO;
import com.my.app.service.SearchVO;
import com.my.app.service.impl.BoardDAOImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardDAOImpl boardDAOImpl;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		
		return "board/boardWrite";
	}
	
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value = "/boardWriteSave",method = RequestMethod.POST)
	public String insertBoard(HttpServletRequest request, Model model) {
		
		int resCnt = 0;

		String title = "";
		String pass = "";
		String name = "";
		String content = "";
		
		try {
			title = request.getParameter("title").trim();
			pass = request.getParameter("pass").trim();
			name = request.getParameter("name").trim();
			content = request.getParameter("content").trim();
			
			System.out.println("title" + title);
			System.out.println("pass" + pass);
			System.out.println("name" + name);
			System.out.println("content" + content);
			
		} catch(Exception e1) {
		}
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle(title);
		vo.setPass(pass);
		vo.setName(name);
		vo.setContent(content);
		
		try {
			resCnt = boardDAOImpl.insertBoard(vo);
		} catch(Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
		
		return "ok";
	}
	
	@RequestMapping("/boardList") 
	public String selectBoardList(SearchVO searchVO, ModelMap model) throws Exception {

		
		searchVO.pageCalculate(boardDAOImpl.selectBoardTotal(searchVO));
		
		//int resCnt = searchVO.getTotRow();
		//System.out.println("searchVO.getTotRow() =====> "+resCnt);
		
		List<?> listview = boardDAOImpl.selectBoardList(searchVO);
		
		model.addAttribute("listview", listview);
		model.addAttribute("searchVO", searchVO);
		return "board/boardList"; 
	}
	
	@RequestMapping("/boardDetail")
	public String selectBoardDetail(HttpServletRequest request, ModelMap model) throws Exception {
		
		String unq = request.getParameter("unq");
		
		boardDAOImpl.updateBoardHits(unq);
		BoardVO boardVO = boardDAOImpl.selectBoardDetail(unq); 
		String content = boardVO.getContent();
		
		// \n을 br tag로 변환
		boardVO.setContent(content.replace("\n", "<br>"));
		model.addAttribute("boardVO", boardVO);
		
		return "board/boardDetail";
	}
	
	@RequestMapping("/boardModifyWrite")
	public String selectBoardModifyWrite(BoardVO vo, ModelMap model) throws Exception{
		
		BoardVO boardVO = boardDAOImpl.selectBoardDetail(vo.getUnq());
		model.addAttribute("boardVO", boardVO);
		
		return "board/boardModifyWrite";
	}
	
	@RequestMapping("/boardModifySave")
	@ResponseBody
	public String updateBoard(BoardVO vo) throws Exception {
		
		int result = 0;
		
		int count = boardDAOImpl.selectBoardPass(vo);
		if(count == 1) {
			result = boardDAOImpl.updateBoard(vo);
		} else {
			result = -1;
		}
		return result+""; // ajax jsp에 전송 시에는 반드시 String 형태로 return 해야됩니다.
	}
	
	@RequestMapping("/passWrite")
	public String passWrite(int unq, ModelMap model) {
		
		model.addAttribute("unq", unq);
		return "board/passWrite";
	}
	
	@RequestMapping("/boardDelete")
	@ResponseBody
	public String deleteBoard(BoardVO vo) throws Exception {
		
		int result = 0;
		
		int count = boardDAOImpl.selectBoardPass(vo);
		if(count == 1) {
			result = boardDAOImpl.deleteBoard(vo);
		} else {
			result = -1;
		}
		
		return result+""; // ajax jsp에 전송 시에는 반드시 String 형태로 return 해야됩니다.
	}
	 	
}
