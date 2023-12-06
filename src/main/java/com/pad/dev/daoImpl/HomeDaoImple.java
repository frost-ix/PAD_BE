package com.pad.dev.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.pad.dev.dao.HomeDao;
import com.pad.dev.vo.boardVO.BoardVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HomeDaoImple implements HomeDao {

    private final SqlSessionTemplate sqlSession;

    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = null;
        try {
            System.out.println("Dao try");
            boardList = sqlSession.selectList("getBoardList");
            System.out.println("갔다왔어?");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(boardList);
        return boardList;
    }

}
