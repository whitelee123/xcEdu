package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;

/**
 * @author jojo
 * @date 2019/11/18 20:49
 **/
public interface CmsPageControllerApi {
    public QueryResponseResult findlist(int pageNum, int pageSizes, QueryPageRequest queryPageRequest);

    public CmsPageResult add(CmsPage cmsPage);

    public CmsPage findById(String id);

    public CmsPageResult edit(String id,CmsPage cmsPage);

    public ResponseResult delete(String id);
}
