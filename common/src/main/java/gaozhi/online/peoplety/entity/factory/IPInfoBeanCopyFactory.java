package gaozhi.online.peoplety.entity.factory;

import gaozhi.online.peoplety.entity.IPInfo;
import gaozhi.online.peoplety.entity.dto.IPInfoDTO;
import gaozhi.online.peoplety.util.StringUtil;
import gaozhi.online.peoplety.util.beans.BeanCopyFactory;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO IPInfo工厂
 * @date 2022/8/2 18:20
 */
public class IPInfoBeanCopyFactory {
    public static class DO2DTO implements BeanCopyFactory<IPInfo, IPInfoDTO> {
        @Override
        public IPInfoDTO copy(IPInfo obj, Class<IPInfoDTO> klass) {
            IPInfoDTO ipInfoDTO = BeanCopyFactory.super.copy(obj, klass);
            ipInfoDTO.setData(StringUtil.json2List(obj.getData()));
            return ipInfoDTO;
        }
    }
    public static class DTO2DO implements BeanCopyFactory<IPInfoDTO, IPInfo> {
        @Override
        public IPInfo copy(IPInfoDTO obj, Class<IPInfo> klass) {
            IPInfo ipInfo = BeanCopyFactory.super.copy(obj, klass);
            ipInfo.setData(StringUtil.list2Json(obj.getData()));
            return ipInfo;
        }
    }
}
