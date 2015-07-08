package com.hztech.framedemo.service.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 定义一个可以上传 并且 可以以URI形式访问的资源存储站
 * Created by Administrator on 2015/5/21.
 */
public interface ResourceServer {

    /**
     * 商家上传的图片
     */
    String CustomerImage = "/uploaded/image/";

    /**
     * 保存资源 并且返回它的token
     *
     * @param data        数据
     * @param orginalName 原始名称
     * @return 一个唯一针对该资源的token 比如 uploaded/...agc.gif
     */
    String saveResource(InputStream data, String orginalName, int customerId, String folder) throws IOException;

    /**
     * 删除资源
     *
     * @param path
     * @return
     * @throws IOException
     */
    void deleteResource(String path) throws IOException;

    /**
     * 根据传入的token返回该资源的uri
     *
     * @param token 资源toke 比如 uploaded/...agc.gif
     * @return uri http://www....gif
     */
    String resourceUri(String token);
}
