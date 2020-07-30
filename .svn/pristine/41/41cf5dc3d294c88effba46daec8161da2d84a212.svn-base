package com.shop.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 邮件发送对象，如果isMoreFile 为true则认为发送多个邮件，需要使用files作为附件容器，否则用file做为附件容器
 * @author xkk
 * @date 2019/12/05
 */
@ToString
@Getter
@Setter
public class MailBean implements Serializable {
    private static final long serialVersionUID = -2116367492649751914L;
    /** 多个邮件接收人*/
    private List<String> recipients = new ArrayList<>();
    /** 邮件主题*/
    private String subject;
    /** 邮件内容*/
    private String content;
    /** 多附件*/
    private List<File> files = new ArrayList<>();

    public MailBean addFile(File file){
        this.files.add(file);
        return this;
    }
    public MailBean addRecipient(String recipient){
        this.recipients.add(recipient);
        return this;
    }
    public MailBean addRecipients(List<String> recipients){
        this.recipients.addAll(recipients);
        return this;
    }
}
