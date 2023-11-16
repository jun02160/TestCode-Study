package org.example.chap07.credit.repository;

import org.example.chap07.credit.dto.AutoDebitInfo;

public interface AutoDebitInfoRepository {

    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
