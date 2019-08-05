package com.weweibuy.webuy.learning.sharing.service;

import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillDetailMapper;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillInfoMapper;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillSettlementInfoMapper;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillWarehouseInfoMapper;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillDetail;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillInfo;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillSettlementInfo;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillWarehouseInfo;
import com.weweibuy.webuy.learning.sharing.utils.UIdHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.Executor;

/**
 * @author durenhao
 * @date 2019/8/2 22:59
 **/
@Slf4j
@Service
public class DispatchService {

    @Autowired
    private DispatchBillInfoMapper billInfoMapper;

    @Autowired
    private DispatchBillDetailMapper detailMapper;

    @Autowired
    private DispatchBillWarehouseInfoMapper warehouseInfoMapper;

    @Autowired
    private DispatchBillSettlementInfoMapper settlementInfoMapper;

    @Autowired
    private Executor executor;

    @Transactional
    public void addHeaderAndDetail() {
        String billNo = "bill_" + UIdHelper.nextId();
        String orderNo = "order_" + UIdHelper.nextId();
        String processStatus = "0";
        DispatchBillInfo dispatchBillInfo = new DispatchBillInfo();
        Long aLong = UIdHelper.nextId();
        dispatchBillInfo.setId(aLong);
        log.info("id : {}", aLong);
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

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addWarehouseInfo(billNo, orderNo);
        });

        executor.execute(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addSettlementInfoInfo(billNo, orderNo);
        });

    }


    public void addWarehouseInfo(String billNo, String orderNo) {
        DispatchBillWarehouseInfo warehouseInfo = new DispatchBillWarehouseInfo();
        warehouseInfo.setId(UIdHelper.nextId());
        warehouseInfo.setBillNo(billNo);
        warehouseInfo.setOrderNo(orderNo);
        warehouseInfo.setBwWarehouseCode("325WH112233");
        warehouseInfo.setWarehouseCode("WH112233");
        warehouseInfo.setWarehouseId("WH112233");
        warehouseInfo.setWarehouseName("上海仓");
        warehouseInfo.setWarehouseType(1);
        warehouseInfo.setExpectOutTime(new Date());
        warehouseInfo.setExpressBillNo("express_no_" + UIdHelper.nextId());
        warehouseInfo.setExpectOutTime(new Date());
        warehouseInfo.setExpressType("空运");
        warehouseInfo.setFreightCompanyCode("my_freight_company_code");
        warehouseInfo.setFreightModeFlag(true);
        warehouseInfo.setMoveModeCode("my_move_mode_code");
        warehouseInfo.setMoveModeLevelNo("first");
        warehouseInfo.setMoveModeName("自提");
        warehouseInfo.setMoveType("同仓");
        warehouseInfoMapper.insertSelective(warehouseInfo);
    }

    public void addSettlementInfoInfo(String billNo, String orderNo) {
        DispatchBillSettlementInfo settlementInfo = new DispatchBillSettlementInfo();
        settlementInfo.setId(UIdHelper.nextId());
        settlementInfo.setBillNo(billNo);
        settlementInfo.setOrderNo(orderNo);
        settlementInfo.setOrderNo(orderNo);
        settlementInfo.setPaymentType(1);
        settlementInfo.setPayAmount(new BigDecimal(120.0));
        settlementInfo.setCollectionAmount(new BigDecimal(120.0));
        settlementInfo.setExpressAmount(new BigDecimal(120.0));
        settlementInfo.setPaymentTime(new Date());
        settlementInfoMapper.insertSelective(settlementInfo);
    }


    public void addDetail(String billNo, String orderNo, String status) {
        DispatchBillDetail dispatchBillInfo = new DispatchBillDetail();
        Long aLong = UIdHelper.nextId();
        log.info("detailId : {}", aLong);
        dispatchBillInfo.setId(aLong);
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
        Long aLong2 = UIdHelper.nextId();
        log.info("detailId : {}", aLong2);
        dispatchBillInfo2.setId(aLong2);
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
