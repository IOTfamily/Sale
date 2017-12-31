package com.iot.sale.Service.service.impl;

import com.iot.sale.Service.dao.FruitGoodListDao;
import com.iot.sale.Service.service.GoodListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by luxiaolin on 17/12/31.
 */
@Service
public class GoodListServiceImpl implements GoodListService {

    @Autowired
    FruitGoodListDao mFruitGoodListDao;

    @Override
    public List<Map<String, Object>> getGoodListInHome() {
        return mFruitGoodListDao.findAll();
    }
}
