package com.weweibuy.webuy.learning.spring.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author durenhao
 * @date 2020/8/2 17:42
 **/
@Service
public class SampleTxService extends AbstractService {

    /**
     * 通过父类的方法调改方法 事务不会生效
     *
     * @return
     */
    @Override
    @Transactional
    protected String doBiz() {
        return TransactionSynchronizationManager.isActualTransactionActive() + "";

    }
}
