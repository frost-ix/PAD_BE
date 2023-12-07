package com.pad.dev.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pad.dev.dao.NoticeDAO;
import com.pad.dev.vo.notiVO.NotiVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NoticeDAOImpl implements NoticeDAO {
    private final SqlSession sqlSession;

    @Override
    public List<NotiVO> getNoticeList() {
        List<NotiVO> noticeList = null;
        try {
            noticeList = sqlSession.selectList("getNoticeList");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return noticeList;
    }


}
