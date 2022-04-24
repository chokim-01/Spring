package com.api.spring.Service;

import com.api.spring.Interface.BoardRepository;
import com.api.spring.VO.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardrepository;

    public List<Board> select() {
        return boardrepository.findAll();
    }

    public boolean insert(Board board) {
        try {
            boardrepository.save(board);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(Long id) {
        try {
            boardrepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}