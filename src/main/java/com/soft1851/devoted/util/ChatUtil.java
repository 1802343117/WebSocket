package com.soft1851.devoted.util;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.devoted.domain.entity.TMessages;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12559
 * 使用单例模型管理通信（聊天）
 */
public class ChatUtil {

    // 创建 聊天消息存储容器
    private List<TMessages> messagesList;

    // 创建 聊天消息管理类
    private static ChatUtil chatUtils;

    /**
     * 判断该类对象 chatUtils 是否为空，如果为空则创建对象
     * 否则返回该类对象的值
     * @return
     */
    public static synchronized ChatUtil getChatUtils() {
        if ( chatUtils == null ) {
            chatUtils = new ChatUtil();
        }
        return chatUtils;
    }

    /**
     * 提供创建该类对象方法
     */
    private ChatUtil() {
        this.messagesList = new ArrayList<>();
    }

    /**
     * 添加聊天消息
     * @param message
     */
    public synchronized void addMessages(String message) {
        // 将 message 转换成 TMessages 对象
        JSONObject mess = JSONObject.parseObject(message);
        TMessages tMessages = new TMessages();
        tMessages.setMContent(mess.getString("mContent"));
        tMessages.setMFromUserid(mess.getString("mFromUserId"));
        tMessages.setRoleId(mess.getString("roleId"));
        tMessages.setMToUserid(mess.getString("mToUserId"));
        tMessages.setDeleteFlag(true);
        LocalDateTime localDateTime = LocalDateTime.now();
        tMessages.setGmtCreate(localDateTime);
        tMessages.setGmtModified(localDateTime);
        tMessages.setMTime(localDateTime);

        System.out.println(tMessages);
        this.messagesList.add(tMessages);
    }

    /**
     * 移除容器中所有聊天记录
     */
    public synchronized void delete() {
        this.messagesList.clear();
    }

}