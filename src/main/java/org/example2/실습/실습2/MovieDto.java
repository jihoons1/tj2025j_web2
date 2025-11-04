package org.example2.실습.실습2;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {

    private int movieid;


    private String title; // null x  , 글자수 최대 50


    private String director; // 감독


    private String releaseDate;  // 개봉일


    private int rating; // 평점

    private String createdate;
    private String updatedate;

    public MovieEntity toEntity() {
        return MovieEntity.builder()
                .movieid( this.movieid )
                .title( this.title )
                .director( this.director )
                .releaseDate( this.releaseDate )
                .rating( this.rating )
                .build();
    }
}
