package com.pomtest01.pomtest01_base.service;

import com.pomtest01.pomtest01_base.dao.LabelDao;
import com.pomtest01.pomtest01_base.pojo.Label;
import com.pomtest01.pomtest01_common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 标签业务逻辑类
 * */
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     * */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     * */
    public void add(Label label){
        label.setId(idWorker.nextId()+"  ");    //设置ID
        labelDao.save(label);
    }

    /**
     * 修改标签
     * */
    public void update(Label label){
        labelDao.save(label);
    }

    /**
     * 删除标签
     * */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象，就是要把条件封装到哪个对象中。  where 类名 = label.getid
             * @param query 封装的都是查询的关键字，比如  group by  order by 等
             * @param cb    用来封装条件对象的，如果直接返回null,表示不需要任何条件
             * */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个List集合，来存放所有条件
                List<Predicate> list = new ArrayList<>();
                //判断  当传入的参数不为空时  进行一下操作
                if(label.getLabelname() != null && !"".equals(label.getLabelname())){
                    Predicate predicate = cb.like(root.get("labelname").as(String.class),"%"+label.getLabelname()+"%"); //labelname like "%小明%"
                    list.add(predicate);
                }

                if(label.getState()!= null && !"".equals(label.getState())){
                    Predicate predicate = cb.equal(root.get("state").as(String.class),label.getState());    //state="1"
                    list.add(predicate);
                }
                //new 一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                //把list转化成数组
                parr = list.toArray(parr);
                return cb.and(parr);    // where labelname "%小明%" and state = "1"
            }
        });
    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        //封装一个分页对象
        Pageable pageable = PageRequest.of(page-1,size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象，就是要把条件封装到哪个对象中。  where 类名 = label.getid
             * @param query 封装的都是查询的关键字，比如  group by  order by 等
             * @param cb    用来封装条件对象的，如果直接返回null,表示不需要任何条件
             * */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个List集合，来存放所有条件
                List<Predicate> list = new ArrayList<>();
                //判断  当传入的参数不为空时  进行一下操作
                if(label.getLabelname() != null && !"".equals(label.getLabelname())){
                    Predicate predicate = cb.like(root.get("labelname").as(String.class),"%"+label.getLabelname()+"%"); //labelname like "%小明%"
                    list.add(predicate);
                }

                if(label.getState()!= null && !"".equals(label.getState())){
                    Predicate predicate = cb.equal(root.get("state").as(String.class),label.getState());    //state="1"
                    list.add(predicate);
                }
                //new 一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                //把list转化成数组
                parr = list.toArray(parr);
                return cb.and(parr);    // where labelname "%小明%" and state = "1"
            }
        },pageable);
    }
}
