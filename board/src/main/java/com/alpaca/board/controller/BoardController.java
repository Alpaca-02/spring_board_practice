package com.alpaca.board.controller;

import com.alpaca.board.entity.Board;
import com.alpaca.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")  // localhost:8080/board/write
    public String boardWriteForm(){

        return "boardwrite";   // return에 보낼 html파일명을 지정
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){  // 메개변수는 post로 받아온 값
        System.out.println("제목 : " + board.getTitle());
        System.out.println("내용 : " + board.getContent());

        boardService.write(board);
        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){  // 모델에 데이터를 담아서 보냄
        model.addAttribute("list", boardService.boardList());
        // list이름으로 boardList의 내용을 담아 보냄
        return "boardlist";
    }

    @GetMapping("/board/view")
    public String boardView(Model model, Integer id){  //  /board/view?id=1

        model.addAttribute("article",boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){

        boardService.boardDelete(id);
        return "redirect:/board/list";  // 글 삭제 후 리스트로 리다이렉트
    }
}
