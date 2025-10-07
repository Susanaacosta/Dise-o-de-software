package com.itm.festivos.domain.port;

import com.itm.festivos.domain.model.Country;
import java.util.*;

public interface CountryRepository {
  Optional<Country> findById(Long id);

  Optional<Country> findByCode(String code);

  List<Country> findAll();
}
