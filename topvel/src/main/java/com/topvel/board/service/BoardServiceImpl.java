package com.topvel.board.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.topvel.board.model.Board;
import com.topvel.board.repository.BoardMapper;
import com.topvel.comment.model.Searchs;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	private final BoardMapper boardMapper;
	
	@Override
	public List<Board> getboardList(Searchs searchs) {
		return boardMapper.getboardList(searchs);
	}

	@Override
	public int getboardListCnt(Searchs searchs) {
		return boardMapper.getboardListCnt(searchs);
	}

	@Override
	public ResponseEntity<?> inserBoard(Board board) {
		if(!ObjectUtils.isEmpty(board)) {
			board.setBoardSeq(boardMapper.getBoardSeq());
			if(boardMapper.inserBoard(board)) {
				return new ResponseEntity<>("게시판이 등록되었습니다.", HttpStatus.OK);
			};
		}
		return new ResponseEntity<>("게시판 등록에 실패하셨습니다.", HttpStatus.BAD_REQUEST);
	}

	@Override
	public Integer getBoardSeq() {
		return  (boardMapper.getBoardSeq() != null) ? boardMapper.getBoardSeq() : 1;

	}

	@Override
	public Board getBoard(Integer boardSeq) {
		return boardMapper.getBoard(boardSeq);
	}

	@Override
	public ResponseEntity<?> deleteBoard(Integer boardSeq) {
		if(!ObjectUtils.isEmpty(boardSeq)) {
			if(boardMapper.deleteBoard(boardSeq)) {
				return new ResponseEntity<>("게시판이 삭제되었습니다.", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("게시판 삭제에 실패하셨습니다.", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> modifyBoard(Board board) {
		if(!ObjectUtils.isEmpty(board)) {
			if(boardMapper.modifyBoard(board)) {
				return new ResponseEntity<>("게시판이 수정되었습니다.", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("게시판 수정에 실패하셨습니다.", HttpStatus.BAD_REQUEST);
	}

	@Override
	public void hitsUp(Integer boardSeq) {
		boardMapper.hitsUp(boardSeq);
		
	}

}
