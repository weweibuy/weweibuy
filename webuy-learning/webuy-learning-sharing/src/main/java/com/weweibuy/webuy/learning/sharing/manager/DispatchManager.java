package com.weweibuy.webuy.learning.sharing.manager;

import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillDetailMapper;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillInfoMapper;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillDetail;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillDetailExample;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillInfo;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillInfoExample;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/9/7 16:57
 **/
@Component
public class DispatchManager {

    @Autowired
    private DispatchBillInfoMapper dispatchBillInfoMapper;

    @Autowired
    private DispatchBillDetailMapper detailMapper;


    @Transactional
    public void updateDispatch(String billNo) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DispatchBillInfoExample example = new DispatchBillInfoExample();
        example.createCriteria().andBillNoEqualTo(billNo);
        List<DispatchBillInfo> dispatchBillInfoList = dispatchBillInfoMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(dispatchBillInfoList)) {
            DispatchBillInfo dispatchBillInfo = dispatchBillInfoList.get(0);
            DispatchBillInfo dispatchBillInfo1 = new DispatchBillInfo();
            dispatchBillInfo1.setBillStatus("100");
            dispatchBillInfo1.setTotalRecordNum(100);
            dispatchBillInfo1.setExpectAmount(200);
            dispatchBillInfoMapper.updateByExampleSelective(dispatchBillInfo1, example);

            DispatchBillDetailExample dispatchBillDetailExample = new DispatchBillDetailExample();
            dispatchBillDetailExample.createCriteria().andBillNoEqualTo(billNo);
            List<DispatchBillDetail> dispatchBillDetailList = detailMapper.selectByExample(dispatchBillDetailExample);

            if(CollectionUtils.isNotEmpty(dispatchBillDetailList)){
                DispatchBillDetail dispatchBillDetail = dispatchBillDetailList.get(0);
                DispatchBillDetail dispatchBillDetail1 = new DispatchBillDetail();
                dispatchBillDetail1.setProcessStatus("30");
                dispatchBillDetail1.setAmount(100);
                dispatchBillDetail1.setPayAmount(200L);
                detailMapper.updateByExampleSelective(dispatchBillDetail1, dispatchBillDetailExample);
            }

        }


    }


}
