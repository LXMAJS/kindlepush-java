package com.lxmajs.library.websocket;

import com.lxmajs.library.util.WebsocketUtil;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * websocket接口处理类
 */
@Component
@ServerEndpoint ( value = "/chat/{usernick}" )
public class WebsocketController {

    /**
     * 连接事件，加入注解
     * @param userNick
     * @param session
     */
    @OnOpen
    public void OnOpen( @PathParam  ( value = "usernick" ) String userNick, Session session ) {
        String message ="有新游客[" + userNick + "]加入聊天室!";

        // 添加到session的映射关系中
        WebsocketUtil.addSession ( userNick, session );
        WebsocketUtil.sendMessageForAll ( message );
    }
}
