package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jojo
 * @date 2019/11/19 21:06
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;
    @Test
    public void cmsPage(){
        Pageable pageable=new PageRequest(1,10);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        // List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all.getTotalElements());
    }

    @Test
    public void findByPageNameTest(){
        CmsPage byPageName = cmsPageRepository.findByPageName("index.html");
        System.out.println(byPageName);
    }
}
