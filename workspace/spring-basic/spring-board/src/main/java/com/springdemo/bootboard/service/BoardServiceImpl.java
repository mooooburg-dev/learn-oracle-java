package com.springdemo.bootboard.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.bootboard.entity.BoardEntity;
import com.springdemo.bootboard.entity.BoardFileEntity;
import com.springdemo.bootboard.repository.BoardRepository;

@Service("boardService") // == @Component("boardService")
                         // == <bean id="boardService" class="...BoardServiceImpl"
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	@Override
	public void writeBoard(BoardEntity board) {
		boardRepository.save(board);
	}

	@Override
	public List<BoardEntity> findBoardList() {
		//List<BoardEntity> boards = (List<BoardEntity>)boardRepository.findAll();
		List<BoardEntity> boards = boardRepository.findAllByOrderByBoardIdxDesc();
		return boards;
	}

	@Override
	public BoardEntity findBoardByBoardIdx(int boardIdx) {
		Optional<BoardEntity> board = boardRepository.findById(boardIdx);
		// return board.get(); //조회된 값이 없으면 오류 발생
		return board.orElse(null); // 조회된 값이 없으면 null 반환
	}

	@Override
	public void updateBoard(BoardEntity board) {
		board.setUpdatedDatetime(new Date());
		//boardRepository.save(board);
		boardRepository.updateBoardOnly(board);
		
	}

	@Override
	public void deleteBoard(BoardEntity board) {

		boardRepository.deleteById(board.getBoardIdx());
		
	}

	@Override
	public BoardFileEntity findBoardFileByIdx(int idx) {

		return boardRepository.findBoardFileByIdx(idx);

	}

}
