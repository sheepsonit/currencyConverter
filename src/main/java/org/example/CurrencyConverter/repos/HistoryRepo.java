package org.example.CurrencyConverter.repos;

import org.example.CurrencyConverter.domain.History;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepo extends CrudRepository<History,Long> {

}
