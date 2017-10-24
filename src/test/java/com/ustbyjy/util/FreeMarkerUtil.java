package com.ustbyjy.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/10/24
 * Time: 15:41
 */
public class FreeMarkerUtil {
    private static Logger logger = LoggerFactory.getLogger(FreeMarkerUtil.class);

    public static Template getTemplate(String templateFile, Class clazz) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setClassForTemplateLoading(clazz, "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        try {
            return cfg.getTemplate(templateFile);
        } catch (IOException e) {
            logger.error("获取模版文件错误", e);
            return null;
        }
    }

    public static String render(Template template, Map<String, Object> objects) {
        StringWriter stringWriter = new StringWriter(1024);
        if (template == null) {
            return StringUtils.EMPTY;
        }
        try {
            template.process(objects, stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            logger.error("渲染文件错误", e);
            return StringUtils.EMPTY;
        }
    }
}
