package com.itm.festivos.domain.port;

import com.itm.festivos.domain.model.HolidayType;
import java.util.*;

public interface HolidayTypeRepository {
  Optional<HolidayType> findById(Long id);

  List<HolidayType> findAll();
}
