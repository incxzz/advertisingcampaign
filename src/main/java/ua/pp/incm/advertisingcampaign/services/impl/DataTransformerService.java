package ua.pp.incm.advertisingcampaign.services.impl;

import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

import ua.pp.incm.advertisingcampaign.services.IDataTransformerService;

@Service
public class DataTransformerService implements IDataTransformerService
{

   @Override
   public String getStringFromList(List<? extends Object> list, char separator)
   {
      StringBuilder result = new StringBuilder();
      StringUtils.join(list, separator, (item) -> {return item != null ? item.toString() : "";}, result);
      return result.toString();
   }

}
