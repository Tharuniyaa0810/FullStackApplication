package com.astrasquad.tharuniyaa.service;


import com.astrasquad.tharuniyaa.dto.request.WithdrawalRequest;
import com.astrasquad.tharuniyaa.dto.response.WithdrawalResponse;

import java.util.List;

public interface WithdrawalService {
    WithdrawalResponse createWithdrawal(WithdrawalRequest withdrawalRequest);

    WithdrawalResponse getWithdrawalById(Long wid);

    List<WithdrawalResponse> getAllWithdrawals();

    WithdrawalResponse updateWithdrawal(Long wid, WithdrawalRequest withdrawalRequest);

    void deleteWithdrawal(Long wid);
}
