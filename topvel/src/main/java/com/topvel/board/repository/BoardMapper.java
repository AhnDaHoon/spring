package com.topvel.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.topvel.board.model.Board;
import com.topvel.comment.model.Searchs;

@Mapper
public interface BoardMapper {

	List<Board> getboardList (Searchs searchs);
	
	int getboardListCnt(Searchs searchs);
	
	boolean inserBoard(Board board);
	
	Integer getBoardSeq();
	
	Board getBoard(Integer boardSeq);
	
	boolean deleteBoard(Integer boardSeq);
	
	boolean modifyBoard(Board board);
	
	void hitsUp(Integer boardSeq);
}