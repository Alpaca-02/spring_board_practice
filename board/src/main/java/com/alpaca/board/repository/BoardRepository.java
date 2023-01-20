package com.alpaca.board.repository;

import com.alpaca.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {   // JpaRepository를 상속 받는다.<엔티티, id의 기본타입> 으로 지정

}
