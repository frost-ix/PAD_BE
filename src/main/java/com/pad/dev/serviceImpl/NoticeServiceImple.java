package com.pad.dev.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pad.dev.dao.NoticeDAO;
import com.pad.dev.service.NoticeService;
import com.pad.dev.vo.notiVO.NotiVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImple implements NoticeService {
    private final NoticeDAO nd;

    @Override
    public List<NotiVO> getNoticeList() {
        List<NotiVO> noticeList = nd.getNoticeList();
        return noticeList;
    }
}
