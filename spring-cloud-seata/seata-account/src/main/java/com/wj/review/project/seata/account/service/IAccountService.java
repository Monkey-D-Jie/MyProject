package com.wj.review.project.seata.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wj.review.project.seata.account.model.entity.Account;

/**
 * <p>
 * AT transaction mode undo table 服务类
 * </p>
 *
 * @author wangjie
 * @since 2023-08-14
 */
public interface IAccountService extends IService<Account> {
    int deduct(String userId,Long money);
}
