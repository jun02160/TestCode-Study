package org.example.chap07.credit;

public interface AutoDebitInfoRepository {

    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
