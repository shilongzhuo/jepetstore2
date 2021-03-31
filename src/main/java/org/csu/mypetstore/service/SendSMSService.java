package org.csu.mypetstore.service;

import org.springframework.stereotype.Service;

import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;

//发送手机验证码
@Service
public class SendSMSService {

    private static String accessKeyId = "LTAI5tDAgwgLiED9M935Ugt2";
    private static String accessKeySecret = "VGROV4IPC3KZX5oYuRNQr13A4wFE0N";

    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public void sendSMS(String phoneNumber, String code)throws Exception {

        String template = "{\"code\":\""+code+"\"}";

        com.aliyun.dysmsapi20170525.Client client = SendSMSService.createClient("accessKeyId", "accessKeySecret");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phoneNumber)
                .setSignName("jpetstore学习")
                .setTemplateCode("mypetstore验证码")
                .setTemplateParam(template);
        // 打印返回信息
        System.out.println(client.sendSms(sendSmsRequest));

    }

}
