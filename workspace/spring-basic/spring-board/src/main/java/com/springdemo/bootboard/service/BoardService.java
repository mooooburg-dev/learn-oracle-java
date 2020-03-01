package com.springdemo.bootboard.service;

import java.util.List;

import com.springdemo.bootboard.entity.BoardEntity;
import com.springdemo.bootboard.entity.BoardFileEntity;

public interface BoardService {
	
	void writeBoard(BoardEntity board);

	List<BoardEntity> findBoardList();

	BoardEntity findBoardByBoardIdx(int boardIdx);

	void updateBoard(BoardEntity board);

	void deleteBoard(BoardEntity board);

	BoardFileEntity findBoardFileByIdx(int idx);

}
