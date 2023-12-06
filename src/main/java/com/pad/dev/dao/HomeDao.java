package com.pad.dev.dao;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardVO;

public interface HomeDao {
    public List<BoardVO> getBoardList();
}
