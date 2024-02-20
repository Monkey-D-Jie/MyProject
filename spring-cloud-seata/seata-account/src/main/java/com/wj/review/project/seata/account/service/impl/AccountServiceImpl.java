package com.wj.review.project.seata.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wj.review.project.seata.account.mapper.AccountMapper;
import com.wj.review.project.seata.account.model.entity.Account;
import com.wj.review.project.seata.account.service.IAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * AT transaction mode undo table 服务实现类
 * </p>
 *
 * @author wangjie
 * @since 2023-08-14
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    /**
     * 扣减余额
     *
     * @param userId
     * @param money
     * @return
     */
    @Transactional
    @Override
    public int deduct(String userId, Long money) {
        UpdateWrapper<Account> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq(Account.Fields.userId,userId)
                .setSql("money = money-"+money);
        this.update(null, updateWrapper);
        return 0;
    }
}
