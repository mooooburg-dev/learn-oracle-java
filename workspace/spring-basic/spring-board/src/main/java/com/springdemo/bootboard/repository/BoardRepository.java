package com.springdemo.bootboard.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdemo.bootboard.entity.BoardEntity;
import com.springdemo.bootboard.entity.BoardFileEntity;

//ORM이 지정된 엔티티(테이블)에 대해 작성한 인테페이스에 따라 
//필요한 작업(CRUD)을 구현하는 클래스를 자동 생성
public interface BoardRepository 
	extends CrudRepository<BoardEntity, Integer> {
	
	//find : select, 
	//AllBy : 모든 데이터, 
	//OrderByBoardIdxDesc : order by board_idx desc
	List<BoardEntity> findAllByOrderByBoardIdxDesc();
	
	@Query("SELECT file FROM BoardFileEntity file WHERE idx = :idx")
	BoardFileEntity findBoardFileByIdx(@Param("idx") int idx);
	
	@Transactional
	@Modifying
	@Query("UPDATE BoardEntity b " + 
		   "SET b.title = :#{#board.title}, " +
		   "    b.contents = :#{#board.contents}, " + 
		   "    b.updatedDatetime = :#{#board.updatedDatetime} " + 
		   "WHERE b.boardIdx = :#{#board.boardIdx}")
	void updateBoardOnly(@Param("board")BoardEntity board);

}









