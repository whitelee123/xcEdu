package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jojo
 * @date 2019/11/19 21:03
 **/
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
    CmsPage findByPageName(String pageName);

    CmsPage findByPageNameAndPageWebPathAndSiteId(String name ,String path,String siteId);
}
