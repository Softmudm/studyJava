package com.sz.softmudm.service.serviceImpl;

import com.sz.softmudm.dao.ProvinceDao;
import com.sz.softmudm.modal.Province;
import com.sz.softmudm.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceDao provinceDao;

    @Override
    public List<Province> getProvinceListByFid(int fid) {
        return provinceDao.getProvinceListByFid(fid);
    }

    @Override
    public Province getProvinceByPname(String pname) {
        return provinceDao.getProvinceByPname(pname);
    }

    @Override
    public int getProvinceId() {
        return provinceDao.getProvinceId();
    }

    @Override
    public List<Province> getProvinceListByPname(String pname) {
        List<Province> list = provinceDao.getProvinceListByPname(pname);
        for (Province province : list) {
            province.setList(getProvince(province.getPid()));
        }
        return list;
    }

    @Override
    public Province getCityByPname(String pname, int fid) {
        return provinceDao.getCityByPname(pname,fid);
    }

    @Override
    public Province getProvinceByPid(int pid) {
        return provinceDao.getProvinceByPid(pid);
    }

    @Override
    public int addProvince(Province province) {
        return provinceDao.addProvince(province);
    }

    @Override
    public int addProvince1(Province province) {
        return provinceDao.addProvince1(province);
    }

    @Override
    public int deleteProvince(int pid) {
        //删除子节点
        provinceDao.deleteProvinceByFid(pid);
        return provinceDao.deleteProvinceByPid(pid);
    }

    @Override
    public int updateProvince(Province province) {
        return provinceDao.updateProvince(province);
    }

    @Override
    public List<Province> getProvince(int fid) {
        List<Province> list = provinceDao.getProvinceListByFid(fid);
        for (Province province : list) {
            province.setList(getProvince(province.getPid()));
        }
        return list;
    }
}
