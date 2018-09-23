package szukacz.firstId.load;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import szukacz.firstId.entity.WordEntity;

public class WordSearch {
    public static String orderingLetters(String word) {

    Collator collator = Collator.getInstance(new Locale("pl", "PL"));
    String[] split = word.split("");
    Arrays.sort(split, collator);
    String sorted = "";
    for (int i = 0; i < split.length; i++)
      sorted += split[i];

    return sorted;
    }

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstIdPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        // Tworzenie bazy danych z wyrazów z pliku

        File file = new File("/home/maciej/Downloads/sjp-20180919/slowa.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        ArrayList<String> fileWords = new ArrayList<String>();
        ArrayList<String> fileWordsSortedLetters = new ArrayList<String>();

        while ((st = br.readLine()) != null) {
            fileWords.add(st);
            fileWordsSortedLetters.add(orderingLetters(st));
        }

        tx.begin();
        for (int i = 0; i < fileWords.size(); i++) {

            WordEntity word = new WordEntity();
            word.setWord(fileWords.get(i));
            word.setOrderedLetters(fileWordsSortedLetters.get(i));

            em.persist(word);
            if (i % 30 == 0) {

                tx.commit();
                tx.begin();
            }
        }
        tx.commit();
        em.close();
    } 
}
