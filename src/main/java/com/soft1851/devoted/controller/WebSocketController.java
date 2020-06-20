package com.soft1851.devoted.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.devoted.domain.entity.TUser;
import com.soft1851.devoted.util.AdminUtil;
import com.soft1851.devoted.util.ChatUtil;
import com.soft1851.devoted.util.MapperUtil;
import com.soft1851.devoted.util.UserUtil;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.List;

/**
 * @author 12559
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocketController {

    private TUser tUser;

    private List<TUser> adminList;

    /**
     * 连接成功时被调用
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("连接成功");
        System.out.println("请求参数" + "\t" + session.getQueryString());
        // 获取前端传入的用户ID
        Integer userId = Integer.parseInt(session.getQueryString());
        // 根据ID获取用户信息
        tUser = MapperUtil.selectById(userId);

        // 获取用户角色并判断角色是否为：客服人员
        Integer role = tUser.getRoleId();
        switch ( role ) {
            case 1:
                // 登录用户为：一般用户
                System.out.println("一般用户");
                UserUtil userUtil = UserUtil.getUserUtils();
                userUtil.addUser(session);
                tUser.setStatus(true);
                tUser.setUserPath(userUtil.selectIndex(session));
                break;
            case 2:
                // 登录用户为：客服人员
                System.out.println("客服人员");
                AdminUtil adminUtil = AdminUtil.getAdminUtil();
                adminUtil.addAdmin(session);
                tUser.setStatus(true);
                tUser.setUserPath(adminUtil.selectIndex(session));
                break;
            default:
                System.out.println("没有该类用户");
        }
        // 将通信地址索引插入该用户的数据库表中
        MapperUtil.updateUserPath(tUser);
    }

    /**
     * 接收到客户端发送的数据时被调用
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("我接收到的信息：" + message);
        // 将聊天消息保存
        ChatUtil chatUtil = ChatUtil.getChatUtils();
        chatUtil.addMessages(message);

        // 将消息 message 转成 jsonObject 对象
        JSONObject jsonObject = JSONObject.parseObject(message);

        // 通过 jsonObject 对象获取 发送者的ID
        String mFromUserId = jsonObject.getString("mFromUserId");
        // 通过 jsonObject 对象获取 接收者的ID、
        String mToUserId = jsonObject.getString("mToUserId");
        // 通过 jsonObject 对象获取 角色的ID、
        String roleId = jsonObject.getString("roleId");

        // 判断消息是否有接收对象
        if ( mToUserId.equals("null") ) {
            // 客服机器人 “ 小 T ”
            try {
                session.getBasicRemote().sendText("我是机器人小T,很高兴为您服务");
                System.out.println("未接入");
                // 获取在线客服的相关消息
                adminList = MapperUtil.selectRsu();
                if ( adminList.size() != 0 ) {
                    // 生成随机数，通过随机数作为索引来分配服务员任务
                    int max = adminList.size();
                    int min = 0;
                    int ran = (int) (Math.random() * max);
                    tUser = adminList.get(ran);

                    // 客服收信地址
                    String adminPath = tUser.getUserPath();
                    // 将信息拼接成JSON字符串
                    String string = "{\"mContent\":\"你好！工号0573\",\"mFromUserId\":\"" + mFromUserId +"\",\"mToUserId\":\""+ tUser.getUserId() +"\",\"roleId\":\"2\",\"userPath\":\"" + adminPath + "\"}";

                    UserUtil userUtils = UserUtil.getUserUtils();
                    userUtils.sending(string);
                } else {
                    session.getBasicRemote().sendText("小T非常抱歉, 暂时没有服务人员在线");
                    session.getBasicRemote().sendText("如果你有什么事情可以说给小T听, 小T虽然不是人...但小T会是您最好的听众");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 判断用户角色, 选择不同的消息发送方式
            switch ( Integer.parseInt(roleId) ) {
                case 1:
                    // 给指定的客服发送消息
                    AdminUtil adminUtil = AdminUtil.getAdminUtil();
                    adminUtil.sending(message);
                    break;
                case 2:
                    // 发送消息给指定用户发送消息
                    UserUtil userUtils = UserUtil.getUserUtils();
                    userUtils.sending(message);
                    break;
                default:
                    System.out.println("没有该类用户");
            }
        }

    }

    /**
     * 连接关闭时被调用
     *
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("我关闭了通信连接");
        UserUtil userUtils = UserUtil.getUserUtils();
        userUtils.delete(session);
        AdminUtil adminUtil = AdminUtil.getAdminUtil();
        adminUtil.delete(session);
        // 用户退出时，将用户数据库中的联系人地址修改为： null（无通讯地址）,用户状态为：false(未接入)
        tUser.setStatus(false);
        tUser.setUserPath("null");
        MapperUtil.updateUserPath(tUser);
    }
}
