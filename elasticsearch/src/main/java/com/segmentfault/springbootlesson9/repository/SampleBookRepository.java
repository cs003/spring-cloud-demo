package com.segmentfault.springbootlesson9.repository;

import com.segmentfault.springbootlesson9.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by jiaozhiguang on 2017/8/7.
 */
public interface SampleBookRepository extends ElasticsearchRepository<Book,String> {

    List<Book> findByName(String name);
}
