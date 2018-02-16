package com.iot.sale.Service.service.impl;

import com.alibaba.fastjson.JSON;
import com.iot.sale.Base.util.Pager;
import com.iot.sale.Service.bean.response.good.GetGoodResponse;
import com.iot.sale.Service.bean.response.good.GetHomeListResponse;
import com.iot.sale.Service.bean.vo.Album;
import com.iot.sale.Service.bean.vo.GoodInfoSimple;
import com.iot.sale.Service.dao.FruitGoodAlbumDao;
import com.iot.sale.Service.dao.FruitGoodDao;
import com.iot.sale.Service.dao.FruitGoodMenuDao;
import com.iot.sale.Service.entity.FruitGood;
import com.iot.sale.Service.entity.FruitGoodAlbum;
import com.iot.sale.Service.service.GoodService;
import com.xiaoleilu.hutool.json.JSONArray;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/2
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private FruitGoodDao fruitGoodDao;

    @Autowired
    private FruitGoodAlbumDao fruitGoodAlbumDao;

    @Autowired
    private FruitGoodMenuDao fruitGoodMenuDao;

    @Override
    public List<Map<String, Object>> getGoodListInHome() {
        return fruitGoodDao.findAll();
    }

    @Override
    public HashMap<String, Object> getGoodListInHometest(int pageNum) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Pager<FruitGood> pager = new Pager<>(GoodService.PAGE_SIZE, 0L, pageNum);
        //Pager的构造函数中会根据totalCount来确认currentPage,所以强行搞一下!F***
        pager.setCurrentPage(pageNum);
        fruitGoodDao.findAllPage(pager);
        List<FruitGood> resultList = pager.getDataList();
        resultMap.put("list", pager.getDataList());
        resultMap.put(GoodService.KEY_CUEENT_PAGE_NUM, pager.getCurrentPage());
        if(resultList==null || resultList.isEmpty() ||
                resultList.size()< pager.getPageSize()){
            resultMap.put(GoodService.KEY_HAS_NEXT, false);
            return resultMap;
        }
        resultMap.put(GoodService.KEY_HAS_NEXT, true);
        return resultMap;
    }

    @Override
    public GetHomeListResponse getGoodListInHome(int pageNum) {
        GetHomeListResponse getHomeListResponse = new GetHomeListResponse();
        getHomeListResponse.setPageNum(pageNum);
        List<GoodInfoSimple> resultList = new ArrayList<>();
        Pager<FruitGood> pager = new Pager<>(GoodService.PAGE_SIZE, 0L, pageNum);
        //Pager的构造函数中会根据totalCount来确认currentPage,所以强行搞一下!F***
        pager.setCurrentPage(pageNum);
        fruitGoodDao.findAllPage(pager);
        List<FruitGood> goodList = pager.getDataList();
        getHomeListResponse.setList(resultList);
        if (goodList == null || goodList.isEmpty()) {
            getHomeListResponse.setHasNext(false);
        } else{
            getHomeListResponse.setHasNext(true);
            for (FruitGood good : goodList) {
                GoodInfoSimple goodInfoSimple = new GoodInfoSimple();
                goodInfoSimple.setId(good.getId());
                goodInfoSimple.setPrice(good.getPrice());
                goodInfoSimple.setTitle(good.getTitle());
                String imageId = good.getShow();
                FruitGoodAlbum fruitGoodAlbum = fruitGoodAlbumDao.findById(imageId);
                goodInfoSimple.setShow(fruitGoodAlbum.getValue());
                resultList.add(goodInfoSimple);
              }
        }
        return getHomeListResponse;
    }

    @Override
    public GetGoodResponse getGood(String id) {
        GetGoodResponse getGood = new GetGoodResponse();
        FruitGood fruitGood = fruitGoodDao.findById(id);

        if(fruitGood != null){
            // 他娘的一比一手动转
            getGood.setId(fruitGood.getId());
            getGood.setKindId(fruitGood.getKindId());
            getGood.setMenuId(fruitGood.getMenuId());
            getGood.setClassify(fruitGood.getClassify());
            getGood.setClick(fruitGood.getClick());
            getGood.setDiscount(fruitGood.getDiscount());
            getGood.setFavourable(fruitGood.getFavourable());
            getGood.setPrice(fruitGood.getPrice());
            getGood.setSort(fruitGood.getSort());
            getGood.setStatus(fruitGood.getStatus());
            getGood.setType(fruitGood.getType());
            getGood.setTitle(fruitGood.getTitle());
            getGood.setAuthor(fruitGood.getAuthor());
            getGood.setColor(fruitGood.getColor());
            getGood.setContent(fruitGood.getContent());
            getGood.setId(fruitGood.getStatus());
            getGood.setContentUrl(fruitGood.getContentUrl());
            getGood.setCreateTime(fruitGood.getCreateTime());
            getGood.setUpdateTime(fruitGood.getUpdateTime());
            getGood.setGoodDesc(fruitGood.getGoodDesc());
            getGood.setSourceMd5(fruitGood.getSourceMd5());


            JSONArray banners = JSONUtil.parseArray(fruitGood.getBanner());
            List<FruitGoodAlbum> fruitGoodAlbum = fruitGoodAlbumDao.findObjsByIds(banners);
            List<Album> bannerList = new ArrayList<>();
            for(FruitGoodAlbum fruitGoodAlbum1 : fruitGoodAlbum){
                Album album = new Album();
                album.setId(fruitGoodAlbum1.getId());
                album.setValue(fruitGoodAlbum1.getValue());
                album.setAlt(fruitGoodAlbum1.getAlt());
                album.setCreateTime(fruitGoodAlbum1.getCreateTime());
                album.setUpdateTime(fruitGoodAlbum1.getUpdateTime());

                bannerList.add(album);
            }

            getGood.setBanner(bannerList);


            FruitGoodAlbum fruitGoodAlbumShow = fruitGoodAlbumDao.findById(fruitGood.getShow());
            getGood.setShow(fruitGoodAlbumShow.getValue());
        }

        return getGood;
    }

    @Override
    public FruitGood getGoodJson(String id) {
        FruitGood fruitGood = fruitGoodDao.findById(id);

        JSONArray banners = JSONUtil.parseArray(fruitGood.getBanner());
        List<FruitGoodAlbum> fruitGoodAlbum = fruitGoodAlbumDao.findObjsByIds(banners);
        List<String> bannerList = new ArrayList<>();
        for(FruitGoodAlbum fruitGoodAlbum1 : fruitGoodAlbum){
            bannerList.add(fruitGoodAlbum1.getValue());
        }
        fruitGood.setBanner(JSON.toJSONString(bannerList));


        FruitGoodAlbum fruitGoodAlbumShow = fruitGoodAlbumDao.findById(fruitGood.getShow());
        fruitGood.setShow(fruitGoodAlbumShow.getValue());

        return fruitGood;
    }

    @Override
    public List<Object> queryCategoriesTree() {
        List<Map<String, Object>> cateList = fruitGoodMenuDao.findAll();
        return this.getTree(cateList, "0");
    }

    private List<Object> getTree(List<Map<String, Object>> cateLists, String pid) {
        List<Object> list = new ArrayList<>();
        for (Map<String, Object> cateList : cateLists) {
            if (cateList.get("pid").toString().equals(pid)) {
                List<Object> subList = this.getTree(cateLists, String.valueOf(cateList.get("id")));
                if (subList != null) {
                    cateList.put("list", subList);
                }
                list.add(cateList);
            }
        }
        return list;
    }
}
