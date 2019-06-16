package com.weweibuy.webuy.learning.sharing.service;

import com.baidu.fsg.uid.UidGenerator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weweibuy.webuy.learning.sharing.mapper.JitTimeOrderDetailMapper;
import com.weweibuy.webuy.learning.sharing.mapper.JitTimeOrderHeaderMapper;
import com.weweibuy.webuy.learning.sharing.model.dto.PageQueryDto;
import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderDetail;
import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderDetailExample;
import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderHeader;
import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderHeaderExample;
import com.weweibuy.webuy.learning.sharing.model.vo.PageQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/6/16 10:28
 **/
@Service
@Slf4j
public class TimeOrderService {

    @Autowired
    private JitTimeOrderDetailMapper detailMapper;

    @Autowired
    private JitTimeOrderHeaderMapper headerMapper;

    private static final String WAREHOUSE_NAME = "myWareHouse";
    private static final String WAREHOUSE_CODE = "myWareCode";
    private static final String VENDOR_CODE = "myVendorCode";
    private static final String VENDOR_NAME = "myVENDOR_NAME";
    private static final String CHANNEL_CODE = "jit";

    @Autowired
    private UidGenerator uidGenerator;


    public PageQueryDto getHeaders(PageQueryVo vo) {
        Page<Object> objects = PageHelper.startPage(vo.getPage(), vo.getSize());

        JitTimeOrderHeaderExample example = new JitTimeOrderHeaderExample();
        example.createCriteria()
                .andCreateTimeBetween(vo.getStartTime(), vo.getEndTime());

        List<JitTimeOrderHeader> orderHeaders = headerMapper.selectByExample(example);
        log.error("总记录数: {}, 查询的数量: {}", objects.getTotal(), orderHeaders.size());
        PageQueryDto<JitTimeOrderHeader> queryDto = new PageQueryDto<>(objects.getTotal(), orderHeaders);
        return queryDto;
    }


    public void insertOrder() {
        JitTimeOrderHeader header = null;
        for (int i = 0; i < 50; i++) {
            String s = uidGenerator.getUID() + "";
            header = new JitTimeOrderHeader();
            header.setTimeOrderNo(s);
            header.setWarehouseName(WAREHOUSE_NAME);
            header.setWarehouseCode(WAREHOUSE_CODE);
            header.setVendorCode(VENDOR_CODE);
            header.setVendorName(VENDOR_NAME);
            header.setChannelCode(CHANNEL_CODE);
            for (int j = 0; j < 10; j++) {
                JitTimeOrderDetail detail = new JitTimeOrderDetail();
                detail.setTimeOrderNo(s);
                detail.setBarcode(uidGenerator.getUID() + "");
                detail.setTotalQty(i);
                detail.setWarehouseCode(WAREHOUSE_CODE);
                detail.setVendorCode(VENDOR_CODE);
                detailMapper.insertSelective(detail);
            }
            headerMapper.insertSelective(header);
        }
    }


    public List<JitTimeOrderDetail> getDetailByOrderNo(String no) {
        JitTimeOrderDetailExample example = new JitTimeOrderDetailExample();
        example.createCriteria()
                .andTimeOrderNoEqualTo(no);
        return detailMapper.selectByExample(example);
    }
}
