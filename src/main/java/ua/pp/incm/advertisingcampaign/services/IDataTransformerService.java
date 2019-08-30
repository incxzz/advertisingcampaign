package ua.pp.incm.advertisingcampaign.services;

import java.util.List;

public interface IDataTransformerService
{
   String getStringFromList(List<? extends Object> list, char separator);

}
