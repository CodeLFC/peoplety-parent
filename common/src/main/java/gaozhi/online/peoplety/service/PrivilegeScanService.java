package gaozhi.online.peoplety.service;

import gaozhi.online.base.privilege.Privilege;
import gaozhi.online.base.privilege.PrivilegesInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Arrays;


/**
* @description: TODO  启动时扫描需要鉴权的API
* @author http://gaozhi.online
* @date 2022/11/21 21:57
* @version 1.0
*/
@Component
@Slf4j
public class PrivilegeScanService implements PrivilegesInitializer {
    private PrivilegeHandler privilegeHandler;

    public void setPrivilegeHandler(PrivilegeHandler privilegeHandler) {
        this.privilegeHandler = privilegeHandler;
    }

    @Override
    public void handlePrivilege(Privilege klass, Privilege method, String[] fullUrl, String[] methodUrl) {
        log.info("扫描到需要鉴权的接口：{}-{}-{}-{}",klass.name(),method.name(),Arrays.toString(fullUrl), Arrays.toString(methodUrl));
        for(String kUrl:fullUrl){
            for(String mUrl:methodUrl){
                if(kUrl.endsWith(mUrl)){
                    //找到对应的方法
                    log.info("找到路径匹配的方法:类URL：{},方法URL:{}",kUrl,mUrl);
                    gaozhi.online.peoplety.entity.Privilege klassPrivilege = new gaozhi.online.peoplety.entity.Privilege();
                    //一级权限
                    klassPrivilege.setFirstUrl(kUrl.substring(0,kUrl.length() - mUrl.length()));
                    klassPrivilege.setSubUrl("*");
                    klassPrivilege.setUrl(klassPrivilege.getFirstUrl()+klassPrivilege.getSubUrl());
                    klassPrivilege.setName(klass.name());
                    klassPrivilege.setDescription(klass.description());
                    insertOrUpdate(klassPrivilege);
                    //二级权限
                    gaozhi.online.peoplety.entity.Privilege privilege = new gaozhi.online.peoplety.entity.Privilege();
                    privilege.setUrl(kUrl);
                    privilege.setFirstUrl(klassPrivilege.getFirstUrl());
                    privilege.setSubUrl(mUrl);
                    privilege.setName(method.name());
                    privilege.setDescription(method.description());
                    insertOrUpdate(privilege);
                    break;
                }
            }
        }
    }
    private void insertOrUpdate(gaozhi.online.peoplety.entity.Privilege privilege){
        if(privilegeHandler!=null){
            privilegeHandler.handle(privilege);
        }else{
            log.info("未注入权限处理器 PrivilegeHandler: 权限未处理:{}", privilege);
        }
    }
    /**权限处理者*/
    public interface PrivilegeHandler{
        void handle(gaozhi.online.peoplety.entity.Privilege privilege);
    }
}
