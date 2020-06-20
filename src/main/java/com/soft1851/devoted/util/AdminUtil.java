package com.soft1851.devoted.util;

import com.alibaba.fastjson.JSONObject;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 12559
 * 使用单例模型管理通信用户（管理员）
 */
public class AdminUtil {

    // 静态的 AdminUtil 表明该对象只有一个
    private static AdminUtil adminUtil;

    private List<Session> list;

    /**
     * 仅允许创建一次该类对象
     *
     * @return
     */
    public static synchronized AdminUtil getAdminUtil() {
        if (adminUtil == null) {
            adminUtil = new AdminUtil();
        }
        return adminUtil;
    }

    /**
     * 无参构造器，提供参加该类对象
     * 在创建对象的同时 创建存储空间
     */
    private AdminUtil() {
        this.list = new ArrayList<>();
    }

    /**
     * 添加通信用户(管理员)
     *
     * @param session
     */
    public synchronized void addAdmin(Session session) {
        this.list.add(session);
        System.out.println(this.list.toString());
    }

    /**
     * 向指定用户推送消息
     *
     * @param message
     */
    public synchronized void sending(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        String i = jsonObject.getString("userPath");
        String mess = jsonObject.getString("mContent");
        try {
            this.list.get(Integer.parseInt(i)).getBasicRemote().sendText(mess);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 管理员退出后删除其通信通道
     *
     * @param session
     */
    public synchronized void delete(Session session) {
        Iterator<Session> it = this.list.iterator();
        while (it.hasNext()) {
            Session sess = (Session) it.next();
            if (session.equals(sess)) {
                it.remove();
            }
        }
        System.out.println(this.list.toString());
    }

    /**
     * 查看通信用户（管理员）容器中的通信地址
     * @param session
     * @return int
     * 返回 null 说明没有该用户的通信地址
     */
    public synchronized String selectIndex(Session session) {
        // 变量查看 List 集合中 Session 对应的索引
        for (int i = 0; i < this.list.size(); i++) {
            if ( this.list.get(i).equals(session) ) {
                return Integer.toString(i);
            }
        }
        return null;
    }
}
