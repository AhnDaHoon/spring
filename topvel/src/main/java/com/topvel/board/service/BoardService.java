package com.topvel.board.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.topvel.board.model.Board;
import com.topvel.comment.model.Searchs;

public interface BoardService {
	List<Board> getboardList (Searchs searchs);
	
	int getboardListCnt(Searchs searchs);
	
	ResponseEntity<?> inserBoard(Board board);
	
	Integer getBoardSeq();
	
	Board getBoard(Integer boardSeq);
	
	ResponseEntity<?> deleteBoard(Integer boardSeq);
	
	ResponseEntity<?> modifyBoard(Board board);
	
	void hitsUp(Integer boardSeq);
}
