package com.shop.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.*;
import java.io.File;
import java.util.List;

@Slf4j
@Service
public class MailService {
    @Value("${spring.mail.username}")
    private String MAIL_SENDER; //邮件发送者

    @Resource
    private JavaMailSender javaMailSender;


    /**
     * 发送有附件的邮件  单个附件
     * @param mailBean
     * @return boolean true： 发送成功 fasle： 发送失败
     */
    public boolean sendMail(MailBean mailBean) {
        long st = System.currentTimeMillis();
        try {
            log.info("mail send info {}",mailBean);
            if(CollectionUtils.isEmpty(mailBean.getRecipients())){
                log.warn("mail send fail ---> :{ *注: 发送对象为空 }");
                return false;
            }
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //发送人
            helper.setFrom(MAIL_SENDER);
            //接收人
            message.addRecipients(Message.RecipientType.TO, handleRecipients(mailBean));
            //主题
            message.setSubject(mailBean.getSubject());
            //内容
            message.setContent(handleContent(mailBean));
            javaMailSender.send(message);
            log.info("mail send success");
            return true;
        } catch (Exception e) {
            log.error("mail send error :{}", e);
            return false;
        }finally {
            log.info("mail send use time all :"+(System.currentTimeMillis()-st)+"ms");
        }
    }

    /**
     * 组装内容
     * @param mailBean
     * @return Multipart
     * @throws MessagingException
     */
    private Multipart handleContent(MailBean mailBean) throws MessagingException {
        // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
        Multipart multipart = new MimeMultipart();
        // 添加邮件正文
        multipart.addBodyPart(handleContentBody(mailBean.getContent()));
        //添加附件
        addFEnclosure(multipart,mailBean);
        return multipart;
    }
    /**
     * 组装接收人
     * @param mailBean
     * @return arr
     * @throws AddressException
     */
    private InternetAddress[] handleRecipients(MailBean mailBean) throws AddressException {
        List<String> recipients = mailBean.getRecipients();
        if(CollectionUtils.isEmpty(recipients)){
            return null;
        }
        InternetAddress[] address = new InternetAddress[recipients.size()];
        for (int i = 0; i < recipients.size(); i++) {
            address[i] = new InternetAddress(recipients.get(i));
        }
        return address;
    }
    /**
     * 添加附件
     * @param multipart
     * @param mailBean
     * @throws MessagingException
     */
    private void addFEnclosure(Multipart multipart,MailBean mailBean) throws MessagingException {
        //添加多个附件
        List<File> files = mailBean.getFiles();
        if(CollectionUtils.isEmpty(files)){
            return;
        }
        for(File file:files){
            multipart.addBodyPart(handleBodyPart(file));
        }
    }
    /**
     * 组装正文内容
     * @param content
     * @return BodyPart
     * @throws MessagingException
     */
    private BodyPart handleContentBody(String content) throws MessagingException {
        BodyPart contentPart = new MimeBodyPart();
        contentPart.setContent(content, "text/html;charset=UTF-8");
        return contentPart;
    }
    /**
     * 组装附件
     * @param file
     * @return BodyPart
     * @throws MessagingException
     */
    private BodyPart handleBodyPart(File file) throws MessagingException {
        //添加附件
        BodyPart bodyPartFile = new MimeBodyPart();
        bodyPartFile.setDataHandler(new DataHandler(new FileDataSource(file)));
        String fileName = file.getName();
        bodyPartFile.setFileName(fileName);
        return bodyPartFile;
    }
}
