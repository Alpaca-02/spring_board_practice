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


    // 특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);  // 받아온 id값의 글을 삭제한다
    }
}
