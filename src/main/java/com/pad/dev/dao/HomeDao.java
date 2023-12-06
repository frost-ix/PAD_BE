package com.pad.dev.dao;

import java.util.List;

import com.pad.dev.VO.boardVO.BoardVO;


public interface HomeDao {
    public List<BoardVO> getBoardList();
}
