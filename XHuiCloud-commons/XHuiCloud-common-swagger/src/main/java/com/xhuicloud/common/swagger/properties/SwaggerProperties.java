package com.xhuicloud.common.swagger.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: XHuiCloud
 * @description: SwaggerProperties
 * @author: Sinda
 * @create: 2019-12-25 22:36
 **/
@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    /**
     * 标题
     **/
    private String title = "";

    /**
     * 描述
     **/
    private String description = "";

    /**
     * 授权
     **/
    private String license = "";

    /**
     * 授权地址
     **/
    private String licenseUrl = "";

    /**
     * 服务条款URL
     **/
    private String termsOfServiceUrl = "";

    /**
     * 版本
     **/
    private String version = "";

    /**
     * host信息
     **/
    private String host = "";

    /**
     * swagger解析包路径
     **/
    private String basePackage = "";

    /**
     * 联系人信息
     */
    private Contact contact = new Contact();

    /**
     * swagger会解析的url规则
     **/
    private List<String> basePath = new ArrayList<>();

    /**
     * 在basePath基础上需要排除的url规则
     **/
    private List<String> excludePath = new ArrayList<>();


    @Data
    @NoArgsConstructor
    public static class Contact {
        /**
         * 联系人
         **/
        private String name = "";

        /**
         * 联系人url
         **/
        private String url = "";

        /**
         * 联系人email
         **/
        private String email = "";
    }

}
