package com.ghost.xboxapi.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "xbox", url = "https://displaycatalog.mp.microsoft.com/v7.0")
public interface XboxFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products?bigIds={bigIds}&market=BR&languages=pt-br&MS-CV=DGU1mcuYo0WMMp+F.1", produces = "application/json")
    Object getGames(@PathVariable("bigIds") String bigIds);

    @RequestMapping(method = RequestMethod.GET, value = "/products?bigIds={bigIds}&market=BR&languages=pt-br&MS-CV=DGU1mcuYo0WMMp+F.1", produces = "application/json")
    Object getGames2(@PathVariable("bigIds") String bigIds);
}
