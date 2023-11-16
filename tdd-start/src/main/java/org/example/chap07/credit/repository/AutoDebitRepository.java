package org.example.chap07.credit.repository;

import java.util.HashMap;
import java.util.Map;
import org.example.chap07.credit.dto.AutoDebitInfo;

public class AutoDebitRepository {

    private Map<String, AutoDebitInfo> infos = new HashMap<>();

    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }

    public void save(AutoDebitInfo newInfo) {
        infos.put(newInfo.getUserId(), newInfo);
    }
}
