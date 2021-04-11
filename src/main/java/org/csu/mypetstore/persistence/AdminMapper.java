package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    public Admin getAdmin(String adminId,String password);

    public void insertAdmin(String adminId,String password);
}
