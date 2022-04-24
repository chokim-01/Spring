package com.api.spring.Controller;

import com.api.spring.Service.BoardService;
import com.api.spring.Service.Security.CustomUserDetails;
import com.api.spring.VO.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService bs;

    @GetMapping("/Board/select")
    public List<Board> select() {

        return bs.select();
    }

    @GetMapping("/Board/delete/{id}")
    public boolean delete(@RequestParam Long id) {

        return bs.delete(id);
    }


    @GetMapping("/Board/insert")
    public boolean insert(@AuthenticationPrincipal CustomUserDetails ud, @RequestBody Board boardContent) {

        Board board = Board.builder().title(boardContent.getTitle()).content(boardContent.getContent()).user(ud.getUser()).picture(boardContent.getPicture()).build();
        bs.insert(board);
        return true;
    }
}
