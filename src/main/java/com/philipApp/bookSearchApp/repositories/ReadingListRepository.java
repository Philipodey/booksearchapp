package com.philipApp.bookSearchApp.repositories;

import com.philipApp.bookSearchApp.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {

}
