package com.weweibuy.webuy.learning.sharing.service;

import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillDetailMapper;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillInfoMapper;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillDetail;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillInfo;
import com.weweibuy.webuy.learning.sharing.utils.UIdHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author durenhao
 * @date 2019/8/2 22:59
 **/
@Service
public class DispatchService {

    @Autowired
    private DispatchBillInfoMapper billInfoMapper;

    @Autowired
    private DispatchBillDetailMapper detailMapper;

    @Transactional
    public void addHeaderAndDetail() {
        String billNo = "bill_" + UIdHelper.nextId();
        String orderNo = "order_" + UIdHelper.nextId();
        String processStatus = "0";
        DispatchBillInfo dispatchBillInfo = new DispatchBillInfo();
        dispatchBillInfo.setBillNo(billNo);
        dispatchBillInfo.setOrderNo(orderNo);
        dispatchBillInfo.setBizFlowNo(UIdHelper.nextStrId());
        dispatchBillInfo.setBillType("my_bill_type_" + RandomStringUtils.randomNumeric(1));
        dispatchBillInfo.setBizType("my_biz_type_" + RandomStringUtils.randomNumeric(1));
        dispatchBillInfo.setBillSource("taobao");
        dispatchBillInfo.setBillStatus("0");
        dispatchBillInfo.setProcessStatus(processStatus);
        dispatchBillInfo.setChannelCode("jit");
        dispatchBillInfo.setSourceBilllNo("source_no_" + UIdHelper.nextId());
        dispatchBillInfo.setManualBillNo("manual_no_" + UIdHelper.nextId());
        dispatchBillInfo.setBatchNo("1");
        dispatchBillInfo.setBuyerUserName("tom");
        dispatchBillInfo.setProvince("上海");
        dispatchBillInfo.setCity("上海");
        dispatchBillInfo.setArea("浦东");
        dispatchBillInfo.setAddress("张江");
        dispatchBillInfo.setContact("jack");

        dispatchBillInfo.setPhone("1380000000");
        dispatchBillInfo.setExpectAmount(20);
        dispatchBillInfo.setTotalRecordNum(2);
        billInfoMapper.insertSelective(dispatchBillInfo);
        addDetail(billNo, orderNo, processStatus);
    }


    public void addDetail(String billNo, String orderNo, String status) {
        DispatchBillDetail dispatchBillInfo = new DispatchBillDetail();
        dispatchBillInfo.setBillNo(billNo);
        dispatchBillInfo.setOrderNo(orderNo);
        dispatchBillInfo.setProcessStatus(status);
        dispatchBillInfo.setSequence(UIdHelper.nextStrId());
        dispatchBillInfo.setBarCode("barcode_" + UIdHelper.nextId());
        dispatchBillInfo.setMaterialCode("material_code" + UIdHelper.nextId());
        dispatchBillInfo.setSizeCode("32");
        dispatchBillInfo.setAmount(20);
        dispatchBillInfo.setPrice(new BigDecimal(102.00));
        dispatchBillInfo.setRetailPrice(102L);

        DispatchBillDetail dispatchBillInfo2 = new DispatchBillDetail();
        dispatchBillInfo2.setBillNo(billNo);
        dispatchBillInfo2.setOrderNo(orderNo);
        dispatchBillInfo2.setProcessStatus(status);
        dispatchBillInfo2.setSequence(UIdHelper.nextStrId());
        dispatchBillInfo2.setBarCode("barcode_" + UIdHelper.nextId());
        dispatchBillInfo2.setMaterialCode("material_code" + UIdHelper.nextId());
        dispatchBillInfo2.setSizeCode("32");
        dispatchBillInfo2.setAmount(14);
        dispatchBillInfo2.setPrice(new BigDecimal(200.00));
        dispatchBillInfo2.setRetailPrice(200L);
        detailMapper.insertSelective(dispatchBillInfo);
        detailMapper.insertSelective(dispatchBillInfo2);

    }


}
