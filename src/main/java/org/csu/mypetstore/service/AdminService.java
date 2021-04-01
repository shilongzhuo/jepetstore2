package org.csu.mypetstore.service;

import org.csu.mypetstore.common.MD5Util;
import org.csu.mypetstore.domain.Admin;
import org.csu.mypetstore.persistence.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Admin getAdmin(String adminId,String password){
        return adminMapper.getAdmin(adminId,MD5Util.md5(password));
    }

    public void insertAdmin(String adminId,String password){
        adminMapper.insertAdmin(adminId, MD5Util.md5(password));
    }
}
