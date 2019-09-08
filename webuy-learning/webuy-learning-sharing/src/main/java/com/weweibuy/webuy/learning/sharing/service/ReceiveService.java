package com.weweibuy.webuy.learning.sharing.service;

import com.weweibuy.webuy.learning.sharing.mapper.ReceiveBillDetailMapper;
import com.weweibuy.webuy.learning.sharing.mapper.ReceiveBillInfoMapper;
import com.weweibuy.webuy.learning.sharing.mapper.ReceiveBillSettlementInfoMapper;
import com.weweibuy.webuy.learning.sharing.mapper.ReceiveBillWarehouseInfoMapper;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillDetail;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillInfo;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillSettlementInfo;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillWarehouseInfo;
import com.weweibuy.webuy.learning.sharing.model.vo.WarehouseInfo;
import com.weweibuy.webuy.learning.sharing.utils.UIdHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author durenhao
 * @date 2019/9/7 22:42
 **/
@Slf4j
@Service
public class ReceiveService {

    @Autowired
    private ReceiveBillInfoMapper receiveBillInfoMapper;
    @Autowired
    private ReceiveBillWarehouseInfoMapper warehouseInfoMapper;
    @Autowired
    private ReceiveBillSettlementInfoMapper settlementInfoMapper;
    @Autowired
    private ReceiveBillDetailMapper detailMapper;

    @Autowired
    private Executor executor;

    private Map<Integer, WarehouseInfo> warehouseInfoMap = new HashedMap<>();

    {
        warehouseInfoMap.put(0, new WarehouseInfo("WH112230", "上海0仓", (short) 0));
        warehouseInfoMap.put(2, new WarehouseInfo("WH112232", "上海2仓", (short) 2));
        warehouseInfoMap.put(1, new WarehouseInfo("WH112231", "上海1仓", (short) 1));
        warehouseInfoMap.put(3, new WarehouseInfo("WH112233", "上海3仓", (short) 3));
        warehouseInfoMap.put(4, new WarehouseInfo("WH112234", "上海4仓", (short) 4));
    }

    private List<String> channelList = new ArrayList<>();

    {
        channelList.add("jit");
        channelList.add("bbc");
        channelList.add("b2c");
        channelList.add("b2b");
        channelList.add("oxo");
    }

    private List<String> bizTypeList = new ArrayList<>();

    {
        bizTypeList.add("biz_type_jit");
        bizTypeList.add("biz_type_bbc");
        bizTypeList.add("biz_type_b2c");
        bizTypeList.add("biz_type_b2b");
        bizTypeList.add("biz_type_oxo");
    }

    private List<String> billSourceList = new ArrayList<>();

    {
        billSourceList.add("tb");
        billSourceList.add("jd");
        billSourceList.add("tm");
        billSourceList.add("sn");
        billSourceList.add("vip");
    }


    @Transactional
    public void addHeaderAndDetail() {
        String billNo = "bill_" + UIdHelper.nextId();
        String orderNo = "order_" + UIdHelper.nextId();
        String processStatus = "0";
        ReceiveBillInfo receiveBillInfo = new ReceiveBillInfo();
        Long aLong = UIdHelper.nextId();
        receiveBillInfo.setId(aLong);
        log.info("id : {}", aLong);
        receiveBillInfo.setBillNo(billNo);
        receiveBillInfo.setOrderNo(orderNo);
        receiveBillInfo.setBizFlowNo(UIdHelper.nextStrId());
        receiveBillInfo.setBillType("bill_type_" + getBizTye());
        receiveBillInfo.setBizType("收货" + getBizTye());
        receiveBillInfo.setBillSource(getSource());
        receiveBillInfo.setBillStatus("0");
        receiveBillInfo.setProcessStatus(processStatus);
        receiveBillInfo.setChannelCode(getChannel());
        receiveBillInfo.setShopBillNo("shop_bill_no_" + UIdHelper.nextId());
        receiveBillInfo.setBuyerUserName("tom");
        receiveBillInfo.setProvince("上海");
        receiveBillInfo.setCity("上海");
        receiveBillInfo.setArea("浦东");
        receiveBillInfo.setAddress("张江");
        receiveBillInfo.setContact("jack");
        receiveBillInfo.setPhone("1380000000");
        receiveBillInfo.setExpectAmount(20);
        receiveBillInfo.setTotalRecordNum(2);
        addDetail(billNo, orderNo, processStatus);

        addWarehouseInfo(aLong, billNo, orderNo);

        addSettlementInfoInfo(aLong, billNo, orderNo);
        receiveBillInfoMapper.insertSelective(receiveBillInfo);

    }


