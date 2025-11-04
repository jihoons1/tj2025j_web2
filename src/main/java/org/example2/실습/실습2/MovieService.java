package org.example2.실습.실습2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    // 등록
    public MovieDto moviesave(MovieDto movieDto){
        MovieEntity entity = movieDto.toEntity();
        MovieEntity movieEntity = movieRepository.save(entity);
        if (movieEntity.getMovieid() >= 0 ){ return movieEntity.toMovieDto(); }
        return movieDto;
    }

    // 조회
    public List<MovieDto> movielist(){
        List<MovieEntity> movieEntities = movieRepository.findAll(); // 모든 엔티티 조회
        List<MovieDto> movieDtos = movieRepository.findAll()
                .stream().map( MovieEntity :: toMovieDto )
                .collect(Collectors.toList() );
        return movieDtos;
    }

    // 개별조회
    public MovieDto movielistid(int movieid){
        Optional<MovieEntity> movieEntity = movieRepository.findById(movieid);
        if (movieEntity.isPresent()){
            MovieEntity movie = movieEntity.get();
            return movie.toMovieDto();
        }
        return null;
    }

    // 수정
    public MovieDto movieupdate( MovieDto movieDto){
        Optional<MovieEntity> movieEntity = movieRepository.findById(movieDto.getMovieid());
        if (movieEntity.isPresent()){
            MovieEntity movie = movieEntity.get();
            movie.setTitle(movieDto.getTitle());
            movie.setDirector(movieDto.getDirector());
            movie.setReleaseDate(movieDto.getReleaseDate());
            return movie.toMovieDto();
        }
        return movieDto;

    }

    // 삭제
    public boolean moviedelete(int movieid){
        if (movieRepository.existsById(movieid)){
            movieRepository.deleteById(movieid);
            return true;
        }
        return false;
    }
}
