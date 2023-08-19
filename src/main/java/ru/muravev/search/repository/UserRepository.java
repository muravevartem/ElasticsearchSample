package ru.muravev.search.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.muravev.search.document.UserIndex;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<UserIndex, String> {
    @Query("""
            {
                  "multi_match": {
                     "query": "?0",
                     "fields": ["fullName", "email", "username"],
                     "fuzziness": "1"
                  }
               }
            """)
    List<UserIndex> findAllByKeyword(String fullName);
}