    public void addWarehouseInfo(Long hid, String billNo, String orderNo) {
        ReceiveBillWarehouseInfo warehouseInfo = new ReceiveBillWarehouseInfo();
        warehouseInfo.setReceiveBillInfoId(hid);
        warehouseInfo.setId(UIdHelper.nextId());
        warehouseInfo.setBillNo(billNo);
        warehouseInfo.setOrderNo(orderNo);
        WarehouseInfo wh = getWh();
        warehouseInfo.setExpressBillNo("express_no_" + UIdHelper.nextId());
        warehouseInfo.setFreightCompanyCode("my_freight_company_code");
        warehouseInfo.setTransportMethodName("my_transport_method");
        warehouseInfo.setTransportMethodCode("my_transport_code");
        warehouseInfo.setBwDeliveryWarehouseCode("my_warehouse_code");
        warehouseInfo.setBwReceiveWarehouseCode("bw_Receive_Warehouse_code");
        warehouseInfo.setDeliveryWarehouseType((short) 1);
        warehouseInfo.setDeliveryWarehouseName("my_warehouse_name");
        warehouseInfoMapper.insertSelective(warehouseInfo);
    }

    public void addSettlementInfoInfo(Long hid, String billNo, String orderNo) {
        ReceiveBillSettlementInfo settlementInfo = new ReceiveBillSettlementInfo();
        settlementInfo.setId(UIdHelper.nextId());
        settlementInfo.setReceiveBillInfoId(hid);
        settlementInfo.setBillNo(billNo);
        settlementInfo.setOrderNo(orderNo);
        settlementInfo.setOrderNo(orderNo);
        settlementInfo.setRefundAmount(new BigDecimal(15.2));
        settlementInfoMapper.insertSelective(settlementInfo);
    }


    public void addDetail(String billNo, String orderNo, String status) {
        ReceiveBillDetail receiveBillInfo = new ReceiveBillDetail();
        Long aLong = UIdHelper.nextId();
        log.info("detailId : {}", aLong);
        receiveBillInfo.setId(aLong);
        receiveBillInfo.setBillNo(billNo);
        receiveBillInfo.setOrderNo(orderNo);
        receiveBillInfo.setProcessStatus(status);
        receiveBillInfo.setSequence(UIdHelper.nextStrId());
        receiveBillInfo.setBarCode("barcode_" + UIdHelper.nextId());
        receiveBillInfo.setMaterialCode("material_code" + UIdHelper.nextId());
        receiveBillInfo.setSizeCode("32");
        receiveBillInfo.setAmount(20);
        receiveBillInfo.setPrice(new BigDecimal(102.00));
        receiveBillInfo.setRetailPrice(new BigDecimal(212.2));

        ReceiveBillDetail receiveBillInfo2 = new ReceiveBillDetail();
        Long aLong2 = UIdHelper.nextId();
        log.info("detailId : {}", aLong2);
        receiveBillInfo2.setId(aLong2);
        receiveBillInfo2.setBillNo(billNo);
        receiveBillInfo2.setOrderNo(orderNo);
        receiveBillInfo2.setProcessStatus(status);
        receiveBillInfo2.setSequence(UIdHelper.nextStrId());
        receiveBillInfo2.setBarCode("barcode_" + UIdHelper.nextId());
        receiveBillInfo2.setMaterialCode("material_code" + UIdHelper.nextId());
        receiveBillInfo2.setSizeCode("32");
        receiveBillInfo2.setAmount(14);
        receiveBillInfo2.setPrice(new BigDecimal(200.00));
        receiveBillInfo2.setRetailPrice(new BigDecimal(2.23));
        detailMapper.insertSelective(receiveBillInfo);
        detailMapper.insertSelective(receiveBillInfo2);

    }

    private WarehouseInfo getWh() {
        int i = RandomUtils.nextInt(0, 5);
        return warehouseInfoMap.get(i);
    }

    private String getChannel() {
        int i = RandomUtils.nextInt(0, 5);
        return channelList.get(i);
    }

    private String getBizTye() {
        int i = RandomUtils.nextInt(0, 5);
        return bizTypeList.get(i);
    }

    private String getSource() {
        int i = RandomUtils.nextInt(0, 5);
        return billSourceList.get(i);
    }


}
