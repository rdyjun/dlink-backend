package dmucs.dmu.notice.Service;

import dmucs.dmu.notice.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNoticeList(int page);
    String getContent (long nId);
}
