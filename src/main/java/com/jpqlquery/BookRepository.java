package com.jpqlquery;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b")
    List<Book> getAllBooks();

    @Query("select b from Book b where b.title = :title")
    Book getByTitle(@Param("title") String title);

    @Query("select b from Book b where b.title = :title and b.author = :author") //instead :title,:author  we can give ?1 and ?2
    List<Book> getByTitleAndAuthor(@Param("title") String title, @Param("author") String author);
    @Query("select b from Book b where b.title = ?1 or b.author = ?2")
    List<Book> getByTitleOrAuthor(@Param("title") String title, @Param("author") String author);
    @Query("select b from Book b where b.id between ?1 and ?2")
    List<Book> getId(int start,int end);

    @Transactional
    @Modifying
    @Query("Update Book b set b.title=:title where b.id= ?1")
    int updateTitle(int id,String title);
}
