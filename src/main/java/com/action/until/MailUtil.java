package com.action.until;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
    static Properties properties;
    static Message msg;
    static Transport transport;
    //初始化Mail信息
    public MailUtil(){
        properties = new Properties();

        properties.setProperty("mail.debug", "true");//调试模式发送
        properties.setProperty("mail.smtp.auth", "true");//身份验证设置
        properties.setProperty("mail.host", "smtp.163.com");//发件人邮箱主机名
        properties.setProperty("mail.transport.protocol", "smtp");//发件协议

        Session session = Session.getInstance(properties);

        msg = new MimeMessage(session);

        try {
            msg.setSubject("xxx网站验证邮件");
            msg.setFrom(new InternetAddress("17815910510@163.com"));//设置发件人

            transport = session.getTransport();
            transport.connect("17815910510@163.com", "7899.8");//设置发件人在该邮箱主机上的用户名密码
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    /**
     * 得到邮箱地址邮箱内容发送。
     * @param //邮箱地址
     * @param //邮箱内容
     * @throws AddressException
     * @throws MessagingException
     */

    public void sendMail(String address,String text) throws AddressException, MessagingException{
        msg.setText(text);
        transport.sendMessage(msg, new Address[] {new InternetAddress(address)});
        transport.close();
    }
    private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private static Random random = new Random();
    public static String getRandomString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 4; i++)
        {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }

        return buffer.toString();
    }


}
