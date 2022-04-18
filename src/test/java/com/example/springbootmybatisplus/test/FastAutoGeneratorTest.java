package com.example.springbootmybatisplus.test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 快速生成
 */
public class FastAutoGeneratorTest {

    /**
     * 数据源配置
     */
    private static final String URL = "jdbc:mariadb://localhost:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG =
            new DataSourceConfig
                    .Builder(URL, USER_NAME, PASSWORD);

    private static final String JAVA_PAHT = System.getProperty("user.dir") + "/src/main/java";

    private static final String XML_PAHT = System.getProperty("user.dir") + "/src/main/resources/dao";

    /**
     * 执行run
     *
     * @param args
     */
    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                /*全局配置(GlobalConfig)
                fileOverride	覆盖已生成文件	默认值:false
                disableOpenDir	禁止打开输出目录	默认值:true
                outputDir(String)	指定输出目录	/opt/baomidou/ 默认值: windows:D:// linux or mac : /tmp
                author(String)	作者名	baomidou 默认值:作者
                enableKotlin	开启 kotlin 模式	默认值:false
                enableSwagger	开启 swagger 模式	默认值:false
                dateType(DateType)	时间策略	DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                commentDate(String)	注释日期	默认值: yyyy-MM-dd*/
                .globalConfig(builder -> {
                    builder.author("6464")
                            .outputDir(JAVA_PAHT)
                            .disableOpenDir();
                })
                /*包配置(PackageConfig)
                方法	说明	示例
                parent(String)	父包名	默认值:com.baomidou
                moduleName(String)	父包模块名	默认值:无
                entity(String)	Entity 包名	默认值:entity
                service(String)	Service 包名	默认值:service
                serviceImpl(String)	Service Impl 包名	默认值:service.impl
                mapper(String)	Mapper 包名	默认值:mapper
                xml(String)	Mapper XML 包名	默认值:mapper.xml
                controller(String)	Controller 包名	默认值:controller
                other(String)	自定义文件包名	输出自定义文件时所用到的包名
                pathInfo(Map<OutputFile, String>)	路径配置信息	Collections.singletonMap(OutputFile.mapperXml, "D://")*/
                .packageConfig(builder -> {
                    builder.parent("com.example.springbootmybatisplus")
                            .moduleName("user")
                            .entity("vo")
                            .mapper("dao")
                            .xml("dao.xml")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, XML_PAHT));
                })
                /*策略配置(StrategyConfig)
                方法	说明	示例
                enableCapitalMode	开启大写命名	默认值:false
                enableSkipView	开启跳过视图	默认值:false
                disableSqlFilter	禁用 sql 过滤	默认值:true，语法不能支持使用 sql 过滤表的话，可以考虑关闭此开关
                enableSchema	启用 schema	默认值:false，多 schema 场景的时候打开
                likeTable(LikeTable)	模糊表匹配(sql 过滤)	likeTable 与 notLikeTable 只能配置一项
                notLikeTable(LikeTable)	模糊表排除(sql 过滤)	likeTable 与 notLikeTable 只能配置一项
                addInclude(String...)	增加表匹配(内存过滤)	include 与 exclude 只能配置一项
                addExclude(String...)	增加表排除匹配(内存过滤)	include 与 exclude 只能配置一项
                addTablePrefix(String...)	增加过滤表前缀
                addTableSuffix(String...)	增加过滤表后缀
                addFieldPrefix(String...)	增加过滤字段前缀
                addFieldSuffix(String...)	增加过滤字段后缀
                entityBuilder	实体策略配置
                controllerBuilder	controller 策略配置
                mapperBuilder	mapper 策略配置
                serviceBuilder	service 策略配置*/
                .strategyConfig(builder -> {
                    builder.addInclude("user_t") // 设置需要生成的表名
                            .addTableSuffix("_t");
                })
                /*模板配置(TemplateConfig)
                方法	说明	示例
                disable	禁用所有模板
                disable(TemplateType...)	禁用模板	TemplateType.ENTITY
                entity(String)	设置实体模板路径(JAVA)	/templates/entity.java
                entityKt(String)	设置实体模板路径(kotlin)	/templates/entity.java
                service(String)	设置 service 模板路径	/templates/service.java
                serviceImpl(String)	设置 serviceImpl 模板路径	/templates/serviceImpl.java
                mapper(String)	设置 mapper 模板路径	/templates/mapper.java
                mapperXml(String)	设置 mapperXml 模板路径	/templates/mapper.xml
                controller(String)	设置 controller 模板路径	/templates/controller.java*/
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .strategyConfig(builder -> {
                    builder.entityBuilder()
                            .enableLombok()
                            .idType(IdType.ASSIGN_ID)
                            .formatFileName("%sVO")
                            .controllerBuilder()
                            .enableRestStyle()
                            .enableHyphenStyle()
                            .mapperBuilder()
                            .formatMapperFileName("%sDao")
                            .formatXmlFileName("%sDao")
                            .build();
                })
                .execute();
    }

}
