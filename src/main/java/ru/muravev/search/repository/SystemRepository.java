package ru.muravev.search.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.muravev.search.document.SystemIndex;

import java.util.List;

public interface SystemRepository extends ElasticsearchRepository<SystemIndex, String> {

    @Query("""
            {
                  "multi_match": {
                     "query": "?0",
                     "fields": ["name", "description"],
                     "fuzziness": "AUTO"
                  }
               }
            """)
    List<SystemIndex> findAllByDescriptionMatches(String name);
}
