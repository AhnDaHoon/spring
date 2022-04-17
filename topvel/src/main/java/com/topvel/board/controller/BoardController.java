package com.topvel.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topvel.board.model.Board;
import com.topvel.board.service.BoardService;
import com.topvel.comment.model.PaginationInfo;
import com.topvel.comment.model.Searchs;
import com.topvel.user.model.User;
import com.topvel.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class BoardController {

	
	private final BoardService boardService;
	
	@GetMapping("/home")
	public String home(Model model, String loginId, HttpServletRequest request, Searchs searchs, String logout) {
	    System.out.println("asdadad" + searchs);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchs.getCurrentPageNo());
	    paginationInfo.setTotalRecordCount(boardService.getboardListCnt(searchs));
	    paginationInfo.setPageSize(searchs.getPageSize());
	    paginationInfo.setRecordCountPerPage(searchs.getRecordCountPerPage());
		
	    
	    model.addAttribute("boardList", boardService.getboardList(searchs));
	    model.addAttribute("listCnt", boardService.getboardListCnt(searchs));
	    
	  	model.addAttribute("searchs", searchs);
	    model.addAttribute("paginationInfo", paginationInfo);
		return "/main/main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/home";
	}
	
	@GetMapping("/board/{boardSeq}")
	public String board(Model model, @PathVariable Integer boardSeq) {
		boardService.hitsUp(boardSeq);
	    model.addAttribute("board", boardService.getBoard(boardSeq));
		return "/board/boardDetail";
	}
	
	@DeleteMapping("/board/{boardSeq}")
	public ResponseEntity<?> deleteBoard(@PathVariable Integer boardSeq){
		return boardService.deleteBoard(boardSeq);
	}
	
	@PutMapping("/board")
	public ResponseEntity<?> modifyBoard(Board board){
		return boardService.modifyBoard(board);
	}
	
	@GetMapping("/boardInput")
	public String boardInputForm(Model model) {
	    
		return "/board/boardInput";
	}
	
	@PostMapping("/boardInput")
	public ResponseEntity<?> boardInput(Board board){
		
		return boardService.inserBoard(board);
	}
	
}
