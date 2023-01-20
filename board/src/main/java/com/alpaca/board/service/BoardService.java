package com.alpaca.board.service;

import com.alpaca.board.entity.Board;
import com.alpaca.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired   // Autowired설정시 new BoardRepository로 생성해 줄 필요가 없다.
    private BoardRepository boardRepository;

    // 게시글 작성
    public void write(Board board){
        boardRepository.save(board);
    }

    // 게시글 리스트 불러오기
    public List<Board> boardList(){
        return boardRepository.findAll();
    }

    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }
}
