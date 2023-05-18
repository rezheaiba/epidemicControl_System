package com.rzab.service;

import com.rzab.dao.AddressChangeDao;
import com.rzab.pojo.AddressChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-19 19:03
 **/

@Service
public class AddressChangeService {
    @Qualifier("addressChangeDao")
    @Autowired
    private AddressChangeDao addressChangeDao;

    public void insertAddressChange(AddressChange addressChange){
        addressChangeDao.insertAddressChange(addressChange);
    }

    public List<AddressChange> selectAllArsChange(){
        return addressChangeDao.selectAllArsChange();
    }
}
