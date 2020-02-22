package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.exception.CustomExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;


/**
 * @author jojo
 * @date 2019/11/19 22:18
 **/
@Service
public class PageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    /**
     * 进行分页查询从1开始
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    public QueryResponseResult findlist(int page, int size, QueryPageRequest queryPageRequest){
        //自定义条件查询
        if (queryPageRequest==null){
            QueryPageRequest queryPageRequest1=new QueryPageRequest();
        }

        //新建匹配器
        ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        CmsPage cmsPage=new CmsPage();
        //根据站点id查询
        if (!StringUtils.isEmpty(queryPageRequest.getSiteId())){
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        //根据页面别名模糊查询
        if (!StringUtils.isEmpty(queryPageRequest.getPageAliase())){
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        Example<CmsPage> example=Example.of(cmsPage,exampleMatcher);

        if (page<=0){
            page=1;
        }
        page=page-1;
        if (size<=0){
            size=10;
        }
        Pageable pageable=new PageRequest(page,size);
        //自定义分页查询
        Page<CmsPage> all = cmsPageRepository.findAll(example,pageable);
        QueryResult queryResult=new QueryResult();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    /**
     * 添加
     * @param cmsPage
     * @return
     */
    public CmsPageResult add(CmsPage cmsPage){
        CmsPage cmspage1 = cmsPageRepository.findByPageNameAndPageWebPathAndSiteId(cmsPage.getPageName(), cmsPage.getPageWebPath(), cmsPage.getSiteId());

        if (cmspage1!=null){
            //抛出可预知异常
            CustomExceptionCast.customerExceptionCast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        cmsPage.setPageId(null);
        CmsPage save = cmsPageRepository.save(cmsPage);
        CmsPageResult cmsPageResult=new CmsPageResult(CommonCode.SUCCESS,save);
        return cmsPageResult;

    }

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    public CmsPage findById(String id){
        Optional<CmsPage> result = cmsPageRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }else {
            return null;
        }
    }

    /**
     * 进行更新
     * @param id
     * @param cmsPage
     * @return
     */
    public CmsPageResult update(String id,CmsPage cmsPage){
        CmsPage page = this.findById(id);
        if (page!=null){
            //更新模板id
            page.setTemplateId(cmsPage.getTemplateId());
            //更新所属站点
            page.setSiteId(cmsPage.getSiteId());
            //更新页面别名
            page.setPageAliase(cmsPage.getPageAliase());
            //更新页面名称
            page.setPageName(cmsPage.getPageName());
            //更新访问路径
            page.setPageWebPath(cmsPage.getPageWebPath());
            //更新物理路径
            page.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            CmsPage save = cmsPageRepository.save(page);
            CmsPageResult cmsPageResult=new CmsPageResult(CommonCode.SUCCESS,save);
            return cmsPageResult;
        }else {
            CmsPageResult cmsPageResult=new CmsPageResult(CommonCode.FAIL,null);
            return cmsPageResult;
        }
    }

    /**
     * 删除指定page
     * @param id
     * @return
     */
    public ResponseResult delete(String id){
        Optional<CmsPage> reslut= cmsPageRepository.findById(id);
        if (reslut.isPresent()){
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }else {
            return new ResponseResult(CommonCode.FAIL);
        }
    }
}
