package com.weweibuy.webuy.learning.sharing.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weweibuy.webuy.learning.sharing.manager.DispatchManager;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillDetailMapper;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillInfoMapper;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillSettlementInfoMapper;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillWarehouseInfoMapper;
import com.weweibuy.webuy.learning.sharing.model.dto.PageQueryDto;
import com.weweibuy.webuy.learning.sharing.model.po.*;
import com.weweibuy.webuy.learning.sharing.model.vo.DispatchPageQueryVo;
import com.weweibuy.webuy.learning.sharing.model.vo.WarehouseInfo;
import com.weweibuy.webuy.learning.sharing.utils.UIdHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
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
    private DispatchManager dispatchManager;

    @Autowired
    private ReceiveService receiveService;

    @Autowired
    private Executor executor;

    private Map<Integer, WarehouseInfo> warehouseInfoMap = new HashedMap<>();

    {
        warehouseInfoMap.put(0, new WarehouseInfo("WH112230", "上海0仓", (short) 0));
        warehouseInfoMap.put(1, new WarehouseInfo("WH112231", "上海1仓", (short) 1));
        warehouseInfoMap.put(2, new WarehouseInfo("WH112232", "上海2仓", (short) 2));
        warehouseInfoMap.put(3, new WarehouseInfo("WH112233", "上海3仓", (short) 3));
        warehouseInfoMap.put(4, new WarehouseInfo("WH112234", "上海4仓", (short) 4));
    }

    private List<String> channelList = new ArrayList<>();

    {
        channelList.add("jit");
        channelList.add("bbc");
        channelList.add("b2b");
        channelList.add("b2c");
        channelList.add("oxo");
    }

    private List<String> bizTypeList = new ArrayList<>();

    {
        bizTypeList.add("biz_type_jit");
        bizTypeList.add("biz_type_bbc");
        bizTypeList.add("biz_type_b2b");
        bizTypeList.add("biz_type_b2c");
        bizTypeList.add("biz_type_oxo");
    }

    private List<String> billSourceList = new ArrayList<>();

    {
        billSourceList.add("tb");
        billSourceList.add("jd");
        billSourceList.add("sn");
        billSourceList.add("tm");
        billSourceList.add("vip");
    }

    @Transactional
    public void addAll(){
        addHeaderAndDetail();
        receiveService.addHeaderAndDetail();
    }

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
        dispatchBillInfo.setBillType("bill_type_" + getBizTye());
        dispatchBillInfo.setBizType("发货" + getBizTye());
        dispatchBillInfo.setBillSource(getSource());
        dispatchBillInfo.setBillStatus("0");
        dispatchBillInfo.setProcessStatus(processStatus);
        dispatchBillInfo.setChannelCode(getChannel());
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
        addDetail(billNo, orderNo, processStatus);

        billInfoMapper.insertSelective(dispatchBillInfo);
        addWarehouseInfo(aLong, billNo, orderNo);

        addSettlementInfoInfo(aLong, billNo, orderNo);

    }


    public void addWarehouseInfo(Long hid, String billNo, String orderNo) {
        DispatchBillWarehouseInfo warehouseInfo = new DispatchBillWarehouseInfo();
        warehouseInfo.setDispatchBillInfoId(hid);
        warehouseInfo.setId(UIdHelper.nextId());
        warehouseInfo.setBillNo(billNo);
        warehouseInfo.setOrderNo(orderNo);
        WarehouseInfo wh = getWh();
        warehouseInfo.setBwWarehouseCode("325" + wh.getWarehouseCode());
        warehouseInfo.setWarehouseCode(wh.getWarehouseCode());
        warehouseInfo.setWarehouseId(wh.getWarehouseCode());
        warehouseInfo.setWarehouseName(wh.getWarehouseName());
        warehouseInfo.setWarehouseType(wh.getWarehouseType());
        warehouseInfo.setExpectOutTime(new Date());
        warehouseInfo.setExpressBillNo("express_no_" + UIdHelper.nextId());
        warehouseInfo.setExpectOutTime(new Date());
        warehouseInfo.setExpressType("空运");
        warehouseInfo.setFreightCompanyCode("my_freight_company_code");
        warehouseInfo.setFreightModeFlag(true);
        warehouseInfo.setAllocateModeCode("my_move_mode_code");
        warehouseInfo.setAllocatePriority("first");
        warehouseInfo.setAllocateType("同仓");
        warehouseInfo.setAllocateModeName("自提");
        warehouseInfo.setTransportMethodName("my_transport_method");
        warehouseInfo.setTransportMethodCode("my_transport_code");
        warehouseInfo.setInterWarehouseCode("my_inter_warehouse_code");
        warehouseInfo.setInterWarehouseName("my_inter_warehouse_name");
        warehouseInfo.setInterWarehouseType((short) 1);
        warehouseInfoMapper.insertSelective(warehouseInfo);
    }

    public void addSettlementInfoInfo(Long hid, String billNo, String orderNo) {
        DispatchBillSettlementInfo settlementInfo = new DispatchBillSettlementInfo();
        settlementInfo.setDispatchBillInfoId(hid);
        settlementInfo.setId(UIdHelper.nextId());
        settlementInfo.setBillNo(billNo);
        settlementInfo.setOrderNo(orderNo);
        settlementInfo.setOrderNo(orderNo);
        settlementInfo.setPaymentType((short) 1);
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


    public PageQueryDto pageQuery(DispatchPageQueryVo dispatchPageQueryVo) {
        Page<Object> objects = PageHelper.startPage(dispatchPageQueryVo.getPage(), dispatchPageQueryVo.getSize());
        DispatchBillInfoExample example = new DispatchBillInfoExample();
        DispatchBillInfoExample.Criteria criteria = example.createCriteria();
        dispatchPageQueryVo.getChannel().ifPresent(i -> criteria.andChannelCodeEqualTo(i));
        dispatchPageQueryVo.getBillSource().ifPresent(i -> criteria.andBillSourceEqualTo(i));
        dispatchPageQueryVo.getBizType().ifPresent(i -> criteria.andBizTypeEqualTo(i));
        dispatchPageQueryVo.getStartTime().ifPresent(i -> criteria.andCreateTimeBetween(i, dispatchPageQueryVo.getEndTime().get()));
        Optional<List<DispatchPageQueryVo.Order>> orderList = dispatchPageQueryVo.getOrderList();
        OrderString orderString = new OrderString();
        orderList.ifPresent(list -> {
            list.forEach(i -> {
                orderString.appendKV(i.getFiled(), i.getValue());
            });
        });
        example.setOrderByClause(orderString.getFinalSql());
        List<DispatchBillInfo> dispatchBillInfos = billInfoMapper.selectByExample(example);
        return new PageQueryDto(objects.getTotal(), dispatchBillInfos);
    }

    public void updateHeaderAndDetail() {
        Page<Object> objects = PageHelper.startPage(1, 10);
        DispatchBillInfoExample example = new DispatchBillInfoExample();
        example.createCriteria().andBillStatusEqualTo("0");
        example.setOrderByClause("create_time asc");
        List<DispatchBillInfo> dispatchBillInfoList = billInfoMapper.selectByExample(example);
        dispatchBillInfoList.forEach(i -> {
            dispatchManager.updateDispatch(i.getBillNo());
        });

    }

    @Data
    private class OrderString {

        private String orderSql = "";

        public void appendKV(String key, String v) {
            orderSql += key;
            orderSql += " ";
            orderSql += v;
            orderSql += ",";
        }

        public String getFinalSql() {
            if (orderSql.equals(",")) {
                return orderSql.substring(0, orderSql.length() - 1);
            } else {
                return null;
            }
        }

    }

}
