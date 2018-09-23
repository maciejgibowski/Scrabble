package szukacz.firstId.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "words")
public class WordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int word_Id;

    @Column(name = "word")
    private String word;

    @Column(name = "orderedLetters")
    private String orderedLetters;


    public String getOrderedLetters() {
        return orderedLetters;
    }

    public void setOrderedLetters(String orderedLetters) {
        this.orderedLetters = orderedLetters;
    }

    public WordEntity(String word) {
        super();
        this.word = word;
    }

    public WordEntity(int word_Id, String word) {
        super();
        this.word_Id = word_Id;
        this.word = word;
    }

    public WordEntity() {
        // TODO Auto-generated constructor stub
    }

    public int getWord_Id() {
        return word_Id;
    }

    public void setWord_Id(int word_Id) {
        this.word_Id = word_Id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
