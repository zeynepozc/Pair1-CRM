package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.mapper.BillingAccountMapper;
import com.etiya.customerservice.repository.BillingAccountRepository;
import com.etiya.customerservice.service.abstracts.BillingAccountService;
import com.etiya.customerservice.service.dto.request.billingAccount.CreateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.request.billingAccount.UpdateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.response.billingAccount.CreateBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.GetByIdBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.ListBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.UpdateBillingAccountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillingAccountServiceImpl implements BillingAccountService
{
    private final BillingAccountRepository billingAccountRepository;
    private final BillingAccountMapper billingAccountMapper;


    @Override
    public List<ListBillingAccountResponseDto> getAll() {
        List<BillingAccount> billingAccountList = billingAccountRepository.findAll();
        return billingAccountMapper.listBillingAccountResponseDtoListFromBillingAccountList(billingAccountList);
    }

    @Override
    public GetByIdBillingAccountResponseDto getById(Long id) {
        Optional<BillingAccount> billingAccount = billingAccountRepository.findById(id);
        return billingAccountMapper.getByIdBillingAccountResponseDtoFromBillingAccount(billingAccount.get());
    }

    @Override
    public Optional<BillingAccount> getBillingAccountById(Long id) {
        return billingAccountRepository.findById(id);
    }

    @Override
    public List<BillingAccount> getBillingAccountsByCustomerAccountId(Long id) {
        return billingAccountRepository.findBillingAccountsByCustomerAccount_Id(id);
    }

    @Override
    public CreateBillingAccountResponseDto add(CreateBillingAccountRequestDto createBillingAccountRequestDto) {
        BillingAccount billingAccount = billingAccountMapper.billingAccountFromCreateBillingAccountRequestDto(createBillingAccountRequestDto);
        return billingAccountMapper.createBillingAccountResponseDtoFromBillingAccount(billingAccountRepository.save(billingAccount));
    }

    @Override
    public UpdateBillingAccountResponseDto update(UpdateBillingAccountRequestDto updateBillingAccountRequestDto) {
        BillingAccount billingAccount = billingAccountMapper.billingAccountFromUpdateBillingAccountRequestDto(updateBillingAccountRequestDto);
        billingAccount = billingAccountRepository.save(billingAccount);
        return billingAccountMapper.updateBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }

    @Override
    public void delete(Long id) {
        billingAccountRepository.deleteById(id);
    }
}
