package com.itm.festivos.domain.port;

import com.itm.festivos.domain.model.HolidayBase;
import java.util.*;

public interface HolidayBaseRepository {
  List<HolidayBase> findByCountryId(Long countryId);

  List<HolidayBase> findByCountryCode(String countryCode); // sobrecarga

  List<HolidayBase> findFixedByCountryId(Long countryId);

  List<HolidayBase> findEasterBasedByCountryId(Long countryId);
}
