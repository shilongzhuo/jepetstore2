package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Verification;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationMapper {

    //创建验证码
    public void creatVerificationCodeByUsername(String username,String code);

    //更新验证码
    public void updateVerificationCodeByUsername(String username,String code);

    //删除验证码
    public void delVerificationCodeByUsername(String username);

    //查询验证码
    public Verification getVerificationCodeByUsername(String username);
}
