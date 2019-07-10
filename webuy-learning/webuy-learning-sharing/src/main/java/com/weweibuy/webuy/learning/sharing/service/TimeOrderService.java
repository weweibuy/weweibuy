package com.weweibuy.webuy.learning.sharing.service;

import com.baidu.fsg.uid.UidGenerator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weweibuy.webuy.learning.sharing.mapper.JitTimeOrderDetailMapper;
import com.weweibuy.webuy.learning.sharing.mapper.JitTimeOrderHeaderLimitMapper;
import com.weweibuy.webuy.learning.sharing.mapper.JitTimeOrderHeaderMapper;
import com.weweibuy.webuy.learning.sharing.model.dto.PageQueryDto;
import com.weweibuy.webuy.learning.sharing.model.po.*;
import com.weweibuy.webuy.learning.sharing.model.vo.PageQueryVo;
import com.weweibuy.webuy.learning.sharing.utils.HashUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private JitTimeOrderHeaderLimitMapper limitMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private static final String WAREHOUSE_NAME = "myWareHouse";
    private static final String WAREHOUSE_CODE = "myWareCode";
    private static final String VENDOR_CODE = "myVendorCode";
    private static final String VENDOR_NAME = "myVENDOR_NAME";
    private static final String CHANNEL_CODE = "jit";

    @Autowired
    private UidGenerator uidGenerator;


    public PageQueryDto noSharingPageQuery(PageQueryVo vo) {
        Page<Object> objects = PageHelper.startPage(vo.getPage(), vo.getSize());
        JitTimeOrderHeaderLimitExample example = new JitTimeOrderHeaderLimitExample();
        example.createCriteria()
                .andCreateTimeBetween(vo.getStartTime(), vo.getEndTime());
        List<JitTimeOrderHeaderLimit> limitList = limitMapper.selectByExample(example);

        log.error("总记录数: {}, 查询的数量: {}", objects.getTotal(), limitList.size());
        PageQueryDto<JitTimeOrderHeaderLimit> queryDto = new PageQueryDto<>(objects.getTotal(), limitList);
        return queryDto;
    }


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


    public void sharingInsert() {
        log.error("非批量插入");
        long l = System.currentTimeMillis();
        insertOrder(false);
        log.error("非批量插入用时: {}", System.currentTimeMillis() - l);
    }

    public void sharingBatchInsert() {
        log.error("批量插入");
        long l = System.currentTimeMillis();
        insertOrder(true);
        log.error("批量插入用时: {}", System.currentTimeMillis() - l);
    }


    public void noSharingBatchInsert() {
        long l = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            JitTimeOrderHeaderLimitMapper mapper = sqlSession.getMapper(JitTimeOrderHeaderLimitMapper.class);
            JitTimeOrderHeaderLimit header = null;
            for (int i = 0; i < 10; i++) {
                String s = uidGenerator.getUID() + "";
                header = new JitTimeOrderHeaderLimit();
                header.setTimeOrderNo(s);
                header.setWarehouseName("batch_" + WAREHOUSE_NAME);
                header.setWarehouseCode("batch_" + WAREHOUSE_CODE);
                header.setVendorCode("batch_" + VENDOR_CODE);
                header.setVendorName("batch_" + VENDOR_NAME);
                header.setChannelCode("batch_" + CHANNEL_CODE);
                header.setIsDelete(false);
                log.error("orderNo: {}; 库: {}; 表: {}", s, Math.abs(s.hashCode() % 3), Math.abs((s.hashCode() + "").hashCode() % 3));
                mapper.insertSelective(header);
            }
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
            log.error("批量插入用时: {}", System.currentTimeMillis() - l);
        }

    }


    @Transactional(rollbackFor = Exception.class)
    public void insertOrder(boolean isBatch) {
        JitTimeOrderDetailMapper timeOrderDetailMapper;
        JitTimeOrderHeaderMapper timeOrderHeaderMapper;
        SqlSession sqlSession = null;
        if (isBatch) {
            sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
            timeOrderDetailMapper = sqlSession.getMapper(JitTimeOrderDetailMapper.class);
            timeOrderHeaderMapper = sqlSession.getMapper(JitTimeOrderHeaderMapper.class);
        } else {
            timeOrderDetailMapper = detailMapper;
            timeOrderHeaderMapper = headerMapper;
        }
        JitTimeOrderHeader header = null;
        for (int i = 0; i < 10000; i++) {
            String s = uidGenerator.getUID() + "";
            header = new JitTimeOrderHeader();
            header.setTimeOrderNo(s);
            header.setWarehouseName(WAREHOUSE_NAME);
            header.setWarehouseCode(WAREHOUSE_CODE);
            header.setVendorCode(VENDOR_CODE);
            header.setVendorName(VENDOR_NAME);
            header.setChannelCode(CHANNEL_CODE);
            //  TODO 批量操作不适合于 多表; 将造成事务问题
//            for (int j = 0; j < 5; j++) {
//                JitTimeOrderDetail detail = new JitTimeOrderDetail();
//                detail.setTimeOrderNo(s);
//                detail.setBarcode(uidGenerator.getUID() + "");
//                detail.setTotalQty(i);
//                detail.setWarehouseCode(WAREHOUSE_CODE);
//                detail.setVendorCode(VENDOR_CODE);
//                timeOrderDetailMapper.insertSelective(detail);
//            }
            timeOrderHeaderMapper.insertSelective(header);
            log.error("DB: {}, table: {}", Math.abs(s.hashCode()) % 3, Math.abs(HashUtil.FNVHash1(s)) % 3);
        }


        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }

    }


    public List<JitTimeOrderDetail> getDetailByOrderNo(String no) {
        JitTimeOrderDetailExample example = new JitTimeOrderDetailExample();
        example.createCriteria()
                .andTimeOrderNoEqualTo(no);
        return detailMapper.selectByExample(example);
    }
}
