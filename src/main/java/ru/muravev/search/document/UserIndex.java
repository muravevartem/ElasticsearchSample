package ru.muravev.search.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "user")
public class UserIndex {
    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "russian", searchAnalyzer = "russian")
    private String fullName;

    @Field(type = FieldType.Text)
    private String username;

    @Field(type = FieldType.Text)
    private String email;

}
