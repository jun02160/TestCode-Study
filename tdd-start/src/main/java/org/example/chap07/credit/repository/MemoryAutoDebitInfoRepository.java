package org.example.chap07.credit.repository;

import java.util.HashMap;
import java.util.Map;
import org.example.chap07.credit.dto.AutoDebitInfo;

/**
 * ## 가짜 대역
 * 특정 사용자에 대한 자동이체 정보가 이미 등록되어 있거나 등록되어 있지 않은 상황을 흉내낸다.
 */
public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {

    private Map<String, AutoDebitInfo> infos = new HashMap<>();

    @Override
    public void save(AutoDebitInfo info) {
        infos.put(info.getUserId(), info);
    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }
}
