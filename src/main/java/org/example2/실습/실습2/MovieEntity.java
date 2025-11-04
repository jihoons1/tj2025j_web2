package org.example2.실습.실습2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity extends BaseTime{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) // 자동 증가
    private int movieid;

    @Column( nullable = false , length = 50 )
    private String title; // null x  , 글자수 최대 50

    @Column( nullable = false , length = 20 )
    private String director; // 감독

    @Column( nullable = false , length = 20 )
    private String releaseDate;  // 개봉일

    @Column( nullable = true ) // null 포함
    private int rating; // 평점

    public MovieDto toMovieDto(){
        return MovieDto.builder()
                .movieid( this.movieid )
                .title( this.title )
                .director( this.director )
                .releaseDate( this.releaseDate )
                .rating( this.rating )
                .createdate( this.getCreateDate().toString() )
                .updatedate( this.getUpdateDate().toString() )
                .build();
    }


}
