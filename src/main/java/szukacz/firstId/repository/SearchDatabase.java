package szukacz.firstId.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import szukacz.firstId.entity.WordEntity;


public interface SearchDatabase extends JpaRepository<WordEntity, String> {

    WordEntity findSingleByWord(String word);

    List<WordEntity> findByWord(String word);

    @Query("SELECT w FROM WordEntity w WHERE w.word LIKE %:part%")
    List<WordEntity> findByPart(@Param("part") String word);

    @Query("SELECT w FROM WordEntity w WHERE w.word LIKE :part")
    List<WordEntity> findCombinationsByPart(@Param("part") String word);

    @Query("SELECT w FROM WordEntity w WHERE orderedLetters LIKE %:querySet AND LENGTH(word) <= :numberOfLetters")
    List<WordEntity> findWOrdSearchOnRandomLettersByPart(@Param("querySet") String querySet, @Param("numberOfLetters") Integer numberOfLetters);

  //  @Query("SELECT w FROM WordEntity w WHERE w REGEXP '[abbb]' AND LENGTH(word) <= 3"
    
//	@Query("SELECT w FROM WordEntity w WHERE w LIKE     
    
} 
